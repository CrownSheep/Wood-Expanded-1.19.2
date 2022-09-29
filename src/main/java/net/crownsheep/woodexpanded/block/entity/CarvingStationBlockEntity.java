package net.crownsheep.woodexpanded.block.entity;

import net.crownsheep.woodexpanded.item.ModItems;
import net.crownsheep.woodexpanded.networking.ModMessages;
import net.crownsheep.woodexpanded.networking.packet.ItemStackSyncS2CPacket;
import net.crownsheep.woodexpanded.recipe.CarvingStationRecipe;
import net.crownsheep.woodexpanded.screen.CarvingStationMenu;
import net.crownsheep.woodexpanded.screen.CarvingStationScreen;
import net.crownsheep.woodexpanded.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.apache.commons.lang3.RandomUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CarvingStationBlockEntity extends BlockEntity implements MenuProvider {

    public static boolean carve;
    public static boolean mayPickup;

    public static ItemStack slotStack;
    public final ItemStackHandler itemHandler = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 178;


    public CarvingStationBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CARVING_STATION.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> CarvingStationBlockEntity.this.progress;
                    case 1 -> CarvingStationBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> CarvingStationBlockEntity.this.progress = value;
                    case 1 -> CarvingStationBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 1;
            }
        };
    }

    public void setHandler(ItemStackHandler itemStackHandler) {
        for (int i = 0; i < itemStackHandler.getSlots(); i++) {
            itemHandler.setStackInSlot(i, itemStackHandler.getStackInSlot(i));
        }
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("");
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new CarvingStationMenu(id, inventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.put("inventory", itemHandler.serializeNBT());

        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, CarvingStationBlockEntity pEntity) {
        if (level.isClientSide()) {
            return;
        }

        if (pEntity.itemHandler.getStackInSlot(0).isEmpty()) {
            carve = false;
        }

        if (slotStack != null) {
            pEntity.itemHandler.setStackInSlot(0, slotStack);
        }

        if (!carve) {
            mayPickup = false;
            if (CarvingStationScreen.countsta == 0) {
                slotStack = new ItemStack(Blocks.OAK_PLANKS, 2);
            }
            if (CarvingStationScreen.countsta == 1) {
                slotStack = new ItemStack(Blocks.OAK_PLANKS, 1);
            }
            if (CarvingStationScreen.countsta == 2) {
                slotStack = new ItemStack(Blocks.OAK_PLANKS, 1);
            }
            if (CarvingStationScreen.countsta == 3) {
                slotStack = new ItemStack(Blocks.OAK_PLANKS, 2);
            }
        }

        if (!level.isClientSide()) {
            ModMessages.sendToClients(new ItemStackSyncS2CPacket(pEntity.itemHandler, pos));
        }
    }

    private static boolean hasKnifeInFirstSlot(SimpleContainer inventory) {
        return inventory.getItem(0).getItem() == ModItems.KNIFE.get();
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack stack) {
        return inventory.getItem(2).getItem() == stack.getItem() || inventory.getItem(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount();
    }
}

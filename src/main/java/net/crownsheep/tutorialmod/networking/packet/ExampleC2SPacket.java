package net.crownsheep.tutorialmod.networking.packet;

import net.crownsheep.tutorialmod.TutorialMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ExampleC2SPacket {
    public ExampleC2SPacket() {

    }

    public ExampleC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE SERVER!
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            for(int i = 0; i < 100; i++) {
                EntityType.COW.spawn(level, null, null, player.blockPosition(),
                        MobSpawnType.COMMAND, true, false);
            }

            level.playSound(null, player.getOnPos(), SoundEvents.DISPENSER_LAUNCH, SoundSource.PLAYERS,
                    5F, level.random.nextFloat() * 0.1F + 0.9F);

        });
        return true;
    }

}

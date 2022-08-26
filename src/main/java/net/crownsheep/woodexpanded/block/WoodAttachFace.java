package net.crownsheep.woodexpanded.block;

import net.minecraft.util.StringRepresentable;

public enum WoodAttachFace implements StringRepresentable {
    FLOOR("floor"),
    WALL("wall"),
    CEILING("ceiling");

    public final String name;

    private WoodAttachFace(String p_61311_) {
        this.name = p_61311_;
    }

    public String getSerializedName() {
        return this.name;
    }
}

package com.codecool.dungeoncrawl.data;

import org.w3c.dom.ls.LSOutput;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    DOOR("door"),
    WATER("water"),
    BRIDGE("bridge");
    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}

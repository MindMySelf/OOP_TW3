package com.codecool.dungeoncrawl.data;

import org.w3c.dom.ls.LSOutput;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    DOOR("door"),
    WATER("water"),
    BRIDGE("bridge"),
    WOODS("treeType2"),
    TREE("treeType1"),
    ROAD("road"),
    CAMPFIRE("campfire"),
    KEY("key"),
    GRASS("grass"),
    APPLE("apple"),
    GOLD("gold"),
    GEM("gem");
    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}

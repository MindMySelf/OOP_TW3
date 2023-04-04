package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.List;

public class Skeleton extends Actor {
    private Cell cell;

    public Skeleton(Cell cell) {
        super(cell);
        this.cell = cell;
        this.cell.setActor(this);
        this.setHealth(5);
        this.setDamage(2);
    }


    @Override
    public String getTileName() {
        return "skeleton";
    }

}

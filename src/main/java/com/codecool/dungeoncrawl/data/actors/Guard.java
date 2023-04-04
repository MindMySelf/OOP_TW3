package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Guard extends Actor {
    private Cell cell;



    public Guard(Cell cell) {
        super(cell);
        this.cell = cell;
        this.cell.setActor(this);
        this.setHealth(15);
        this.setDamage(7);
    }




    @Override
    public String getTileName() {
        return "guard";
    }


}

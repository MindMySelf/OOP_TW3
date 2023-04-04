package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.logic.Action;

import java.util.List;

public class Guard extends Actor {

    private int health = 15;
    private int damage = 7;
    private Cell cell;
    private Action action;

    


    public Guard(Cell cell) {
        super(cell);
        this.cell = cell;
        this.cell.setActor(this);
        action =  new Action(List.of("player"), cell, this);
    }



    @Override
    public String getTileName() {
        return "guard";
    }

    public int getHealth() {
        return health;
    }
    public int getDamage() { return damage; }
    public Action getAction() {
        return action;
    }


}

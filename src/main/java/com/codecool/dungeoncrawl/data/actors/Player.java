package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.logic.Action;

import java.util.List;

public class Player extends Actor {
    private Cell cell;
    private Action action;
    public Player(Cell cell) {
        super(cell);
        this.cell = cell;
        this.cell.setActor(this);
        action =  new Action(List.of("guard", "skeleton"), cell, this);
    }

    public Action getAction() {
        return action;
    }

    public String getTileName() {
        return "player";
    }



}

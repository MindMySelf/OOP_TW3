package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.logic.Action;

import java.util.List;

public class Skeleton extends Actor {
    private Cell cell;
    private Action action;


    public Skeleton(Cell cell) {
        super(cell);
        this.cell = cell;
        this.cell.setActor(this);
        action = new Action(List.of("player"), cell, this);
        this.setHealth(5);
        this.setDamage(2);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if(checkPlayerDeath(this.getHealth())){
            cell.setActor(null);
        }else {
        if (!checkWall(nextCell)) {
            if (checkForActor(nextCell)) {
                if (nextCell.getActor().getTileName().equals("player")) {
                    attack(nextCell, this);

                }
            }
            } else {
                cell.setActor(null);
                nextCell.setActor(this);
                cell = nextCell;
            }
        }
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }

    public Action getAction() {
        return action;
    }
}

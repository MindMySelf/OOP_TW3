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
        this.setHealth(700);
        this.setDamage(1);
    }
    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);

        if (!checkWall(nextCell)) {
            if (checkForActor(nextCell)) {
                if (nextCell.getActor().getTileName().equals("skeleton") || nextCell.getActor().getTileName().equals("guard")) {
                    attack(nextCell, this);
                    if(checkPlayerDeath(this.getHealth())){
                        cell.setActor(null);
                    };
                }

            } else {
                cell.setActor(null);
                nextCell.setActor(this);
                cell = nextCell;
            }
        }
    }


    public String getTileName() {
        return "player";
    }



}

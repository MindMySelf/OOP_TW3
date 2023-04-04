package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.logic.Action;

import java.util.List;

public class Guard extends Actor {
    private Cell cell;
    private Action action;




    public Guard(Cell cell) {
        super(cell);
        this.cell = cell;
        this.cell.setActor(this);
        this.setHealth(15);
        this.setDamage(7);
    }


    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);

        if(checkPlayerDeath(this.getHealth())) {
            cell.setActor(null);
        } else {
            if (!checkWall(nextCell)) {
                if (checkForActor(nextCell)) {
                    if (nextCell.getActor().getTileName().equals("player")) {
                        attack(nextCell, this);

                    }

                } else {
                    cell.setActor(null);
                    nextCell.setActor(this);
                    cell = nextCell;
                }
            }
        }
    }

    @Override
    public String getTileName() {
        return "guard";
    }


}

package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.actors.Actor;

import java.util.List;

public class Action {
    private Actor actor;
    private List<String> targets;
    private Cell currentCell;

    public Action(List<String> targets, Cell currentCell, Actor actor) {
        this.targets = targets;
        this.currentCell = currentCell;
        this.actor = actor;
    }


    public void move(int dx, int dy) {
        Cell nextCell = currentCell.getNeighbor(dx, dy);

        if (checkWall(dx, dy)) {
            if (checkForActor(dx,dy)) {
                if (targets.contains(nextCell.getActor().getTileName())) {
                    System.out.println(currentCell.getActor().getTileName() + " támadt " + nextCell.getActor().getTileName());
                }

            } else {
                currentCell.setActor(null);
                nextCell.setActor(actor);
                currentCell = nextCell;
            }
        }
    }



    public boolean checkWall(int dx, int dy){
        Cell nextCell = currentCell.getNeighbor(dx, dy);
        return nextCell.getType() != CellType.WALL;
    }

    public boolean checkForActor(int dx, int dy){
        Cell nextCell = currentCell.getNeighbor(dx, dy);
        return nextCell.getActor() != null;
    }

}

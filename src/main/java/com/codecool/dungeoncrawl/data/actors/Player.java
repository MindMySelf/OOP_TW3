package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Player extends Actor {
    private Cell cell;
    public Player(Cell cell) {
        super(cell);
        this.cell = cell;
        this.cell.setActor(this);
    }

    public String getTileName() {
        return "player";
    }


    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getType() == CellType.WALL) {
            System.out.println("\n");
        } //If nextCell is enemy then go log out Belépett
        else if (nextCell.getActor() != null) {
            System.out.println("Belelépett");
            if (nextCell.getActor().getTileName().equals("skeleton") || nextCell.getActor().getTileName().equals("guard")) {
                System.out.println("Player Támadt "  +nextCell.getActor().getTileName());
            }
        } else {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }
}

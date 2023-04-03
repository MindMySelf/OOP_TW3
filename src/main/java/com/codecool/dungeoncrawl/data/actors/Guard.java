package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Guard extends Actor{
    private Cell cell;
    public Guard(Cell cell) {
        super(cell);
        this.cell = cell;
        this.cell.setActor(this);
    }

    @Override
    public String getTileName() {
        return "guard";
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);

        if(nextCell.getType() == CellType.WALL){
            System.out.println("Nah mate that's a wall");
        }
        else {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }


}

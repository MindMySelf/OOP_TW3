package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Skeleton extends Actor {
    private int health = 5;
    private int damage = 2;
    private Cell cell;
    public Skeleton(Cell cell) {
        super(cell);
        this.cell = cell;
        this.cell.setActor(this);
    }


    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);

        if(nextCell.getType() == CellType.WALL ){
            System.out.println("Nah mate that's a wall");
        }  else if (nextCell.getActor() != null) {
            System.out.println("Skeleton Belépett");
            if (nextCell.getActor().getTileName().equals("player")) {
                System.out.println("Skeleton támadt " + nextCell.getActor().getTileName());
            }
        }
        else {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }
    @Override
    public String getTileName() {
        return "skeleton";
    }


    public int getHealth() {
        return health;
    }
    public int getDamage() { return damage; }
}

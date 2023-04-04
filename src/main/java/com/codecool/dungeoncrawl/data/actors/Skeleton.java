package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Enemy;

public class Skeleton extends Actor implements Enemy {
    private int health = 5;
    private int damage = 2;
    private Cell cell;
    public Skeleton(Cell cell) {
        super(cell);
        this.cell = cell;
        this.cell.setActor(this);
    }
    @Override
    public String getTileName() {
        return "skeleton";
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
    public int getHealth() {
        return health;
    }
    public int getDamage() { return damage; }
}

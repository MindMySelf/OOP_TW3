package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Guard extends Actor {

    private int health = 15;
    private int damage = 7;
    private Cell cell;


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

    public Guard(Cell cell) {
        super(cell);
        this.cell = cell;
        this.cell.setActor(this);
    }



    @Override
    public String getTileName() {
        return "guard";
    }

    public int getHealth() {
        return health;
    }
    public int getDamage() { return damage; }


}

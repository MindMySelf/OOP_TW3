package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;

    private int damage = 1;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }



    public int getHealth() {
        return health;
    }
    public int getDamage() { return damage; }

    public void setHealth(int hp) { health = hp; }

    public void setDamage(int dmg) { damage = dmg; }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}

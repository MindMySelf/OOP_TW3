package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

public class Weapon implements Drawable {
    private String name;
    private int quantity;
    private int damage;
    private boolean equipped;
    private Cell cell;


    public Weapon(String name, int quantity, int damage, Cell cell) {
        this.cell = cell;
        this.cell.setWeapon(this);
        this.name = name;
        this.quantity = quantity;
        this.equipped = false;
        this.damage = damage;
    }



    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    public int getDamage() {
        return damage;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
    @Override
    public String getTileName() {
        return "sword";
    }
}

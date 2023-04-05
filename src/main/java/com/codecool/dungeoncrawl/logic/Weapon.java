package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

public class Weapon implements Drawable {
    private String name;
    private int quantity;
    private int damage;
    private boolean equipped;


    public Weapon(String name, int quantity, int damage) {
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

    @Override
    public String getTileName() {
        return "sword";
    }
}

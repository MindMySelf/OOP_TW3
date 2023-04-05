package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Drawable;

public class Consumable implements Drawable {
    private String name;
    private int quantity;
    private int healingPower;

    public Consumable(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getHealingPower() {
        return healingPower;
    }

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }

    @Override
    public String getTileName() {
        return null;
    }
}

package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.logic.Inventory;
import com.codecool.dungeoncrawl.logic.Item;

import java.util.List;

public class Player extends Actor {
    private Cell cell;
    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public Player(Cell cell) {
        super(cell);
        this.cell = cell;
        this.cell.setActor(this);
        this.setHealth(700);
        this.setDamage(1);
        this.inventory = new Inventory();
    }

    @Override
    protected void handleAttack(Cell nextCell) {
        Actor actor = nextCell.getActor();
        String tileName = actor.getTileName();
        if (tileName.equals("skeleton") || tileName.equals("guard")) {
            attack(nextCell, this);
        }

    }

    @Override
    public void updateAttack() {
        if (inventory.getEquippedItem() != null) {
            if (inventory.getEquippedItem().getName().equals("Sword")) {
                this.setDamage(1);
                this.setDamage(getDamage() + inventory.getEquippedItem().getDamage());
                System.out.println(this.getDamage());
            }

            if (inventory.getEquippedItem().getName().equals("Dagger")) {
                this.setDamage(1);
                this.setDamage(getDamage() + inventory.getEquippedItem().getDamage());
                System.out.println(this.getDamage());
            }
        } else {
            this.setDamage(1);
        }

    }


    public String getTileName() {
        return "player";
    }


}

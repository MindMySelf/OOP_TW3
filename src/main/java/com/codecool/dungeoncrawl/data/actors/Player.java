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
        inventory =  new Inventory();
    }

    @Override
    protected void handleActor(Cell nextCell) {
        Actor actor = nextCell.getActor();
        String tileName = actor.getTileName();

        if (tileName.equals("skeleton") || tileName.equals("guard")) {
            attack(nextCell, this);
            if (checkPlayerDeath(this.getHealth())) {
                cell.setActor(null);
            }
        }
        inventory.addItem(new Item("Sword", 3));
        System.out.println(inventory.getItems());
    }

    public String getTileName() {
        return "player";
    }



}

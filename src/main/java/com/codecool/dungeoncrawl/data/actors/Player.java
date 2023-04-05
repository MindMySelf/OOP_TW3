package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.logic.Inventory;
import com.codecool.dungeoncrawl.logic.Weapon;

import java.util.List;

public class Player extends Actor {
    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public Player(Cell cell) {
        super(cell);
        setHealth(700);
        setDamage(1);
        inventory = new Inventory();
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
                setDamage(1);
                setDamage(getDamage() + inventory.getEquippedItem().getDamage());
                System.out.println(getDamage());
            }

            if (inventory.getEquippedItem().getName().equals("Dagger")) {
                setDamage(1);
                setDamage(getDamage() + inventory.getEquippedItem().getDamage());
                System.out.println(getDamage());
            }
        } else {
            setDamage(1);
        }

    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = getCell().getNeighbor(dx, dy);
        if (checkPlayerDeath(getHealth())) {
            getCell().setActor(null);
        } else {
            if (checkWall(nextCell)) {
                return;
            }
            if (isActorOnNextCell(nextCell)) {
                handleAttack(nextCell);
            } else {
                moveActor(nextCell);
                updateAttack();
            }
        }
    }

    @Override
    public String getTileName() {
        return "player";
    }
}

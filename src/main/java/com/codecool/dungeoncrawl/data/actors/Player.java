package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.logic.Inventory;
import com.codecool.dungeoncrawl.logic.Weapon;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Random;

public class Player extends Actor {
    private Inventory inventory;
    private Random random;

    public Inventory getInventory() {
        return inventory;
    }

    public Player(Cell cell) {
        super(cell);
        setHealth(100);
        setDamage(1);
        inventory = new Inventory();
        random = new Random();
    }

    @Override
    protected void handleAttack(Cell nextCell) {
        int chanceToDrop = random.nextInt(4) + 1;
        Actor actor = nextCell.getActor();
        String tileName = actor.getTileName();
        if (tileName.equals("skeleton") || tileName.equals("guard")) {
            attack(nextCell, this);
        }
        if(tileName.equals("skeleton") && actor.getHealth() <= 0 && chanceToDrop == 1){
            Weapon sword = new Weapon("Sword", 1, 3);
            if (inventory.hasItem(sword)) {
            } else {
                inventory.addItem(sword);
            }
        }else if(tileName.equals("guard") && actor.getHealth() <= 0 && chanceToDrop == 1){
            Weapon dagger = new Weapon("Dagger", 1, 10);
            if (inventory.hasItem(dagger)) {
            } else {
                inventory.addItem(dagger);
            }
        }
    }

    @Override
    public void updateAttack() {
        if (inventory.getEquippedItem() != null) {
            setDamage(1);
            setDamage(getDamage() + inventory.getEquippedItem().getDamage());
        } else {
            setDamage(1);
        }

    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = getCell().getNeighbor(dx, dy);
        if (checkPlayerDeath(getHealth())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Game over!", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
            getCell().setActor(null);
            if (alert.getResult() == ButtonType.OK) {
                System.exit(0);
            }
        } else {
            if (checkObstacle(nextCell)) {
                return;
            }
            if(checkForKey(nextCell)){
                inventory.addItem(new Weapon("Key", 1, 0));
                nextCell.setType(CellType.FLOOR);
            }
            if(checkForApple(nextCell)){
                setHealth(getHealth() + 2);
                nextCell.setType(CellType.FLOOR);
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

    public boolean checkDoorCanBeOpened() {
        return inventory.getWeapon("key") == null;
    }
}

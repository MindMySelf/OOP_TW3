package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.logic.Inventory;
import com.codecool.dungeoncrawl.logic.Weapon;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.*;

public class Player extends Actor {
    private static Inventory inventory;
    private Random random;
    private static final int DROPCHANCE = 4;
    private static final int GETITEM = 1;

   public static int mapIndex = 0;

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
        int chanceToDrop = random.nextInt(DROPCHANCE) + 1;
        Actor actor = nextCell.getActor();
        String tileName = actor.getTileName();
        if (tileName.equals("skeleton") || tileName.equals("guard")) {
            attack(nextCell, this);
        }
        if(tileName.equals("skeleton") && actor.getHealth() <= 0 && chanceToDrop == GETITEM){
            Weapon sword = new Weapon("Sword", 1, 3);
            if (inventory.hasItem(sword)) {
            } else {
                inventory.addItem(sword);
            }
        }else if(tileName.equals("guard") && actor.getHealth() <= 0 && chanceToDrop == GETITEM){
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
            handleDeath();
        } else {
            handleActions(nextCell);
        }
    }
    public void handleWin() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "CONGRATULATIONS YOU HAVE WON!");
        alert.setHeaderText(null);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    alert.setResult(ButtonType.OK);
                    alert.hide();
                });
            }
        }, 3500);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.exit(0);
        }
        timer.cancel();
    }
    public boolean winCondition() {
        return getCell().getType().equals(CellType.DOOR) && mapIndex == 2;
    }
    public void pickUpItem(Cell nextCell){
        if(checkForKey(nextCell)){
            inventory.addItem(new Weapon("Key", 1, 0));
            nextCell.setType(CellType.FLOOR);
        }
        if(checkForApple(nextCell)){
            setHealth(getHealth() + 2);
            nextCell.setType(CellType.FLOOR);
        }
    }
    public void handleDeath() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Game over!", ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
        getCell().setActor(null);
        if (alert.getResult() == ButtonType.OK) {
            System.exit(0);
        }
    }
    public void handleActions(Cell nextCell) {
        if (checkObstacle(nextCell)) {
            return;
        }
        if(doorIsNotOpenable(nextCell)){
            return;
        } else if (winCondition()) {
            handleWin();
            return;
        } else{
            if(nextCell.getType().equals(CellType.DOOR)) {
                mapIndex++;
            }
        }
        pickUpItem(nextCell);
        checkForFight(nextCell);
    }
    public void checkForFight(Cell nextCell) {
        if (isActorOnNextCell(nextCell)) {
            handleAttack(nextCell);
        } else {
            moveActor(nextCell);
            updateAttack();
        }
    }
    public boolean doorIsNotOpenable(Cell nextCell) {
        return !checkDoorCanBeOpened() && nextCell.getType().equals(CellType.DOOR);
    }

    @Override
    public String getTileName() {
        return "player";
    }

    public boolean checkDoorCanBeOpened() {
        if(inventory.getEquippedItem() != null) {
            return inventory.getItems().containsKey("Key") && inventory.getEquippedItem().getName().equals("Key");
        }else{
            return false;
        }
    }

    public int getMapIndex() {
        return mapIndex;
    }

    public void setMapIndex(int mapIndex) {
        this.mapIndex = mapIndex;
    }
}

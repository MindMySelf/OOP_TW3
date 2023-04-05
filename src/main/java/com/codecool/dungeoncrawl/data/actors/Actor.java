package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.logic.Inventory;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health;

    private int damage;



    public Actor(Cell cell){
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

    protected boolean checkPlayerDeath(int actorHp){
        return actorHp <= 0;
    }

    protected boolean checkWall(Cell nextCell){
        return nextCell.getType() == CellType.WALL || nextCell.getType() == CellType.WATER;
    }


    protected void attack(Cell nextCell, Actor actor) {
        int targetHp = nextCell.getActor().getHealth() - actor.getDamage();
        int actorHp = actor.getHealth() - nextCell.getActor().getDamage();
        actor.setHealth(actorHp);
        nextCell.getActor().setHealth(targetHp);
        System.out.println(nextCell.getActor().getTileName()+ " | " + nextCell.getActor().getHealth());
    }

    protected boolean isActorOnNextCell(Cell cell) {
        return cell.getActor() != null;
    }


    protected void moveActor(Cell nextCell) {
        cell.setActor(null);
        nextCell.setActor(this);
        cell = nextCell;
    }
    protected void handleAttack(Cell nextCell) {
        Actor actor = nextCell.getActor();
        String tileName = actor.getTileName();

        if (tileName.equals("player")) {
            attack(nextCell, this);
        }
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (checkPlayerDeath(this.getHealth())) {
            cell.setActor(null);
        } else {
            if (checkWall(nextCell)) {
                return;
            }
            if (isActorOnNextCell(nextCell)) {
                handleAttack(nextCell);
            } else {
                moveActor(nextCell);
                this.updateAttack();
            }
        }
    }
    public void updateAttack() {
    }
}

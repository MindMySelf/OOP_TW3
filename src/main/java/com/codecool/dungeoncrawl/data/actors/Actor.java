package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health;

    private int damage;

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

    protected boolean checkPlayerDeath(int actorHp){
        return actorHp <= 0;
    }

    protected boolean checkWall(Cell nextCell){
        return nextCell.getType() == CellType.WALL;
    }

    protected boolean checkForActor(Cell nextCell){
        return nextCell.getActor() != null;
    }

    protected void attack(Cell nextCell, Actor actor) {
        int targetHp = nextCell.getActor().getHealth() - actor.getDamage();
        int actorHp = actor.getHealth() - nextCell.getActor().getDamage();
        actor.setHealth(actorHp);
        nextCell.getActor().setHealth(targetHp);
        System.out.println(nextCell.getActor().getTileName()+ " | " + nextCell.getActor().getHealth());
    }

    protected boolean isActorNear(Cell cell) {
        return cell.getActor() != null;
    }


    protected void moveActor(Cell nextCell) {
        cell.setActor(null);
        nextCell.setActor(this);
        cell = nextCell;
    }
    protected void handleActor(Cell nextCell) {
        Actor actor = nextCell.getActor();
        String tileName = actor.getTileName();

        if (tileName.equals("player")) {
            attack(nextCell, this);
            if (checkPlayerDeath(this.getHealth())) {
                cell.setActor(null);
            }
        }
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);

        if (checkWall(nextCell)) {
            return;
        }
        if (isActorNear(nextCell)) {
            handleActor(nextCell);
        } else {
            moveActor(nextCell);
        }
    }
}

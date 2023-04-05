package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Guard;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.Skeleton;
import com.codecool.dungeoncrawl.logic.Weapon;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;

    private Guard guard;
    private List<Skeleton> skeletons = new ArrayList<>();
    private List<Weapon> weapons = new ArrayList<>();

    public List<Weapon> getWeapons() {
        return weapons;
    }
    public void addWeapon(Weapon weapon) {
        this.weapons.add(weapon);
    }

    public List<Skeleton> getSkeletons() {
        return skeletons;
    }

    public void addSkeleton(Skeleton skeleton) {
        this.skeletons.add(skeleton);
    }


    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setGuard(Guard guard) {this.guard = guard;}

    public Guard getGuard(){
        return guard;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

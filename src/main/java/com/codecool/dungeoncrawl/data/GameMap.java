package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Guard;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.Skeleton;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;

    private Guard guard;
    private List<Skeleton> skeletons = new ArrayList<>();


    public List<Skeleton> getSkeletons() {
        return skeletons;
    }

    public void setSkeletons(List<Skeleton> skeletons) {
        this.skeletons.addAll(skeletons);
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

package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.actors.Actor;

import java.util.List;

public class Action {
    private Actor actor;
    private List<String> targets;
    private Cell currentCell;

    public Action(List<String> targets, Cell currentCell, Actor actor) {
        this.targets = targets;
        this.currentCell = currentCell;
        this.actor = actor;
    }










}

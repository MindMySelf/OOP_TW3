package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Up implements KeyHandler {
    public static final KeyCode arrow_up = KeyCode.UP;

    public static final KeyCode w = KeyCode.W;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if(arrow_up.equals(event.getCode()) || w.equals(event.getCode()))
            map.getPlayer().move(0, -1);
    }
}

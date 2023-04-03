package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Left implements KeyHandler {
    public static final KeyCode arrow_left = KeyCode.LEFT;
    public static final KeyCode a = KeyCode.A;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if(arrow_left.equals(event.getCode()) || a.equals(event.getCode()))
            map.getPlayer().move(-1, 0);
    }
}

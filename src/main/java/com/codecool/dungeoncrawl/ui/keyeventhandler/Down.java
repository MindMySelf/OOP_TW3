package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Down implements KeyHandler {
    public static final KeyCode arrow_down = KeyCode.DOWN;
    public static final KeyCode s = KeyCode.S;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if (arrow_down.equals(event.getCode()) || s.equals(event.getCode()))
            map.getPlayer().move(0, 1);
    }
}

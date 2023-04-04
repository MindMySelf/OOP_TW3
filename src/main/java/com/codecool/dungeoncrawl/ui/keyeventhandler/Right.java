package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Right implements KeyHandler {
    public static final KeyCode arrow_right = KeyCode.RIGHT;
    public static final KeyCode d = KeyCode.D;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if(arrow_right.equals(event.getCode()) || d.equals(event.getCode()))
        map.getPlayer().getAction().move(1, 0);
    }
}

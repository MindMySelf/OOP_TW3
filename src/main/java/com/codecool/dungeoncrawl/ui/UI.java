package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Skeleton;
import com.codecool.dungeoncrawl.logic.GameLogic;
import com.codecool.dungeoncrawl.ui.elements.MainStage;
import com.codecool.dungeoncrawl.ui.keyeventhandler.KeyHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class UI {
    private Canvas canvas;
    private GraphicsContext context;

    private MainStage mainStage;
    private GameLogic logic;
    private Set<KeyHandler> keyHandlers;
    private Random random = new Random();

    private List<Skeleton> skelylist;


    public UI(GameLogic logic, Set<KeyHandler> keyHandlers) {
        this.canvas = new Canvas(
                logic.getMapWidth() * Tiles.TILE_WIDTH,
                logic.getMapHeight() * Tiles.TILE_WIDTH);
        this.logic = logic;
        this.context = canvas.getGraphicsContext2D();
        this.mainStage = new MainStage(canvas);
        this.keyHandlers = keyHandlers;
    }

    public void setUpPain(Stage primaryStage) {
        Scene scene = mainStage.getScene();
        primaryStage.setScene(scene);
        logic.setup();
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        for (KeyHandler keyHandler : keyHandlers) {
            keyHandler.perform(keyEvent, logic.getMap());
        }
        refresh();
    }

    public void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < logic.getMapWidth(); x++) {
            for (int y = 0; y < logic.getMapHeight(); y++) {

                Cell cell = logic.getCell(x, y);
                if (cell.getActor() != null && cell.getActor().getHealth() >= 0) {
                    Tiles.drawTile(context, cell.getActor(), x, y);
                } else{
                    Tiles.drawTile(context, cell, x, y);
                }
            }
        }


        skelylist = logic.getMap().getSkeletons();


        for(Skeleton skeleton: skelylist){
            int randomX = random.nextInt(3) - 1;
            skeleton.move(randomX, 0);
        }
        logic.getMap().getGuard().move(random.nextInt(3) - 1, 0);


        mainStage.setHealthLabelText(logic.getPlayerHealth());
        mainStage.setDamageLabelText(logic.getPlayerDamage());
        mainStage.updateInventory(logic.getMap().getPlayer().getInventory());
    }
}

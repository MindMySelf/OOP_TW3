package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    public static int TILE_WIDTH = 32;
    public static int DRAW_WITH = 48;

    private static Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static Map<String, Tile> tileMap = new HashMap<>();
    public static class Tile {
        public final int x, y, w, h;
        Tile(int i, int j) {
            x = i * (TILE_WIDTH + 2);
            y = j * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static {
        tileMap.put("empty", new Tile(0, 0));
        tileMap.put("wall", new Tile(10, 17));
        tileMap.put("floor", new Tile(2, 0));
        tileMap.put("player", new Tile(27, 0));
        tileMap.put("skeleton", new Tile(29, 6));
        tileMap.put("guard", new Tile(28, 0));
        tileMap.put("door", new Tile(3,4));
        tileMap.put("bridge", new Tile(6,5));
        tileMap.put("water", new Tile(8,4));
        tileMap.put("apple", new Tile(15,29));
        tileMap.put("road", new Tile(3,0));
        tileMap.put("treeType1", new Tile(2,1));
        tileMap.put("treeType2", new Tile(3,1));
        tileMap.put("campfire", new Tile(14,10));
        tileMap.put("key", new Tile(16,23));
        tileMap.put("grass", new Tile(7,0));
        tileMap.put("gold", new Tile(9,26));
        tileMap.put("gem", new Tile(17,22));
    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        Tile tile = tileMap.get(d.getTileName());
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                x * DRAW_WITH, y * DRAW_WITH, DRAW_WITH, DRAW_WITH);
    }
}

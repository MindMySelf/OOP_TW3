package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Player;

public class GameLogic {
    private GameMap map;

    public GameLogic() {
        this.map = MapLoader.loadMap(Player.mapIndex);
    }

    public double getMapWidth() {
        return map.getWidth();
    }

    public double getMapHeight() {
        return map.getHeight();
    }

    public void setup() {
    }

    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public String getPlayerHealth() {
        return Integer.toString(map.getPlayer().getHealth());
    }


    public String getPlayerDamage() {
        return Integer.toString(map.getPlayer().getDamage());
    }

public void loadNextMap() {
    System.out.println("helo");
        if(map.getPlayer().getX() == 21 && map.getPlayer().getY() == 19){
            this.map = MapLoader.loadMap(map.getPlayer().getMapIndex());
        }
        else{
            System.out.println(map.getPlayer().getMapIndex() + " | " + map.getPlayer().getX() + " | " + map.getPlayer().getY() + " | " + map.getCell(21, 18));
        }
}
    public GameMap getMap() {
        return map;
    }

}

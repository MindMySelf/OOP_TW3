package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Guard;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.Skeleton;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/map.txt");
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            Skeleton skeleton = new Skeleton(cell);
                            map.addSkeleton(skeleton);
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            break;
                        case 'g':
                            cell.setType(CellType.FLOOR);
                            map.addGuard(new Guard(cell));
                            break;
                        case 'd':
                            cell.setType(CellType.DOOR);
                            break;
                        case 'w':
                            cell.setType(CellType.WATER);
                            break;
                        case 'b':
                            cell.setType(CellType.BRIDGE);
                            break;
                        case 'W':
                            cell.setType(CellType.WOODS);
                            break;
                        case 't':
                            cell.setType(CellType.TREE);
                            break;
                        case 'c':
                            cell.setType(CellType.CAMPFIRE);
                            break;
                        case 'r':
                            cell.setType(CellType.ROAD);
                            break;
                        case 'k':
                            cell.setType(CellType.KEY);
                            break;
                        case 'G':
                            cell.setType(CellType.GRASS);
                            break;
                        case 'a':
                            cell.setType(CellType.APPLE);
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}

package tile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;

import main.GamePanel;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    public String currMapName  = "house main";
    public TreeMap<String, GameMap> mapList;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        getTileImages();
        mapList = new TreeMap<String, GameMap>();
        mapList.put("house main", new GameMap("/res/maps/houseMain.txt", 28, 14, gp));
        mapList.put("house bedroom", new GameMap("/res/maps/houseBedroom.txt", 16, 8, gp));
        mapList.put("yard", new GameMap("/res/maps/yard.txt", 50, 50, gp));

        loadMap(currMapName);
    }

    public void getTileImages() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResource("/res/tiles/grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResource("/res/tiles/wall.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResource("/res/tiles/water01.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResource("/res/tiles/hut.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResource("/res/tiles/bush.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResource("/res/tiles/woodFloor.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResource("/res/tiles/earth.png"));

            

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String mapName) {
        mapList.get(currMapName).objectList = gp.obj;

        GameMap map = mapList.get(mapName);
        gp.maxWorldCol = map.worldCol;
        gp.maxWorldRow = map.worldrow;
        this.mapTileNum = map.mapTileNum;
        this.currMapName = mapName;


        //if map.objectlist is not empty make it the current objectlist
        //this.gp.obj = map.objectList;
    }

    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;

        while ( worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int  TileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

                if(worldX > gp.player.worldX - gp.player.screenX - gp.tileSize &&
                worldX < gp.player.worldX + gp.player.screenX + gp.tileSize &&
                worldY > gp.player.worldY - gp.player.screenY - gp.tileSize &&
                worldY < gp.player.worldY + gp.player.screenY + gp.tileSize) {

                    g2.drawImage(tile[TileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

               }

            worldCol++;

            if(worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }


    }
}

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
        tile = new Tile[25];
        getTileImages();
        mapList = new TreeMap<String, GameMap>();
        mapList.put("house main", new GameMap("/res/maps/houseMain.txt", 28, 14, gp));
        mapList.put("house bedroom", new GameMap("/res/maps/houseBedroom.txt", 19, 10, gp));
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
            tile[2].image = ImageIO.read(getClass().getResource("/res/tiles/water00.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResource("/res/tiles/void.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResource("/res/tiles/bush.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResource("/res/tiles/woodFloor.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResource("/res/tiles/earth.png"));



            //Walls (border only)
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResource("/res/tiles/walls/leftBottom.png"));
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResource("/res/tiles/walls/rightBottom.png"));
            tile[8].collision = true;

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResource("/res/tiles/walls/left.png"));
            tile[9].collision = true;

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResource("/res/tiles/walls/bottom.png"));
            tile[10].collision = true;

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResource("/res/tiles/walls/right.png"));
            tile[11].collision = true;

            //Walls

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResource("/res/tiles/walls/bottomWall.png"));
            tile[12].collision = true;

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResource("/res/tiles/walls/leftBottomWall.png"));
            tile[13].collision = true;

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResource("/res/tiles/walls/rightBottomWall.png"));
            tile[14].collision = true;

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResource("/res/tiles/walls/topWall.png"));
            tile[15].collision = true;

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResource("/res/tiles/walls/rightTopWall.png"));
            tile[16].collision = true;

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResource("/res/tiles/walls/leftTopWall.png"));
            tile[17].collision = true;

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResource("/res/tiles/walls/leftWall.png"));
            tile[18].collision = true;

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResource("/res/tiles/walls/rightWall.png"));
            tile[19].collision = true;

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResource("/res/tiles/walls/wall.png"));
            tile[20].collision = true;




            

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String mapName) {
        GameMap map = mapList.get(mapName);
        gp.maxWorldCol = map.worldCol;
        gp.maxWorldRow = map.worldrow;
        this.mapTileNum = map.mapTileNum;
        this.currMapName = mapName;
        this.gp.obj = map.objectList;
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

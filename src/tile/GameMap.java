package tile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import main.GamePanel;
import object.SuperObject;

public class GameMap {
    int[][] mapTileNum;
    int worldCol;
    int worldrow;
    String mapPath;
    SuperObject objectList[];

    public GameMap(String mapPath, int worldCol, int worldRow, GamePanel gp) {
        this.worldCol = worldCol;
        this.worldrow = worldRow;
        this.mapPath = mapPath;
        loadMap();
    }

    private void loadMap() {
        mapTileNum = new int[worldCol][worldrow];
        try {
            InputStream is = getClass().getResourceAsStream(mapPath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while ( col < worldCol && row < worldrow) {
                String line = br.readLine();


                while (col < worldCol) {
                    
                    String numbers[] = line.split(" ");

                    int num;
                     
                    try {
                        num = Integer.parseInt(numbers[col]);
                    } catch (Exception e) {
                        num = 4;
                    }

                    //int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }

                if (col == worldCol) {
                    col = 0;
                    row ++;
                }
            }
            br.close();
        } catch (Exception e) {
        }
    }

}

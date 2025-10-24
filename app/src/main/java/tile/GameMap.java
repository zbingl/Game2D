package tile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import main.GamePanel;
import object.SuperObject;

public class GameMap {
    int[][] mapTileNum;
    int worldCol;
    int worldrow;
    String mapPath;
    ArrayList<SuperObject> objectList;
    GamePanel gp;

    public GameMap(String mapPath, int worldCol, int worldRow, GamePanel gp) {
        this.worldCol = worldCol;
        this.worldrow = worldRow;
        this.mapPath = mapPath;
        this.gp = gp;
        this.objectList = gp.aSetter.setObjects(mapPath);
        try {
            System.out.println(this.objectList.get(0).toString());
        } catch (Exception e) {
            System.out.println("empty");
        }
        
        loadMapFile();
    }

    private void loadMapFile() {
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

package object;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Door extends SuperObject {
    int itemFrame = 1;
    int newPlayerX;
    int newPlayerY;
    BufferedImage frame1;
    BufferedImage frame2;
    GamePanel gp;
    String mapName;


    public OBJ_Door(String direction, GamePanel gp, String mapName, int newPlayerX, int newPlayerY) {
        name = "door";
        
        
        interactable = true;
        collision = true;
        this.gp = gp;
        this.mapName = mapName;
        this.newPlayerX = newPlayerX;
        this.newPlayerY = newPlayerY;
        
        if (direction.equals("in")) {
            try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/doorEnterance.png"));
            dimX = 1;
            dimY = 2;
            trueArea = new Rectangle(0, 0 , dimX * 48, dimY * 48);

        } catch (IOException e) {
            e.printStackTrace();
        }  
        } else {
            try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/doorExit(1x1).png"));
            dimX = 1;
            dimY = 1;
            trueArea = new Rectangle(0, 0 , dimX * 48, dimY * 48);

        } catch (IOException e) {
            e.printStackTrace();
        }  
        }

        solidArea = new Rectangle(0, 0 , dimX * 48, dimY * 48);

         
    }

    @Override
    public void interact() {
        gp.tileM.loadMap(mapName);
        gp.player.worldX = newPlayerX * gp.tileSize;
        gp.player.worldY = newPlayerY * gp.tileSize;
        gp.player.currObject = 999;

    }
}

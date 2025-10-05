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
    String mapPath;


    public OBJ_Door(GamePanel gp, String mapPath, int newPlayerX, int newPlayerY) {
        super();
        name = "door";
        dimX = 1;
        dimY = 2;
        solidArea = new Rectangle(0, 0 , dimX * 48, dimY * 48);
        interactable = true;
        collision = true;
        this.gp = gp;
        this.mapPath = mapPath;
        this.newPlayerX = newPlayerX;
        this.newPlayerY = newPlayerY;
        

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/door.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }   
    }

    @Override
    public void interact() {
        //Change this to something better asap
        gp.tileM.loadMap(mapPath);
        
        gp.aSetter.setObjects();
        gp.player.worldX = newPlayerX * gp.tileSize;
        gp.player.worldY = newPlayerY * gp.tileSize;
        gp.player.currObject = 999;

    }
}

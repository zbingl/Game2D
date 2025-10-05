package object;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Door extends SuperObject {
    int itemFrame = 1;
    BufferedImage frame1;
    BufferedImage frame2;
    GamePanel gp;
    String mapPath;

    public OBJ_Door(GamePanel gp, String mapPath) {
        name = "door";
        dimX = 1;
        dimY = 2;
        interactable = true;
        collision = true;
        this.gp = gp;
        this.mapPath = mapPath;
        

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/door.png"));
            frame1 = image;
            frame2 = ImageIO.read(getClass().getResourceAsStream("/res/objects/door.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }

    @Override
    public void interact() {
        gp.tileM.loadMap(mapPath);
        gp.aSetter.setObjects();

        /*
        itemFrame = itemFrame == 1 ? 2 : 1;
        if (itemFrame == 1) {
            image = frame1;
        }
        if (itemFrame == 2) {
            image = frame2;
        }
        */
    }
}

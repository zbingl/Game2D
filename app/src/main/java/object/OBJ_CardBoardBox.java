package object;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_CardBoardBox extends SuperObject {
    int itemFrame = 1;
    BufferedImage frame1;
    BufferedImage frame2;

    public OBJ_CardBoardBox() {
        
        name = "box";
        dimX = 1;
        dimY = 1;
        interactable = true;
        collision = true;
        solidArea = new Rectangle(0, 0 , dimX * 48, dimY * 48);
        

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/box-closed.png"));
            frame1 = image;
            frame2 = ImageIO.read(getClass().getResourceAsStream("/res/objects/box-open.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }

    @Override
    public void interact() {
        itemFrame = itemFrame == 1 ? 2 : 1;
        if (itemFrame == 1) {
            image = frame1;
        }
        if (itemFrame == 2) {
            image = frame2;
        }
    }
}

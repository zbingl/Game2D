package object;

import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Shelf extends SuperObject{
    public OBJ_Shelf() {
    super();
    name = "shelf";
    dimX = 2;
    dimY = 3;
    solidArea = new Rectangle(0, 0 , dimX * 48, dimY * 48);
    try {
        image = ImageIO.read(getClass().getResourceAsStream("/res/objects/shelf(2x3).png"));
    } catch (IOException e) {
        e.printStackTrace();
    }

    collision = true;
    }
}

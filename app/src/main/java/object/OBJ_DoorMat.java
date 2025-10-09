package object;

import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_DoorMat extends SuperObject {
    public OBJ_DoorMat() {
    super();
    name = "doormat";
    dimX = 1;
    dimY = 1;
    solidArea = new Rectangle(0, 0 , dimX * 48, dimY * 48);
    try {
        image = ImageIO.read(getClass().getResourceAsStream("/res/objects/doorMat(1x1).png"));
    } catch (IOException e) {
        e.printStackTrace();
    }

    }
}

package object;

import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_DoubleBed extends SuperObject {
    public OBJ_DoubleBed() {
    super();
    name = "double bed";
    dimX = 4;
    dimY = 6;
    solidArea = new Rectangle(0, 0 , dimX * 48, dimY * 48);
    try {
        image = ImageIO.read(getClass().getResourceAsStream("/res/objects/doubleBed(4x6).png"));
    } catch (IOException e) {
        e.printStackTrace();
    }

    collision = true;
    }
}

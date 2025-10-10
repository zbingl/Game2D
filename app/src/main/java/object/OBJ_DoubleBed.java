package object;

import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_DoubleBed extends SuperObject {
    public OBJ_DoubleBed() {
    super(3,4);
    name = "double bed";
    try {
        image = ImageIO.read(getClass().getResourceAsStream("/res/objects/doubleBed(3x4).png"));
    } catch (IOException e) {
        e.printStackTrace();
    }

    collision = true;
    }
}

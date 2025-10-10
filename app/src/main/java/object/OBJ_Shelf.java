package object;

import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Shelf extends SuperObject{
    public OBJ_Shelf() {
    super(2,3);
    name = "shelf";
    try {
        image = ImageIO.read(getClass().getResourceAsStream("/res/objects/shelf(2x3).png"));
    } catch (IOException e) {
        e.printStackTrace();
    }

    collision = true;
    }
}

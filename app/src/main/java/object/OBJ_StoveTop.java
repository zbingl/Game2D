package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_StoveTop extends SuperObject{
    public OBJ_StoveTop() {
    super(1,1);
    name = "stovetop";
    try {
        image = ImageIO.read(getClass().getResourceAsStream("/res/objects/stoveTop(1x1).png"));
    } catch (IOException e) {
        e.printStackTrace();
    }

    collision = true;
    }
}

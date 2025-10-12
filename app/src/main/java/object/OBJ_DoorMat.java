package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_DoorMat extends SuperObject {
    public OBJ_DoorMat() {
    super(1,1);
    name = "doormat";
    try {
        image = ImageIO.read(getClass().getResourceAsStream("/res/objects/doorMat(1x1).png"));
    } catch (IOException e) {
        e.printStackTrace();
    }

    }
}

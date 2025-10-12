package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Sink extends SuperObject {
    public OBJ_Sink() {
    super(1,1);
    name = "sink";
    try {
        image = ImageIO.read(getClass().getResourceAsStream("/res/objects/sink(1x1).png"));
    } catch (IOException e) {
        e.printStackTrace();
    }

    collision = true;
    }
}

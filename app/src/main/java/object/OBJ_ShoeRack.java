package object;

import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Rectangle;

public class OBJ_ShoeRack extends SuperObject {
    public OBJ_ShoeRack() {
    super(2,1);
    name = "shoerack";
    try {
        image = ImageIO.read(getClass().getResourceAsStream("/res/objects/shoeRack(2x1).png"));
    } catch (IOException e) {
        e.printStackTrace();
    }

    collision = true;
    }
}

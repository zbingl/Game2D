package object;

import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Rectangle;

public class OBJ_ShoeRack extends SuperObject {
    public OBJ_ShoeRack() {
    super();
    name = "shoerack";
    dimX = 2;
    dimY = 1;
    solidArea = new Rectangle(0, 0 , dimX * 48, dimY * 48);
    try {
        image = ImageIO.read(getClass().getResourceAsStream("/res/objects/shoeRack(2x1).png"));
    } catch (IOException e) {
        e.printStackTrace();
    }

    collision = true;
    }
}

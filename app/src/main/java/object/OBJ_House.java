package object;

import java.awt.Rectangle;
import java.io.IOException;
import javax.imageio.ImageIO;


//Buildings should not be objects, this is only for testing
public class OBJ_House extends SuperObject {

    public OBJ_House() {
        super();
        name = "house";
        dimX = 14;
        dimY = 8;
        solidArea = new Rectangle(0, 0 , dimX * 48, (dimY-1) * 48);
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/house.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}


package object;

import java.awt.Rectangle;
import java.io.IOException;
import javax.imageio.ImageIO;


//Buildings should not be objects, this is only for testing
public class OBJ_House extends SuperObject {

    public OBJ_House() {
        super(14,8);
        name = "house";
        solidArea = new Rectangle(0, 48*4 , (dimX) * 48, (dimY-5) * 48);
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/house.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}


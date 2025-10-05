package object;

import java.awt.Rectangle;
import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_CasetteComputer extends SuperObject {

    public OBJ_CasetteComputer() {
        super();
        name = "box";
        dimX = 4;
        dimY = 3;
        solidArea = new Rectangle(0, 0 , dimX * 48, dimY * 48);
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/CasetteComputer.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

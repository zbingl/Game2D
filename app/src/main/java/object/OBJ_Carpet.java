package object;

import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Rectangle;

public class OBJ_Carpet extends SuperObject{
    public OBJ_Carpet() {
        super();
        name = "carpet";
        dimX = 4;
        dimY = 6;
        solidArea = new Rectangle(0, 0 , dimX * 48, dimY * 48);
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/carpet(4x6).png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = false;
    }

}

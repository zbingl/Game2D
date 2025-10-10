package object;

import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Rectangle;

public class OBJ_Carpet extends SuperObject{
    public OBJ_Carpet() {
        super(4,6);
        name = "carpet";
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/carpet(4x6).png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = false;
    }

}

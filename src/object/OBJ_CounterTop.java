package object;

import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_CounterTop extends SuperObject {
    public OBJ_CounterTop() {
        super();
        name = "counter top ";
        dimX = 1;
        dimY = 1;
        solidArea = new Rectangle(0, 0 , dimX * 48, dimY * 48);
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/counterTop(1x1).png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }
}


package object;


import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Rectangle;

public class OBJ_DinnerTable extends SuperObject {
    public OBJ_DinnerTable() {
        super();
        name = "dinner table";
        dimX = 2;
        dimY = 3;
        solidArea = new Rectangle(0, 0 , dimX * 48, dimY * 48);
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/dinnerTable(2x3).png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }
}

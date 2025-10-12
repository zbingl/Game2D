package object;


import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_DinnerTable extends SuperObject {
    public OBJ_DinnerTable() {
        super(2,3);
        name = "dinner table";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/dinnerTable(2x3).png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }
}

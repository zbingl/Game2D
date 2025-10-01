package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_CardBoardBox extends SuperObject {

    public OBJ_CardBoardBox() {
        name = "box";
        dimX = 1;
        dimY = 1;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/box-open.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

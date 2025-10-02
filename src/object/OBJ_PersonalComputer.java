package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_PersonalComputer extends SuperObject {

    public OBJ_PersonalComputer() {
        name = "box";
        dimX = 1;
        dimY = 1;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/computer1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_CasetteComputer extends SuperObject {

    public OBJ_CasetteComputer() {
        name = "box";
        dimX = 4;
        dimY = 3;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/CasetteComputer.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

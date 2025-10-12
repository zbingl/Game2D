package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_CasetteComputer extends SuperObject {

    public OBJ_CasetteComputer() {
        super(4,3);
        name = "casette computer";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/CasetteComputer.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

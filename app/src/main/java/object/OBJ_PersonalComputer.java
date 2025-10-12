package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_PersonalComputer extends SuperObject {

    public OBJ_PersonalComputer() {
        super(1,1);
        name = "box";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/computer1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

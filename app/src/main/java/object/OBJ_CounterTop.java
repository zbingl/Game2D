package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_CounterTop extends SuperObject {
    public OBJ_CounterTop() {
        super(1,1);
        name = "counter top ";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/counterTop(1x1).png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }
}


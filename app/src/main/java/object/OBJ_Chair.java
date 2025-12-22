package object;

import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Chair extends SuperObject{
    public OBJ_Chair(String direction) {
        super(1,2);
        name = "chair ";
        solidArea = new Rectangle(0, 0 , dimX * 48, dimY * 48);
        if (direction.equals("left")) {
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/res/objects/chairSideLeft(1x2).png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
           try {
                image = ImageIO.read(getClass().getResourceAsStream("/res/objects/chairSideRight(1x2).png"));
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
        
        collision = true;
        pickupable = true;
    }

}

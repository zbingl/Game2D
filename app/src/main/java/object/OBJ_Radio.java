package object;

import java.awt.Rectangle;
import java.io.IOException;
import javax.imageio.ImageIO;

import music.MusicPlayer;

public class OBJ_Radio extends SuperObject{
    MusicPlayer player;

    public OBJ_Radio() {
        super(1,1);
        name = "radio";
        collision = true;
        interactable = true;


        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/radio.png"));
            player = new MusicPlayer("/res/music/Dire Straits - Sultans Of Swing.wav");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public void interact() {
        if (player.playing) {
            player.stop();
        } else {
            player.play();
        }
    }
}



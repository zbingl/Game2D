package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import music.MusicPlayer;

public class OBJ_Radio extends SuperObject{
    MusicPlayer player;

    public OBJ_Radio() {
        name = "radio";
        dimX = 1;
        dimY = 1;
        collision = true;
        interactable = true;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/radio.png"));
            player = new MusicPlayer("src/music/Dire Straits - Sultans Of Swing.wav");
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



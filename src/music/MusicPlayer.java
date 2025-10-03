package music;

import javax.sound.sampled.*;
import java.io.File;


public class MusicPlayer {

    public MusicPlayer (String songPath){
        new Thread(() -> {
        try {
            File soundFile = new File(songPath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            
        } catch(Exception e) {
            System.exit(0);
        }
        }).start();
        
    }
   
}

package music;

import javax.sound.sampled.*;
import java.io.File;

public class MusicPlayer {
    private Thread musicThread;
    private Clip clip;
    public boolean playing = false;


    public MusicPlayer(String songPath) {
        musicThread = new Thread(() -> {
            try {
                File soundFile = new File(songPath);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        musicThread.start();
    }

    public void play() {
        playing = true;
        System.out.println("radio on");
        
        if (clip != null && !clip.isRunning()) {
            clip.start();
        }
    }

    public void stop() {
        playing = false;
        System.out.println("radio off");
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}

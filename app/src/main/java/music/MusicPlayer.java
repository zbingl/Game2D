package music;

import javax.sound.sampled.*;
import java.io.InputStream;

public class MusicPlayer {
    private Thread musicThread;
    private Clip clip;
    public boolean playing = false;

    public String onMessage = "on";
    public String offMessage = "off";

    public MusicPlayer(String songPath) {
        musicThread = new Thread(() -> {
            try {
                InputStream is = getClass().getResourceAsStream(songPath);
                if (is == null) {
                    throw new IllegalArgumentException("Could not find resource: " + songPath);
                }

                AudioInputStream audioStream = AudioSystem.getAudioInputStream(is);
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
        System.out.println(onMessage);
        if (clip != null && !clip.isRunning()) {
            //clip.setFramePosition(0); // Restart from beginning each time
            clip.start();
        }
    }

    public void stop() {
        playing = false;
        System.out.println(offMessage);
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public void setOnMessage(String message) {
        onMessage = message;
    }

    public void setOffMessage(String message) {
        offMessage = message;
    }
}


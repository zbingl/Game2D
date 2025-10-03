package main;

import javax.swing.JFrame;
import music.MusicPlayer;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Game");

        

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();


        window.setLocationRelativeTo(null);
        window.setVisible(true);

        new MusicPlayer("src/music/Dire Straits - Sultans Of Swing.wav");

        gamePanel.setUpGame();
        gamePanel.startGameThread();
    }
}

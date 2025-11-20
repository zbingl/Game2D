package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
    




    final int originalTileSize = 16; // 16 x 16 px
    final int scale = 3;
    public int maxWorldCol = 16;
    public int maxWorldRow = 12;
    int FPS = 60;

    public final int tileSize = originalTileSize * scale; // 48 x 48 px
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public final int screenWidth = (int) screenSize.getWidth();
    public final int screenHeight = (int) screenSize.getHeight();;


    

    
    Thread gameThread;

    public KeyHandler keyH = new KeyHandler(this);
    public CollisionChecker cc = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this, keyH);
    public ArrayList<SuperObject> obj = new ArrayList<>();
    public TileManager tileM = new TileManager(this);
    public PlayerHUD pHUD = new PlayerHUD(this);


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }


    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {
            update();
            repaint();
            
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }

    public void update() {
        player.update();
    }

    

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2);
        if (player.behindObject) {
            player.draw(g2);
            for (int i = 0; i < obj.size(); i++) {
                if (obj.get(i) != null) {
                    obj.get(i).draw(g2, this);
                }
            } 
        } else {
            for (int i = 0; i < obj.size(); i++) {
                if (obj.get(i) != null) {
                    obj.get(i).draw(g2, this);
                }
            }
            player.draw(g2);
        }
        
        pHUD.draw(g2);
        
        g2.dispose();
    }

    
}

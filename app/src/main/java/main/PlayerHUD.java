package main;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayerHUD {
    GamePanel gp;

    boolean inventory = true;
    boolean menu = false;
    String inventoryImagePath = "/res/hud/InventoryBar.png";
    public BufferedImage inventoryImage;


    public PlayerHUD(GamePanel gp) {
        this.gp = gp;
        try {
                inventoryImage = ImageIO.read(getClass().getResourceAsStream(inventoryImagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void drawInventory(Graphics2D g2) {
        g2.drawImage(inventoryImage, 600, gp.screenHeight - 180, 320 * 2, 32 * 2, null);
    }

    public void drawMenu(Graphics2D g2) {
        System.err.println("menu is drawn");
    }


    public void draw(Graphics2D g2) {
        if (inventory) {drawInventory(g2);};
        if (menu) {drawMenu(g2);}
    }





}

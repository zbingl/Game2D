package main;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import object.SuperObject;

public class PlayerHUD {
    GamePanel gp;

    boolean inventory = true;
    boolean menu = false;

    String inventoryImagePath = "/res/hud/InventoryBar.png";
    String interactionMessageImagePath = "/res/hud/interactMessage.png";

    int inventoryBarWidth = 360;

    public BufferedImage inventoryImage;
    public BufferedImage interactionMessageImage;


    public PlayerHUD(GamePanel gp) {
        this.gp = gp;
        try {
                inventoryImage = ImageIO.read(getClass().getResourceAsStream(inventoryImagePath));
                interactionMessageImage = ImageIO.read(getClass().getResourceAsStream(interactionMessageImagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void toggleInventory() {
        this.inventory = !this.inventory;
    }

    public void drawInventory(Graphics2D g2) {
        int inventoryX = 600;
        int inventoryY = 5 * gp.screenHeight / 6;

        g2.drawImage(inventoryImage, 
        inventoryX, 
        inventoryY, 
        (gp.screenWidth - inventoryBarWidth)/2 , 
        32 * 2, 
        null);

        ArrayList<SuperObject> inventoryList = gp.pInv.getInventory();
        for (int i = 0; i < inventoryList.size(); i++) {
            SuperObject obj = inventoryList.get(i);
            g2.drawImage(obj.image, 
                inventoryX + gp.tileSize/2 + i*gp.tileSize, 
                inventoryY, 
                obj.dimX*gp.tileSize / Math.max(obj.dimX, obj.dimY), 
                obj.dimY*gp.tileSize / Math.max(obj.dimX, obj.dimY), 
                null);
        }
    }

    public void drawInderactionMessage(Graphics2D g2) {
        g2.drawImage(interactionMessageImage, 
        gp.player.screenX - 1 * gp.tileSize / 3, 
        gp.player.screenY - 8 * gp.tileSize / 3, 
        gp.tileSize * gp.player.dimX * 2, 
        gp.tileSize * gp.player.dimY, 
        null);
    }

    public void drawMenu(Graphics2D g2) {
        System.err.println("menu is drawn");
    }


    public void draw(Graphics2D g2) {
        if (inventory) {drawInventory(g2);};
        if (menu) {drawMenu(g2);}
    }





}

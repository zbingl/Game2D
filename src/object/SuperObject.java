package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public boolean interactable = false;
    public int worldX, worldY;
    public int dimX, dimY;
    public Rectangle solidArea;
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;



    public void draw(Graphics2D g2, GamePanel gp) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if(worldX > gp.player.worldX - gp.player.screenX - gp.tileSize*dimX &&
        worldX < gp.player.worldX + gp.player.screenX + gp.tileSize*dimX &&
        worldY > gp.player.worldY - gp.player.screenY - gp.tileSize*dimY &&
        worldY < gp.player.worldY + gp.player.screenY + gp.tileSize*dimY) {
            g2.drawImage(image, screenX, screenY, dimX*gp.tileSize, dimY*gp.tileSize, null);
        }
    }
    
    public void interact() {
        
    }

    public String toString() {
        return name;
    }
}

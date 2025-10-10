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
    public Rectangle trueArea;
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    public SuperObject(int dimX, int dimY) {
        this.dimX = dimX;
        this.dimY = dimY;
        this.trueArea = new Rectangle(0, 0 , dimX * 48, dimY * 48);
        this.solidArea = new Rectangle(0, 0 , dimX * 48, dimY * 48);
    }



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

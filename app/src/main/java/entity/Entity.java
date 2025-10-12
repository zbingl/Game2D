package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldX,worldY;
    public int dimX, dimY;
    public int speed;
    public int speedBonus;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public int spriteCounter = 0;
    public int spriteNum = 1;

    public BufferedImage up0, up1, up2, down0, down1, down2, left1, left2, right1, right2;
    
    public String direction;

    public Rectangle solidArea;
    public Rectangle trueArea;

    public boolean moving;
    public boolean sprinting;
    public boolean collisionOn = false;
    public boolean behindObject = false;

    
}
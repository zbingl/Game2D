package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH2) {
        this.gp = gp;
        this.keyH = keyH2;

        screenX = gp.screenWidth/2 -gp.tileSize/2;
        screenY = gp.screenHeight/2 - gp.tileSize/2;

        solidArea = new Rectangle(8, 16, 32, 32);



        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        dimX = 1;
        dimY = 2;
        speed = 4;
        direction = "down";
        moving = false;
        sprinting = false;
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_2.png"));
            down0 = ImageIO.read(getClass().getResourceAsStream("/res/player/down_still.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/down_step1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/down_step2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/left_still.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/left_still.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/right_still.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/right_still.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            moving = true;
            sprinting = false;
            if (keyH.shiftPressed){
                sprinting = true;
            }

            speedBonus = sprinting ? speed : 0;

            collisionOn = false;
            

            if (keyH.upPressed) {
                direction = "up";
                gp.cc.checkTile(this);
                worldY -= !collisionOn ? speed + speedBonus : 0;
                collisionOn = false;
            }
            if (keyH.downPressed) {
                direction = "down";
                gp.cc.checkTile(this);
                worldY += !collisionOn ? speed + speedBonus : 0;
                collisionOn = false;
            }
            if (keyH.leftPressed) {
                direction = "left";
                gp.cc.checkTile(this);
                worldX -= !collisionOn ? speed + speedBonus : 0;
                collisionOn = false;
            }
            if (keyH.rightPressed) {
                direction = "right";
                gp.cc.checkTile(this);
                worldX += !collisionOn ? speed + speedBonus : 0;
                collisionOn = false;
            }

            



            spriteCounter ++;
            if (spriteCounter > 12 - (speedBonus * 3)/2) {
                spriteNum++;
                if(spriteNum == 5) {
                    spriteNum = 1;}
                spriteCounter = 0;
            }
        } else {
            moving = false;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 2 && moving) {
                    image = up2;
                    
                } else {
                    image = up1;
                }
                break;
            case "down":
                if (moving) {
                    switch (spriteNum) {
                        case 1: image = down1; break;
                        case 2: image = down0; break;
                        case 3: image = down2; break;
                        case 4: image = down0; break;
                        
                    }
                } else {
                    image = down0;
                }
                break;
            case "left":
                if (spriteNum == 2 && moving) {
                    image = left2;
                    
                } else {
                    image = left1;
                }
                break;
            case "right":
                if (spriteNum == 2 && moving) {
                    image = right2;
                    
                } else {
                    image = right1;
                }
                break;
            default:
                break;
        }

        g2.drawImage(image, 
        screenX - gp.tileSize * (dimX - 1), 
        screenY - gp.tileSize * (dimY - 1), 
        gp.tileSize * dimX, 
        gp.tileSize * dimY, 
        null);
    }
    
}

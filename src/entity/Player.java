package entity;

import java.awt.Graphics2D;
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

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
        moving = false;
        sprinting = false;
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_2.png"));
            
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

            int speedBonus = sprinting ? 1 : 0;

            if (keyH.upPressed) {
                direction = "up";
                worldY -= speed + speedBonus * speed;
            }
            if (keyH.downPressed) {
                direction = "down";
                worldY += speed + speedBonus * speed;
            }
            if (keyH.leftPressed) {
                direction = "left";
                worldX -= speed + speedBonus * speed;
            }
            if (keyH.rightPressed) {
                direction = "right";
                worldX += speed + speedBonus * speed;
            }

            spriteCounter ++;
            if (spriteCounter > 12 - (speedBonus * 12)/2) {
                if(spriteNum == 1) {
                    spriteNum = 2;
                } else if(spriteNum == 2) {
                    spriteNum = 1;
                }
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
                if (spriteNum == 2 && moving) {
                    image = down2;
                    
                } else {
                    image = down1;
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

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
    
}

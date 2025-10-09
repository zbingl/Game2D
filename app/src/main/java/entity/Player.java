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
    public int currObject = 999;
    public BufferedImage interactionMessage;

    public Player(GamePanel gp, KeyHandler keyH2) {
        this.gp = gp;
        this.keyH = keyH2;

        screenX = gp.screenWidth/2 -gp.tileSize/2;
        screenY = gp.screenHeight/2 - gp.tileSize/2;

        solidArea = new Rectangle(8, 16, 32, 32);

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;



        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 10;
        worldY = gp.tileSize * 10;
        dimX = 1;
        dimY = 2;
        speed = 4;
        direction = "down";
        moving = false;
        sprinting = false;
    }

    public void getPlayerImage() {
        try {
            up0 = ImageIO.read(getClass().getResourceAsStream("/res/player/up0.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/up2.png"));
            down0 = ImageIO.read(getClass().getResourceAsStream("/res/player/down0.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/left0.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/left1.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/right0.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/right1.png"));

            interactionMessage = ImageIO.read(getClass().getResourceAsStream("/res/hud/interactMessage.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if (keyH.eTyped && currObject < gp.obj.size() ){
            if (gp.obj.get(currObject).interactable) {
                gp.obj.get(currObject).interact(); 
            }    
        }
        keyH.consumeETyped();

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
                currObject = gp.cc.checkObject(this, true);
                worldY -= !collisionOn ? speed + speedBonus : 0;
                collisionOn = false;
            }
            if (keyH.downPressed) {
                direction = "down";
                gp.cc.checkTile(this);
                currObject = gp.cc.checkObject(this, true);
                worldY += !collisionOn ? speed + speedBonus : 0;
                collisionOn = false;
            }
            if (keyH.leftPressed) {
                direction = "left";
                gp.cc.checkTile(this);
                currObject = gp.cc.checkObject(this, true);
                worldX -= !collisionOn ? speed + speedBonus : 0;
                collisionOn = false;
            }
            if (keyH.rightPressed) {
                direction = "right";
                gp.cc.checkTile(this);
                currObject = gp.cc.checkObject(this, true);
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
                if (moving) {
                    switch (spriteNum) {
                        case 1: image = up1; break;
                        case 2: image = up0; break;
                        case 3: image = up2; break;
                        case 4: image = up0; break;
                        
                    }
                } else {
                    image = up0;
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
                if (moving) {
                    switch (spriteNum) {
                        case 1: image = left1; break;
                        case 2: image = left2; break;
                        case 3: image = left1; break;
                        case 4: image = left2; break;
                        
                    }
                } else {
                    image = left1;
                }
                break;
            case "right":
                if (moving) {
                    switch (spriteNum) {
                        case 1: image = right1; break;
                        case 2: image = right2; break;
                        case 3: image = right1; break;
                        case 4: image = right2; break;
                        
                    }
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

        if (currObject < gp.obj.size() && gp.obj.get(currObject) != null) {
            if (gp.obj.get(currObject).interactable) {
                drawInderactionMessage(g2);
            }
        }
        

    }

    public void drawInderactionMessage(Graphics2D g2) {
        g2.drawImage(interactionMessage, 
        screenX - 1 * gp.tileSize / 3, 
        screenY - 8 * gp.tileSize / 3, 
        gp.tileSize * dimX * 2, 
        gp.tileSize * dimY, 
        null);
    }
    
}

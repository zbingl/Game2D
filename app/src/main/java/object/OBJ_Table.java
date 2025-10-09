package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Table extends SuperObject{
    SuperObject objectOnTable;

    public OBJ_Table() {
        super();
        name = "table";
        dimX = 1;
        dimY = 2;
        solidArea = new Rectangle(0, 0 , dimX * 48, dimY * 48 - 16);

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/table.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }


    public OBJ_Table(SuperObject obj) {
        name = "table";
        dimX = 1;
        dimY = 2;
        solidArea = new Rectangle(0, 0 , dimX * 48, dimY * 48 - 16);

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/table.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;


        objectOnTable = obj;
        objectOnTable.worldX = worldX;
        objectOnTable.worldY = worldY;
        interactable = objectOnTable.interactable;
        
    }

    public void interact() {
        objectOnTable.interact();
    }

    public void remove() {
        objectOnTable = null;
    }


    // put and remove methods, as well as drawing both table and object

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if(worldX > gp.player.worldX - gp.player.screenX - gp.tileSize*dimX &&
        worldX < gp.player.worldX + gp.player.screenX + gp.tileSize*dimX &&
        worldY > gp.player.worldY - gp.player.screenY - gp.tileSize*dimY &&
        worldY < gp.player.worldY + gp.player.screenY + gp.tileSize*dimY) {
            g2.drawImage(image, 
            screenX, 
            screenY, 
            dimX*gp.tileSize, 
            dimY*gp.tileSize, 
            null);
            if (objectOnTable != null) {
                g2.drawImage(objectOnTable.image, 
                screenX, 
                screenY, 
                objectOnTable.dimX*gp.tileSize, 
                objectOnTable.dimY*gp.tileSize, 
                null);
            }
        }
    }

        
}


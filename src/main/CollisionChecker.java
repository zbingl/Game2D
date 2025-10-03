package main;

import java.awt.Rectangle;

import entity.Entity;
import object.SuperObject;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public int checkObject(Entity e, boolean player) {
        int index = 999;

        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null) {

                SuperObject o = gp.obj[i];

                int eSolidAreaX = e.worldX + e.solidArea.x;
                int eSolidAreaY = e.worldY + e.solidArea.y;

                Rectangle eSolidArea = new Rectangle(
                    eSolidAreaX, 
                    eSolidAreaY,
                    e.solidArea.width,
                    e.solidArea.height);  

                Rectangle objSolidArea = new Rectangle(
                    o.worldX + o.solidArea.x, 
                    o.worldY + o.solidArea.y,
                    gp.tileSize * o.dimX,
                    gp.tileSize * o.dimY);


                switch (e.direction) {
                    case "up":
                        eSolidArea.y -= (e.speed + e.speedBonus);
                        if (eSolidArea.intersects(objSolidArea)) {
                            if (o.collision) {
                                e.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        eSolidArea.y += (e.speed + e.speedBonus);
                        if (eSolidArea.intersects(objSolidArea)) {
                            if (o.collision) {
                                e.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        eSolidArea.x -= (e.speed + e.speedBonus);
                        if (eSolidArea.intersects(objSolidArea)) {
                            if (o.collision) {
                                e.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        eSolidArea.x += (e.speed + e.speedBonus);
                        if (eSolidArea.intersects(objSolidArea)) {
                            if (o.collision) {
                                e.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    }

            }
        }
        return index;
    }

    public void checkTile(Entity e) {
        int entityLeftWorldX = e.worldX + e.solidArea.x;
        int entityRightWorldX = e.worldX + e.solidArea.x + e.solidArea.width;
        int entityTopWorldY = e.worldY + e.solidArea.y;
        int entityBottomWorldY = e.worldY + e.solidArea.y + e.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        switch (e.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - e.speed - e.speedBonus)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];

                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    e.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + e.speed + e.speedBonus)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    e.collisionOn = true;
                }
                break;

            case "left":

                entityLeftCol = (entityLeftWorldX - e.speed - e.speedBonus)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];

                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    e.collisionOn = true;
                }
                break;

            case "right":
                entityRightCol = (entityRightWorldX + e.speed + e.speedBonus)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    e.collisionOn = true;
                }
                break;
        }
    }
}

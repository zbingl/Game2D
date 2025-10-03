package main;

import object.OBJ_CardBoardBox;
import object.OBJ_CasetteComputer;
import object.OBJ_PersonalComputer;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new OBJ_CardBoardBox();
        gp.obj[0].worldX = 6 * gp.tileSize;
        gp.obj[0].worldY = 5 * gp.tileSize;

        gp.obj[1] = new OBJ_CasetteComputer();
        gp.obj[1].worldX = 7 * gp.tileSize;
        gp.obj[1].worldY = 1 * gp.tileSize;

        gp.obj[2] = new OBJ_PersonalComputer();
        gp.obj[2].worldX = 6 * gp.tileSize;
        gp.obj[2].worldY = 4 * gp.tileSize;
    }
}

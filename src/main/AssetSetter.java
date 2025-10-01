package main;

import object.OBJ_CardBoardBox;
import object.OBJ_CasetteComputer;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new OBJ_CardBoardBox();
        gp.obj[0].worldX = 22 * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;

        gp.obj[1] = new OBJ_CasetteComputer();
        gp.obj[1].worldX = 34 * gp.tileSize;
        gp.obj[1].worldY = 7 * gp.tileSize;
    }
}

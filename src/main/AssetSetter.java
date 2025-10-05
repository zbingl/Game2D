package main;


import object.OBJ_CardBoardBox;
import object.OBJ_CasetteComputer;
import object.OBJ_Door;
import object.OBJ_PersonalComputer;
import object.OBJ_Radio;
import object.SuperObject;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }


    public void setObjectAt(SuperObject obj, int x, int y) {
        int i = 0;
        while (gp.obj[i] != null) {
            if (i + 1 == gp.obj.length) {
                System.out.println("no space left in object array");
                return;
            }
            i++;
        }

        gp.obj[i] = obj;
        gp.obj[i].worldX = x * gp.tileSize;
        gp.obj[i].worldY = y * gp.tileSize;
    }

    public void setObjects() {
        for (int i = 0; i < gp.obj.length; i++) {
            gp.obj[i] = null;
        }

        System.out.println(gp.tileM.currMapPath);
        System.out.println("hello");

        if (gp.tileM.currMapPath == "/res/maps/map1.txt") {
            setObjectAt(new OBJ_CardBoardBox(), 9, 6);
            setObjectAt(new OBJ_CasetteComputer(), 7, 1);
            setObjectAt(new OBJ_PersonalComputer(), 6, 4);
            setObjectAt(new OBJ_Radio(), 6, 6);
            setObjectAt(new OBJ_Door(gp, "/res/maps/map2.txt"), 9, 7);
        }

        if (gp.tileM.currMapPath == "/res/maps/map2.txt") {
            setObjectAt(new OBJ_Door(gp, "/res/maps/map1.txt"), 20, 20);
        }
    }
}

package main;


import object.OBJ_CardBoardBox;
import object.OBJ_CasetteComputer;
import object.OBJ_Door;
import object.OBJ_PersonalComputer;
import object.OBJ_Radio;
import object.OBJ_Table;
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

        if (gp.tileM.currMapPath.equals("/res/maps/map1.txt")) {
            setObjectAt(new OBJ_Table(new OBJ_PersonalComputer()), 6,0);
            setObjectAt(new OBJ_Table(new OBJ_CardBoardBox()), 7, 0);
            setObjectAt(new OBJ_Table(new OBJ_Radio()), 8, 0);
            setObjectAt(new OBJ_Table(), 9, 0);
            setObjectAt(new OBJ_CasetteComputer(), 11, -1);

            setObjectAt(new OBJ_CardBoardBox(), 1, 1);
            setObjectAt(new OBJ_CardBoardBox(), 1, 2);
            setObjectAt(new OBJ_CardBoardBox(), 2, 1);





            //setObjectAt(new OBJ_CardBoardBox(), 4, 1);
            //setObjectAt(new OBJ_Radio(), 5, 1);
            setObjectAt(new OBJ_Door(gp, "/res/maps/map2.txt", 10, 12 ), 7, 10);
        }

        if (gp.tileM.currMapPath.equals("/res/maps/map2.txt")) {
            setObjectAt(new OBJ_Door(gp, "/res/maps/map1.txt", 7, 9), 10, 10);
        }
    }
}

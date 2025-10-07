package main;


import object.OBJ_CardBoardBox;
import object.OBJ_Carpet;
import object.OBJ_CasetteComputer;
import object.OBJ_Chair;
import object.OBJ_CounterTop;
import object.OBJ_DinnerTable;
import object.OBJ_Door;
import object.OBJ_DoorMat;
import object.OBJ_DoubleBed;
import object.OBJ_House;
import object.OBJ_PersonalComputer;
import object.OBJ_Radio;
import object.OBJ_Shelf;
import object.OBJ_ShoeRack;
import object.OBJ_Sink;
import object.OBJ_StoveTop;
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
            //setObjectAt(new OBJ_Table(new OBJ_PersonalComputer()), 6,0);
            //setObjectAt(new OBJ_Table(new OBJ_CardBoardBox()), 7, 0);




            //bedroom
            setObjectAt(new OBJ_Table(new OBJ_Radio()), 23, 0);
            setObjectAt(new OBJ_DoubleBed(), 24, 0);
            setObjectAt(new OBJ_Shelf(), 20, -1);
            
            //kitchen
            setObjectAt(new OBJ_CounterTop(), 1, 14);
            setObjectAt(new OBJ_CounterTop(), 1, 15);
            setObjectAt(new OBJ_CounterTop(), 1, 16);
            setObjectAt(new OBJ_Sink(), 2, 16);
            setObjectAt(new OBJ_StoveTop(), 3, 16);
            setObjectAt(new OBJ_CounterTop(), 4, 16);
            setObjectAt(new OBJ_CounterTop(), 5, 16);
            setObjectAt(new OBJ_CounterTop(), 6, 16);
            setObjectAt(new OBJ_CounterTop(), 7, 16);

            //livingroom
            setObjectAt(new OBJ_Carpet(), 5, 3);
            setObjectAt(new OBJ_DinnerTable(), 15,0);
            setObjectAt(new OBJ_Chair("left"), 17,0);
            setObjectAt(new OBJ_Chair("left"), 17,1);
            setObjectAt(new OBJ_Chair("right"), 14,0);
            setObjectAt(new OBJ_Chair("right"), 14,1);






            //hallway
            setObjectAt(new OBJ_ShoeRack(), 29, 16);
            setObjectAt(new OBJ_DoorMat(), 28, 16);


            setObjectAt(new OBJ_Door(gp, "/res/maps/map2.txt", 10, 12 ), 27, 16);
        }

        if (gp.tileM.currMapPath.equals("/res/maps/map2.txt")) {
            setObjectAt(new OBJ_House(), 8, 6);
            setObjectAt(new OBJ_Door(gp, "/res/maps/map1.txt", 27, 15), 10, 10);
        }
    }
}

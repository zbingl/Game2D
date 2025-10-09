package main;


import java.util.ArrayList;

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

    public void setObjectAt(SuperObject obj, int x, int y, ArrayList<SuperObject> objList) {
        obj.worldX = x * gp.tileSize;
        obj.worldY = y * gp.tileSize;
        objList.add(obj);
    }


    public ArrayList<SuperObject> setObjects(String mapPath) {
        ArrayList<SuperObject> objList = new ArrayList<SuperObject>();

        if (mapPath.equals("/res/maps/houseMain.txt")) {
 
            //kitchen
            setObjectAt(new OBJ_CounterTop(), 1, 10, objList);
            setObjectAt(new OBJ_CounterTop(), 1, 11, objList);
            setObjectAt(new OBJ_CounterTop(), 1, 12, objList);
            setObjectAt(new OBJ_Sink(), 2, 12, objList);
            setObjectAt(new OBJ_StoveTop(), 3, 12, objList);
            setObjectAt(new OBJ_CounterTop(), 4, 12, objList);
            setObjectAt(new OBJ_CounterTop(), 5, 12, objList);
            setObjectAt(new OBJ_CounterTop(), 6, 12, objList);
            setObjectAt(new OBJ_CounterTop(), 7, 12, objList);
            //livingroom
            setObjectAt(new OBJ_Carpet(), 3, 2, objList);
            setObjectAt(new OBJ_DinnerTable(), 15,8, objList);
            setObjectAt(new OBJ_Chair("left"), 17,8, objList);
            setObjectAt(new OBJ_Chair("left"), 17,9, objList);
            setObjectAt(new OBJ_Chair("right"), 14,8, objList);
            setObjectAt(new OBJ_Chair("right"), 14,9, objList);
            //hallway
            setObjectAt(new OBJ_ShoeRack(), 25, 12, objList);
            setObjectAt(new OBJ_DoorMat(), 24, 12, objList);

            //doors
            setObjectAt(new OBJ_Door("out", gp, "yard", 10, 12 ), 24, 13, objList);
            setObjectAt(new OBJ_Door("in", gp, "house bedroom", 15, 6 ), 24, 7, objList);
        }

        if (mapPath.equals("/res/maps/houseBedroom.txt")) {
            setObjectAt(new OBJ_Table(new OBJ_Radio()), 13, 0, objList);
            setObjectAt(new OBJ_DoubleBed(), 10, 0, objList);
            setObjectAt(new OBJ_Shelf(), 15, -1, objList);

            //doors
            setObjectAt(new OBJ_Door("out", gp, "house main", 24, 9), 15, 7, objList);
        }

        if (mapPath.equals("/res/maps/yard.txt")) {
            setObjectAt(new OBJ_House(), 8, 6, objList);

            //doors
            setObjectAt(new OBJ_Door("in", gp, "house main", 24, 12), 10, 10, objList);
        }

        

        return objList;
    }
}

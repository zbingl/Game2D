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
            setObjectAt(new OBJ_CounterTop(), 1, 12, objList);
            setObjectAt(new OBJ_CounterTop(), 1, 13, objList);
            setObjectAt(new OBJ_CounterTop(), 1, 14, objList);
            setObjectAt(new OBJ_Sink(), 2, 14, objList);
            setObjectAt(new OBJ_StoveTop(), 3, 14, objList);
            setObjectAt(new OBJ_CounterTop(), 4, 14, objList);
            setObjectAt(new OBJ_CounterTop(), 5, 14, objList);
            setObjectAt(new OBJ_CounterTop(), 6, 14, objList);
            setObjectAt(new OBJ_CounterTop(), 7, 14, objList);
            //livingroom
            setObjectAt(new OBJ_Carpet(), 3, 4, objList);
            setObjectAt(new OBJ_DinnerTable(), 15,10, objList);
            setObjectAt(new OBJ_Chair("left"), 17,10, objList);
            setObjectAt(new OBJ_Chair("left"), 17,11, objList);
            setObjectAt(new OBJ_Chair("right"), 14,10, objList);
            setObjectAt(new OBJ_Chair("right"), 14,11, objList);
            //hallway
            //setObjectAt(new OBJ_ShoeRack(), 25, 12, objList);
            setObjectAt(new OBJ_DoorMat(), 24, 14, objList);

            //doors
            setObjectAt(new OBJ_Door("out", gp, "yard", 36,32), 24, 15, objList);
            setObjectAt(new OBJ_Door("in", gp, "house bedroom", 15, 8 ), 24, 9, objList);
        }

        if (mapPath.equals("/res/maps/houseBedroom.txt")) {
            setObjectAt(new OBJ_Table(new OBJ_Radio()), 13, 2, objList);
            setObjectAt(new OBJ_DoubleBed(), 10, 2, objList);
            setObjectAt(new OBJ_Shelf(), 15, 1, objList);

            //doors
            setObjectAt(new OBJ_Door("out", gp, "house main", 24, 11), 15, 9, objList);
        }

        if (mapPath.equals("/res/maps/yard.txt")) {
            //house
            setObjectAt(new OBJ_House(), 25, 25, objList);

            //doors
            setObjectAt(new OBJ_Door("in", gp, "house main", 24, 14), 36, 30, objList);
        }

        

        return objList;
    }
}

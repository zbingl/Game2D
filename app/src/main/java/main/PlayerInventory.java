package main;

import java.util.ArrayList;

import object.SuperObject;
import tile.TileManager;

public class PlayerInventory {
    ArrayList<SuperObject> objectList;
    GamePanel gp;

    public PlayerInventory(GamePanel gp) {
        this.objectList = new ArrayList<SuperObject>();
        this.gp = gp;
    }

    public void pickup(SuperObject obj) {
        if (objectList.size() < 8) {
            TileManager tilemanager = gp.tileM;
            ArrayList<SuperObject> worldobjs = tilemanager.mapList.get(tilemanager.currMapName).objectList;

            objectList.add(obj);
            worldobjs.remove(obj);
        }
    }

    public void place(SuperObject obj) {

    }

}

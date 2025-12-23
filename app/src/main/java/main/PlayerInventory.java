package main;

import java.util.ArrayList;

import object.SuperObject;
import tile.TileManager;

public class PlayerInventory {
    GamePanel gp;
    TileManager tilemanager;
    ArrayList<SuperObject> objectList = new ArrayList<SuperObject>();

    public PlayerInventory(GamePanel gp) {
        this.gp = gp;
        this.tilemanager = gp.tileM;
    }

    public void pickup(SuperObject obj) {
        if (objectList.size() < 8) {
            
            ArrayList<SuperObject> worldObjs = tilemanager.mapList.get(tilemanager.currMapName).objectList;

            objectList.add(obj);
            worldObjs.remove(obj);
        }
    }

    public void place(SuperObject obj, int x, int y) {
        
        ArrayList<SuperObject> worldObjs = tilemanager.mapList.get(tilemanager.currMapName).objectList;

        obj.relocate(x, y);

        worldObjs.add(obj);
        objectList.remove(obj);

    }

    public SuperObject getFirstObject() {
        return objectList.get(0);
    }

    public int getNbrOfObjectsStored() {
        return objectList.size();
    }

    public ArrayList<SuperObject> getInventory() {
        return objectList;
    }

}

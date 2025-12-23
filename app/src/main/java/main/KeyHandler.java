package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class KeyHandler implements KeyListener {

    private GamePanel gp;
    public HashMap<Integer, Boolean> typedMap;
    public HashMap<Integer, Boolean> pressedMap;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;

        typedMap = new HashMap<>();
        typedMap.put(KeyEvent.VK_E, false);
        typedMap.put(KeyEvent.VK_I, false);
        typedMap.put(KeyEvent.VK_P, false);
        typedMap.put(KeyEvent.VK_O, false);

        pressedMap = new HashMap<>();
        pressedMap.put(KeyEvent.VK_W, false);
        pressedMap.put(KeyEvent.VK_A, false);
        pressedMap.put(KeyEvent.VK_S, false);
        pressedMap.put(KeyEvent.VK_D, false);
        pressedMap.put(KeyEvent.VK_SHIFT, false);

        pressedMap.put(KeyEvent.VK_I, false);
        pressedMap.put(KeyEvent.VK_E, false);
        pressedMap.put(KeyEvent.VK_P, false);
        pressedMap.put(KeyEvent.VK_O, false);
        
    }

    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (pressedMap.containsKey(code)) {
            consumableTyped(code);
            pressedMap.put(code, true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (pressedMap.containsKey(code)) {
            pressedMap.put(code, false);
        }
    }

    public void consumableTyped(int code) {
        if (typedMap.containsKey(code)) {
            if (!pressedMap.get(code)) {
                typedMap.put(code, true); 
            }
        }
    }

    public boolean consumeTyped(int code) {
        boolean typed = typedMap.get(code);
        if (typed) {
            typedMap.put(code, false);
            return true;
        }
        return false;
    }

    public void consumeAllTyped() {
        for (int code: typedMap.keySet()) {
            consumeTyped(code);
        }
    }
}

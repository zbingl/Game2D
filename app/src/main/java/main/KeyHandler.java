package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class KeyHandler implements KeyListener {

    private GamePanel gp;
    public HashMap<Integer, Boolean> typedMap;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
        typedMap = new HashMap<>();

        typedMap.put(KeyEvent.VK_E, false);
        typedMap.put(KeyEvent.VK_TAB, false);
        
    }

    public boolean upPressed, downPressed, rightPressed, leftPressed, shiftPressed, tabPressed;
    public boolean ePressed, eTyped, tabTyped; // eTyped = true only once per press

    

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) upPressed = true;
        if (code == KeyEvent.VK_A) leftPressed = true;
        if (code == KeyEvent.VK_S) downPressed = true;
        if (code == KeyEvent.VK_D) rightPressed = true;
        if (code == KeyEvent.VK_SHIFT) shiftPressed = true;

        if (code == KeyEvent.VK_E) {
            if (!ePressed) {
                typedMap.put(code, true); 
            }
            ePressed = true;
        }

        if (code == KeyEvent.VK_I) {
            if (!tabPressed) {
                typedMap.put(code, true);   
            }
            tabPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) upPressed = false;
        if (code == KeyEvent.VK_A) leftPressed = false;
        if (code == KeyEvent.VK_S) downPressed = false;
        if (code == KeyEvent.VK_D) rightPressed = false;
        if (code == KeyEvent.VK_SHIFT) shiftPressed = false;

        if (code == KeyEvent.VK_E) {
            ePressed = false;
        }

        if (code == KeyEvent.VK_I) {
            tabPressed = false;
        }
    }

    public boolean consumeTyped(int keycode) {
        boolean typed = typedMap.get(keycode);
        if (typed) {
            typedMap.put(keycode, false);
            return true;
        }
        return false;
    }
}

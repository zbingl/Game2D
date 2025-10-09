package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, rightPressed, leftPressed, shiftPressed;
    public boolean ePressed, eTyped; // eTyped = true only once per press

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
                eTyped = true;   // mark this as a "new press"
            }
            ePressed = true;
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
    }

    // Call this from your game update loop
    public boolean consumeETyped() {
        if (eTyped) {
            eTyped = false; // reset after using
            return true;
        }
        return false;
    }
}

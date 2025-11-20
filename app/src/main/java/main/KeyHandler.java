package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private GamePanel gp;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
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
                eTyped = true;   // mark this as a "new press"
            }
            ePressed = true;
        }

        if (code == KeyEvent.VK_I) {
            if (!tabPressed) {
                tabTyped = true;   // mark this as a "new press"
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

    // Abstract this

    public boolean consumeETyped() {
        if (eTyped) {
            eTyped = false;
            return true;
        }
        return false;
    }

    public boolean consumeTABTyped() {
        if (tabTyped) {
            tabTyped = false;
            return true;
        }
        return false;
    }
}

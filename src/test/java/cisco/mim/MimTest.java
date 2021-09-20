package cisco.mim;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import static org.junit.jupiter.api.Assertions.*;

class MimTest {
    @Test
    void testKey_Invalid() throws AWTException {
        Mim mim = new Mim();
        Robot rob = new Robot();
        rob.keyPress(KeyEvent.VK_K);
        KeyEvent key = new KeyEvent(mim.mimTerminal, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_K,'K');
        mim.mimTerminal.getKeyListeners()[0].keyReleased(key);
        assertEquals(mim.mimKeyListener.getCaretPos(), 1);
        mim.mimKeyListener.previousKeys.clear();
        mim.mimKeyListener.setCaretPos(0);
    }

    @Test
    void testKey_0() throws AWTException {
        Mim mim = new Mim();
        Robot rob = new Robot();
        rob.keyPress(KeyEvent.VK_0);
        KeyEvent key = new KeyEvent(mim.mimTerminal, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_0,'0');
        mim.mimTerminal.getKeyListeners()[0].keyReleased(key);
        assertEquals(mim.mimKeyListener.getCaretPos(), 1);
        mim.mimKeyListener.previousKeys.clear();
        mim.mimKeyListener.setCaretPos(0);
    }

    @Test
    void testKey_E() throws AWTException {
        Mim mim = new Mim();
        Robot rob = new Robot();
        rob.keyPress(KeyEvent.VK_E);
        KeyEvent key = new KeyEvent(mim.mimTerminal, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_E,'E');
        mim.mimTerminal.getKeyListeners()[0].keyReleased(key);
        assertEquals(mim.mimKeyListener.getCaretPos(), 5);
        mim.mimKeyListener.previousKeys.clear();
        mim.mimKeyListener.setCaretPos(0);
    }

    @Test
    void testKeyEnd_E() throws AWTException {
        Mim mim = new Mim();
        Robot rob = new Robot();
        mim.mimKeyListener.setCaretPos(7);
        rob.keyPress(KeyEvent.VK_E);
        KeyEvent key = new KeyEvent(mim.mimTerminal, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_E,'E');
        mim.mimTerminal.getKeyListeners()[0].keyReleased(key);
        assertEquals(mim.mimKeyListener.getCaretPos(), 10);
        mim.mimKeyListener.previousKeys.clear();
        mim.mimKeyListener.setCaretPos(0);
    }

    @Test
    void testKey_$() throws AWTException {
        Mim mim = new Mim();
        Robot rob = new Robot();
        rob.keyPress(KeyEvent.VK_SHIFT);
        rob.keyPress(KeyEvent.VK_4);
        KeyEvent key = new KeyEvent(mim.mimTerminal, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_4,'$');
        mim.mimTerminal.getKeyListeners()[0].keyReleased(key);
        assertEquals(mim.mimKeyListener.getCaretPos(), 11);
        mim.mimKeyListener.previousKeys.clear();
        mim.mimKeyListener.setCaretPos(0);
    }

    @Test
    void testKey_TW() throws AWTException {
        Mim mim = new Mim();
        Robot rob = new Robot();
        rob.keyPress(KeyEvent.VK_T);
        mim.mimKeyListener.previousKeys.add(84);
        rob.keyPress(KeyEvent.VK_W);
        KeyEvent key = new KeyEvent(mim.mimTerminal, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_W,'w');
        mim.mimTerminal.getKeyListeners()[0].keyReleased(key);
        assertEquals(mim.mimKeyListener.getCaretPos(), 6);
        mim.mimKeyListener.previousKeys.clear();
        mim.mimKeyListener.setCaretPos(0);
    }

    @Test
    void testKey_VE() throws AWTException {
        Mim mim = new Mim();
        Robot rob = new Robot();
        mim.mimKeyListener.previousKeys.add(86);
        rob.keyPress(KeyEvent.VK_E);
        KeyEvent key = new KeyEvent(mim.mimTerminal, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_E,'E');
        mim.mimTerminal.getKeyListeners()[0].keyReleased(key);
        assertEquals(mim.mimKeyListener.getCaretPos(), 5);
        mim.mimKeyListener.previousKeys.clear();
        mim.mimKeyListener.setCaretPos(0);
    }

    @Test
    void testKeyEnd_VE() throws AWTException {
        Mim mim = new Mim();
        Robot rob = new Robot();
        mim.mimKeyListener.previousKeys.add(86);
        mim.mimKeyListener.setCaretPos(7);
        rob.keyPress(KeyEvent.VK_E);
        KeyEvent key = new KeyEvent(mim.mimTerminal, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_E,'E');
        mim.mimTerminal.getKeyListeners()[0].keyReleased(key);
        assertEquals(mim.mimKeyListener.getCaretPos(), 10);
        mim.mimKeyListener.previousKeys.clear();
        mim.mimKeyListener.setCaretPos(0);
    }

    @Test
    void testResetText() throws AWTException {
        Mim mim = new Mim();
        Robot rob = new Robot();
        mim.mimTerminal.replaceRange("Hello Cisco", 0, 11);
        assert(!mim.mimTerminal.getText().equalsIgnoreCase(MimKeyListener.TERMINAL_CONTENT));
        mim.mimKeyListener.resetText(mim.mimTerminal, 0, 11);
        assert(mim.mimTerminal.getText().equalsIgnoreCase(MimKeyListener.TERMINAL_CONTENT));
    }
}
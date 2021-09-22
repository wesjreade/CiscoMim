package cisco.mim;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class MimeTest {
    @Test
    void testKey_Invalid() throws AWTException {
        String data = "hello world";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
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
        String data = "hello world";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
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
        String data = "hello world";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
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
        String data = "hello world";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
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
        String data = "hello world";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
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
        String data = "hello world";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
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
        String data = "hello world";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
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
        String data = "hello world";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
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
    void testKey_V$() throws AWTException {
        String data = "hello world";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Mim mim = new Mim();
        Robot rob = new Robot();
        mim.mimKeyListener.previousKeys.add(86);
        rob.keyPress(KeyEvent.VK_SHIFT);
        rob.keyPress(KeyEvent.VK_4);
        KeyEvent key = new KeyEvent(mim.mimTerminal, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_4,'$');
        mim.mimTerminal.getKeyListeners()[0].keyReleased(key);
        assertEquals(mim.mimKeyListener.getCaretPos(), 11);
        mim.mimKeyListener.previousKeys.clear();
        mim.mimKeyListener.setCaretPos(0);
    }

    @Test
    void testKtwey_VTW() throws AWTException {
        String data = "hello world";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Mim mim = new Mim();
        Robot rob = new Robot();
        rob.keyPress(KeyEvent.VK_T);
        mim.mimKeyListener.previousKeys.add(86);
        mim.mimKeyListener.previousKeys.add(84);
        rob.keyPress(KeyEvent.VK_W);
        KeyEvent key = new KeyEvent(mim.mimTerminal, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_W,'w');
        mim.mimTerminal.getKeyListeners()[0].keyReleased(key);
        assertEquals(mim.mimKeyListener.getCaretPos(), 6);
        mim.mimKeyListener.previousKeys.clear();
        mim.mimKeyListener.setCaretPos(0);
    }

    @Test
    void testResetText() throws AWTException {
        String data = "hello world";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Mim mim = new Mim();
        mim.mimTerminal.replaceRange("Hello Cisco", 0, 11);
        assert(!mim.mimTerminal.getText().equalsIgnoreCase("hello world"));
        mim.mimKeyListener.resetText(mim.mimTerminal, 0, 11, "hello world");
        assert(mim.mimTerminal.getText().equalsIgnoreCase("hello world"));
    }
}
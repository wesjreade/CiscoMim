package cisco.mim;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MimKeyListener {
    int caretPos;
    ArrayList<Integer> previousKeys = new ArrayList();
    public static final String TERMINAL_CONTENT = "hello world";

    public void addKeyListener(JTextArea mimTerminal) {
        mimTerminal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                try {
                    mimTerminal(evt);
                } catch (AWTException | BadLocationException e) {
                    e.printStackTrace();
                }
            }

            private void mimTerminal(KeyEvent evt) throws AWTException, BadLocationException {
                try {
                    int keyCode = evt.getKeyCode();
                    //set previous key set for t[char] vs vt[char]
                    boolean vtFlag = false;
                    if(previousKeys.size() == 3 && previousKeys.contains(86) && previousKeys.contains(84)) {
                        previousKeys.clear();
                        vtFlag = true;
                    }

                    //Multi Key
                    if(vtFlag==true || (previousKeys.contains(84) && vtFlag==false)) {
                        resetText(mimTerminal, 0, mimTerminal.getDocument().getLength());
                        int p1 = vtFlag == true ? getCaretPos() - 1 : mimTerminal.getText().indexOf(evt.getKeyChar()) - 1;
                        int p2 = vtFlag == true ? mimTerminal.getText().indexOf(evt.getKeyChar()) : p1 + 1;
                        highLightArea(mimTerminal, p1, p2);
                        mimTerminal.setCaretPosition(0);
                        setCaretPos(p2);
                        previousKeys.clear();
                    } else if (previousKeys.contains(86)) {
                        previousKeys.add(keyCode);
                        if (keyCode == 69) {
                            int p1 = getCaretPos();
                            int p2 = p1 >= 6 ? mimTerminal.getText().length() - 1 : mimTerminal.getText().indexOf(" ") - 1;
                            resetText(mimTerminal, 0, mimTerminal.getDocument().getLength());
                            highLightArea(mimTerminal, p1 - 1, p2 - 1);
                            setCaretPos(p1 <= 6 ? mimTerminal.getText().indexOf(" ") : mimTerminal.getDocument().getLength() - 1);
                            previousKeys.clear();
                        } else if (keyCode == 52) {
                            int p1 = 0;
                            int p2 = mimTerminal.getDocument().getLength();
                            resetText(mimTerminal, p1, p2);
                            highLightArea(mimTerminal, p1, mimTerminal.getDocument().getLength());
                            setCaretPos(mimTerminal.getDocument().getLength());
                            previousKeys.clear();
                        } else if (previousKeys.contains(84)) {
                            previousKeys.add(keyCode);
                        }
                        //Single key
                    } else {
                        previousKeys.add(keyCode);
                        if (keyCode == 48) {
                            resetText(mimTerminal, 0, mimTerminal.getDocument().getLength());
                            highLightArea(mimTerminal, 0, 1);
                            setCaretPos(1);
                            previousKeys.clear();
                        } else if (keyCode == 52) {
                            resetText(mimTerminal, 0, mimTerminal.getDocument().getLength());
                            highLightArea(mimTerminal, mimTerminal.getDocument().getLength() - 1, mimTerminal.getDocument().getLength());
                            setCaretPos(mimTerminal.getDocument().getLength());
                            previousKeys.clear();
                        } else if (keyCode == 69) {
                            int p1 = getCaretPos() <= 6 ? mimTerminal.getText().indexOf(" ") - 1 : mimTerminal.getDocument().getLength() - 1;
                            int p2 = p1 + 1;
                            resetText(mimTerminal, 0, mimTerminal.getDocument().getLength());
                            highLightArea(mimTerminal, p1 - 1, p2 - 1);
                            setCaretPos(p1 <= 6 ? mimTerminal.getText().indexOf(" ") : mimTerminal.getDocument().getLength() - 1);
                            previousKeys.clear();
                        }
                        mimTerminal.setCaretPosition(0);
                        evt.consume();
                    }
                } catch(Exception ex) {
                    resetText(mimTerminal, 0, mimTerminal.getDocument().getLength());
                    setCaretPos(1);
                    previousKeys.clear();
                }
            }
        });
    }
    public void setCaretPos(int input) {
        this.caretPos = input;
    }

    public int getCaretPos() {
        return this.caretPos;
    }

    public void highLightArea(JTextArea mimTerminal, int p1, int p2) throws BadLocationException {
        Highlighter highlighter = mimTerminal.getHighlighter();
        Highlighter.HighlightPainter painter =
                new DefaultHighlighter.DefaultHighlightPainter(Color.lightGray);
        highlighter.addHighlight(p1, p2, painter);
    }

    public void resetText(JTextArea mimTerminal, int p1, int p2) {
        mimTerminal.replaceRange(TERMINAL_CONTENT, p1, p2);
    }

}

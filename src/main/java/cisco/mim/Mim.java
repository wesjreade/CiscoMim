package cisco.mim;

import java.awt.*;
import javax.swing.*;

public class Mim extends JFrame {
    JTextArea mimTerminal;
    MimKeyListener mimKeyListener = new MimKeyListener();

    public Mim() {
        mimKeyListener.setCaretPos(1);
        setTitle("Cisco");
        JPanel panel = setUp();
        mimKeyListener.addKeyListener(mimTerminal);
        panel.add(mimTerminal);
        add(panel);
        setVisible(true);
    }

    public JPanel setUp() {
        JPanel panel = new JPanel();
        setLayout(new GridLayout(1, 1));
        setSize(400, 250);
        panel.setLayout(new GridLayout(1, 1));
        mimTerminal = new JTextArea(MimKeyListener.TERMINAL_CONTENT);
        mimTerminal.setBackground(Color.black);
        mimTerminal.setForeground(Color.white);
        mimTerminal.setCaretColor(Color.white);
        mimTerminal.setFocusTraversalKeysEnabled(false);
        return panel;
    }
}

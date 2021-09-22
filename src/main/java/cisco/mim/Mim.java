package cisco.mim;

import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class Mim extends JFrame {
    JTextArea mimTerminal;
    MimKeyListener mimKeyListener = new MimKeyListener();
    Scanner in = new Scanner(System.in);

    public Mim() {
        mimKeyListener.setCaretPos(1);
        setTitle("Cisco");
        System.out.println("Please enter some text up to 30 chars long.");
        String content = in.nextLine();
        if(content.length() > 30) {
            System.out.println("You have entered a string with too many characters, please enter some text up to 30 chars long.");
            content = in.next();
        }
        JPanel panel = setUp(content);
        mimKeyListener.addKeyListener(mimTerminal);
        panel.add(mimTerminal);
        add(panel);
        setVisible(true);
    }

    public JPanel setUp(String content) {
        JPanel panel = new JPanel();
        setLayout(new GridLayout(1, 1));
        setSize(400, 250);
        panel.setLayout(new GridLayout(1, 1));
        mimTerminal = new JTextArea(content);
        mimTerminal.setBackground(Color.black);
        mimTerminal.setForeground(Color.white);
        mimTerminal.setCaretColor(Color.white);
        mimTerminal.setFocusTraversalKeysEnabled(false);
        return panel;
    }
}

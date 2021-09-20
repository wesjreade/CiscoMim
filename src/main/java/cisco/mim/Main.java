package cisco.mim;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Mim mim = new Mim();
            }
        });
        //Mim mim = new Mim();
    }
}

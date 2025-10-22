package w1022;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest extends JFrame {
    public BorderLayoutTest() {
        setLayout(new BorderLayout(15, 10));
        String[] locs = {BorderLayout.EAST, BorderLayout.WEST, BorderLayout.SOUTH, BorderLayout.NORTH, BorderLayout.CENTER};
        JButton[] btns = new JButton[5];
        for (int i = 0; i < btns.length; i++) {
            btns[i] = new JButton("btton"+(i+1));
            add(btns[i], locs[i]);
        }

        setTitle("BorderLayoutTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(300, 250);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    public static void main(String[] args) {
        new BorderLayoutTest();
    }
}

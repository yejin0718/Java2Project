package w1029;

import center_frame.CenterFrame;

import javax.swing.*;

public class CardLayoutTest extends JFrame {
    public CardLayoutTest() {
        for (int i=0; i<3; i++) {
            JButton btn = new JButton("버튼" + (i+1));
            add(btn);
        }

        setTitle("CardLayoutTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(250, 250);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    public static void main(String[] args) {
        new CardLayoutTest();
    }
}

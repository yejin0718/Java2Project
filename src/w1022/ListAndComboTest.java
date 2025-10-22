package w1022;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;

public class ListAndComboTest extends JFrame {
    JList list;
    JComboBox combo;
    String[] items = {"사과", "토마토", "포도", "딸기", "오렌지", "바나나"};

    ListAndComboTest() {
        setLayout(new FlowLayout());
        list = new JList(items);
        combo = new JComboBox(items);
        add(list);
        add(combo);

        setTitle("ListAndComboTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(300, 250);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    public static void main(String[] args) {
        new ListAndComboTest();
    }
}

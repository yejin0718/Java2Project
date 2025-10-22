package w1022;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectFoodTest extends JFrame {
    JComboBox combo;
    JLabel imgLbel;
    String[] foods = {"김치찌개", "부대찌개", "고추장찌개", "된장찌개", "순두부찌개", "청국장찌개"};
    String[] imgs = {"food1.png", "food2.png", "food3.png", "food4.png", "food5.png", "food6.png"};

    public SelectFoodTest() {
        JPanel northPan = new JPanel();
        JLabel lbl = new JLabel("Food: ");
        combo = new JComboBox(foods);
        JButton btn = new JButton("click");
        northPan.add(lbl); northPan.add(combo); northPan.add(btn);
        add(northPan, "North");
        imgLbel = new JLabel(new ImageIcon("D:/Java2Project/javaProject2/src/w1022/food/food1.png"));
        add(imgLbel, "Center");

        btn.addActionListener(btnListener);

        setTitle("ListAndComboTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(300, 250);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    ActionListener btnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           int index = combo.getSelectedIndex();
            ImageIcon icon = new ImageIcon("D:/Java2Project/javaProject2/src/w1022/food/" + imgs[index]);
            imgLbel.setIcon(icon);
        }
    };

    public static void main(String[] args) {
        new SelectFoodTest();
    }
}

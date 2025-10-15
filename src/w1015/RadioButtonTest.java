package w1015;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonTest extends JFrame {
    String[] rbStrArr = {"아이브", "뉴진스", "블랙핑크"};
    String[] imgsArr = {"img1.jpg", "img2.jpg", "img3.jpg"};
    JRadioButton[] rbArr = new JRadioButton[rbStrArr.length];
    JLabel lbl = new JLabel("", JLabel.CENTER);

    public RadioButtonTest() {
        JPanel panel = new JPanel();
        setLayout(new BorderLayout());
        ButtonGroup bg = new ButtonGroup();
        int i = 0;
        for (String str : rbStrArr) {
            rbArr[i] = new JRadioButton(str);
            rbArr[i].addActionListener(radioButtonListener);
            bg.add(rbArr[i]);
            panel.add(rbArr[i]);
            i++;
        }
        lbl.setOpaque(true);
        lbl.setBackground(Color.PINK);
        add(panel, "North");
        add(lbl, "Center");

        setTitle("RadioButtonTest");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        CenterFrame cf = new CenterFrame(500, 300);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    ActionListener radioButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int i=0;
            for(JRadioButton rb : rbArr) {
                if(rb.isSelected()) {
                    JOptionPane.showMessageDialog(null, rb.getText() + "가 선택되었습니다.");

                    String ImgSrc = "D:/Java2Project/javaProject2/src/w1015/imgs/" + imgsArr[i];
                    ImageIcon icon = new ImageIcon(ImgSrc);
                    lbl.setIcon(icon);
                }
                i++;
            }
//            if(rbArr[0].isSelected()) {
//                JOptionPane.showMessageDialog(null,  "아이브");
//            } else if (rbArr[1].isSelected()) {
//                JOptionPane.showMessageDialog(null,  "뉴진스");
//            } else if (rbArr[2].isSelected()) {
//                JOptionPane.showMessageDialog(null,  "블랙핑크");
//            }
        }
    };

    public static void main(String[] args) {
        new RadioButtonTest();
    }
}

package w1001;

import javax.swing.*;
import java.awt.*;

//JFrame의 기본 LayoutManager(배치관리자) : borderLayout(동, 서, 남, 북, 가운데)
public class JLabelTest extends JFrame {
    public JLabelTest() {
        setLayout(new FlowLayout());
        setTitle("JLabelTest");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String[] lblTexts = {"한국폴리텍대학", "서울 정수캠퍼스", "인공지능소프트웨어과"};
        String[] locTexts = {"North", "Center", "South"};
        Color[] lblBgColors = {Color.orange, Color.magenta, Color.pink};
        JLabel[] lbls = new JLabel[lblTexts.length];
        for (int i = 0; i < lbls.length; i++) {
            lbls[i] = new JLabel(lblTexts[i], JLabel.CENTER);
            lbls[i].setForeground(Color.white);
            lbls[i].setOpaque(true);
            lbls[i].setBackground(lblBgColors[i]);
            add(lbls[i], locTexts[i]);
        }

        Font font = new Font("맑은고딕", Font.BOLD, 30);
        lbls[2].setFont(font);

        setBounds(100, 100, 350, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JLabelTest();
    }
}


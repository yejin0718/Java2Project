package w1105;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventTest2 extends JFrame {
    public MouseEventTest2() {
        addMouseListener(mouseAdapter);

        setTitle("MouseEventTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(500, 500);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            switch (e.getButton()) {
                case MouseEvent.BUTTON1:
                    JOptionPane.showMessageDialog(MouseEventTest2.this, "왼쪽 버튼을 클릭했군요.");
                    break;
                case MouseEvent.BUTTON2:
                    JOptionPane.showMessageDialog(MouseEventTest2.this, "가운데 버튼을 클릭했군요.");
                    break;
                case MouseEvent.BUTTON3:
                    JOptionPane.showMessageDialog(MouseEventTest2.this, "오른쪽 버튼을 클릭했군요.");
                    break;
            }
        }
    };

    public static void main(String[] args) {
        new MouseEventTest2();
    }
}

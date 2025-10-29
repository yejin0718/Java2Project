package w1029;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventTest extends JFrame {
    public MouseEventTest() {
        addMouseListener(mouseListener);

        setTitle("MouseEventTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(500, 500);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    MouseListener mouseListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            switch (e.getButton()) {
                case MouseEvent.BUTTON1:
                    JOptionPane.showMessageDialog(MouseEventTest.this, "왼쪽 버튼을 클릭했군요.");
                    break;
                case MouseEvent.BUTTON2:
                    JOptionPane.showMessageDialog(MouseEventTest.this, "가운데 버튼을 클릭했군요.");
                    break;
                case MouseEvent.BUTTON3:
                    JOptionPane.showMessageDialog(MouseEventTest.this, "오른쪽 버튼을 클릭했군요.");
                    break;
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
        }
    };

    public static void main(String[] args) {
        new MouseEventTest();
    }
}

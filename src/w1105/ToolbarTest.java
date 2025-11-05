package w1105;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolbarTest extends JFrame{
    JLabel label = new JLabel();
    JButton btnNew = new JButton(new ImageIcon("D:/Java2Project/javaProject2/src/w1105/toolbar_icons/fileIcon.png"));
    JButton btnOpen = new JButton(new ImageIcon("D:/Java2Project/javaProject2/src/w1105/toolbar_icons/saveIcon.png"));
    JButton btnClose = new JButton(new ImageIcon("D:/Java2Project/javaProject2/src/w1105/toolbar_icons/stopIcon.png"));
    public ToolbarTest() {
        JToolBar toolbar = new JToolBar();
        add(toolbar, BorderLayout.NORTH);
        add(label);

        toolbar.add(btnNew);
        toolbar.add(btnOpen);
        toolbar.addSeparator();
        toolbar.add(btnClose);

        btnNew.addActionListener(btnListenr);
        btnOpen.addActionListener(btnListenr);
        btnClose.addActionListener(btnListenr);

        setTitle("툴바 작성");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(500, 500);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    ActionListener btnListenr = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            if(button == btnNew) {
                label.setText("[새문서] 메뉴 항목을 선택했습니다.");
            } else if (button == btnOpen) {
                label.setText("[열기] 메뉴 항목을 선택했습니다.");
            } else {
                System.exit(0);
            }
        }
    };

    public static void main(String[] args) {
        new ToolbarTest();
    }
}

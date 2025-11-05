package w1105;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TotalMenuTest extends JFrame {
    JLabel lbl = new JLabel("메뉴를 선택하면 문자열이 변경됩니다.", JLabel.CENTER);
    JMenuItem miNew = new JMenuItem("새문서");
    JMenuItem miOpen = new JMenuItem("열기");
    JMenuItem miClose = new JMenuItem("닫기");
    JButton btnNew = new JButton(new ImageIcon("D:/Java2Project/javaProject2/src/w1105/toolbar_icons/fileIcon.png"));
    JButton btnOpen = new JButton(new ImageIcon("D:/Java2Project/javaProject2/src/w1105/toolbar_icons/saveIcon.png"));
    JButton btnClose = new JButton(new ImageIcon("D:/Java2Project/javaProject2/src/w1105/toolbar_icons/stopIcon.png"));
    public TotalMenuTest() {
        add(lbl);
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        JMenu mFile = new JMenu("파일");
        JMenu mEdit = new JMenu("편집");
        mb.add(mFile);
        mb.add(mEdit);

        mFile.add(miNew);
        mFile.add(miOpen);
        mFile.add(miClose);

        miNew.addActionListener(itemListenr);
        miOpen.addActionListener(itemListenr);
        miClose.addActionListener(itemListenr);

        JToolBar toolbar = new JToolBar();
        add(toolbar, BorderLayout.NORTH);
        add(lbl);

        toolbar.add(btnNew);
        toolbar.add(btnOpen);
        toolbar.addSeparator();
        toolbar.add(btnClose);

        btnNew.addActionListener(itemListenr);
        btnOpen.addActionListener(itemListenr);
        btnClose.addActionListener(itemListenr);

        setTitle("메뉴 작성");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(500, 500);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    ActionListener itemListenr = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            JButton button = null;
            JMenuItem item = null;
            if(e.getSource() instanceof JButton) {
                button = (JButton) e.getSource();
            } else {
                item = (JMenuItem) e.getSource();
            }
            if(button == btnNew ||  item == miNew) {
                lbl.setText("[새문서] 메뉴 항목을 선택했습니다.");
            } else if (button == btnOpen ||  item == miOpen) {
                lbl.setText("[열기] 메뉴 항목을 선택했습니다.");
            } else {
                System.exit(0);
            }
        }
    };

    public static void main(String[] args) {
        new TotalMenuTest();
    }
}

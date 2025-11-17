package w1112.draw;

import center_frame.CenterFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    PaintingPanel panel;
    String[] rbStrs = {"선", "사각형", "타원형"};
    JRadioButton[] rbs = new JRadioButton[rbStrs.length];

    public MainFrame() {
        JPanel panelNorth = new JPanel();
        ButtonGroup bg = new ButtonGroup();

        for (int i = 0; i < rbStrs.length; i++) {
            rbs[i] = new JRadioButton(rbStrs[i]);
            bg.add(rbs[i]);
            panelNorth.add(rbs[i]);
            rbs[i].addActionListener(this);
        }
        rbs[0].setSelected(true);

        add(panelNorth, "North");

        panel = new PaintingPanel("선");
        add(panel);

        setTitle("단순 그림판");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(500, 500);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String cmd = e.getActionCommand();

        panel.polygon = cmd;
        panel.clearDraw();
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}

package w1022;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldTest extends JFrame {
    JTextField tf;
    JTextArea ta;
    JPasswordField pf;

    public TextFieldTest() {
        tf = new JTextField(10);
        ta = new JTextArea(5, 10);
        pf = new JPasswordField(10);
        JButton btn = new JButton("showMessage");
        btn.addActionListener(btnListener);

        setLayout(new FlowLayout());

        add(tf);
        JScrollPane sp = new JScrollPane(ta);
        add(sp);
        add(pf);
        add(btn);

        setTitle("TextFieldTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(250, 250);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    ActionListener btnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String tfMsg = tf.getText();
            String taMsg = ta.getText();
            String pfMsg = pf.getText();

            JOptionPane.showMessageDialog(null, tfMsg + "\n"  + taMsg + "\n"  + pfMsg);
        }
    };

    public static void main(String[] args) {
        new TextFieldTest();
    }
}

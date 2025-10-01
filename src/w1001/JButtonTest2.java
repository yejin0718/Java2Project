package w1001;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonTest2 extends JFrame {
    private JTextField tf;

    public JButtonTest2() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int fw = 500;
        int fh = 200;
        int x = screenWidth/2 - fw/2;
        int y = screenHeight/2 - fh/2;

        setLayout(new FlowLayout(FlowLayout.CENTER));
        setTitle("JButtonTest2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tf = new JTextField(10);
        add(tf);

        JButton button = new JButton("Button");
        button.addActionListener(btnListener);
        add(button);

        setBounds(200, 200, 300, 200);
        setVisible(true);

    }

    ActionListener btnListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, tf.getText());
        }
    };

    public static void main(String[] args) {
        new JButtonTest2();
    }
}

package w1001;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonTest extends JFrame {
    public JButtonTest() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setTitle("JButtonTest");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JButton btn = new JButton("클릭하세요.");
        btn.addActionListener(btnListener);
        add(btn);

        JButton btn2 = new JButton("인공지능소프트웨어과");
        btn2.addActionListener(btnListener);
        add(btn2);

        String[] btnArray = {"btn3", "btn4", "btn5", "btn6", "btn7"};
        for(int i=0; i<5; i++) {
            JButton btns = new JButton(btnArray[i]);
            btns.addActionListener(btnListener);
            add(btns);
        }

        setBounds(200, 200, 300, 200);
        setVisible(true);
    }

    ActionListener btnListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, e.getActionCommand() + "버튼을 선택했습니다.");
        }
    };

    public static void main(String[] args) {
        new JButtonTest();
    }
}

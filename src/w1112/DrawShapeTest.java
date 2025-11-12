package w1112;

import center_frame.CenterFrame;
import w1105.DrawPolygonTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DrawShapeTest extends JFrame {
    public DrawShapeTest() {
        setTitle("그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 창 중앙 정렬
        CenterFrame cf = new CenterFrame(400, 400);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());

        // 상단 라디오 버튼 패널
        JPanel topPanel = new JPanel();
        JRadioButton circleBtn = new JRadioButton("원");
        JRadioButton rectBtn = new JRadioButton("사각형");
        JRadioButton ovalBtn = new JRadioButton("타원", true); // 기본 선택

        ButtonGroup group = new ButtonGroup();
        group.add(circleBtn);
        group.add(rectBtn);
        group.add(ovalBtn);

        topPanel.add(circleBtn);
        topPanel.add(rectBtn);
        topPanel.add(ovalBtn);
        add(topPanel, BorderLayout.NORTH);

        // 중앙 도형 그리기 패널
        DrawPanel drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);

        // 버튼 이벤트 리스너
        ActionListener listener = e -> {
            if (circleBtn.isSelected()) drawPanel.setShape("circle");
            else if (rectBtn.isSelected()) drawPanel.setShape("rect");
            else drawPanel.setShape("oval");
        };

        circleBtn.addActionListener(listener);
        rectBtn.addActionListener(listener);
        ovalBtn.addActionListener(listener);

        setVisible(true);
    }

    // 내부 클래스: 도형을 그리는 패널
    class DrawPanel extends JPanel {
        private String shape = "oval";

        public DrawPanel() {
            setBackground(Color.YELLOW);
        }

        public void setShape(String shape) {
            this.shape = shape;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            int w = getWidth();
            int h = getHeight();
            int x = w / 2 - 50;
            int y = h / 2 - 70;
            int width = 100;
            int height = 140;

            switch (shape) {
                case "circle":
                    g.drawOval(x, y, width, width);
                    break;
                case "rect":
                    g.drawRect(x, y, width, height);
                    break;
                case "oval":
                    g.drawOval(x, y, width, height);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new DrawShapeTest();
    }
}

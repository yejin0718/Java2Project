package w1112.draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaintingPanel extends JPanel {
    String polygon;

    int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
    boolean dragging = false;

    public PaintingPanel(String polygon) {
        this.polygon = polygon;

        setBackground(Color.YELLOW);

        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
                dragging = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                dragging = false;
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                repaint();
            }
        };

        addMouseListener(ma);
        addMouseMotionListener(ma);
    }

    public void clearDraw() {
        x1 = y1 = x2 = y2 = -1;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0)
            return;

        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        int w = Math.abs(x2 - x1);
        int h = Math.abs(y2 - y1);

        switch (polygon) {
            case "선":
                g.setColor(Color.RED);
                g.drawLine(x1, y1, x2, y2);
                break;

            case "사각형":
                g.setColor(Color.GREEN);
                g.drawRect(x, y, w, h);
                break;

            case "타원형":
                g.setColor(Color.BLUE);
                g.drawOval(x, y, w, h);
                break;
        }
    }
}

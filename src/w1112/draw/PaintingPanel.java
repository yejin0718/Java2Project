package w1112.draw;

import javax.swing.*;
import java.awt.*;

public class PaintingPanel extends JPanel {
    String polygon;

    public PaintingPanel(String polygon) {
        this.polygon = polygon;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        switch (polygon) {
            case "선":
                g.setColor(Color.RED);
                g.drawLine(30, 30, 200, 200);
                break;
            case "사각형":
                g.setColor(Color.green);
                g.fillRect(70, 50, 200, 200);
                break;
            case "타원형":
                g.setColor(Color.blue);
                g.drawOval(230, 150, 80, 250);
                break;
        }
    }
}

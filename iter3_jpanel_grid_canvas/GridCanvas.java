package iter3_jpanel_grid_canvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import iter4_fillarc_strategy.ColorStrategy;

public class GridCanvas extends JPanel {
    private int id;
    private Color[] colors = new Color[4];
    private ColorStrategy colorStrategy;

    public GridCanvas(int id, int w, int h) {
        setPreferredSize(new Dimension(w, h));
        this.id = id;
    }
    
    public GridCanvas(int id) {
        this(id, 300, 300);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.setFont(new Font("Courier", Font.BOLD, 20));

        switch (id) {
            case 1:
                g.drawString("Q1", 25, 25); 
                g.setColor(Color.BLACK);
                g.drawArc(100, 100, 400, 400, 90, 90);
                g.setColor(colors[0]);
                g.fillArc(100, 100, 400, 400, 90, 90);
                g.setColor(Color.BLACK);
                g.drawLine(300, 0, 300, 300);
                g.drawLine(0, 300, 300, 300);
                break;
            case 2:
                g.drawString("Q2", 250, 25); 
                g.setColor(Color.BLACK);
                g.drawArc(-200, 100, 400, 400, 90, -90);
                g.setColor(colors[1]);
                g.fillArc(-200, 100, 400, 400, 90, -90);
                g.setColor(Color.BLACK);
                g.drawLine(0, 0, 0, 300);
                g.drawLine(0, 300, 300, 300);
                break;
            case 3:
                g.drawString("Q3", 25, 250); 
                g.setColor(Color.BLACK);
                g.drawArc(100, -200, 400, 400, 180, 90);
                g.setColor(colors[2]);
                g.fillArc(100, -200, 400, 400, 180, 90);
                g.setColor(Color.BLACK);
                g.drawLine(300, 0, 300, 300);
                g.drawLine(0, 0, 300, 0);
                break;
            case 4:
                g.drawString("Q4", 250, 250); 
                g.setColor(Color.BLACK);
                g.drawArc(-200, -200, 400, 400, 270, 90);
                g.setColor(colors[3]);
                g.fillArc(-200, -200, 400, 400, 270, 90);
                g.setColor(Color.BLACK);
                g.drawLine(0, 0, 0, 300);
                g.drawLine(0, 0, 300, 0);
                break;
            default:
                System.exit(0);
        }
    }

    public void setColors(ColorStrategy colorStrategy) {
        this.colorStrategy = colorStrategy;
        for (int i = 0; i < 4; i++) {
            colors[i] = colorStrategy.getColor(i);
        }
    }
}

////////////////////////////////////////////////////////////////////////////////
// File:            Cloud.java
// Course:          CSC 232 A, Spring 2021
// Authors:         Minh Nguyem
//
// Acknowledgments: None
//
// Online sources: https://www.youtube.com/watch?v=zCiMlbu1-aQ
////////////////////////////////////////////////////////////////////////////////

import java.awt.*;
import java.awt.geom.*;

/**
 * A Cloud graphic implements Image
 * @author minhnguyemn_2024@depauw.edu
 */
public class Cloud implements Image  {

    private double x;
    private double y;
    private double size;
    private Color color;

    public Cloud(double x, double y, double size, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    @Override
    public void render(Graphics2D g2d) {
        Ellipse2D.Double c1 = new Ellipse2D.Double(x, y, size, size);
        Ellipse2D.Double c2 = new Ellipse2D.Double(x + size*0.35, y - size*0.2, size*1.75, size*1.4);
        Ellipse2D.Double c3 = new Ellipse2D.Double(x + size*1.5, y + size*0.9, size*0.9, size*0.9);
        Ellipse2D.Double c4 = new Ellipse2D.Double(x + size*1.8, y + size*0.8, size*0.30, size*0.3);
        g2d.setColor(color);
        g2d.fill(c1);
        g2d.fill(c2);
        g2d.fill(c3);
        g2d.fill(c4);
    }
}

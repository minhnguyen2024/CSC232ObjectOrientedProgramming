////////////////////////////////////////////////////////////////////////////////
// File:            Triangle.java
// Course:          CSC 232 A, Spring 2021
// Authors:         Minh Nguyen
//
// Acknowledgments: None
//
// Online sources: None
////////////////////////////////////////////////////////////////////////////////

import java.awt.geom.*;
import java.awt.*;

/**
 * A Triangle graphic implements Image
 * @author minhnguyen_2024@depauw.edu
 */
public class Triangle implements Image {
    private double x;
    private double y;
    private double w;
    private double h;
    private Color color;
    
    
    /**
     * Creates a triangle based at (0,0)
     * @param w width of triangle
     * @param hm height of triangle
     * @param color color of triangle
     */
    public Triangle(double w, double h, Color color){
        this.x = 0;
        this.y = 0;
        this.w = w;
        this.h = h;
        this.color = color;
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(color);
        Path2D.Double reverseTriangle = new Path2D.Double();
        reverseTriangle.moveTo(x,y);
        reverseTriangle.lineTo(x+w,y);
        reverseTriangle.lineTo(w/2, h);
        reverseTriangle.closePath();
        g2d.fill(reverseTriangle);
    }
    
}

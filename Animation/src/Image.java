////////////////////////////////////////////////////////////////////////////////
// File:            Image.java
// Course:          CSC 232 A, Spring 2021
// Authors:         Brian Howard, Minh Nguyen
//
// Acknowledgments: None
//
// Online sources:  None
////////////////////////////////////////////////////////////////////////////////

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.*;

/**
 * An <code>Image</code> represents anything that can be drawn in a rectangular
 * region. The x and y coordinates of the region go from (0., 0.) in the
 * upper-left to (1., 1.) in the lower-right.
 * 
 * @author bhoward
 */
public interface Image
{
   /**
    * Draws the image on the provided graphics context.
    * 
    * @param graphics
    *           The <code>Graphics2D</code> context object with which to do the
    *           drawing
    */
   void render(Graphics2D graphics);

   /**
    * Creates a new <code>Image</code> by composing this image on top of
    * another.
    * 
    * @param that
    *           The <code>Image</code> to draw under this one
    * @return a new composite image
    */
   default Image over(Image that)
   {
      return new CompositeImage(that, this);
   }

   /**
    * Creates a new <code>Image</code> by rotating this image clockwise around
    * the origin.
    * 
    * @param theta
    *           The rotation angle in radians
    * @return a new rotated image
    */
   default Image rotate(double theta)
   {
      return new TransformImage(this, AffineTransform.getRotateInstance(theta));
   }

   /**
    * Creates a new <code>Image</code> by scaling this image in the x and y
    * directions.
    * 
    * @param scalex
    *           The scale factor in the x direction
    * @param scaley
    *           The scale factor in the y direction
    * @return a new scaled image
    */
   default Image scale(double scalex, double scaley)
   {
      return new TransformImage(this,
               AffineTransform.getScaleInstance(scalex, scaley));
   }

   /**
    * Creates a new <code>Image</code> by translating this image. The origin of
    * this image will be shifted to the given point (transx, transy).
    * 
    * @param transx
    *           The distance to translate in the x direction
    * @param transy
    *           The distance to translate in the y direction
    * @return a new translated image
    */
   default Image translate(double transx, double transy)
   {
      return new TransformImage(this,
               AffineTransform.getTranslateInstance(transx, transy));
   }

   /**
    * Creates a new <code>Image</code> consisting of a circle with diameter 1,
    * centered at (0.5, 0.5).
    * 
    * @return a new circle image
    */
   static Image circle()
   {
      return new ShapeImage(new Ellipse2D.Double(0, 0, 1, 1));
   }

   /**
    * Creates a new <code>Image</code> consisting of a square with side 1 (so it
    * will completely fill the viewing region unless it is transformed).
    * 
    * @return a new square image
    */
   static Image square()
   {
      return new ShapeImage(new Rectangle2D.Double(0.5, 0.5, 0.1, 0.1));
   }
   /**
    * Creates a square at the I quadrant of the canvas
    * @return  a square at the I quadrant of the canvas
    */
   static Image square1(){
      return new ShapeImage(new Rectangle2D.Double(0, 0, 1, 0.5));
   }

   /**
    * Creates a square at the II quadrant of the canvas
    * @return  a square at the II quadrant of the canvas
    */
   static Image square2()
   {
      return new ShapeImage(new Rectangle2D.Double(0.5, 0, 0.5, 1));
   }

   /**
    * Creates a square at the III quadrant of the canvas
    * @return  a square at the III quadrant of the canvas
    */
   static Image square3(){
      return new ShapeImage(new Rectangle2D.Double(0.5, 0.5, 0.5, 0.5));
   }

   /**
    * Creates a square at the IV quadrant of the canvas
    * @return  a square at the IV quadrant of the canvas
    */
   static Image square4(){
      return new ShapeImage(new Rectangle2D.Double(0, 0.5, 0.5, 0.5));
   }

   /**
    * Creates a cloud
    * @param x coordinate of the cloud
    * @param y coordinate of the cloud
    * @param size of the cloud
    * @param color of the cloud
    * @return a cloud image
    */
   static Image cloud(double x, double y, double size, Color color){
      return new Cloud(x, y, size, color);
   }

   /**
    * Creates a circle 
    * @param x the X coordinate of the upper-left corner of the framing rectangle
    * @param y the Y coordinate of the upper-left corner of the framing rectangle
    * @param w the width of the framing rectangle
    * @param h the height of the framing rectangle
    * @return a circle image
    */
   static Image circle1(double x, double y, double w, double h)
   {
      return new ShapeImage(new Ellipse2D.Double(x,y,w,h));
   }

   /**
    * creates a triangle at pivots at the left angle with width w, height h and color color
    * @param x coordinate of pivot point
    * @param y coordinate of pivot point
    * @param w width of triangle
    * @param h height of triangle
    * @param color color of triangle
    * @return a triangle at (x,y) with width w, height h and color color
    */
   static Image triangle(double x, double y, double w, double h, Color color){
      return new Triangle(w, h, color).translate(x, y);
   }

   /**
    * creates a triangle at pivots at the right angle angle with width w, height h and color color
    * @param x coordinate of pivot point
    * @param y coordinate of pivot point
    * @param w width of triangle
    * @param h height of triangle
    * @param color color of triangle
    * @return a cone at (x,y) with width w, height h and color color
    */
   static Image cone(double x, double y, double w, double h, Color color){
      return new Cone(w, h, color).translate(x, y);
   }
}

////////////////////////////////////////////////////////////////////////////////
// File:            Scaled.java
// Course:          CSC 232 A, Spring 2021
// Authors:         Minh Nguyen
//
// Acknowledgments: None
//
// Online sources:  None
////////////////////////////////////////////////////////////////////////////////

/**
 * An implementation of <code>MovingAverageInterface</code> interface that will calculate 
 * the cumulative average of given scaled elements 
 * 
 * @author minhnguyen_2024@depauw.edu
 */
public class Scaled implements MovingAverage{

    public Scaled(double scale){
        this.scale = scale;
    }

    @Override
    public void print() {
        System.out.println(scaledSum);
    }

    @Override
    public void add(int n) {
        maxIsUpdated = true;
        minIsUpdated = true;
        if(ct == 0){
            maxOfScaled = n;
            minOfScaled = n;
        }
        if (n > maxOfScaled){
            maxOfScaled= n;
        }
        if(n < minOfScaled){
            minOfScaled = n;
        }
        scaledSum+=Math.floor(n*scale); //round n*scale down to nearst int
        size++;
        ct++;

    }

    @Override
    public double avg() {
        if (size == 0){
            return 0.0;
        }
        else{
            return scaledSum/size;
        }
    }

    /**
    * Return the minimium value of all Scaled instances.
    * @return the minimum value of all Scaled instances
    */
    public static int maxOfScaled(){
        return maxOfScaled;
    }

    /**
    * Return the maximium value of all Scaled instances.
    * @return the maximum value of all Scaled instances
    */
    public static int minOfScaled(){
        return minOfScaled;
    }

    /**
     * Check if maxOfScaled is updated for the first time.
     * @return true if maxOfScaled is updated for the first time
     */
    public static boolean maxIsUpdated(){
        return maxIsUpdated;
    }

    /**
     * Check if minOfScaled is updated for the first time.
     * @return true if minOfScaled is updated for the first time
     */
    public static boolean minIsUpdated(){
        return minIsUpdated;
    }
    
    private double scale;
    private double scaledSum;
    private int size;
    
    private static int maxOfScaled = 0;
    private static int minOfScaled = 0;
    private static int ct = 0;
    private static boolean minIsUpdated = false;
    private static boolean maxIsUpdated = false;
}
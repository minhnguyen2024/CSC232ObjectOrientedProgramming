////////////////////////////////////////////////////////////////////////////////
// File:            SimpleAverage.java
// Course:          CSC 232 A, Spring 2021
// Authors:         Minh Nguyen
//
// Acknowledgments: None
//
// Online sources:  None
////////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
/**
 * An implementation of <code>MovingAverageInterface</code> interface that will calculate 
 * the simple average of a given window
 * 
 * @author minhnguyen_2024@depauw.edu
 */

public class SimpleAverage implements MovingAverage{
    /**
     * Construct a SimpleAverage object with given window
     * @param window
     */
    public SimpleAverage(int window){
        this.window = window;
        simple = new ArrayList<>();
        simpleSum = 0;
        size = 0;
    }
    /**
     * Print out an ArrayList containing elements of a SimpleAverage instance
     */
    @Override
    public void print() {
        System.out.println("Simple Average ArrayList: ");
        for (int i: simple){
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    /**
     * Add an element to <code>simple</code>. Keep track of whether the first element of the all instances is added
     */
    @Override
    public void add(int n) {
        maxIsUpdated = true;
        minIsUpdated = true;
        if (ct == 0){
            maxOfSimple = n;
            minOfSimple = n;
        }
        if (n > maxOfSimple){
            maxOfSimple = n;
            
        }
        if (n < minOfSimple){
            minOfSimple = n;
            
        }
        simple.add(n);
        simpleSum+= n;
        size++;
        ct++;
    }

    /**
     * Caluculate the simple average of window <code>window</code> of a SimpleAverage instance.
     * @return the simple average of window <code>window</code> of a SimpleAverage instance. 
     * Return -1 if window is larger than <code>simple.size()</code>
     */
    @Override
    public double avg() {
        double sum = 0;
        if(simple.size() == 0){
            return 0.0;
        }
        else 
        if (simple.size() < window){
            return simpleSum/size;
        }
        else{
            for (int i = simple.size() - window; i < simple.size(); i++){
                sum += simple.get(i); 
            }
            return sum/window;
        }
    }

   /**
    * Return the maximum value of all SimpleAverage instances.
    * @return the maximum value of all SimpleAverage instances
    */
    public static int maxOfSimple() {
        return maxOfSimple;
    }

    /**
    * Return the minimium value of all SimpleAverage instances.
    * @return the minimum value of all SimpleAverage instances
    */
    public static int minOfSimple() {
        return minOfSimple;
    }

    /**
     * Check if maxOfSimple is updated for the first time.
     * @return true if maxOfSimple is updated for the first time
     */
    public static boolean maxIsUpdated(){
        return maxIsUpdated;
    }

     /**
     * Check if minOfSimple is updated for the first time.
     * @return true if minOfSimple is updated for the first time
     */
    public static boolean minIsUpdated(){
        return minIsUpdated;
    }

    private ArrayList<Integer> simple;
    private int window;
    private double simpleSum;
    private int size;

    private static int ct = 0;
    private static int maxOfSimple = 0;
    private static int minOfSimple = 0;
    private static boolean minIsUpdated = false;
    private static boolean maxIsUpdated = false;
}

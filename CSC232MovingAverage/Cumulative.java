////////////////////////////////////////////////////////////////////////////////
// File:            Cumulative.java
// Course:          CSC 232 A, Spring 2021
// Authors:         Minh Nguyen
//
// Acknowledgments: None
//
// Online sources:  None
////////////////////////////////////////////////////////////////////////////////
/**
 * An implementation of <code>MovingAverageInterface</code> interface that will calculate 
 * the cumulative average of given elements
 * 
 * @author minhnguyen_2024@depauw.edu
 */
public class Cumulative implements MovingAverage{
    /**
     * Construct a Cumulative object 
     */
    
    public Cumulative(){
        //cumulative = new ArrayList<>();
        cumulativeSum = 0;
        size = 0;
    }

    @Override
    public void print() {
        
    }

    /**
     * Add an element to <code>simple</code>. Keep track of whether the first element of the all instances is added.
     */
    @Override
    public void add(int n) {
        maxIsUpdated = true;
        minIsUpdated = true;
        if(ct == 0){
            maxOfCumulative = n;
            minOfCumulative = n;
        }
        if (n > maxOfCumulative){
            maxOfCumulative = n;
        }
        if(n < minOfCumulative){
            minOfCumulative = n;
        }
        cumulativeSum+=n;
        size++;
        ct++;
    }
    
    /**
     * Caluculate the cumulative average of a Cumulative instance.
     * @return the cumulative average of a Cumulative instance.
     */
    @Override

    public double avg() {
        if (size == 0){
            return 0.0;
        }
        else{
            return cumulativeSum/size;
        }
    }

    /**
    * Return the minimium value of all Cumulative instances.
    * @return the minimum value of all Cumulative instances
    */
    public static int maxOfCumulative(){
        return maxOfCumulative;
    }

    /**
    * Return the maximium value of all Cumulative instances.
    * @return the maximum value of all Cumulative instances
    */
    public static int minOfCumulative(){
        return minOfCumulative;
    }

    /**
     * Check if maxOfCumulative is updated for the first time.
     * @return true if maxOfCumulative is updated for the first time
     */
    public static boolean maxIsUpdated(){
        return maxIsUpdated;
    }

    /**
     * Check if minOfCumulative is updated for the first time.
     * @return true if minOfCumulative is updated for the first time
     */
    public static boolean minIsUpdated(){
        return minIsUpdated;
    }

    private static int maxOfCumulative = 0;
    private static int minOfCumulative = 0;
    private static int ct = 0;
    private double cumulativeSum;
    private int size;
    
    private static boolean minIsUpdated = false;
    private static boolean maxIsUpdated = false;

    
}

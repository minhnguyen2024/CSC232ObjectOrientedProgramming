////////////////////////////////////////////////////////////////////////////////
// File:            MovingAverageInterface.java
// Course:          CSC 232 A, Spring 2021
// Authors:         Minh Nguyen
//
// Acknowledgments: None
//
// Online sources:  None
////////////////////////////////////////////////////////////////////////////////
/**
 * An <code>MovingAverage</code> represents any methods of calculating moving averages from an ArrayList<Integer>.
 * @author minhnguyen_2024@depauw.edu
 */

import java.util.ArrayList;
public interface MovingAverage {
    /**
     * To be called in implementations of <code>this</code>. Add int n to arr to record all insertions from those created implementations.
     * @param n integer to be added
     */
    public static void updateMaxMin(int n){
        int maxOfAll = 0;
        int minOfAll = 0;
        if (n > maxOfAll){
            maxOfAll = n;
        }
        if (n < minOfAll){
            minOfAll = n;
        }
    }

    /**
     * Calculate the simple average of window n of a <code>this</code> implementation.
     * @param n simple average window
     * @return an instance of an implementation of <code>this</code>
     */
    public static MovingAverage makeSimple(int n){
        SimpleAverage sma = new SimpleAverage(n);
        return sma;
    }

    /**
     * Calculate the cumulative average of a <code>this</code> implementation.
     * @return an instance of an implementation of <code>this</code>
     */
    public static MovingAverage makeCumulative(){
        Cumulative cma = new Cumulative();
        return cma;
    }

    /**
     * Calculate the cumulative average of a <code>this</code> implementation with elements scaled to n.
     * @return an instance of an implementation of <code>this</code>
     */
    public static MovingAverage makeScaled(double scale){
        Scaled scaled = new Scaled(scale);
        return scaled;
    }

    /**
     * Return the maximum value of all instances of implementations of MovingAverageInterface
     * @return the maximum value of all instances of implementations of MovingAverageInterface
     */
    public static int max(){
        ArrayList<Integer> maxValues = new ArrayList<>();
        if (Cumulative.maxIsUpdated()){
            maxValues.add(Cumulative.maxOfCumulative());
        }
        if (SimpleAverage.maxIsUpdated()){
            maxValues.add(SimpleAverage.maxOfSimple());
        }
        if (Scaled.maxIsUpdated()){
            maxValues.add(Scaled.maxOfScaled());
        }

        int maxOfAll = maxValues.get(0);
        for (Integer i: maxValues){
            if (i > maxOfAll){
                maxOfAll = i;
            }
        }
        return maxOfAll;
    }

    /**
     * Return the minimum value of all instances of implementations of MovingAverageInterface
     * @return the minimum value of all instances of implementations of MovingAverageInterface
     */
    public static int min(){
        ArrayList<Integer> minValues = new ArrayList<>();
        if (Cumulative.minIsUpdated()){
            minValues.add(Cumulative.minOfCumulative());
        }
        if (SimpleAverage.minIsUpdated()){
            minValues.add(SimpleAverage.minOfSimple());
        }
        if (Scaled.minIsUpdated()){
            minValues.add(Scaled.minOfScaled());
        }

        int minOfAll = minValues.get(0);
        for (Integer i: minValues){
            if (i < minOfAll){
                minOfAll = i;
            }
        }
        return minOfAll;
    }

    public void print();
    public void add(int n);
    public double avg();
}


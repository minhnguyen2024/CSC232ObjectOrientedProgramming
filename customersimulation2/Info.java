package customersimulation2;
/**
   The <code>Info</code> class creates random names and ages for <code>Customer</code> .
   @author Minh Nguyen <minhnguyen_2024@depauw.edu>
*/

import java.util.Random;

public class Info {
    /**
     * Construct an Info object
     */
    public Info(){
        for (int i = 0; i < 100; i++){
            ages[i] = i;
            this.random = new Random();
        }
    }
    /**
     * get a random age from 0 to 100
     * @return a random age as int
     */
    public int getRandomAge(){
        return ages[random.nextInt(ages.length)];
    }
    
    /**
     * get a random name from names
     * @return a random name as String
     */
    public String getRandomName(){
        return names [random.nextInt(names.length)];
    }

    private int[] ages = new int[100];
    private Random random;
    private String[] names = {"Brian", "George", "Scott", "Minh", "Chad", "Steven", "Alicia", "Alex", "Brandon", "Max", "DeJuan", "Jacob", "Damir"};
}

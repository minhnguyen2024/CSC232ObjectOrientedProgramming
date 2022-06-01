package customersimulation1;
/**
   The <code>Customer</code> class creates a Customer Object.
   @author Minh Nguyen <minhnguyen_2024@depauw.edu
*/

public class Customer {
    /**
     * Constructs a Customer Object
     * @param name name of customer
     * @param arrivalTime arrival time of customer
     */
    public Customer(int arrivalTime){
        this.arrivalTime = arrivalTime;
    }
  
    public Customer(String name, int arrivalTime){
        this.name = name;
        this.arrivalTime = arrivalTime;
        System.out.println(this.toString());
    }

    /**
     * Set customer's name
     * @param name name of a customer
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get the name of a Customer object
     * @return the name of an according customer
     */
    public String getName(){
        return name;
    }
    
    /**
     * Set customer's arrival time
     * @param arrivalTime arrival time of a customer
     */
    public void setArrivalTime(int arrivalTime){
        this.arrivalTime = arrivalTime;
    }
    
    /**
     * Get the arrival time of a Customer object
     * @return the arrival time of an according customer
     */
    public int getArrivalTime(){
        return arrivalTime;
    }

    
    /**
     * Return information about the customer as a String
     * @return a String containing the Customer's name, age, and arrival time
     */
    public String toString(){
        return "Customer " + "{ " + "name: " + name  + "; arrival time: " + arrivalTime + " }";
    }

    private String name;
    private int arrivalTime;
}

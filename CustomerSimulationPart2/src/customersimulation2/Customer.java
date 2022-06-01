package customersimulation2;
/**
   The <code>Customer</code> class creates a customer.
   @author Minh Nguyen <minhnguyen_2024@depauw.edu>
*/

class Customer{
    /**
     * Constructs a Customer object
     * @param name of customer
     * @param arrivalTime arrival time of customer
     */
    public Customer(String name, int arrivalTime){
      this.name = name;
      this.arrivalTime = arrivalTime;
    }

    /**
     * Constructs a Customer object, with random name and age 
     * @param arrivalTime arrival time of customer
     */
    public Customer(int arrivalTime){
      this.arrivalTime = arrivalTime;
      Info info = new Info();
      this.name = info.getRandomName();
      this.age = info.getRandomAge();
    }

    /**
     * Constructs a Customer object
     * @param name name of customer
     * @param arrivalTime arrival time of customer
     * @param age age of customer
     */
    public Customer(String name, int age ,int arrivalTime){
      this.arrivalTime = arrivalTime;
      this.name = name;
      this.age = age;
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
     * Set customer's age
     * @param age age of a customer
     */
    public void setAge(int age){
      this.age = age;
    }
  
    /**
     * Get the age of a Customer object
     * @return the age of an according customer
     */
    public int getAge(){
      return age;
    }

    /**
     * Return information about the customer as a String
     * @return a String containing the Customer's name, age, and arrival time
     */
    public String toString(){
      return "Customer " + "{ " + "name: " + name  + "; age: " + age + "; arrival time: " + arrivalTime + " }";
    }

    private String name;
    private int arrivalTime;
    private int age;
  }

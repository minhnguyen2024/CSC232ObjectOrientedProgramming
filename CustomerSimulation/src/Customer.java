class Customer{
    private String name;
    private int arrivalTime;
    private int age;
  
    public Customer(String name, int arrivalTime, int age){
      this.name= name;
      this.arrivalTime = arrivalTime;
      this.age = age;
    }
  
    public Customer(){
      
    }
  
    public void setName(String name){
      this.name = name;
    }
  
    public String getName(){
      return name;
    }
  
    public void setArrivalTime(int arrivalTime){
      this.arrivalTime = arrivalTime;
    }
  
    public int getArrivalTime(){
      return arrivalTime;
    }
  
    public void setAge(int age){
      this.age = age;
    }
  
    public int getAge(){
      return age;
    }
  
    public String toString(){
      return "Customer " + "{ " + "name: " + name  + "; age: " + age + "; arrival time: " + arrivalTime + " }";
    }
  }

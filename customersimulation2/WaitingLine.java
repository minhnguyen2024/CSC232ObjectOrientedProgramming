package customersimulation2;
/**
   The <code>WaitingLine</code> class creates a waiting line.
   @author Minh Nguyen <minhnguyen_2024@depauw.edu>
*/

import java.util.ArrayList;
public class WaitingLine {
    ArrayList<Customer> newQueue;

    public WaitingLine(){
        newQueue = new ArrayList <>();
    }

    /**
     * add a customer to the end of the line
     * @param c Customer object to be added to the waiting line
     */
    public void addCustomer(Customer c){
        newQueue.add(c);
        bubbleSort();
    }

    public void addCustomer1(Customer c){
        if (newQueue.size()==0){
            newQueue.add(c);
            // printWaitingLine();
            // System.out.println();
        }
        else if (newQueue.size() == 1) {
            if (c.getArrivalTime() > newQueue.get(0).getArrivalTime()){
                newQueue.add(c);
                // printWaitingLine();
                // System.out.println();
            }
            else{
                newQueue.add(0, c);
                // printWaitingLine();
                // System.out.println();
            }
        }
        else{
            if (c.getArrivalTime() < newQueue.get(0).getArrivalTime()){
                newQueue.add(0, c);
                // printWaitingLine();
                // System.out.println();
            }
            else{
                for (int i = 0; i < newQueue.size()-1; i++){
                    if (c.getArrivalTime() >= newQueue.get(i).getArrivalTime() && c.getArrivalTime() < newQueue.get(i+1).getArrivalTime()){
                        newQueue.add(i+1, c);
                        // printWaitingLine();
                        // System.out.println();
                        break;
                    }
                }
            }
        }
    }

    /**
     * Get the number of customer waiting in line/
     * @return the number of customer waiting in line.
     */
    public int numberOfCustomerInLine(){
        return newQueue.size();
    }

    /**
     * Sorts the waiting line in order of ascending arrival time
     */
    public void bubbleSort(){
        for(int i = 0; i < newQueue.size(); i++){
            for (int j = 0; j < newQueue.size()-1; j++){
                if (newQueue.get(j).getArrivalTime() > newQueue.get(j+1).getArrivalTime()){
                    Customer temp = newQueue.get(j);
                    newQueue.set(j, newQueue.get(j+1));
                    newQueue.set(j+1, temp);
                }
            }
        }
    }

    /**
     * Prints out the information of the customers waiitng in line.
     */
    public void printWaitingLine(){
        for (Customer customer: newQueue){
            System.out.println(customer.toString());
        }
    }

    public boolean isEmpty(){
        if(newQueue.isEmpty()) 
            return true;
        else 
            return false;
    }

    public Customer remove(){
        return newQueue.remove(0);
    }
}

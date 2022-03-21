import java.util.ArrayList;
public class WaitingLine {
    ArrayList<Customer> newQueue;

    public WaitingLine(){
        newQueue = new ArrayList <>();
    }

    public void addCustomer(Customer c){
        newQueue.add(c);
        bubbleSort();
    }

    public int numberOfCustomerInLine(){
        return newQueue.size();
    }

    public void bubbleSort(){
        for(int i = 0; i < newQueue.size(); i++){
            for (int j = 0; j < newQueue.size()-1; j++){
                if (newQueue.get(j).getArrivalTime() > newQueue.get(j+1).getArrivalTime()){
                    Customer temp = newQueue.get(j);
                    newQueue.set(j+1, temp);
                    newQueue.set(j, newQueue.get(j+1));
                }
            }
        }
    }

    public void printWaitingLine(){
        for (Customer customer: newQueue){
            System.out.println(customer.toString());
        }
    }
}

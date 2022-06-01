import customersimulation1.Customer;
import customersimulation1.WaitingLine;

////////////////////////////////////////////////////////////////////////////////
// File:             CustomerSimulation
// Course:           CSC232A, Spring 2022
// Authors:          Minh Nguyen
//
// Acknowledgements: None
//
// Online sources:  None
////////////////////////////////////////////////////////////////////////////////

public class App {
    public static void main(String[] args) throws Exception {
        WaitingLine line = new WaitingLine();
        System.out.println("Creating Customer: ");

        Customer jthomas = new Customer("Justin Thomas", 6);
        line.addCustomer(jthomas);

        Customer mscott = new Customer("Michael Scott", 1);
        line.addCustomer(mscott);

        Customer twoods = new Customer("Tiger Woods", 3);
        line.addCustomer(twoods);

        Customer lbj  = new Customer("LeBrom James", 7);
        line.addCustomer(lbj);

        Customer jhalpert = new Customer("Jim Halpert", 2);
        line.addCustomer(jhalpert);

        Customer dshrute = new Customer("Dwight Shrute", 5);
        line.addCustomer(dshrute);

        System.out.println();


        System.out.println("Serving customers: ");
        while (line.numberOfCustomerInLine() > 0){
            System.out.println(line.remove().toString());
        }
    }
}

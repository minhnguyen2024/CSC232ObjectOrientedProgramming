package customersimulation2;
/**
   The <code>Part1Test</code> tests addCustomer1().
   @author Minh Nguyen <minhnguyen_2024@depauw.edu>
*/

import java.util.Random;

public class Part1Test {
    public static void main(String[] args){
        
        WaitingLine line1 = new WaitingLine();
        Info info = new Info();
        Random random = new Random();

        for (int i = 0; i < 10; i++){
            line1.addCustomer1(new Customer(info.getRandomName(), random.nextInt(100)));
        }
        System.out.println("Creating Customer: ");
        line1.printWaitingLine();


        System.out.println("Serving customers: ");
        while (line1.numberOfCustomerInLine() > 0){
            System.out.println(line1.remove().toString());
        }
        
        System.out.println("---------------------");

        WaitingLine line = new WaitingLine();

        Customer jthomas = new Customer("Justin Thomas", 6);
        line.addCustomer1(jthomas);

        Customer mscott = new Customer("Michael Scott", 1);
        line.addCustomer1(mscott);

        Customer twoods = new Customer("Tiger Woods", 3);
        line.addCustomer1(twoods);

        Customer lbj  = new Customer("LeBrom James", 7);
        line.addCustomer1(lbj);

        Customer jhalpert = new Customer("Jim Halpert", 2);
        line.addCustomer1(jhalpert);

        Customer dshrute = new Customer("Dwight Shrute", 5);
        line.addCustomer1(dshrute);

        Customer mj = new Customer("Michael Jordan", 0);
        line.addCustomer1(mj);

        System.out.println();
        line.printWaitingLine();
        System.out.println();

        System.out.println("Serving customers: ");
        while (line.numberOfCustomerInLine() > 0){
            System.out.println(line.remove().toString());
        }
    }
}

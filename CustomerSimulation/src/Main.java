public class Main {
    public static void main(String[] args) throws Exception {
        Customer bhoward = new Customer("Brian Howard", 13, 55);
        Customer sthede = new Customer("Scott Thede", 15, 60);
        Customer mnguyen = new Customer("Minh Nguyen", 48, 19);

        WaitingLine newLine = new WaitingLine();
        newLine.addCustomer(bhoward);
        newLine.addCustomer(sthede);
        newLine.addCustomer(mnguyen);

        newLine.printWaitingLine();;
        
    }
}

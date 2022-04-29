package customersimulation2;
////////////////////////////////////////////////////////////////////////////////
// File:             Customer Simulation Part II
// Course:           CSC232A, Spring 2022
// Authors:          Brian Howard, Minh Nguyen
//
// Acknowledgements: None
//
// Online sources:  None
////////////////////////////////////////////////////////////////////////////////
import java.util.Random;

/**
 * An <code>Office</code> manages a simulation of an office with a number (N) of
 * servers, each with their own waiting line. During the simulation, at each
 * minute there is a probability of a new customer arriving; they will enter the
 * shortest available waiting line. Each customer requires a fixed service time
 * with a server; at the end of that time, there is a probability that their
 * visit is complete, and if not, then the customer rejoins the shortest
 * available waiting line to await another turn with a server.
 * 
 * @author bhoward
 */
public class Office
{
   /**
    * Construct an <code>Office</code> with the specified characteristics.
    * 
    * @param N
    *           the number of servers (and waiting lines)
    * @param arrivalProbability
    *           the probability (between 0 and 1) that a customer will arrive in
    *           any given minute of the simulation
    * @param serviceTime
    *           the time each customer will spend with a server
    * @param completionProbability
    *           the probability (between 0 and 1) that a customer will complete
    *           their visit after seeing a server
    */
   public Office(int N, double arrivalProbability, int serviceTime, double completionProbability){
      this.time = 0;

      this.lines = new WaitingLine[N]; //creates an array with N number of WaitingLine objects
      for (int i = 0; i < N; i++) {
         lines[i] = new WaitingLine();
      }

      this.servers = new Server[N]; //creates an array with N number of Server objects, as ond WaitingLine will have 1 Server
      for (int i = 0; i < N; i++) {
         servers[i] = new Server();
      }

      this.arrivalProbability = arrivalProbability;
      this.serviceTime = serviceTime;
      this.completionProbability = completionProbability;

      this.arrivals = 0;
      this.services = 0;
      this.completions = 0;
      this.totalVisitTime = 0;

      this.random = new Random();
   }

   /**
    * Process one minute of the simulation.
    */
   public void processMinute()
   {
      // Check for a new arrival
      if (random.nextDouble() < arrivalProbability) {
         Customer customer = new Customer(time);
         arrive(customer, time);
         addToShortestLine(customer);
      }

      // Check for end of service
      for (int i = 0; i < servers.length; i++) {
         if (servers[i].customer != null && servers[i].endTime <= time) {
            Customer customer = servers[i].customer;
            servers[i].customer = null;

            // Check for completion of visit
            if (random.nextDouble() < completionProbability) {
               complete(customer, time);
            }
            else {
               addToShortestLine(customer);
               delay(customer, time);
            }
         }
      }

      // Check for start of service
      for (int i = 0; i < servers.length; i++) {
         if (servers[i].customer == null && !lines[i].isEmpty()) {
            Customer customer = lines[i].remove();
            servers[i].customer = customer;
            servers[i].endTime = time + serviceTime;
            serve(customer, time);
         }
      }

      // Increment the clock, ready for the next minute
      time++;
   }

   public static void main(String[] args)
   {
      final int N = 3;
      final int SERVICE_TIME = 15;
      
      final int DURATION = 10;
      final double ARRIVAL_PROBABILITY = 0.1;
      final double COMPLETION_PROBABILITY = 0.5;

      Office office = new Office(N, ARRIVAL_PROBABILITY, SERVICE_TIME, COMPLETION_PROBABILITY);
      for (int time = 0; time < DURATION; time++) {
         office.processMinute();
      }

      System.out.println("Arrivals: " + office.arrivals);
      System.out.println("Completions: " + office.completions);
      double completionRate = (double) office.completions / office.arrivals;
      System.out.println("Completion rate: " + completionRate);
      double averageVisitTime = (double) office.totalVisitTime / office.completions;
      System.out.println("Average completed visit time: " + averageVisitTime);

      double utilization = (double) office.services * office.serviceTime / (N * (DURATION + SERVICE_TIME));
      System.out.println("Server utilization: " + utilization);
   }

   private void arrive(Customer customer, int time)
   {
      arrivals++;
      System.out.println("Arriving customer: " + customer + " at time " + time);
   }

   private void serve(Customer customer, int time)
   {
      services++;
      System.out.println("Serving customer: " + customer + " at time " + time);
   }

   private void delay(Customer customer, int time)
   {
      System.out.println("Delaying customer: " + customer + " at time " + time);
   }

   private void complete(Customer customer, int time)
   {
      completions++;
      totalVisitTime += (time - customer.getArrivalTime());
      System.out.println("Completed customer: " + customer + " at time " + time);
   }

   //TODO:
   private void addToShortestLine(Customer customer)
   {
      int minNumberOfCustomerInLine = lines[0].numberOfCustomerInLine();
      int indexOfLineWithLeastCustomer = 0;
      for (int i = 0; i < lines.length; i++){
         if (lines[i].numberOfCustomerInLine() < minNumberOfCustomerInLine){
            indexOfLineWithLeastCustomer = i;
            minNumberOfCustomerInLine = lines[i].numberOfCustomerInLine();
         }
      }
      lines[indexOfLineWithLeastCustomer].addCustomer1(customer); //Using O(n) runtime sorting algorithm
   }

   private int time;
   private WaitingLine[] lines;
   private Server[] servers;

   private double arrivalProbability;
   private int serviceTime;
   private double completionProbability;
   private Random random;

   private int arrivals;
   private int services;
   private int completions;
   private int totalVisitTime;

   /**
    * A <code>Server</code> is just an object with a customer and an
    * end-of-service time. It is not intended for use outside the Office class.
    * 
    * @author bhoward
    */
   private static class Server
   {
      public Customer customer;
      public int endTime;
   }
}

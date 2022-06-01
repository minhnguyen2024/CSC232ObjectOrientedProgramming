////////////////////////////////////////////////////////////////////////////////
// File:            Main.java
// Course:          CSC 232 A, Spring 2021
// Authors:         Minh Nguyen
//
// Acknowledgments: None
//
// Online sources:  None
////////////////////////////////////////////////////////////////////////////////
class Main {
  public static void main(String[] args) {
    MovingAverage scale = MovingAverage.makeScaled(2.5);

    for (int i = 1; i < 5; i++){
      scale.add(i);
    }

    System.out.println(scale.avg());
    scale.print();
  }
}
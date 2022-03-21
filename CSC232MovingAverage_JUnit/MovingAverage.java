import java.util.ArrayList;

public class MovingAverage{
  ArrayList <Integer> arr;
  int simpleWindow;
  int cumulativeWindow;
  static int max = 0;
  static int min = 0;

  public MovingAverage(){
    arr = new ArrayList<>();
  }

  public MovingAverage(int simpleWindow){
    arr = new ArrayList<>();
    this.simpleWindow = simpleWindow;
  }

  public void add(int n){
    if (arr.size() == 0){
      arr.add(n);
      cumulativeWindow++;
      min = arr.get(0);
      max = arr.get(0);
    }
    else{
      arr.add(n);
      cumulativeWindow++;
      if (n > max){
        max = n;
      }
      if (n < min){
        min = n;
      }
    }
  }

  public static int max(){
    return max;
  }

  public static int min(){
    return min;
  }

  public double avg(){
    int k = arr.size();
    double avg = 0;
    if (k < simpleWindow && cumulativeWindow >= 0){
      System.out.println("Error");
    }
    else{
      if (simpleWindow == 0){
        double cumulativeSum = 0;
        for (int i = 0; i < k; i++){
          cumulativeSum += arr.get(i);
        }
        double cumulativeAvg = cumulativeSum/cumulativeWindow;
        return cumulativeAvg;
      } 
      else if (simpleWindow >= 0){
        double simpleSum = 0;
        for (int i = k - simpleWindow; i < k; i++){
          simpleSum += arr.get(i);
        }
        double simpleAvg = simpleSum/simpleWindow;
        return simpleAvg;
      } 
    }
    return avg;
  }

  public void printArrayList(){
    for (Integer i: arr){
      System.out.print(i + ", ");
    }
  }
}

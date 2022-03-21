public class App {
  public static boolean print(){
      return true;
  }

  public static boolean isPalindorme(String s){
    //string with even number of character
    if (s.length() % 2 == 0){
      for (int i = 0; i < s.length(); i++){
        int j = s.length() - 1 - i;
        while (i < j){
          if (s.charAt(i) != s.charAt(j)){
            return false;
          }
        }
      }
      return true;
    }
    else{
      for (int i = 0; i < s.length(); i++){
        int j = s.length() - 1 - i;
        while (i != j){
          if (s.charAt(i) != s.charAt(j)){
            return false;
          }
        }
      }
      return true;
    }
  }
  static int[] bubbleSort(int[] arr){
    for (int i = 0; i < arr.length; i++){
      for(int j = 0; j < arr.length-1; j++){
        int temp;
        if(arr[j] > arr [j+1]){
          temp = arr[j];
          arr[j] = arr [j+1];
          arr [j+1] = temp;
        }
      }
    }
  return arr;
  }

  static int solution(int[] statues) {
    bubbleSort(statues);
    
    int ct = 0;
    for (int i = 0; i < statues.length-1;i++){
        if (statues[i+1] - statues[i] != 1){
            ct = ct + (statues[i+1] - statues[i])-1;
        }
    }
    return ct;
  }

  static void printArray(int[] arr){
    for (int i = 0; i < arr.length;i++){
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) {
    System.out.println("Hello World");
  }
}

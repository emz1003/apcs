public class Children{
  public static void main(String[] args) {
    new Children().run();
  }

  public void run(){
    int[] arr = new int[4];
    double sum = 0;
    for(int trials = 0; trials < 100; trials++){
      int t = trial();
      sum += t;
      if(t < 5)
        arr[t - 2]++;
      else
        arr[3]++;
    }

    int max = 0;
    int index = 0;
    String result;
    for(int i = 0; i < arr.length; i++){
      if (arr[i] > max){
         max = arr[i];
         index = i;
       }
    }
    if (index < 5) result = index + 2 + " children";
    else result = "more than 5 children";
    System.out.println("mean # children: " + sum/100.0);
    System.out.println("most common outcome: " + result);
  }

  public int trial(){
    int girls = 0;
    int boys = 0;
    while(girls == 0 || boys == 0){
      Coin c = new Coin();
      if(c.flip().equals("H"))
        girls++;
      else
        boys++;
    }
    return boys + girls;
  }

}

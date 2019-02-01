import java.util.Arrays;
public class MyBridge{
    public static void main(String [] args){
      new MyBridge().run();
    }
    public void run(){
      int[] ans = new int[3];//{case5332. case4432, case4333}
      for(int i = 0; i < 100; i++)
        countCombinations(count(createShuffledDeck()), ans);
      int max = Math.max(ans[0],Math.max(ans[1],ans[2]));
      if ( max == ans[0]) System.out.println("5-3-3-2 is the most likely.");
      else if (max == ans[1]) System.out.println("4-4-3-2 is the most likely.");
      else System.out.println("4-3-3-3 is the most likely.");

    }
    private int[] createShuffledDeck(){
      int[] deck = new int[52];
        for(int i = 0; i < 4; i++)
          for(int j = 0; j < 13; j++)
            deck[i * 13 + j] = i;
      shuffle(deck);
      return deck;

    }

    private int[] shuffle(int [] deck){
      for (int i = 0; i < deck.length; i++){
        int x = (int)(Math.random() * deck.length - 1);
        int y = deck[i];
        deck[i] = deck[x];
        deck[x] = deck[y];
      }
      return deck;
    }
    private int[][] count(int[] deck){
      int[][] hands = new int[4][4];
      for(int card = 0; card < 52; card++){
        hands[card / 13][deck[card]]++;
      }
      for(int i = 0; i < 4; i++)
        Arrays.sort(hands[i]);
      return hands;
    }
    private int[] countCombinations(int[][] hands, int[] ans){
      int[] c5332 = {5,3,3,2};
      int[] c4432 = {4,4,3,2};
      int[] c4333 = {4,3,3,3};
      for(int[] hand: hands){
        if(hand == c5332) ans[0]++;
        if(hand == c4432) ans[1]++;
        if(hand == c4333) ans[2]++;
      }
      return ans;
    }
    private void printArray(int[] array){
      System.out.print("{");
      for(int i = 0; i < array.length; i++){
        System.out.print(array[i]);
        if(i != array.length - 1) System.out.print(", ");
      }
      System.out.println("}");
    }
    private void printArray(int[][] array){
      System.out.print("{");
      for(int i = 0; i < array.length; i++){
        printArray(array[i]);
        System.out.println(",");
      }
      System.out.print("}");
    }

}

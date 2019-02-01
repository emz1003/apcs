//Claire Tempelman and Emily Zhang

//TO RUN: no input needed.
//OUTPUT: will output the occurence of each card distribution in 1000000 games of bridge, as well as which one occurs the most.

public class Bridge{
    public static void main(String [] args){
      new Bridge().run();
    }
    public void run(){
      int a = 0;
      int b = 0;
      int c = 0;
      for (int x = 0; x < 1000000; x++){
        if (countCombinations(count(createShuffledDeck())) == 1) a++;
        if (countCombinations(count(createShuffledDeck())) == 2) b++;
        if (countCombinations(count(createShuffledDeck())) == 3) c++;
      }
      System.out.println(a);
      System.out.println(b);
      System.out.println(c);
      if ((Math.max(a, Math.max(b, c))) == a) System.out.println("5-3-3-2 is the most likely.");
      if ((Math.max(b, Math.max(a, c))) == b) System.out.println("4-4-3-2 is the most likely.");
      if ((Math.max(c, Math.max(b, a))) == c) System.out.println("4-3-3-3 is the most likely.");
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
      return hands;
    }
    private boolean arrayequals(int[] a1, int[] a2){
      for (int x = 0; x < a1.length; x++){
        if (a1[x] != a2[x]) return false;
      }
      return true;
    }
    private int [] sort(int [] a){
      int[] dis = new int[4];
      dis[0] = Math.max(Math.max(a[0], a[1]), Math.max(a[2], a[3]));
      dis[1] = Math.min(Math.max(a[0], a[1]), Math.max(a[2], a[3]));
      dis[2] = Math.max(Math.min(a[0], a[1]), Math.min(a[2], a[3]));
      dis[3] = Math.min(Math.min(a[0], a[1]), Math.min(a[2], a[3]));
      return dis;
    }
    private int countCombinations(int[][] hands){
      int case5332 = 0;
      int case4432 = 0;
      int case4333 = 0;
      int [] c5332 = {5, 3, 3, 2};
      int [] c4432 = {4, 4, 3, 2};
      int [] c4333 = {4, 3, 3, 3};
      for (int x = 0; x < hands.length; x++){
        if (arrayequals(sort(hands[x]), c4432)) case4432++;
        if (arrayequals(sort(hands[x]), c5332)) case5332++;
        if (arrayequals(sort(hands[x]), c4333)) case4333++;
      }
      if (case5332 == 0 && case4432 == 0 && case4333 == 0) return 0;
      if ((Math.max(case4432, Math.max(case5332, case4333))) == case4432) return 2;
      if ((Math.max(case5332, Math.max(case4432, case4333))) == case5332) return 1;
      if ((Math.max(case4333, Math.max(case4432, case5332))) == case4333) return 3;
      else return 0;
    }

}

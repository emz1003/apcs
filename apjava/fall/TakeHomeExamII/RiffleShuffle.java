//Claire Tempelman and Emily Zhang
//TO RUN: no input needed.
//OUTPUT: Will output a shuffled deck of 52 cards (numbered 1-52) number by number.

import java.util.ArrayList;

public class RiffleShuffle{
  public static void main(String [] args){
    new RiffleShuffle().run();
  }
  public void run(){
    int [] deck = new int[52];
    deck = riffleshuffle(riffleshuffle(riffleshuffle(riffleshuffle(riffleshuffle(riffleshuffle(riffleshuffle(setupdeck(52))))))));
    for (int x : deck){
      System.out.println(x);
    }
  }
  private int flipcoin(int n){
    int h = 0;
    for (int x = 0; x < n; x++){
      if (((int)(Math.random() * 2.0)) == 1) h++;
    }
    return h;
  }
  private int[] setupdeck(int a){
    int [] deck = new int[a];
    for(int i = 1; i < (a+1); i++) deck[i - 1] = i;
    return deck;
  }
  private int[] riffleshuffle(int [] deck){
    int a = deck.length;
    int n = flipcoin(a);
    ArrayList<Integer> d1 = new ArrayList<Integer>();
    for(int i = 0; i < n; i++) d1.add(deck[i]);
    ArrayList<Integer> d2 = new ArrayList<Integer>();
    for(int i = 0; i < (a-n); i++) d2.add(deck[n+i]);
    int [] newdeck = new int[a];
    for(int i = (a-1); i > -1; i--){
      int p = (int)(Math.random() * a);
      if ((p > d1.size() && d1.size() != 0)){
        newdeck[i] = d1.get(0);
        d1.remove(0);
      }
      else{
        newdeck[i] = d2.get(0);
        d2.remove(0);
      }
    }
    return newdeck;
  }
}

import java.util.ArrayList;

public class Stats {
  private ArrayList<ScoreInfo> scoreList;

  public Stats() {
    scoreList = new ArrayList<ScoreInfo>();
  }

  public boolean record(int score) {
    for(int i = 0; i < scoreList.size(); i++) {
      if (score == scoreList.get(i).getScore()){
        scoreList.get(i).increment();
        return true;
      }
    }

    return scoreList.add(new ScoreInfo(score));
  }

  public void recordScores(int[] stuScores) {
    for (int i: stuScores) {
      record(i);
    }
  }

  public String toString() {
    return scoreList.toString();
  }

  public static void main(String[] args) {
    Stats stat = new Stats();
    int[] arr = new int[10];
    for (int i = 0; i < 10; i++) {
      stat.record(i);
    }
    System.out.println(stat);
    for (int i = 0; i < 10; i++) {
      arr[i] = (int)(Math.random() * 10);
    }
    stat.recordScores(arr);
    System.out.println(stat);
  }
}

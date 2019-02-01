public class TokenScannerClient{
  public static void main(String[] args) {
    new TokenScannerClient().run();
  }

  public void run(){
    TokenScanner sc = new TokenScanner("Ok 007, this is a sentence.");
    sc.ignoreWhitespace();
    System.out.println(avgWordLength(sc));
  }

  public double avgWordLength(TokenScanner s){
    int numToken = 0;
    double sum = 0;
    while(s.hasMoreTokens()){
      sum += s.nextToken().length();
      numToken++;
    }
    System.out.println(sum + " " + numToken);
    return sum / numToken;
  }
}

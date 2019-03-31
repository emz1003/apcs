public class TokenScanner{

    // private instance variables
    private String input;      // String to scan
    private int cp;            // current position
    private boolean ignoreWhitespaceFlag;


    // default constructor
    public TokenScanner(){
      input = "";
      cp = 0;
      ignoreWhitespaceFlag = false;
    }

    // constructor
    public TokenScanner(String input){
      this.input = input;
      cp = 0;
      ignoreWhitespaceFlag = false;
    }


    // resets the input and cp
    public void setInput(String input){
      this.input = input;
      cp = 0;
    }

    // returns true when input contains unprocessed tokens
    public boolean hasMoreTokens(){
      return cp < input.length();
    }


     public void ignoreWhitespace(){
     	   ignoreWhitespaceFlag = true;
     }

    // Skips over any whitespace characters before the next token.
    private void skipWhitespace(){
      while(Character.isWhitespace(input.charAt(cp)))
        cp++;
    }

    // Assumes string does not contain a floating point number.
    // Returns the nextToken() if there is no next token then return
    // an empty string.
    public String nextToken(){
      String ans = "";
      if(Character.isWhitespace(input.charAt(cp)))
        if(ignoreWhitespaceFlag) skipWhitespace();
        else{
          ans = Character.toString(input.charAt(cp));
          cp++;
        }
      else if(!Character.isLetterOrDigit(input.charAt(cp))){
        ans = Character.toString(input.charAt(cp));
        System.out.println(input.charAt(cp));
        cp++;
      } else if(Character.isLetterOrDigit(input.charAt(cp)))
      while(cp < input.length() && Character.isLetterOrDigit(input.charAt(cp))){
        ans += Character.toString(input.charAt(cp));
        System.out.println(input.charAt(cp));
        cp++;
      }
      return ans;
    }
  }

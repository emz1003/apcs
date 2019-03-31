public final class BarCode{

  // instance variables
  private final int CHECKDIGIT;  // a nonnegative digit
  private final String ZIP;      // a string of digits (excludes check digit)
  private final String BARCODE;  // a string of full and half bars

  // table for conversion : digit -> string
  final static String [] CODES = { "||:::", ":::||", "::|:|",
			     "::||:",":|::|",":|:|:",":||::",
			     "|:::|", "|::|:", "|:|::"};
  // constructors
  //precondtion: zip.length() = 5 and zip contains only digits.
  //postcondition: throws a runtime exception zip is not the correct length
  //               or zip contains a non digit
  public BarCode(String zip) {
    String barcode = "";
    if (zip.length() != 5)
      throw new RuntimeException("zip is not the correct length");
    for(int i = 0; i < 5; i++){
      if(!Character.isDigit(zip.charAt(i))) throw new RuntimeException("zip contains a non digit");
      barcode += CODES[Integer.parseInt(Character.toString(zip.charAt(i)))];
    }
    ZIP = zip;
    CHECKDIGIT = zipSum() % 10;
    BARCODE = barcode;
  }

  // postcondition: Creates a copy of a bar code.
  public BarCode(BarCode x){
    ZIP = x.ZIP;
    CHECKDIGIT = x.CHECKDIGIT;
    BARCODE = x.BARCODE;
  }


  //post: computes and returns the check sum for ZIP
  private int zipSum(){
    int zipNum = Integer.parseInt(ZIP);
    int zipSum = 0;
    for(int i = 0; i < 5; i++){
      zipSum += zipNum % 10;
      zipNum /= 10;
    }
    return zipSum;
  }

  //postcondition: format zip + check digit + barcode
  //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"
  public String toString(){
    return ZIP + CHECKDIGIT + "\t" + BARCODE;
  }

  @Override
  public boolean equals(Object other){
    return ZIP == other;
  }

  @Override
  public int hashCode(){
    return this.ZIP.hashCode();
  }
}

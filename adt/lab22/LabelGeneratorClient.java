public class LabelGeneratorClient{
  public static void main(String[] args){
    new LabelGeneratorClient().run();
  }

  public void run(){
       LabelGenerator figureNumbers = new LabelGenerator("Figure ", 1);
       LabelGenerator pointNumbers = new LabelGenerator("P", 0);
       System.out.print("Figure numbers: ");
       for (int i = 0; i < 3; i++){
       	   if (i > 0) System.out.print(", ");
	   System.out.print(figureNumbers.nextLabel());
       }
       System.out.println();
       System.out.print("Point numbers: ");
        for (int i = 0; i < 5; i++){
       	   if (i > 0) System.out.print(", ");
	   System.out.print(pointNumbers.nextLabel());
       }
       System.out.println();
       System.out.print("More figures: ");
       for (int i = 0; i < 3; i++){
       	   if (i > 0) System.out.print(", ");
	   System.out.print(figureNumbers.nextLabel());
       }
       System.out.println();
     }
}

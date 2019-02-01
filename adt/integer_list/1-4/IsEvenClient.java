public class IsEvenClient{
  public static void main(String[] args) {
    new IsEvenClient().run();
  }

  public void run(){
    System.out.println(filter(new IsEven(), new IntegerList(1,2,3,4,5)));
  }

  private IntegerList filter(PredicateFunction f, IntegerList l){
    IntegerList ans = new IntegerList();
    for(int i : l)
      if (f.evaluate(i)) ans.add(i);
    return ans;
  }
}

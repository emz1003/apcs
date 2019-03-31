import java.util.ArrayList;
public class Polymorphism{
  public static void main(String[] args) {
    HourlyEmployee h = new HourlyEmployee("Harold", 15, 8);
    SalaryEmployee s = new SalaryEmployee("Selena", 800000);
    CommissionedEmployee c = new CommissionedEmployee("Caroline", 1000, .15, 20000);
    ArrayList<Employee> list = new ArrayList<Employee>();
    list.add(h);
    list.add(s);
    list.add(c);

    System.out.println(list);
    for(Employee x: list){
      if(x instanceof Payable){
        Payable y = (Payable) x;
        y.pay();
        System.out.println(y);
      }
    }
  }
}

public class Client{
  public static void main(String[] args) {
    HourlyEmployee e = new HourlyEmployee("h");
    System.out.println(e);
    e.setHourlyRate(1.1);
    e.setHoursWorked(2);
    System.out.println(e);
    SalaryEmployee s = new SalaryEmployee("s");
    System.out.println(s);
    s.setSalary(15);
    System.out.println(s);
    CommissionedEmployee c = new CommissionedEmployee("c");
    c.setSalary(15);
    c.setRate(2);
    c.setSales(5);
    System.out.println(c);
  }
}

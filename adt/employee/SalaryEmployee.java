public class SalaryEmployee extends Employee implements Payable{
  private double salary;

  public SalaryEmployee(String name, double salary){
    super(name);
    this.salary = salary;
  }

  public void setSalary(double salary){
    this.salary = salary;
  }

  public double pay(){
    return salary / 104;
  }

  @Override
  public double getPay(){
    return salary;
  }

  @Override
  public String toString(){
    return getName()  +  "\nPay: " + getPay();
  }
}

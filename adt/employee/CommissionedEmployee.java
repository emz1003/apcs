public class CommissionedEmployee extends Employee implements Payable{
  public double baseSalary;
  public double commissionRate;
  public double salesVolume;

  public CommissionedEmployee(String name, double base, double rate, double sales){
    super(name);
    baseSalary = base;
    commissionRate = rate;
    salesVolume = sales;
  }

  public void setSalary(double salary){
    baseSalary = salary;
  }

  public void setRate(double rate){
    commissionRate = rate;
  }

  public void setSales(double sales){
    salesVolume = sales;
  }

  public double pay(){
    double pay = getPay();
    salesVolume = 0;
    return pay;
  }

  @Override
  public double getPay(){
    return baseSalary + commissionRate * salesVolume;
  }

  @Override
  public String toString(){
    return getName()  +  "\nBase: " + baseSalary + "\nRate: " + commissionRate + "\nSales: " + salesVolume + "\nPay: " + getPay();
  }
}

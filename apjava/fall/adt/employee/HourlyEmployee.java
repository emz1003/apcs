public class HourlyEmployee extends Employee implements Payable{
  private double hourlyRate;
  private double hoursWorked;

  public HourlyEmployee(String name, double rate, double hours){
    super(name);
    hourlyRate = rate;
    hoursWorked = hours;
  }

  public void setHourlyRate(double rate){
    hourlyRate = rate;
  }

  public void setHoursWorked(double hours){
    hoursWorked = hours;
  }

  public double pay(){
    double pay = getPay();
    hoursWorked = 0;
    return pay;
  }

  @Override
  public double getPay(){
    return hourlyRate * hoursWorked;
  }

  @Override
  public String toString(){
    return getName()  + "\nRate: " + hourlyRate + "\nHours: " + hoursWorked + "\nPay: " + getPay();
  }
}

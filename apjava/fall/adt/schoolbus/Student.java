public class Student implements Person{
  private String name;
  private String street;
  private int number;

  public Student(String name, String street, int number){
    this.name = name;
    this.street = street;
    this.number = number;
  }

  @Override
  public String getName(){
    return name;
  }

  @Override
  public String getStreet(){
    return street;
  }

  @Override
  public int getNumber(){
    return number;
  }

  @Override
  public String toString(){
    return name + " lives at " + number + " " + street + " street.";
  }

  public int distance(Student other){
    if(street.equals(other.street))
    return Math.abs(number - other.number);
    return 99999;
  }
}

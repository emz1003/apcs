import java.util.List;
import java.util.ArrayList;
public class SchoolBus extends ArrayList<Student>{
  private int seats;

  public SchoolBus(int seats){
    this.seats = seats;
  }

  public boolean isFull(){
    return seats == 0;
  }

  @Override
  public boolean add(Student s){
    if(isFull())
      return false;
    super.add(s);
    seats--;
    return true;
  }

  @Override
  public void add(int x, Student s){
    if(!isFull()){
      super.add(x, s);
      seats--;
    }
  }

  @Override
  public Student remove(int x){
    seats++;
    return super.remove(x);
  }
}

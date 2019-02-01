import java.util.ArrayList;
import java.util.List;

public class SchoolTransport{
  private List <SchoolBus> buses;

  public SchoolTransport(){
    buses = new ArrayList<SchoolBus>();
  }

  public void add(SchoolBus sb){
    buses.add(sb);
  }

  public boolean enroll(Student student){
    int index = -1;
    int dist = 99999;
    for(SchoolBus sb : buses){
      if(!sb.isFull())
        for(Student st : sb){
          if (st.distance(student) < dist){
            index = buses.indexOf(sb);
            dist = st.distance(student);
          }
        }
    }
    if(index > -1)
      return buses.get(index).add(student);
    return false;
  }
}

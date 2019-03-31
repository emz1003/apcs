public class Client{
  public static void main(String[] args) {
    SchoolBus sb = new SchoolBus(3);
    sb.add(new Student("a", "lex", 2));
    sb.add(new Student("b", "lex", 4));
    sb.add(new Student("c", "spr", 6));
    sb.add(new Student("d", "spr", 8));
    System.out.println(sb);
    System.out.println(sb.remove(1));
    System.out.println(sb);
    sb.add(1, new Student("e", "mer", 1));
    System.out.println(sb);

    SchoolTransport st = new SchoolTransport();
    st.add(sb);

    SchoolBus sb1 = new SchoolBus(1);
    SchoolBus sb2 = new SchoolBus(2);
    SchoolBus sb3 = new SchoolBus(3);

    sb1.add(new Student("e", "lex", 1000));
    sb2.add(new Student("f", "bwy", 50));
    sb2.add(new Student("g", "spr", 38));
    sb3.add(new Student("h", "bwy", 13500));
    sb3.add(new Student("i", "spr", 134));
    sb3.add(new Student("j", "mer", 100));

    st.add(sb1);
    st.add(sb2);
    st.add(sb3);

    st.enroll(new Student("z", "spr", 39));
    

    //[a lives at 2 lex street., e lives at 1 mer street., c lives at 100 spr street.]
  }
}

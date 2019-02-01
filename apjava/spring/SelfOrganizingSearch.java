public class SelfOrganizingSearch{

    // O(n)
    public static void print(int [] data){
        for (int x: data)
            System.out.print(x + " ");
        System.out.println();
    }

    public static int sequentialSearch(int [] data, int x){
      for(int i = 0; i < data.length; i++){
        if(data[i] == x)
          return i;
      }
      return -1;
    }
    /***************************************
      2N + 1 comparisons, N + 1 assignments
      F(N = a(2N + 1) + b(N + 1)
    ****************************************/

    //precondition: data != null
    //postcondition: returns true if x is found in data
    //               and moves x to the front of the sequence while
    //               all elements to the left of x are shifted
    //               to the right by 1; otherwise return false.
    public static boolean selfOrganizingSearch(int [] data, int x){
      int index = sequentialSearch(data, x);
      if(index != -1){
        int initial = data[0];
        data[0] = data[index];
        int saved;
        for(int i = 1; i <= index; i++){
          saved = data[i];
          data[i] = initial;
          initial = saved;
        }
        return true;
      }
      return false;
    }


    public static void main(String [] args){
        int[] data = {1,2,3,4,5};
        print(data);   // 1 2 3 4 5
        selfOrganizingSearch(data,5);
        print(data);   // 5 1 2 3 4
        selfOrganizingSearch(data,2);
        print(data);   // 2 5 1 3 4
        selfOrganizingSearch(data,0);
        print(data);   // 2 5 1 3 4
    }

}

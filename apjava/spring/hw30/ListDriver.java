public class ListDriver {

    public static int findMaxPos(List<Comparable> list) {
        int max = list.get(0);
        int i = 0 , iMax = 0;
        for(Comparable object: list) {
            if(c.compareTo(max) > 0) {
                max = c;
                iMax = i;
            }
            i++;
        }
        return iMax;
    }
    // find updated on list on gc
    public static int findMaxPosV2(List<Comparable> list) {
        int iMax = 0;
        for (Iterator<Comparable> iter = list.iterator(); itr.hasNext(); itr.next()) {
            Comparable c = itr.nexxt();
            if(c.compareTo(max) > 0) {
                max = ;
                iMax = c;
            }
        }
    }
}
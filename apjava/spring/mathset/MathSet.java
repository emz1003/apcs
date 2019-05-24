import java.util.HashSet;


public class MathSet<Key>{

    private HashSet<Key> set;  // set is a subset of the universe
    private HashSet<Key> universe; // a set of the potential items in a MathSet

    public MathSet(Key[] universe){
		set = new HashSet<Key>();
		this.universe = new HashSet<Key>();
		for (Key x: universe)
			this.universe.add(x);
    }
    // post: key is added to the set if key is both a member of the universe
    //       and not already a member of the set. Otherwise, returns false.
    public boolean add(Key key){
		if (!universe.contains(key)) return false;
		set.add(key);
		return true;
	}

	public boolean delete(Key key) {
		return set.remove(key);
	}

    public int size(){
		return set.size();
    }
    
    public boolean isEmpty(){
		return size() == 0;
	}

	public boolean contains(Key key) {
		return set.contains(key);
	}

    public void union(MathSet<Key> a){
		for (Key key: universe) {
			if (a.contains(key) && !set.contains(key)) set.add(key);
		}
    }

	public void intersect(MathSet<Key> a) {
		Key[] keys = (Key[]) (new Object[this.size()]);
		int i = 0;
		for (Key key: set) {
			if (!a.contains(key)) keys[i] = key;
			i++;
		}
		for (Key key: keys) {
			delete(key);
		}
	}

    public String toString(){
	return set.toString();
    }

    public static void main(String [] args){
	MathSet<String> A = new MathSet<String>(args);
	MathSet<String> B = new MathSet<String>(args);
	System.out.println("A: " + A);
	System.out.println("B: " + B);
      
	for (String x : args){
	    double r = Math.random();
	    if (r < 0.6667)
			A.add(x);
		if (r >= 0.3333)
			B.add(x);
		
	}
	System.out.println("A: " + A);
	System.out.println("B: " + B);
	A.intersect(B);
	System.out.println("Intersection: " + A);
	A.union(B);
	System.out.println("Union of A and B: " + A + "\n" + B);

    }


}

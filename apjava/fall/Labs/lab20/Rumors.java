//Thomas Creighton & Emily Zhang
public class Rumors{
    public static void main(String [] args){
	int n = Integer.parseInt(args[0]);
	new Rumors().run(n);
    }
    private void run(int n){
	double num = 0.0;
	int total = 0;
	for(int trial = 0; trial < 100000; trial++){
	    boolean[] guest = new boolean[n];
	    while (true){
		num++;
		guest[0] = true;
		shuffle(guest);
		if (guest[0]) break;
	    }
	    boolean all = true;
	    for (int i = 0; i < n; i++){
		if (!(guest[i])){
		    all = false;
		    break;
		}
	    }
	    if (all) total++;
	}
	num /= 100000;
	total /= 1000;
	System.out.println("It reaches all guests " + total + "% of the time");
	System.out.println("It reaches an average of " + num + " guests");
    }
    private void shuffle(boolean [] data){
	for (int i = 1; i < data.length; i++){
	    int rPos = i + (int)(Math.random() * (data.length - i));
	    boolean temp = data[i];
	    data[i] = data[rPos];
	    data[rPos] = temp;
	}
	int rPos = 1 + (int)(Math.random() * (data.length - 1));
	data[0] = data[rPos];
	data[rPos] = true;
    }

}

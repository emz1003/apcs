public class Deal{
	public static void main(String[] args){
		new Deal().run(Integer.parseInt(args[0]));
	}
	
	public void run(int n){
		final String[] SUIT = {"Clubs","Hearts","Diamonds","Spades"};
		final String[] RANKS = {"2","3","4","5","6","7","8","9","10","JACK","QUEEN","KING","ACE"};
		for(int i = 0; i < n; i++){
			int randIndexSuit = (int) (Math.random() * SUIT.length);
			int randIndexRank = (int) (Math.random() * RANKS.length);
			System.out.println(SUIT[randIndexSuit] + " " + RANKS[randIndexRank]);
		}
	}
}

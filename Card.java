package blackjack;

public class Card {
	
	enum Suite {
		CLUBS,
		SPADES,
		HEARTS,
		DIAMONDS
	}
	
	enum Rank {
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		TEN,
		JACK,
		QUEEN,
		KING,
		ACE
	}
	
	private Rank rank;
	private Suite suite;
	
	public Card(Card.Rank r, Card.Suite s) {
		rank = r;
		suite = s;
	}
	
	public Card.Suite getSuite() {
		return this.suite;
	}
	
	public Card.Rank getRank() {
		return this.rank;
	}
	
	public String toString() {
		return (rank + " OF " + suite);
	}
	
	public static void main(String[] args) {
		Card thing = new Card(Card.Rank.ACE,Card.Suite.SPADES);
		System.out.println(thing.toString());
	}


}

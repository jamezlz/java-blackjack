package blackjack;
import java.util.*;

public class Deck {

	private ArrayList<Card> deck;
	private int size;
	
	public Deck() {
		deck = new ArrayList<Card>();
		size = 52;
		for (Card.Suite s : Card.Suite.values()) {
			for (Card.Rank r : Card.Rank.values()) {
				deck.add(new Card(r,s));
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public int getSize() {
		return size;
	}
	
	public Card draw() {
		Card card = deck.get(0);
		deck.remove(0);
		size--;
		return card;
	}

	public static void main(String[] args) {
		Deck thing = new Deck();
		thing.shuffle();
		for (int i = 0; i< 52; i++) {
			System.out.println(thing.draw().toString());
		}
	}

}

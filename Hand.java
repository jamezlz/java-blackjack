package blackjack;

import java.util.ArrayList;
import java.util.*;

public class Hand {
	
	private int size;
	private int aces11;
	private int value;
	private ArrayList<Card> cards;
	Map<Card.Rank, Integer> values = new EnumMap<Card.Rank, Integer>(Card.Rank.class);

	public Hand() {
		cards = new ArrayList<Card>();
		size = 0;
		aces11 = 0;
		value = 0;
		values.put(Card.Rank.TWO, 2);
		values.put(Card.Rank.THREE, 3);
		values.put(Card.Rank.FOUR, 4);
		values.put(Card.Rank.FIVE, 5);
		values.put(Card.Rank.SIX, 6);
		values.put(Card.Rank.SEVEN, 7);
		values.put(Card.Rank.EIGHT, 8);
		values.put(Card.Rank.NINE, 9);
		values.put(Card.Rank.TEN, 10);
		values.put(Card.Rank.JACK, 10);
		values.put(Card.Rank.QUEEN, 10);
		values.put(Card.Rank.KING, 10);
		values.put(Card.Rank.ACE, 11);
	}
	
	public void clear() {
		cards.clear();
		size = 0;
		aces11 = 0;
		value = 0;
	}
	
	public void add(Card c) {
		cards.add(c);
		if (c.getRank() == Card.Rank.ACE)
			aces11++;
		size++;
		value += values.get(c.getRank());
		while(value > 21 && aces11 > 0) {
			aces11--;
			value -= 10;
		}
	}
	
	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.println(cards.get(i).toString());
		}
	}
	
	public void print1() {
		System.out.println(cards.get(0).toString());
	}
	
	public int getValue() {
		return value;
	}

	public static void main(String[] args) {
		Hand myHand = new Hand();
		myHand.add(new Card(Card.Rank.ACE,Card.Suite.SPADES));
		myHand.add(new Card(Card.Rank.ACE,Card.Suite.SPADES));
		myHand.add(new Card(Card.Rank.TEN,Card.Suite.SPADES));
		myHand.print();
		System.out.println(myHand.getValue());
	}

}

package blackjack;
import java.util.*;

public class Game {
	
	public static Hand playerHand, dealerHand;
	public static Deck deck;
	
	
	public static void drawLine() {
		System.out.println("-------------------------------------------------------");
	}
	
	public static void printHands() {
		System.out.println("The Dealer Has Upcard:");
		dealerHand.print1();
		System.out.println("");
		System.out.println("You have:");
		playerHand.print();
	}
	
	public static void printHands2() {
		System.out.println("The Dealer Had:");
		dealerHand.print();
		System.out.println("");
		System.out.println("You had:");
		playerHand.print();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		playerHand = new Hand();
		dealerHand = new Hand();
		while(true) {
			boolean gameover = false;
			String input;
			deck = new Deck();
			deck.shuffle();
			playerHand.clear();
			dealerHand.clear();
			dealerHand.add(deck.draw());
			playerHand.add(deck.draw());
			dealerHand.add(deck.draw());
			playerHand.add(deck.draw());
			drawLine();
			printHands();
			//check blackjack
			if (playerHand.getValue() == 21) {
				System.out.println("BLACKJACK: you win!");
				gameover = true;
			}
			//otherwise do player turn
			while(!gameover) {
				System.out.println("Would you like to hit or stay?");
				input = in.nextLine();
				if (input.equals("stay")) {
					break;
				} else if (input.equals("hit")) {
					playerHand.add(deck.draw());
					drawLine();
					printHands();
					if (playerHand.getValue() > 21) {
						System.out.println("BUSTED: you lose");
						gameover = true;
					}
				} else {
					System.out.println("Invalid Input");
				}
			}
			//dealer turn
			while(!gameover && dealerHand.getValue() < 17) {
				dealerHand.add(deck.draw());
			}
			if(!gameover) {
				drawLine();
				printHands2();
				System.out.println("");
				if (dealerHand.getValue() > 21) {
					System.out.println("Dealer Busted: You Win!");
				} else if (dealerHand.getValue() > playerHand.getValue()) {
					System.out.println("Dealer Wins");
				} else if (dealerHand.getValue() < playerHand.getValue()) {
					System.out.println("You Win!");
				} else {
					System.out.println("Its a tie");
				}
			}
			//play again?
			System.out.println("Type quit to quit or anything else to play again");
			input = in.nextLine();
			if (input.equals("quit")) {
				break;
			}
		}
	}

}

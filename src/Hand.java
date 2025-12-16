import java.util.ArrayList;

//notes to myself for organizaiton.
public class Hand {
	private ArrayList<Card> hand; // more flexible than regular.
	// private ArrayList<Integer> values;

	public Hand() {
		hand = new ArrayList<>();
	}

	public int value() { // adds the two cards together and gets the value.
		int value = 0;
		for (Card c : hand) {
			if (c.isFaceUp()) {
				value += c.calculateValue();
			}
		}
		return value;
	}

	public int highValue() { // check if there's an Ace. If so, return 10, if not, return value.
		for (Card c : hand) {
			if (c.getValue() == 1) {
				return value() + 10;

			}
		}
		return value();
	}
	
	public int bestValue() { //whichever ace value goes in favor of the player.
		
		if (value() > 21)
			return -1;
		if(highValue() < 21) {
			return highValue();
		} else {
			return value();
		}
		//if it's a bust value, return -1 so everything wins against it
	}

	public ArrayList<Card> getCards() { 
		return hand;
	}

	public void hit(Card c) { // the hit function. Adds card to hand.
		hand.add(c);
	}

	public String toString() { // prints out the player's hand.
		String s = "";
		for (Card c : hand) {
			s += c + " ";
		}
		return s;
	}

	public int compare(Hand other) {
		// return 1 if this wins against other
		// 0 if tie
		// -1 if other wins
		if (this.bestValue() > other.bestValue()) {
			return 1;
		} 
		else if(this.bestValue() < other.bestValue()) {
			return -1;
		} else {
			return 0;
		}
	}

	public String withValue() { //return both options if ace is presented.
		if (this.highValue() == this.value()) {
			return this.toString() + " " + this.value();
		} else {
			return this.toString() + " " + this.value() + " | " + this.highValue();
	}
	}
}

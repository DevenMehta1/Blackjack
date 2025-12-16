import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> cards;
	
	public Deck() { //Constructor
		cards = new ArrayList<Card>();
		for(Card.Suit s: Card.Suit.values()) {
			for(int i = 1; i <= 13; i++) {
				cards.add(new Card(s, i));
				//adds a new card to the cards. Basically making deck.
			}
		}
	}
	
	public String toString() { //prints out the cards.
		String s = "";
		for(Card c: cards) {
			s += c + "\n";
		}
		return s;
	}
	
	public void shuffle() {
		for(int i = 0; i < 1e4; i++) {
		int randomPosition = (int)(Math.random()*52); //random index in the deck.
		Card top = cards.remove(0);
		cards.add(randomPosition, top); //puts card at top to the random index
		}
	}
	
	public Card deal() {
		return cards.remove(0); //takes off top card (index 0) and "places on table"
	}
	
	
	public static void main(String[] Args) { //tester for the different methods.
		Deck test = new Deck();
		test.shuffle();
		System.out.println(test);
		
		Hand h = new Hand();
		h.hit(test.deal());
		h.hit(test.deal());
		System.out.print("Hand \n" + h + h.value());
		
	}
	
	
}

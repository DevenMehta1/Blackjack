
public class Card {
	public static enum Suit{SPADES, HEARTS, DIAMONDS, CLUBS}
	public static final String RED = "\u001b[91m";
	public static final String RESET = "\u001b[0m";
	private int value;
	private Suit suit;
	private boolean faceUp;
	
	public Card(Suit suit, int value) {
		this.suit = suit;
		this.value = value;
		this.faceUp = true;
	}
	
	public void flip() {
		if (this.faceUp) {
			faceUp = false;
		}
		else {
			faceUp = true;
		}
	}
	
	int calculateValue() { //this is a rough, testing plan. REDO
		switch(this.value) {
			case 11:
			case 12:
			case 13:
				return 10;
			default:
				return this.value;
		}
	}
	
	int getValue() {
		return value;
	}
	
	public String toString() {
		if(!faceUp) {
			return "[  ]";
		
		}
		
		String s = "[";
		switch(suit) {
			case SPADES:
				s +=  "♠";
				break;
			case HEARTS:
				s += RED + "♥";
				break;
			case DIAMONDS:
				s += RED + "♦";
				break;
			case CLUBS:
				s += "♣";
				break;
		}
		switch(value){
		case 13:
			s += "K";
			break;
		case 12:
			s += "Q";
			break;
		case 11:
			s += "J";
			break;
		case 1:
			s += "A";
			break;
		default:
			s += String.valueOf(this.value);
		}
		return s + RESET + "]" ;
	}
	public static void main(String[] Args) {
		Card test = new Card(Suit.SPADES, 3);
		System.out.println(test);
		test.flip();
		System.out.println(test);
		test.flip();
		System.out.println(test);
	}
	
	public boolean isFaceUp() {
		return faceUp;
	}

}

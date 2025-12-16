public class Player {
	int chips;
	String name;
	Hand hand;
	int bet;
	
	public Player(String name, int chips) {
		this.name = name;
		this.chips = chips;
	}
	
	public void initialDeal(Deck d) {
		hand = new Hand();
		hand.hit(d.deal());
		hand.hit(d.deal());
		
		if (this.name.equals("Dealer")) {
			hand.getCards().get(0).flip();
		}
		System.out.println(this);
		
		if(hand.bestValue() == 21 && ! this.name.equals("Dealer")) {
			System.out.println("Blackjack"); //????
		}
	}
	
	public void playHand(Deck d) {

		while (true) { // the player functionality for hitting or standing.
			System.out.println();
			
			System.out.println("Do you want to Hit or Stand? ");
			String response = TextIO.getlnString();

			if (response.equals("hit")) {
				hand.hit(d.deal());
				if (hand.value() > 21) {
					System.out.println(this);
					System.out.println("bust!");
					break;
				}
				if (hand.value() == 21 || hand.highValue() == 21) {
					System.out.println(this);
					System.out.println("Blackjack");
					break;
				}
				System.out.println(this);
				continue;
			} else {
				System.out.println("Dealer's turn.\n");
				break;

			}
		}

	}
	
	public void dealerHand(Deck d, Player other) {
		hand.getCards().get(0).flip();
		System.out.println("***********DEALERS TURN**************");
		pause();
		System.out.println(this);
		while (hand.bestValue() > 0 && hand.bestValue() <= 17 && hand.compare(other.hand) <= 0) {
			pause();
			System.out.print("\nDealer hits.\n");
			hand.hit(d.deal());
			System.out.println(this);
		} 
		pause();
		System.out.println("Dealer stands.");
	}
	
	public String toString() {
		return name + " : " +  hand.withValue();
	}
	
	public void pause() {
		try{
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
}

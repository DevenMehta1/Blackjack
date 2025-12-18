
public class Dealer extends Player{
	
	public Dealer() {
		this.name = "Dealer";
	}
	
	public void playHand(Deck d, Player other) {
		hand.getCards().get(0).flip();
		System.out.println("**************DEALERS TURN**************");
		pause();
		
		System.out.println(this);
		// hit if didn't bust AND less than 17 AND losing to player
		while (hand.bestValue() > 0 && hand.bestValue() <= 17 && hand.compare(other.hand) <= 0) {
			pause();
			System.out.print("\nDealer hits.\n");
			hand.hit(d.deal());
			System.out.println(this);
		}
		pause();
		System.out.println("Dealer stands.");
	}
	
	public void initialDeal(Deck d) {

		hand = new Hand();
		hand.hit(d.deal());
		hand.hit(d.deal());

		hand.getCards().get(0).flip();
		
		System.out.println(this);
	}
	
	public String toString() {
		return name + " : " + hand.withValue();
	}
	
	public void pause() { 
		try {				
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
}

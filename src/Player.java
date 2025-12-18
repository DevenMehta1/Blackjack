import java.util.ArrayList;

public class Player {

	int chips;
	String name;
	Hand hand;
	int bet;

	public Player() {};
	
	public Player(String name, int chips) {
		this.name = name;
		this.chips = chips;
	}
	
	public void getBet() {
		System.out.println("how much do you want to bet?");
		
		int bet;
		do {
			bet = TextIO.getInt();
			if(bet > chips) {
				System.out.println("You don't have enough $$. Try again.");
				continue;
			} else if (bet <= 0){
				System.out.println("You have to bet more than $0.");
				continue;
			}
			break;
		} while(true); 
			
		this.bet = bet;
		this.chips -= this.bet;
	}

	//JUST THE INTIAL PARTS OF THE ROUND.
	public void initialDeal(Deck d) {
		getBet();
		
		hand = new Hand();
		hand.hit(d.deal());
		hand.hit(d.deal());

		System.out.println(this);
		if (hand.bestValue() == 21) {
			System.out.println("Blackjack"); // ????
		}
	}
	
// THE PLAYER FUNCTIONALITY FOR HITTING OR STANDING
	public void playHand(Deck d) {

		while (true) { 
			System.out.println();

			System.out.println("Do you want to Hit or Stand? ");
			String response = TextIO.getlnString(); // for some reason there was already something in buffer??
			response = TextIO.getlnString();

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
					chips += 1.5 * bet;
					break;
				}
				System.out.println(this);
				continue;
			} else {
				break;
			}
			
		}
	}
	
	public Hand getHand() {
		return hand;
		
	}

	public int getBankroll() {
		return chips;
	}

	
	public String toString() {
		return name + " : " + hand.withValue() + " ||| bankroll: " + this.chips + "   bet:  " + this.bet;
	}


	

	
	

}

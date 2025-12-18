import java.util.ArrayList;

public class BlackjackGame {
	// rough draft of game functionality. Unorganized and will refactor later
	ArrayList<Player> hands;
	Player dealer;

	public BlackjackGame() {
		hands = new ArrayList<>();
	}

	public String toString() { // for later, if i want to, make it look nicer almost like a graphic maybe.
		String s = "\n\n\n\n\n\n\n\n\n\n";
		return s;
	}

	public static void main(String[] Args) {

		Deck d = new Deck();
		d.shuffle();
		Player player = new Player("Player", 300);
		Dealer dealer = new Dealer(); // dealers bankroll??

		while (true) {
			player.initialDeal(d);
			dealer.initialDeal(d);
			player.playHand(d);
			dealer.playHand(d, player);

			if (dealer.hand.compare(player.hand) > 0) {
				System.out.println("Dealer has won");
			} else if (player.hand.compare(dealer.hand) > 0) {
				System.out.println("You win!");
				player.chips += 2 * player.bet;
			} else {
				System.out.println("tied. bet returned");
				player.chips += player.bet;
			}
			// put the cards back into the deck.
			d.getCards().addAll(player.getHand().getCards());
			d.getCards().addAll(dealer.getHand().getCards());
			d.shuffle();
			System.out.println("your bankroll is currently: " + player.getBankroll());
		}
	}
}

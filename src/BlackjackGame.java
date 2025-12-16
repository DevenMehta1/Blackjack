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

	private static String printRules() {
		System.out.println("Welcome to blackjack! Do you need the rules?");
		String answers = TextIO.getlnString();
		if (answers.equals("yes")) {
			System.out.println("The rules go as follow: \nYou can hit (place another card)\n"
					+ "stand (move turns)\ndouble down (final card and double bet)\n"
					+ "or split (only when you get two of the same card pair)");
			System.out
					.println("Get as close as you can to 21. If you hit 21, that's a blackjack! Your bet is doubled \n"
							+ "If you lose to the dealer, you lose your bet :( \n"
							+ "If you go over 21, that's a bust. You lose your bet.\n"
							+ "Tie with the dealer and your bet is split in half.\nGood luck!");
			System.out.println();
			System.out.println();
		} else {
			System.out.println("Okay then, good luck!");
			System.out.println();
			System.out.println();
		}
		return "";
	}

	public static void main(String[] Args) {
		
		Deck d = new Deck();
		d.shuffle();
		Player player = new Player("Deven", 300);		
		Player dealer = new Player("Dealer", 100000); // dealers bankroll??
		
		player.initialDeal(d);
		dealer.initialDeal(d);
		player.playHand(d);
		dealer.dealerHand(d, player);

		
		if (dealer.hand.compare(player.hand) > 0) {
			System.out.println("Dealer has won");
		} else if (player.hand.compare(dealer.hand) > 0) {
			System.out.println("You win!");
		} else {
			System.out.println("tied. Half of your money is taken");
		}
		

	}
}

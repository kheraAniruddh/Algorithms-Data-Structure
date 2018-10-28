import java.util.*;

public class BlackJackGame {
	
	private List<Player> participants;
	private Deck deck;
	private List<Player> softWinners;
	private List<Player> toRemove;

	public BlackJackGame(List<Player> participants) {
		softWinners = new ArrayList<>();
		toRemove = new ArrayList<>();
		ArrayList<BlackJackCard> cards = new ArrayList<>(); 
		for(Card.Suit s: Card.Suit.values()) {
			for(int i=1;i<14;i++)
				cards.add(new BlackJackCard(s, i));
		}

		this.deck = new Deck(cards);
		this.participants =participants;

	}  

	public boolean isBusted(Player player) {
		return player.getPoints()>21;
	} 

	public boolean is21(Player player) {
		return player.getPoints() == 21;	
	}

	public boolean isBlackJack(Player player) {
		return player.hand.size()==2 && player.getPoints()==21;	
	}	
	
	public void play() {
		int i=1;
		System.out.println("round "+ i++);
		distribute(2);
		round();
		while(participants.size()>1) {
			System.out.println("\nround "+ i++);
			round();
			if(softWinners.size()>0) {
				for(Player p: softWinners) {
					System.out.println("Player "+ p.getName()+" gets 21 "+" Winner!!");
				}
				System.exit(1);
			}
			distribute(1);

		}

		System.out.println(participants.get(0).getName()+ " is the Winner!!");

	}

	public void round() {
		for(Player p: participants) {
			if(isBusted(p) && ! p.wantsToPlay()) {
				System.out.println("Player "+ p.getName()+ " quits \t Points: "+p.getPoints());
				toRemove.add(p);
			}
			else {
				if(isBlackJack(p)) {
					System.out.println("Player "+ p.getName()+" gets BlackJack x"+" Winner!!");
					System.exit(1);
				}
				else {
					if(is21(p))
						softWinners.add(p);
				}

			}

		}
		for(Player p: toRemove)
			participants.remove(p);
		toRemove= new ArrayList<>();
	}

	public void distribute(int no) {
		// distribute two cards to each player
		// Making the rules a little simple
		for(int i=0;i<no;i++) {
			for(Player parti: participants) {
				try {
					BlackJackCard card = (BlackJackCard) deck.dealCard();
					System.out.println(parti.getName()+" "+ parti.getPoints()+" "+parti.hand.size());
					parti.addCard(card);
				}
				catch(RuntimeException e) {

				}

			}
		}
	}

	public static void main(String[] args) {
		
		List<Player> participants = new ArrayList<>();
		participants.add(new Dealer("Dealer"));
		participants.add(new BlackJackPlayer("P1"));	
		participants.add(new BlackJackPlayer("P2"));	
		participants.add(new BlackJackPlayer("P3"));	

		BlackJackGame game = new BlackJackGame(participants);
		game.play();

	}
}

import java.util.*;

public class Deck <T extends Card> {
	private List<T> deck;

	public Deck(ArrayList<T> deck) {
		createDeck(deck);
		shuffle();
	}  

	public void createDeck(ArrayList<T> deck) {
		this.deck = deck;
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public T dealCard() {
		if(deck.size()==0) 
			throw new RuntimeException("No more cards, initialize a new deck");
		else  {
			T card = deck.remove(deck.size()-1);
			return card;
		}
	}

}
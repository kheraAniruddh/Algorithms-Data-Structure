import java.util.*;

public abstract class Player<T extends Card> {
	private  String name;
	protected List<T> hand;


	public Player(String name) {
		this.name = name;
		hand = new ArrayList<>();
	}

	public abstract boolean canPlay();
	
	public abstract boolean wantsToPlay();

	public void addCard(T card) {
		hand.add(card);
	} 

	public String getName() {
		return name;
	}
	public abstract int getPoints();
}
public abstract class Card {
	public enum Suit {
		HEART, SPADE,CLUB, DIAMOND;
	}
	protected int value;
	protected Suit suit;  
	private boolean available;
	public Card(Suit s, int v) {
		suit =s;
		value =v;
	}

	public abstract int value();

	public boolean isAvailable() {return available;}

	public void markUnavailable() {
		available =false;
	}
	
}
public class BlackJackCard extends Card {
	public BlackJackCard(Card.Suit s, int val) { super(s,val); }

	public boolean isAce() {
		return super.value==1;
	}

	public boolean isFaceCard() {
		return super.value>10;
	}

	public int value() {
		if(isAce()) return 1;
		// if Face-card, assign value as 10
		else if(isFaceCard()) return 10;
		else return super.value;
	}

	public int getMin() {
		if(isAce()) return 1;
		else return value();
	}

	public int getMax() {
		if(isAce()) return 11;
		else return value();
	}

}
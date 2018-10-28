import java.util.*;

public class Dealer extends Player {

	public Dealer(String name) {
		super(name);
	}

	public boolean canPlay() {
		return getPoints() < 21;
	}

	public int getPoints() {
		int minPoint =0, maxPoint=0;
		for(BlackJackCard card: (List<BlackJackCard>) hand) {
			minPoint+=card.getMin();
			maxPoint+=card.getMax();
		}
		return maxPoint>21 ? minPoint : maxPoint;
	}
	public boolean wantsToPlay() {
		return true;
	}
}
import java.util.*;

public class BlackJackPlayer<T extends Card> extends Player {

	public BlackJackPlayer(String name) {
		super(name);
	}

	public boolean canPlay() {
		return this.getPoints() < 21;
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
		return this.getPoints() < 17;
	}

}
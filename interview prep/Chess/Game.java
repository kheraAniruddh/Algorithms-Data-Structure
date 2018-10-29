public class Game {

	private Board board;
	private boolean checkMate = false;
	private boolean whiteTurn =true;

	public void initializeGame() {

		Board board = new Board(8,8);
		this.board = board; 

		// Set White pawns
		for(int i=0;i<8;i++) {
			Piece piece = new Pawn(i,1,Piece.Color.WHITE);
			board.setPosition(i, 1, piece);
		}

		// Set Black pawns
		for(int i=0;i<8;i++) {
			Piece piece = new Pawn(i,6,Piece.Color.BLACK);
			board.setPosition(i, 6, piece);
		}

	}

	public Piece.Color whoseTurn(boolean turn) {
		if(turn) return Piece.Color.WHITE;
		return Piece.Color.BLACK;
	}

	public void makeMove(int x, int y, int newX, int newY) {
		Piece p = board.getPosition(x, y).getPiece();
		if(p!=null && p.color==whoseTurn(whiteTurn)) {
			if(p.movement(board, newX, newY)) {
				System.out.println("Moved "+p.color);
				whiteTurn = !whiteTurn;
			}
			else
				System.out.println("Not valid!!");
		}
		else 
			System.out.println("Not allowed!!");
	}
	public void play() {
		initializeGame();
		System.out.println("********Initial setup********");
		this.board.displayPositions();
		int i=0;
		while(!checkMate && i<=3) {
			makeMove(i,1,i,3);
			whiteTurn = !whiteTurn;
			i++;
		}

		board.displayPositions();
	}



	public static void main(String[] args) {
		Game game = new Game();
		game.play();
	}
}
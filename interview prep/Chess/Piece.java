public abstract class Piece {
	
	public enum Type {
		PAWN, BISHOP, QUEEN, KING, ROOK, KNIGHT;
	}

	public enum Color {
		WHITE, BLACK;
	}

	private int xCord;
	private int yCord;
	public Type type; 
	public Color color;
	private boolean inGame =true;

	public Piece(int init_x, int init_y, Type type, Color color) {
		xCord = init_x;
		yCord = init_y;
		this.type = type;
		this.color = color;
	}

	public abstract boolean movement(Board board, int x, int y);

	public abstract boolean validMove(Board board, int x, int y);


	public void markEliminated() {
		inGame =  false;
	}

	public int currentX() {
		return xCord;
	}

	public int currentY() {
		return yCord;
	}

	public Type getType() {
		return this.type;
	}

	public Color getColor() {
		return this.color;
	}

	public void setX(int x) {xCord = x;}

	public void setY(int y) {yCord = y;}
} 
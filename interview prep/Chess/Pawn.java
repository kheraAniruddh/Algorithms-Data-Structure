public class Pawn extends Piece {

	private int init_x;
	private int init_y;
	public Pawn(int init_x, int init_y, Color color) {
		super(init_x, init_y, Type.PAWN, color);
		this.init_x =init_x;
		this.init_y=init_y;
		
	}

	public boolean movement(Board board, int x, int y) {
		if(validMove(board, x, y)) {
			super.setX(x);
			super.setY(y);
			return true;
		}
		else 
			return false;
	}

	public boolean validMove(Board board, int x, int y) {
			boolean temp =	board.onBoard(x, y);
			Position pos = board.getPosition(x,y);
			if((Math.abs(this.currentX()-x)==1) && (y-this.currentY()==1) && (pos.occupyPosition(this)) && temp) {
				board.getPosition(this.currentX(), this.currentY()).releasePosition();
				return true;
			}
			if((this.currentX()-x==0) && (y-this.currentY()==1)) {
				board.getPosition(this.currentX(), this.currentY()).releasePosition();
				return true;
			}

			if((this.currentX()==init_x) &&(this.currentY()==init_y) && (y-this.currentY()==2)){
				board.getPosition(this.currentX(), this.currentY()).releasePosition();
				return true;
			}
			return false;
	}



}
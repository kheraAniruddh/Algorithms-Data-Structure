public class Position <T extends Piece> {
	
	private int x;
	private int y;
	private T piece;

	public Position(int x, int y) {
		this.x =x;
		this.y =y;
		piece =null;
	}

	public Piece getPiece() {
		return this.piece;
	}

	public void setPiece(T newpiece) {
		this.piece = newpiece;
	}

	public boolean occupyPosition(T newpiece) {
		if(this.piece!=null) {
			if(this.piece.color!=newpiece.color) {
				this.piece.markEliminated();
				this.piece = newpiece;
			}
			else 
				return false;
		}
		else
			this.piece = newpiece;
		return true;
	}

	public boolean requestPosition(T newpiece) {
		if(this.piece==null) {
			this.piece = newpiece;
			return true;
		}
		return false;
	}

	public void releasePosition() {
		this.piece = null;
	}

}
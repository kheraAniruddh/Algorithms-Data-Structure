public class Board {
	

	private Position[][] positions;

	public Board(int r, int c) {
		positions = new	Position[r][c]; 
		for(int i =0;i<r;i++){
			for(int j=0;j<c;j++)
				positions[i][j] = new Position(i, j);
		}
	}

	public void setPosition(int x, int y, Piece newpiece) {
		positions[x][y].setPiece(newpiece); 
	} 

	public Position getPosition(int x, int y) {
		return positions[x][y]; 
	} 

	public boolean onBoard(int x, int y) {
		return (x>=0 && x<positions[0].length && y>=0 && y<positions.length);

	}

	public void displayPositions() {
		for(int i=0;i<positions.length;i++) {
			for(int j=0;j<positions[0].length;j++) {
					if(positions[i][j].getPiece()!=null)
						System.out.println(positions[i][j].getPiece().color+ " "+positions[i][j].getPiece().type+ " at: "+i+" "+j);
			}
		}
	}

	


}
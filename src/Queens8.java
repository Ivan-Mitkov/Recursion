import java.util.HashSet;

public class Queens8 {
	final static int SIZE=8;
	static boolean [][]chessboard = new boolean[SIZE][SIZE];
	static int solutionFound=0;
	static HashSet<Integer> attackedRows= new HashSet<>();
	static HashSet<Integer> attackedCols= new HashSet<>();
	static HashSet<Integer> attackedLeftDiag= new HashSet<>();
	static HashSet<Integer> attackedRightDiag= new HashSet<>();
	static void putQueens(int row){
		if(row==SIZE){
			printSolution();
		}
		else{
			for(int col = 0; col<SIZE; col++){
				if(canPlaceQueen(row,col)){
					markAllAtackedPositions(row,col);
					putQueens(row+1);
					unmarkAllAtackedPostion(row,col);
				}
			}
		}
	}
	
	
	private static void unmarkAllAtackedPostion(int row, int col) {
		attackedRows.remove(row);
		attackedCols.remove(col);
		attackedLeftDiag.remove(col-row);
		attackedRightDiag.remove(row+col);
		chessboard[row][col]=false;
		
		
	}


	private static void markAllAtackedPositions(int row, int col) {
		attackedRows.add(row);
		attackedCols.add(col);
		attackedLeftDiag.add(col-row);
		attackedRightDiag.add(row+col);
		chessboard[row][col]=true;
		
	}


	private static boolean canPlaceQueen(int row, int col) {
		boolean postionOccupied=
				attackedRows.contains(row)||
				attackedCols.contains(col)||
				attackedLeftDiag.contains(col-row)||
				attackedRightDiag.contains(row+col);
		return !postionOccupied;
	}


	private static void printSolution() {
		for(int row=0; row<SIZE; row++){
			for(int col=0; col<SIZE; col++){
				if(chessboard[row][col]==true)
					System.out.print("* ");
				else
					System.out.print("- ");
			}
			System.out.println();
		}
		System.out.println();
		solutionFound++;
	}


	public static void main(String[] args) {
		putQueens(0);
		//System.out.println(solutionFound);

	}

}

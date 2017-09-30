
public class Nqueens {
	private static final int SIZE = 8;
	
	private static void printSolution(boolean [][] board){
		
		for(int i =0; i<SIZE; i++){
			for(int j=0; j<SIZE; j++){
				if(board[i][j]==true)
				System.out.print('*');
				else{
					System.out.print('-');
				}
			}
			System.out.println();
		}
	}
	boolean isSafe(boolean board[][], int row, int col){
		int i,j;
		 /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == true)
                return false;
 
        /* Check upper diagonal on left side */
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == true)
                return false;
 
        /* Check lower diagonal on left side */
        for (i=row, j=col; j>=0 && i<SIZE; i++, j--)
            if (board[i][j] == true)
                return false;
 
        return true;
	}
	/* A recursive utility function to solve N
    Queen problem */
	 boolean solveNQUtil(boolean board[][], int col)
	 {
	     /* base case: If all queens are placed
	        then return true */
	     if (col >= SIZE)
	         return true;
	
	     /* Consider this column and try placing
	        this queen in all rows one by one */
	     for (int i = 0; i < SIZE; i++)
	     {
	         /* Check if queen can be placed on
	            board[i][col] */
	         if (isSafe(board, i, col))
	         {
	             /* Place this queen in board[i][col] */
	             board[i][col] = true;
	
	             /* recur to place rest of the queens */
	             if (solveNQUtil(board, col + 1) == true)
	                 return true;
	
	             /* If placing queen in board[i][col]
	                doesn't lead to a solution then
	                remove queen from board[i][col] */
	             board[i][col] = false; // BACKTRACK
	         }
	     }
	
	     /* If queen can not be place in any row in
	        this colum col, then return false */
	     return false;
	 }
	
	 /* This function solves the N Queen problem using
	    Backtracking.  It mainly uses  solveNQUtil() to
	    solve the problem. It returns false if queens
	    cannot be placed, otherwise return true and
	    prints placement of queens in the form of 1s.
	    Please note that there may be more than one
	    solutions, this function prints one of the
	    feasible solutions.*/
	 boolean solveNQ()
	 {
		
	    	 boolean [][] chessboard = new boolean[SIZE][SIZE];
		     if (solveNQUtil(chessboard, 0) == false)
		     {
		         System.out.print("Solution does not exist");
		         return false;
		     }
		    
		     printSolution(chessboard);
	     return true;
	 }

	public static void main(String[] args) {
		
		Nqueens Queen = new Nqueens();
        Queen.solveNQ();
	}

}

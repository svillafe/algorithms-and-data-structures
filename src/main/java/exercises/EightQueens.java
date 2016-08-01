package exercises;

import java.util.ArrayList;

/*
 * Write an algorithm to print all ways of  eight queens on an 8x8 chess board. 
 * We have eight queens which must be lined up on an 8x8 chess board such that none
 * share the same row, column of diagonal. So, we know that each row and column (and
 * diagonal) must be used exactly once.
 *  
 */

public class EightQueens {
	
	private static final int GRID_SIZE = 8;
	
	public static ArrayList<Integer[]>  compute(){
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		Integer [] columns = new Integer[GRID_SIZE];
		placeQueens(0, columns, results);
		return results;
	}
	
	/*
	 * We only need a single array where column[r] = c indicates that row r has a queen
	 * at column c. 
	 */
	private static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results){
		
		if(row == GRID_SIZE){
			//we found a distribution so we add it to the list of valid distributions.
			results.add(columns.clone());
		}else{
			for(int col = 0; col < GRID_SIZE; col++){
				if(checkValid(columns, row, col)){
					columns[row] = col;
					placeQueens(row+1, columns, results);
				}
			}
		}
	}

	private static Boolean checkValid(Integer[] columns, int row1, int column1) {
		for(int row2 = 0 ; row2 < row1 ; row2++){
			int column2 = columns[row2];
			if(column2 == column1){
				return false;
			}
			
			/* 
			 * If the distance between the columns equals the distance between
			 * the rows, then they are in the same diagonal.
			 */
			int columnDistance = Math.abs(column2 - column1);
			int rowDistance = row1 - row2;
			
			if(columnDistance == rowDistance){
				return false;
			}
		}
		return true;
	}
}

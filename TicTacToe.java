/**
 * @author MICHAEL SUN, DREW BECKMEN, LINDSEY YU 
 *
 *
 */
public class TicTacToe
{
	
	public static void main(String[] args){
	 
	}
	
	
	/**
	* Initializes an int array that is our board
	* @param size The size of the length/width of the board
	* @return Returns the initialized array
	*/
	public static String[][] init(int size){
	 String[][] grid = new String[size][size];
	 int counter = 1; 
	 for (int i = 0; i < size; i++){
	  for (int n = 0; n < size; n++){
	   grid[i][n] = Integer.toString(counter);
	   counter++; 
	  }
	 }
	 return grid; 
	}
	
	/**
	* Prints the tictactoe board
	* @param array The array that we will print into a board
	*/
	public static void printGrid(String[][] array){
	 for (int row = 0; row < array.length; row++){
      for (int col = 0; col < array[row].length; col++){
       System.out.print(array[row][col] + " ");
      }
     System.out.println();
     }
	}
	
	/**
	* Calls upon checkwinner for all directions
	* @param array The current board
	* @return Returns if there is a winner
	*/
	public static boolean checkWinner(String[][] array){
	 boolean win; 
	 if (checkDiag(array) == true || checkReverseDiag(array) == true || checkVert(array) == true || checkHoriz(array) == true)
	 	win = true; 
	 else
	 	win = false; 
	 return win; 
	}
	
	/**
	 *@param grid the current grid
	 *@return whether there is a diagonal victory going from (0,0) to (2,2)
	*/
	public static boolean checkDiag(String[][] grid){
	 String firstSymbol = grid[0][0];
	 for (int i = 1; i < grid.length; i++){
	 		if (!(grid[i][i].equals(firstSymbol)))
	 			return false;
	 	}
	 	return true; 
	}
	
	/**
	 *@param grid the current grid
	 *@return whether there is a diagonal victory from (0,2) to (2,0)
	 *
	*/
	public static boolean checkReverseDiag(String[][] grid){
		int gridLength = grid.length;
		String firstSymbol = grid[gridLength - 1][gridLength - 1];
		for (int i = gridLength - 2; i >= 0; i--)
		{
			if (!(grid[i][i]).equals(firstSymbol))
				return false; 
		}
		return true; 
	}
	
	/**
	 *@param grid the current grid
	 *@return whether or not there is a verticle victory
	*/
	public static boolean checkVert(String[][] grid){
		int sum = 0; 
		for (int column = 0; column < grid.length; column++){
			String value = grid[0][column];
			for (int row = 0; row < grid.length; row++){
				if (grid[row][column].equals(value))
			 	 	sum++;
			}
			if (sum == grid.length)
				return true;
			sum = 0;
		}
		return false; 
	}
	
	/**
	 *
	 *
	 *
	 *
	*/
	public static boolean checkHoriz(String[][] grid){
		int sum = 0; 
		for (int row = 0; row < grid.length; row++){
			String value = grid[row][0];
			for (int column = 0; column < grid.length; column++){
				if (grid[row][column].equals(value))
			 	 	sum++;
			}
			if (sum == grid.length)
				return true;
			sum = 0;
		}
		return false; 
	}
	
	
	
}
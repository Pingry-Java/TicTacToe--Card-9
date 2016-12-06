import java.util.Scanner;

/**
 * @author MIROSLAV BERGAM, JEREMY NEWMAN, GRAHAM MATTHEWS, TOM DRZIK
 *
 *
 */
public class TicTacToe9
{
	
	public static void main(String[] args)
	{
		Scanner keys = new Scanner(System.in);
		boolean win = false;
		System.out.println("Hello! Welcome to tic tac toe! ");
		System.out.println("What would you like the size of the board to be?: ");
		int size = keys.nextInt();
		keys.nextLine();
		String[][] grid = init(size);
		printGrid(grid);
		int i = 1;
		String place;
		while((win==false) && (i <= (grid.length * grid.length)))
		{
			System.out.println("Where do you want to place your character?");
			place=keys.nextLine();
			addSymbol(place, grid, size, i);
			i++;
			win=checkWinner(grid);
			printGrid(grid);
		}
		if (i%2 == 0 && win == true)
			System.out.println("Congratulations Player 1! You won!");
		else if (i%2== 1 && win == true)
			System.out.println("Congratulations Player 2! You won!");
		else
			System.out.println("YOU TIED!!!");
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
	public static void printGrid(String[][] a)
	{
		for (int row = 0; row < a.length; row++)
		{
			for (int col = 0; col < a[row].length; col++)
				System.out.print(" –––––––");
			System.out.println();
			System.out.print("|");
			for (int col = 0; col < a[row].length; col++)
				System.out.print(a[row][col] + "\t |");
			System.out.println();
		}
		for (int col = 0; col < a[0].length; col++)
			System.out.print(" –––––––");
		System.out.println();
	}
	
	/*
	 for (int row = 0; row < array.length; row++){
      System.out.println("–––––");
      for (int col = 0; col < array[row].length; col++){
       System.out.print("|");
       System.out.print(array[row][col] + "\t |");
      }
     System.out.println();
     }
	}
	*/
	
	/**
	* Calls upon checkwinner for all directions
	* @param array The current board
	* @return Returns if there is a winner
	*/
	public static boolean checkWinner(String[][] array){
	 boolean win; 
	 if (checkDiag(array) == true || checkReverseDiagonal(array) == true || checkVert(array) == true || checkHoriz(array) == true)
	 	win = true; 
	 else
	 	win = false; 
	 return win; 
	}
	
	public static void addSymbol(String place, String[][]grid, int size, int turn){
		String symbol;
		int spot=Integer.parseInt(place);
		if(turn%2==1){
			symbol="X";
		}
		else{
			symbol="O";
		}
		grid[(spot-1)/size][(spot-1)%size]=symbol;
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
	
	public static boolean checkReverseDiagonal(String[][] grid){
		int gridLength = grid.length;
		String firstSymbol = grid[0][gridLength - 1];
		for (int i = gridLength - 2; i >= 0; i--)
		{
			if (!(grid[gridLength-i][i]).equals(firstSymbol))
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
	 * This method checks if a player has won in the horizontal row.
	 * @param grid The String array that holds the current board
	 * @return Returns true or false, true if a player has won, false if a player has not
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
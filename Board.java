// Anna Bergin 2080132B
// AE2 Stage 2: The Board Class
// AE2 Stage 3: Moving (the takeTurns method)

public class Board {

	int row;
	int col;
	private Player[] playerList = new Player[4]; // assuming that a maximum of 4 players will play the game
	private Square[][] board; 
	private int maxPlayers = 0;

	// a constructor that takes in the row and column values
	public Board(int r, int c) { 
		row = r;
		col = c;
		board = new Square[row][col]; // a two dimensional array of Square objects with the reference board
		for (int i = 0; i < row; i++) { // a for loop that creates an empty array of Square references
			for (int j = 0; j < col; j++) {
				board[i][j] = new Square(i*col+j);
			}
		}
	}

	// storing a player in the maxPlayers position of the array and then incrementing maxPlayers by 1
	public void addPlayer(Player players) {
		playerList[maxPlayers++] = players; 
		board[0][0].setPlayer(players); // setting a player on the square at position 0,0 on the board
		players.setPlayerPos(this.getSquareAtPos(0)); // setting a player on the square so that they know what square they are on
	}
	// note that the square can have more than one player, but a player can only be on 1 square

	// returning the position of a given row and column
	public int pos(int row, int col) { 
		return board[row][col].getPos();
	}

	// returning the last position of the board
	public int getMaxPosition() {
		return row*col-1;
	}

	// returning the column and row of a given position
	public int[] location(int pos) { 
		int helperCol = pos % col; // storing the column 
		int helperRow = pos / col; // storing the row  
		int[] myArray = new int[2];
		myArray[0] = helperRow; // setting the row
		myArray[1] = helperCol; // setting the column 
		return myArray; 
	}

	// returning a reference to a square at any integer position
	public Square getSquareAtPos(int anyIntPos) { 
		int[] array = new int[2];
		array = location(anyIntPos);
		return board[array[0]][array[1]];
	} 

	// returning a String that can be used to print out the board
	// note that the winning position is at the top left square and the starting position is at the bottom left square
	public String toString() { 

		String output = "";

		for (int i=row-1; 0<=i ; i--) { // a for loop with i in descending order
			if (i % 2 == 0) { // an if statement to check if the row is even 
				for (int j=0; j<col; j++) { // a for loop with j in ascending order
					output += board[i][j].toString();
				}
			} else {
				for (int j=col-1; j>=0; j--) { // a for loop with j in descending order
					output += board[i][j].toString();
				}
			}
			output += "\n";
		} 
		return output;
	}

	// repeatedly looping through the players until a player wins
	public boolean takeTurns(Board b) {

		boolean gameover = false; 
		while (!gameover){
			for(int i=0; i<maxPlayers; i++) { 
				if (playerList[i]==null) {
					continue;
				}
				if (playerList[i].move(this)) { // executed if someone wins
					gameover = true;
					System.out.println("Player " + playerList[i] + ", you have won!");
					return gameover; // exit a player has won
				} 
			}
		}
		return gameover; // needed to satisfy Java that gameover is a boolean that we will eventually return gameover
	}
	
	public static void main(String[] args) {

		Board board = new Board(10, 5); // creating a board with 10 rows and 5 columns
		Player pE = new Player('E');  // creating two players
		Player pS = new Player('S');
		board.addPlayer(pE); // adding the players to the board
		board.addPlayer(pS);
		System.out.println(board); 
	}
}
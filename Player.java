// Anna Bergin 2080132B
// Stage 1: The Player class
// Stage 3: Moving (the move method)

import java.util.Random;

public class Player {

	private char playerId; // a player's piece
	protected Square playerPos; // a player's position 

	// a constructor that takes in a player's piece
	public Player(char p) {
		playerId = p; 
	}

	// returning a player's piece as a String
	public String toString() {
		return "" + playerId;
	}

	// can be used set a player's position in another class
	public void setPlayerPos(Square sq) { 
		playerPos = sq;
	} 

	// checking if a player has made a winning move
	public boolean move(Board b) {

		// rolling a die to generate a random number between 1 and 6
		Random r = new Random(); 
		int diceRoll = r.nextInt(6)+1; 
		System.out.println("Player " + this + " you have rolled a " + diceRoll + "\n");

		// removing a player from a square and getting the new position of the player after the dice roll
		playerPos.removePlayer(this); 
		int newPos = diceRoll + playerPos.getPos(); 

		// an if statement which returns true if the new position is greater than or equal to the winning position which is 49
		if(newPos>= b.getMaxPosition()) { 
			return true; 
		}
		// if the program gets here the player has not won and delta is added to their new position
		// note that delta will never take a player to a winning position or land on another delta
		int delta = b.getSquareAtPos(newPos).getDelta();
		newPos += delta; 
		this.setPlayerPos(b.getSquareAtPos(newPos)); // setting the player's piece and printing the board
		playerPos.setPlayer(this); 
		System.out.println(b); 
		return false; 
	}

	public static void main(String[] args) {

		Player pE = new Player('E'); // creating a player
		Square sq = new Square(1); // creating a square
		sq.setPlayer(pE); // assigning a player to a square
		System.out.println(pE);
		System.out.println(sq);
	}
}

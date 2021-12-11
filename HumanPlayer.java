// Anna Bergin 2080132B
// AE2 Stage 5: Different types of player

import java.util.Scanner;

public class HumanPlayer extends Player { 

	public HumanPlayer(char p) {
		super(p); // calling the constructor from the Player class
	}

	// overriding the move method in the Player class to allow the human player to enter their moves
	public boolean move(Board b) {

		System.out.println("Player " + super.toString() + " please enter a number between 1 and 6");
		Scanner s = new Scanner(System.in);
		int diceRoll = s.nextInt();
		playerPos.removePlayer(this); // removing a player from a square and getting their new position
		int newPos = diceRoll + playerPos.getPos(); 

		// an if statement that returns true if the new position is greater than or equal to the winning position which is 49
		if(newPos>=b.getMaxPosition()) { 
			return true; // exit here if a player wins
		}

		// the program moves here if the player has not won and delta is added to their new position
		// note that delta will never take a player to a winning position or land on another delta
		int delta = b.getSquareAtPos(newPos).getDelta();
		newPos += delta; 
		this.setPlayerPos(b.getSquareAtPos(newPos)); // setting the player to their new position
		playerPos.setPlayer(this);
		System.out.println(b);
		return false; 
	}
}

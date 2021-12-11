// Anna Bergin 2080132B
// AE2 Stage 1: The Square class

public class Square {

	private int pos; 
	private int delta; 
	private Player[] player;
	private int numOfPlayers;

	// a square constructor that takes in an integer position
	public Square(int p) { 
		numOfPlayers = 0; 
		player = new Player[4]; // assuming a maximum of 4 players will play the game
		pos = p;
		delta = 0;
	}

	// can be used to set delta in another class
	public void setDelta(int d) { 
		delta = d;
	}

	// can be used to get delta in another class
	public int getDelta() { 
		return delta;
	}

	// storing each player at the numOfPlayers position in the array and then incrementing the numOfPlayers by 1
	public void setPlayer(Player p) {
		player[numOfPlayers++] = p;
	}

	// removing a player from the array and putting the player at the end into the gap that has been created
	public void removePlayer(Player p) {
		for(int i=0; i<numOfPlayers; i++) { 
			if(player[i] == p) { // an if statement that says if they are this player we know that they are at this position in the array
				numOfPlayers--; 
				player[i] = player[numOfPlayers]; 
				player[numOfPlayers] = null;
			}
		}
	}

	// used to get the position in a different class
	public int getPos() {
		return pos;
	}

	// returning a String representation of a square
	public String toString() {
		String output = "";
		String playersFormatted = "";

		if (numOfPlayers>0) { // an if statement that checks if there is anyone playing the game
			for (int i = 0; i < numOfPlayers; i++) { // a for loop that stores the player's piece as a String
				playersFormatted += player[i].toString();
			}
		}
		if (delta == 0) { // an if statement that checks if delta is 0 which means there are no snakes or ladders 
			output += String.format("%4s %4d (   )", playersFormatted, pos); 
		} else {
			output += String.format("%4s %4d (%3d)", playersFormatted, pos, delta); 
		}
		return output;
	}
}
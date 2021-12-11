// Anna Bergin 2080132B
// AE2 Stage 4: Playing

public class Play {

	public static void main(String[] args) {

		Board board = new Board(10,5); // creating a board with 10 rows and 5 columns

		board.getSquareAtPos(0).setDelta(4); // setting ladders which move a player up to its highest point
		board.getSquareAtPos(8).setDelta(1); 
		board.getSquareAtPos(13).setDelta(-1); // setting snakes which a player slides down to its lowest point
		board.getSquareAtPos(26).setDelta(-2); 
		board.getSquareAtPos(22).setDelta(-4); 
		// note that a delta will never take a player to a winning position or land on another delta

		// assuming a maximum of 4 players will play the game
		// creating three virtual players
		Player pE = new Player('E'); 
		Player pA = new Player('A'); 
		Player pB = new Player('B');
		HumanPlayer pS = new HumanPlayer('S'); // creating a human player

		// adding the players to the board
		board.addPlayer(pE); 
		board.addPlayer(pS);
		board.addPlayer(pA);
		board.addPlayer(pB);

		board.takeTurns(board); // starting a game
	}
}

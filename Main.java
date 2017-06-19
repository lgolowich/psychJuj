import java.util.*;
import java.io.*;

public class Main
{
    public static List<Integer> runTests(int numTests)
    {
	Config.initVars();
	List<Integer> numWins = new ArrayList<Integer>();
	for (int i = 0; i < Config.getNumPlayers(); i++)
	    numWins.add(0);
	
	for (int test = 0; test < numTests; test++) {
	    Game curGame = new Game();
	    for (int round = 1; round <= curGame.getNumRounds(); round++)
		curGame.playRound();
	    
	    int winnerInd = curGame.getLeader();
	    if (winnerInd >= 0)
		numWins.set(winnerInd, numWins.get(winnerInd) + 1);
	}
	return numWins;
    }

    public static int printTest()
    {
	Game game = new Game();

	for (Integer round = 1; round <= game.getNumRounds(); round++) {
	    System.out.println("Round " + round.toString() + ":");
	    System.out.println("Card: " + new Integer(game.getNextCard()).toString());
	    int result = game.playRound();
	    System.out.println("Cards played: " + game.getPlayed().toString());
	    System.out.println("New scores: " + game.getScores().toString());
	    System.out.println();
	}
	System.out.println("Winner: " + new Integer(game.getLeader()).toString());
	
	return game.getLeader();
    }
    
    public static void main(String[] args)
    {
	// int numTests = 10000;
	// List<Integer> numWins = runTests(numTests);
	// System.out.println(numWins);
	// System.out.println((double)numWins.get(0) / (numWins.get(0) + numWins.get(1)));

	printTest();
    }
}


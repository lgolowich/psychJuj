import java.io.*;
import java.util.*;

public class Config
{
    private static String action;
    private static int numCards;
    private static List<Player> players = new ArrayList<>();

    public static void initVars()
    {
	// Set the action that Main should perform to one of the following options:
	// "Print": Play a single match and print the moves.
	// "Test": Play many matches and print the number of wins of each player, as well as the fraction won by the first.
	action = "Print";
	
	// Initialize the number of cards in a suit
	numCards = 13;

	// Add the players to the game
	// players.add(new Person());
	players.clear();
	players.add(new Person());
	players.add(new Smartbot());
	// players.add(new Simplebot());
    }

    public static String getAction()
    {
	return action;
    }
    
    public static int getNumCards()
    {
	return numCards;
    }

    public static int getNumPlayers()
    {
	return players.size();
    }
    
    public static List<Player> getPlayers()
    {
	return players;
    }
}


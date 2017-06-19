import java.io.*;
import java.util.*;

public class Config
{
    private static int numCards;
    private static List<Player> players = new ArrayList<>();

    public static void initVars()
    {
	// Initialize the number of cards in a suit
	numCards = 13;

	// Add the players to the game
	// players.add(new Person());
	players.clear();
	players.add(new Person());
	players.add(new Dumbot());
	players.add(new Simplebot());
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


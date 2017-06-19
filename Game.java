import java.util.*;
import java.io.*;

public class Game
{
    private List<Player> players;
    private List<Integer> cards;
    private int pos; // position of next card to be chosen, representing position in game
    private List<Integer> played; // the moves of the players from the most recent round

    public Game()
    {
	Config.initVars();
	players = Config.getPlayers();
	pos = 0;
	cards = new ArrayList<Integer>();
	for (int i = 1; i <= Config.getNumCards(); i++)
	    cards.add(i);
	Collections.shuffle(cards);
	played = new ArrayList<Integer>();
    }

    public List<Integer> getScores()
    {
	List<Integer> scores = new ArrayList<Integer>();
	for (Player p : players)
	    scores.add(p.getScore());
	return scores;
    }

    public List<Integer> getPlayed()
    {
	return played;
    }

    public int getNextCard()
    {
	return cards.get(pos);
    }
    
    public int getLastCard()
    {
	return cards.get(pos - 1);
    }

    public int getNumRounds()
    {
	return Config.getNumCards();
    }

    public int getLeader()
    {
	int leaderInd = 0;
	boolean isTie = false;
	for (int i = 1; i < Config.getNumPlayers(); i++) {
	    int curScore = players.get(i).getScore(), leaderScore = players.get(leaderInd).getScore();
	    if (curScore > leaderScore) {
		leaderInd = i;
		isTie = false;
	    }
	    else if (curScore == leaderScore) {
		isTie = true;
	    }
	}

	// Return -1 if there was a tie, or the index of the player that won otherwise.
	if (isTie)
	    return -1;
	else
	    return leaderInd;
    }

    public int playRound()
    {
	if (pos >= cards.size())
	    return -2; // return -2 if the game is over
	
	int curCard = cards.get(pos++);
	played.clear();
	for (Player p : players)
	    played.add(p.getMove(curCard));

	int bestInd = -1, bestVal = -1;
	boolean isTie = false;
	for (int i = 0; i < played.size(); i++) {
	    if (played.get(i) > bestVal) {
		bestInd = i;
		bestVal = played.get(i);
		isTie = false;
	    }
	    else if (played.get(i) == bestVal) {
		isTie = true;
	    }
	}

	for (int i = 0; i < players.size(); i++) {
	    if (isTie || bestInd != i)
		players.get(i).newPoints(0);
	    else
		players.get(i).newPoints(curCard);
	}

	// Return the index of the player that won, or -1 if no player won (there was a tie).
	if (isTie)
	    return -1;
	else
	    return bestInd;
    }
}


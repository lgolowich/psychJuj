import java.util.*;
import java.io.*;

public abstract class Player
{
    protected List<Integer> cards;
    private int score;
    
    public Player()
    {
	cards = new ArrayList<Integer>();
	for (int i = 1; i <= Config.getNumCards(); i++)
	    cards.add(i);
	score = 0;

	// TODO: give the extending classes an initialization function that is called in the constructor.
    }

    public int getScore()
    {
	return score;
    }

    public List<Integer> getCards()
    {
	return new ArrayList<Integer>(cards);
    }

    public int getMove(int curCard)
    {
	int move = -1;
	while (!cards.contains(move))
	    move = decideMove(curCard);
	cards.remove(new Integer(move));
	return move;
    }

    public void newPoints(int val)
    {
	score += val;

	// TODO: tell the extending classes their new points, and give them a function called here.
    }

    public abstract int decideMove(int curCard);
}


import java.util.*;
import java.io.*;

public class Dumbot extends Player
{
    public int decideMove(int curCard)
    {
	List<Integer> myCards = getCards();
	Random randomizer = new Random();
	int choice = myCards.get(randomizer.nextInt(myCards.size()));
	return choice;
    }
}


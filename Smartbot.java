import java.util.*;
import java.io.*;

public class Smartbot extends Player
{
    public int decideMove(int curCard)
    {
	double mean = curCard + 2;
	double variance = Config.getNumCards() * .15;
	
	List<Integer> myCards = getCards();
	Random randomizer = new Random();
	
	List<Double> weights = new ArrayList<Double>();
	for (int i = 0; i < myCards.size(); i++)
	    weights.add(Math.exp(-(myCards.get(i) - mean) * (myCards.get(i) - mean) / (double)(2 * variance)));
	
	List<Double> cumWeights = new ArrayList<Double>();
	cumWeights.add(0.);
	for (int i = 0; i < weights.size(); i++)
	    cumWeights.add(cumWeights.get(i) + weights.get(i));
	double totalWeight = cumWeights.get(cumWeights.size() - 1);

	double chosen = totalWeight * randomizer.nextDouble();
	int choice = -1;
	for (int i = 0; i < cumWeights.size() - 1; i++)
	    if (chosen >= cumWeights.get(i) && chosen < cumWeights.get(i + 1)) {
		choice = myCards.get(i);
		break;
	    }
	
	return choice;
    }
}


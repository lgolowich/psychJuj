import java.util.*;
import java.io.*;

public class Person extends Player
{
    public int decideMove(int curCard)
    {
	List<Integer> myCards = getCards();
	System.out.println("Here are your cards: " + myCards.toString());
	int choice = -1;
	Scanner input = new Scanner(System.in);
	while (!myCards.contains(choice)) {
	    System.out.print("Enter the card you want to play: ");
	    choice = input.nextInt();
	}
	return choice;
    }
}


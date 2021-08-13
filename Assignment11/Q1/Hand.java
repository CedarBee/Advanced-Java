
import java.util.ArrayList;

public class Hand {//Hand class represents a player's hand during a round
	
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	//Adds the dealt card to the players hand. Adds the Ace card to the end of the list to make
	//sum of the hand easier (Ace can be value of 1 or 11).
	public void addCard(Card myCard)	{
		if (myCard.getFace()=="Ace")
			hand.add(myCard);
		else
			hand.add(0, myCard);
	}
	
	public String listCards(){
		
		String temp = "";
		
		if (hand.size()>0) 
			temp = hand.get(0).getFace();
		
		for (int i = 1; i < hand.size(); i++) 
		{
			temp = temp + ", ";
			temp = temp + (hand.get(i).getFace());
		}
		return temp;
	}
	
	public int calculateHand(){ //Calculates the value of a hand.
		int sum = 0;
		int i = 0;
		int numberOfAces = 0;
		
		while (hand.size()>i && hand.get(i).getValue()!=11)
		{
			sum = sum + hand.get(i).getValue();
			i++;
		}
		
		//This calculates the value of the hand and determines how many aces should be valued as 11 or 1.
		numberOfAces = hand.size()-i;
		sum = sum + numberOfAces*11;
		
		while (sum>22 && numberOfAces>=1)
		{
			sum = sum - 10; 
			numberOfAces--;
		}
			
		return sum;
	}
	
}


import javax.swing.JOptionPane;

public class GameManager {//GameManager class manages the black jack game

	public static void PlayGame(){
		int anotherGame = JOptionPane.YES_OPTION;
		int computerHandLimit = 17;
		int reply = JOptionPane.YES_OPTION;
		int messageFlag=0;
			
		while (anotherGame == JOptionPane.YES_OPTION){ //Rounds continue as long as player presses Yes in dialog box. 
			
			Hand playerHand = new Hand();
			Hand computerHand = new Hand();
			messageFlag = 0;

			//get new deck of cards and shuffle
			DeckOfCards myDeckOfCards = new DeckOfCards();
			myDeckOfCards.shuffle();
			//Give two cards to each player
			playerHand.addCard(myDeckOfCards.dealCard());
			computerHand.addCard(myDeckOfCards.dealCard());
			playerHand.addCard(myDeckOfCards.dealCard());
			computerHand.addCard(myDeckOfCards.dealCard());
			
			//Alternately ask user if to take another card and deal card to computer. Computer limit is 
			//hand value of computerHandLimit
			reply = JOptionPane.YES_OPTION;
			while (reply == JOptionPane.YES_OPTION){
				reply =  AnotherCard("Your hand is: " + playerHand.listCards());
				if (reply == JOptionPane.YES_OPTION)
					playerHand.addCard(myDeckOfCards.dealCard());
				if (computerHand.calculateHand()<=computerHandLimit)
					computerHand.addCard(myDeckOfCards.dealCard());
			}
			//Computer continues to take cards up to value of computerHandLimit
			while (computerHand.calculateHand()<=computerHandLimit)
				computerHand.addCard(myDeckOfCards.dealCard());
				
			if ((computerHand.calculateHand() < playerHand.calculateHand()) && playerHand.calculateHand()<=21
					&& computerHand.calculateHand()<=21 && messageFlag==0){
				anotherGame = JOptionPane.showConfirmDialog(null, "You win! Your hand is: " + playerHand.listCards() + ". Value is " + 
								playerHand.calculateHand() + "\nComputer's hand is: " +  computerHand.listCards() + ". Value is "	+
								computerHand.calculateHand() + ".\nAnother game?");
				messageFlag=1;
			}
			
			if ((computerHand.calculateHand() > playerHand.calculateHand()) && computerHand.calculateHand()<=21
					&& playerHand.calculateHand()<=21 && messageFlag==0)
			{
				anotherGame = JOptionPane.showConfirmDialog(null, "Computer wins! \nYour hand is: " + playerHand.listCards() + ". Value is " + 
						playerHand.calculateHand() + "\nComputer's hand is: " +  computerHand.listCards() + ". Value is "	+
						computerHand.calculateHand() + ".\nAnother game?");
				messageFlag=1;
			}
			
			if ((computerHand.calculateHand() == playerHand.calculateHand()) ||
					(playerHand.calculateHand()>21 && computerHand.calculateHand()>21) && messageFlag==0)
			{
				anotherGame = JOptionPane.showConfirmDialog(null, "It's a tie! \nYour hand is: " + playerHand.listCards() + ". Value is " +
						playerHand.calculateHand() + "\nComputer's hand is: " +  computerHand.listCards() + ". Value is "	+
						computerHand.calculateHand() + ".\nAnother game?");
				messageFlag=1;
			}
			
			if ((computerHand.calculateHand() == playerHand.calculateHand()) &&
					(playerHand.calculateHand()<=21 && computerHand.calculateHand()<=21) && messageFlag==0)
			{
				anotherGame = JOptionPane.showConfirmDialog(null, "It's a tie! \nYour hand is: " + playerHand.listCards() + ". Value is " +
						playerHand.calculateHand() + "\nComputer's hand is: " +  computerHand.listCards() + ". Value is "	+
						computerHand.calculateHand() + ".\nAnother game?");
				messageFlag=1;
			}
			
			if (playerHand.calculateHand()<=21 && computerHand.calculateHand()>21 && messageFlag==0) {
				anotherGame = JOptionPane.showConfirmDialog(null, "You win! \nYour hand is: " + playerHand.listCards() + ". Value is " +
						playerHand.calculateHand() + "\nComputer's hand is: " +  computerHand.listCards() + ". Value is "	+
						computerHand.calculateHand() + ".\nAnother game?");
				messageFlag=1;
				}
				
			if (playerHand.calculateHand()>21 && computerHand.calculateHand()<=21 && messageFlag==0) {
				anotherGame = JOptionPane.showConfirmDialog(null, "Computer wins! \nYour hand is: " + playerHand.listCards() + ". Value is " +
						playerHand.calculateHand() + "\nComputer's hand is: " +  computerHand.listCards() + ". Value is "	+
						computerHand.calculateHand() + ".\nAnother game?");
				messageFlag=1;
			}
			
		}//end while (anotherGame == 1)
	
	}
	
	public static int AnotherCard(String cardsList)
	{
			return JOptionPane.showConfirmDialog(null, "Your cards are: " + cardsList + ".\nAnother card?");
	}

}

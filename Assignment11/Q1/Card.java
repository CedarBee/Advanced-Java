public class Card {//Card class represents a playing card
	
	private final String face;
	private final String suit;
	private final int value;
	
	public Card(String cardFace, String cardSuit){
		this.face=cardFace;
		this.suit=cardSuit;
		this.value = getValue();
	}
	
	public String toString()	{
		return face + " of " + suit;
	}
	
	public String getFace(){
		return face;
	}
	
	public int getValue(){
		if (this.face.equals("Ten") || this.face.equals("Jack") ||  this.face.equals("Queen")
			|| this.face.equals("King"))
			return 10;
		if (this.face.equals("Ace"))
			return 11;
		if (this.face.equals("Deuce"))
			return 2;
		if (this.face.equals("Three"))
			return 3;
		if (this.face.equals("Four"))
			return 4;	
		if (this.face.equals("Five"))
			return 5;		
		if (this.face.equals("Six"))
			return 6;		
		if (this.face.equals("Seven"))
			return 7;
		if (this.face.equals("Eight"))
			return 8;
		if (this.face.equals("Nine"))
			return 9;
		
		return 0;
	}

}

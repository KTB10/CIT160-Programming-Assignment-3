// Kyle Bouder
// October 21, 2016
// War Card Game

public class War {
	private int rangeMin = 1;
	private int rangeMax = 13;

	private int playerACards = 26;
	private int playerBCards = 26;
	
	public int getRangeMin() {
		return rangeMin;
	}
	public int getRangeMax() {
		return rangeMax;
	}
	
	public int getPlayerACards() {
		return playerACards;
	}
	public int getPlayerBCards() {
		return playerBCards;
	}
	
	public void addA(int numb) {
		playerACards+=numb;
		playerBCards-=numb;
		if(playerACards > 52) {
			playerACards = 52;
			playerBCards = 0;
		}
	}
	public void addB(int numb) {
		playerACards-=numb;
		playerBCards+=numb;
		if(playerBCards > 52) {
			playerBCards = 52;
			playerACards = 0;
		}
	}
}

class Main {
	public static void main(String[] args) {
		//Initialize War() and local variables
		War war = new War();
		int play = 0;
		int cardA = 0;
		int cardB = 0;
		int modifier = 1;
		boolean win = false;
		
		System.out.println("Get ready for a game of WAR!");
		while(!win) {
			play++;
			//Calculate values of each card
			cardA = (int)(Math.random() * (war.getRangeMax()) + war.getRangeMin());
			cardB = (int)(Math.random() * (war.getRangeMax()) + war.getRangeMin());
			
			//Print first Line
			System.out.println("Play " + play + " -- Player one: " + cardA + " Player two: " + cardB);
			
			//Update score and print second line
			if(cardA > cardB) {
				System.out.println("Player one wins");
				war.addA(modifier);
				if(modifier != 1) {
					modifier = 1;
				}
			} else if(cardA < cardB) {
				System.out.println("Player two wins");
				war.addB(modifier);
				if(modifier != 1) {
					modifier = 1;
				}
			} else if(cardA == cardB) {
				System.out.println("War!");
				modifier += 3;
			}
			
			//Scores
			System.out.println("Scores -- Player one: " + war.getPlayerACards() + " Player two: " + war.getPlayerBCards() + "\n");
			
			//Check for win and break out of loop
			if(war.getPlayerACards() <= 0) {
				System.out.println("******** Player 2 Wins ********");
				win = true;
			} else if (war.getPlayerBCards() <= 0) {
				System.out.println("******** Player 1 Wins ********");
				win = true;
			}
			
		}
	}
}

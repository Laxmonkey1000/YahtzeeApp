import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/** Holds values for players array data and checks certain boxes
 * score values using dice array and confirms user actions for scoring
 * @author Holt, Mary */
public class YahtzeeData //extends YahtzeeContent
{
	/** Stores the number of players 1-4 */
	public static int numOfPlayers;
	
	/** Counter for which player is currently rolling */
	public static byte currentPlayer;
	
	/** Counter for number of complete turn cycles 0-13 */
	public static byte cycleCounter;
	
	/** Counter for number of rolls, used to call specific methods */
	public static byte turnCounter = 0;
	
	/** Array List that holds the values for each players scores */
	public static ArrayList<YahtzeeData> players = new ArrayList<YahtzeeData>();
	
	/** True: Scored, False: UnScored
	 *  0: One, 1: Two, 2: Three, 3: Four, 4: Five, 5: Six */
	public boolean[] upperScored = new boolean[6]; 
	
	/** 0: One, 1: Two, 2: Three, 3: Four, 4: Five, 5: Six */
	public int[] upperScores = new int[6];
	
	public boolean
	/** True: threeOfKind is scored, False: threeOfKind is not scored */
	threeOfKindScored,
	/** True: fourOfKind is scored, False: fourOfKind is not scored */
	fourOfKindScored,
	/** True: fullHouse is scored, False: fullHouse is not scored */
	fullHouseScored,
	/** True: smallStraight is scored, False: smallStraight is not scored */
	smallStraightScored,
	/** True: largeStraight is scored, False: largeStraight is not scored */
	largeStraightScored,
	/** True: chance is scored, False: chance is not scored */
	chanceScored,
	/** True: yahtzee is scored, False: yahtzee is not scored */
	yahtzeeScored;
	
	public int
	/** Holds value for a players bonus box value */
	bonus,
	/** Holds value for a players threeOfKind box value*/
	threeOfKind,
	/** Holds value for a players fourOfKind box value*/
	fourOfKind,
	/** Holds value for a players fullHouse box value*/
	fullHouse,
	/** Holds value for a players smallStraight box value*/
	smallStraight,
	/** Holds value for a players largeStraight box value*/
	largeStraight,
	/** Holds value for a players chance box value*/
	chance,
	/** Holds value for a players yahtzee box value*/
	yahtzee;
	
	/** Displays available boxes available for player on score screen */
	public static void displayScoreBox()
	{
		int length = players.get(currentPlayer).upperScored.length;
		
		for(int x = 0; x < length; x++)
		{
			if(players.get(currentPlayer).upperScored[x] == false)
			{
				switch(x)
				{
				case 0:
					YahtzeeFrame.f.add(YahtzeeFrame.oneBox); break;
				case 1:
					YahtzeeFrame.f.add(YahtzeeFrame.twoBox); break;
				case 2:
					YahtzeeFrame.f.add(YahtzeeFrame.threeBox); break;
				case 3:
					YahtzeeFrame.f.add(YahtzeeFrame.fourBox); break;
				case 4:
					YahtzeeFrame.f.add(YahtzeeFrame.fiveBox); break;
				case 5:
					YahtzeeFrame.f.add(YahtzeeFrame.sixBox); break;
				}
			}
		}
		if(players.get(currentPlayer).threeOfKindScored == false)
		{ YahtzeeFrame.f.add(YahtzeeFrame.threeOfKind); }
		if(players.get(currentPlayer).fourOfKindScored == false)
		{ YahtzeeFrame.f.add(YahtzeeFrame.fourOfKind); }
		if(players.get(currentPlayer).fullHouseScored == false)
		{ YahtzeeFrame.f.add(YahtzeeFrame.fullHouse); }
		if(players.get(currentPlayer).smallStraightScored == false)
		{ YahtzeeFrame.f.add(YahtzeeFrame.smallStraight); }
		if(players.get(currentPlayer).largeStraightScored == false)
		{ YahtzeeFrame.f.add(YahtzeeFrame.largeStraight); }
		if(players.get(currentPlayer).chanceScored == false)
		{ YahtzeeFrame.f.add(YahtzeeFrame.chance); }
		if(players.get(currentPlayer).yahtzeeScored == false)
		{ YahtzeeFrame.f.add(YahtzeeFrame.yahtzee); }
	}
	
	/** Method that searches for 1-6 in the die and adds the
	 * score of all the die that match the number entered
	 * @param index Die number that is being searched for
	 * @return tempScore Score based on index input */
	public static int checkScoreUpper(int index)
	{
		int tempScore = 0;
		int length = YahtzeeDice.dice.length;
		
		for(int x = 0; x < length; x ++)
		{
			if(YahtzeeDice.dice[x] == index)
			{
				tempScore += index;
			}
		}
		
		return tempScore;
	}
	
	/** Checks if there is a 3 or 4 of a kind and returns
	 * value of score that will be scored in the box
	 * @param num 3: Three of Kind 4: Four of Kind
	 * @return score Adds up total of all dice or is 0
	 */
	public static byte checkNumOfKind(int num)
	{
		byte sameCounter = 0;
		byte score = 0;
		for(int x = 1; x < YahtzeeDice.sidesNum + 1; x++)
		{
			sameCounter = 0;
			
			for(int i = 0; i < YahtzeeDice.dice.length; i++)
			{
				if(x == YahtzeeDice.dice[i]) 
				{ 
					sameCounter++;
				}
			}
			if(sameCounter >= num) 
			{
				for(int i = 0; i < YahtzeeDice.dice.length; i++)
				{
					score += YahtzeeDice.dice[i];
				}
				break;
			}
			else
			{
				score = 0;
			}
		}

		return score;
	}
	
	/** Checks if there is a fullHouse and returns score
	 * for fullHouse box based on dice[] array
	 * @return 25: FullHouse present 0: no FullHouse
	 */
	public static int checkFullHouse()
	{
		int
		countOne = 0,
		countTwo = 0,
		countThree = 0,
		countFour = 0,
		countFive = 0,
		countSix = 0;
		
		int score = 0;

			for(int i = 0; i < YahtzeeDice.dice.length; i++)
			{
				switch(YahtzeeDice.dice[i])
				{
					case 1:
							countOne++;
						break;
					case 2:
							countTwo++;
						break;
					case 3:
							countThree++;
						break;
					case 4:
							countFour++;
						break;
					case 5:
							countFive++;
						break;
					case 6:
							countSix++;
						break;
				}
			}
		
	if(countOne == 3 || countTwo == 3 || countThree == 3 || countFour == 3 || countFive == 3 || countSix == 3)
	{
		if(countOne == 2 || countTwo == 2 || countThree == 2 || countFour == 2 || countFive == 2 || countSix == 2)
		{
			score = 25;
		}
	}
		return score;
	}
	
	/** Checks if there is a 4 or 5 die straight and returns
	 * appropriate score based on dice[] array
	 * @param num 4: smallStraight, 5: largeStraight
	 * @return 30: smallStraight 40: largeStraight 0: none
	 */
	public static int checkStraight(int num)
	{
		Arrays.sort(YahtzeeDice.dice);
		byte counter = 0;
		int length = YahtzeeDice.dice.length;
		int score = 0;
		
		try //Exception happens when num = 5, and there is no straight present
		{   //The loop will try to access an non-existing 6th dice
			for(int x = 0; x < length; x++)
			{
				if(counter == num-1)
				{ 
					if(num == 4) { score = 30; break; }
					else if(num == 5) { score = 40; break;}
				}
				else if(YahtzeeDice.dice[x] + 1 == YahtzeeDice.dice[(x+1)])
				{ 
					counter++; 
				}
				else if(YahtzeeDice.dice[x] == YahtzeeDice.dice[x+1])
				{
					continue; 
				}
				else 
				{ 
					counter = 0; 
				}
			}
		} catch(Exception e)
			{}
		
		return score;
	}
	
	/** Adds value of all dice and returns it for chance box 
	 * @return score Value of all die*/
	public static int checkChance()
	{
		int length = YahtzeeDice.dice.length;
		int score = 0;
		
		for(int x = 0; x < length; x++)
		{
			score += YahtzeeDice.dice[x];
		}
		return score;
	}
	
	/** Checks if all dice are same number and returns value
	 * for yahtzee box based on dice[] array
	 * @return 50: Yahtzee 0: No Yahtzee
	 */
	public static int checkYahtzee()
	{
		int score = 0;
		
		byte counter = 0;
		for(int x = 0; x < YahtzeeDice.sidesNum + 1; x++)
		{
			for(int i = 0; i < YahtzeeDice.dice.length; i++)
			{
				if(YahtzeeDice.dice[i] == x) 
				{ 
					counter++; 
				}
			}
			if(counter == 5)
			{ 
				score = 50; 
				break;
			}
			else 
			{ 
				counter = 0; 
			}
		}
		
		return score;
	}
	
	/** Displays pop-up message prompting user to confirm calculated
	 * score for selected box
	 * @param score Used to display calculated score for the box
	 * @param name Used to display their selected box name
	 * @return true: Save + swtich Players false: Don't save, remain on screen */
	public static boolean confirmBox(int score, String name)
	{
		int result = JOptionPane.showConfirmDialog(null, "Save " + score + " in box " 
				+ name + "?",  "Confirm Box Selection", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION)
		{
			return true;
		}
		return false;
	}
	
	/** Displays current scores for each box for currentPlayer */
	public static void displayScores()
	{
		YahtzeeContent.oneLabel.setText(Integer.toString(
				players.get(currentPlayer).upperScores[0]));
		YahtzeeFrame.f.add(YahtzeeContent.oneLabel);
		
		YahtzeeContent.twoLabel.setText(Integer.toString(
				players.get(currentPlayer).upperScores[1]));
		YahtzeeFrame.f.add(YahtzeeContent.twoLabel);
		
		YahtzeeContent.threeLabel.setText(Integer.toString(
				players.get(currentPlayer).upperScores[2]));
		YahtzeeFrame.f.add(YahtzeeContent.threeLabel);
		
		YahtzeeContent.fourLabel.setText(Integer.toString(
				players.get(currentPlayer).upperScores[3]));
		YahtzeeFrame.f.add(YahtzeeContent.fourLabel);
		
		YahtzeeContent.fiveLabel.setText(Integer.toString(
				players.get(currentPlayer).upperScores[4]));
		YahtzeeFrame.f.add(YahtzeeContent.fiveLabel);
		
		YahtzeeContent.sixLabel.setText(Integer.toString(
				players.get(currentPlayer).upperScores[5]));
		YahtzeeFrame.f.add(YahtzeeContent.sixLabel);
		
		YahtzeeContent.oneSixLabel.setText(Integer.toString(
				players.get(currentPlayer).getOneSixScore()));
		YahtzeeFrame.f.add(YahtzeeContent.oneSixLabel);
		
		YahtzeeContent.bonusLabel.setText(Integer.toString(
				players.get(currentPlayer).checkBonus()));
		YahtzeeFrame.f.add(YahtzeeContent.bonusLabel);
		
		YahtzeeContent.totalUpLabel.setText(Integer.toString(
				players.get(currentPlayer).getUpScore()));
		YahtzeeFrame.f.add(YahtzeeContent.totalUpLabel);
		//------------------------------------------------------------//
		YahtzeeContent.threeKindLabel.setText(Integer.toString(
				players.get(currentPlayer).threeOfKind));
		YahtzeeFrame.f.add(YahtzeeContent.threeKindLabel);
		
		YahtzeeContent.fourKindLabel.setText(Integer.toString(
				players.get(currentPlayer).fourOfKind));
		YahtzeeFrame.f.add(YahtzeeContent.fourKindLabel);
		
		YahtzeeContent.fullHouseLabel.setText(Integer.toString(
				players.get(currentPlayer).fullHouse));
		YahtzeeFrame.f.add(YahtzeeContent.fullHouseLabel);
		
		YahtzeeContent.smStraightLabel.setText(Integer.toString(
				players.get(currentPlayer).smallStraight));
		YahtzeeFrame.f.add(YahtzeeContent.smStraightLabel);
		
		YahtzeeContent.lgStraightLabel.setText(Integer.toString(
				players.get(currentPlayer).largeStraight));
		YahtzeeFrame.f.add(YahtzeeContent.lgStraightLabel);
		
		YahtzeeContent.yahtzeeLabel.setText(Integer.toString(
				players.get(currentPlayer).yahtzee));
		YahtzeeFrame.f.add(YahtzeeContent.yahtzeeLabel);
		
		YahtzeeContent.chanceLabel.setText(Integer.toString(
				players.get(currentPlayer).chance));
		YahtzeeFrame.f.add(YahtzeeContent.chanceLabel);
		
		YahtzeeContent.totalLowLabel.setText(Integer.toString(
				players.get(currentPlayer).getLowScore()));
		YahtzeeFrame.f.add(YahtzeeContent.totalLowLabel);
	}
	
	/** Gets upper section value and checks if bonus is reached
	 * @return bonus 35 if reached, 0 if under 63 */
	public int checkBonus()
	{
		int tempScore = 0;
		tempScore += upperScores[0];
		tempScore += upperScores[1];
		tempScore += upperScores[2];
		tempScore += upperScores[3];
		tempScore += upperScores[4];
		tempScore += upperScores[5];
		
		if(tempScore > 63)
			{ bonus = 35; }
		else 
			{ bonus = 0; }
		return bonus;
	}
	
	/** Gets upper section score of one-six boxes
	 * @return tempScore Score of one-six boxes values */
	public int getOneSixScore()
	{
		int tempScore = 0;
		tempScore += upperScores[0];
		tempScore += upperScores[1];
		tempScore += upperScores[2];
		tempScore += upperScores[3];
		tempScore += upperScores[4];
		tempScore += upperScores[5];
		return tempScore;
	}
	
	/** Gets upper section score for certain player
	 * @return tempScore Cummulative score of upperSection values */
	public int getUpScore()
	{
		int tempScore = 0;
		tempScore += upperScores[0];
		tempScore += upperScores[1];
		tempScore += upperScores[2];
		tempScore += upperScores[3];
		tempScore += upperScores[4];
		tempScore += upperScores[5];
		
		tempScore += checkBonus();
		
		return tempScore;
	}
	
	/** Gets lower section score for certain player
	 * @return tempScore Cummulative score of lowerSection values */
	public int getLowScore()
	{
		int tempScore = 0;
		tempScore += threeOfKind;
		tempScore += fourOfKind;
		tempScore += fullHouse;
		tempScore += smallStraight;
		tempScore += largeStraight;
		tempScore += chance;
		tempScore += yahtzee;
		return tempScore;
	}
	
	/** Gets score of upper and lower sections
	 * @return tempScore Cummulative score of all values */
	public int calculateScore()
	{
		//TODO: Utilize other two methods to condense
		int tempScore = 0;
		tempScore += upperScores[0];
		tempScore += upperScores[1];
		tempScore += upperScores[2];
		tempScore += upperScores[3];
		tempScore += upperScores[4];
		tempScore += upperScores[5];
		
		if(tempScore >= 63) 
			{ tempScore += 35; } 
		
		tempScore += threeOfKind;
		tempScore += fourOfKind;
		tempScore += fullHouse;
		tempScore += smallStraight;
		tempScore += largeStraight;
		tempScore += chance;
		tempScore += yahtzee;
		
		return tempScore;
	}
	
	/** Sets turn counter to keep track of rolls and
	 * calls finalScore screen when cycleCounter = 13*/
	public static void setTurnCounter()
	{
		if(cycleCounter > 12)
		{
			YahtzeeFrame.f.getContentPane().removeAll();
			YahtzeeFrame.f.repaint();
			YahtzeeFrame.finalScore();
		}
		else
		{
			turnCounter++; //turnOne() = 1, turnTwo() = 2
			
			switch(turnCounter)
			{
				case 3:
					YahtzeeFrame.scoreCard();
					break;
				case 2:
					YahtzeeFrame.turnTwo();
					break;
				case 1:
					YahtzeeFrame.turnOne();
					break;
			}
		}
	}
	
	/** Sets number of players and adds them to the players array
	 * @param num Number of players selected from menuScreen */
	public static void setPlayers(int num)
	{ 
		numOfPlayers = num; 
		for(int x = 0; x < numOfPlayers; x++)
		{
			players.add(new YahtzeeData());
		}
	}
	
	/** Switched players and updates cycle counter after last players
	 * turn in order to keep track of when all boxes are scored*/
	public static void switchPlayers()
	{
		switch(currentPlayer)
		{
			case 0: 
				if(numOfPlayers > 1)
					{ currentPlayer++; }
				else 
				{ 
					currentPlayer = 0;
					cycleCounter++;
				}
				turnCounter = 0;
				break;
			case 1:
				if(numOfPlayers > 2) 
					{ currentPlayer++;}
				else 
				{
					currentPlayer = 0;
					cycleCounter++;
				}
				turnCounter = 0;
				break;
			case 2:
				if(numOfPlayers > 3) 
					{ currentPlayer++; }
				else 
				{ 
					currentPlayer = 0; 
					cycleCounter++;
				}
				turnCounter = 0;
				break;
			case 3:
				currentPlayer = 0;
				cycleCounter++;
				turnCounter = 0;
				break;
		}
		
		if(currentPlayer == 0)
		{ YahtzeeContent.playerLabel.setIcon(new ImageIcon("C:/Users/laxmo/OneDrive/Documents/GitHub/Yahtzee/res/1Label.png")); }
		else if(currentPlayer == 1)
		{ YahtzeeContent.playerLabel.setIcon(new ImageIcon("C:/Users/laxmo/OneDrive/Documents/GitHub/Yahtzee/res/2Label.png")); }
		else if(currentPlayer == 2)
		{ YahtzeeContent.playerLabel.setIcon(new ImageIcon("C:/Users/laxmo/OneDrive/Documents/GitHub/Yahtzee/res/3Label.png")); }
		else if(currentPlayer == 3)
		{ YahtzeeContent.playerLabel.setIcon(new ImageIcon("C:/Users/laxmo/OneDrive/Documents/GitHub/Yahtzee/res/4Label.png")); }
		
	}

}

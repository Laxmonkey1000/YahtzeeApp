import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/** Holds values for players array data and checks certain boxes
 * score values using dice array and confirms user actions for scoring
 * @author Holt, Mary */
public class YahtzeeData 
{
	/** Stores the number of players 1-4 */
	public static int numOfPlayers;
	
	/** Counter for which player is currently rolling */
	public static byte currentPlayer;
	
	/** Counter for number of complete turn cycles 0-13 */
	public static byte cycleCounter;
	
	/** Counter for number of rolls, used to call specific methods */
	public static byte turnCounter = 0;
	
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
		int length = YahtzeeDice.dice.length;
		int sides = YahtzeeDice.sidesNum;
		for(int x = 1; x < sides + 1; x++)
		{
			for(int i = 0; i < length; i++)
			{
				if(x == YahtzeeDice.dice[i]) 
				{ 
					sameCounter++;
				}
			}
			if(sameCounter >= num) 
			{
				for(int i = 0; i < length; i++)
				{
					score += YahtzeeDice.dice[i];
				}
				return score;
			}
			
			sameCounter = 0;
		}

		return 0;
	}
	
	/** Checks if there is a fullHouse and returns score
	 * for fullHouse box based on dice[] array
	 * @return 25: FullHouse present 0: no FullHouse
	 */
	public static int checkFullHouse()
	{
		byte
		countOne = 0,
		countTwo = 0,
		countThree = 0,
		countFour = 0,
		countFive = 0,
		countSix = 0;
		
		int length = YahtzeeDice.dice.length;
		int sides = YahtzeeDice.sidesNum;
		
		for(int x = 1; x < sides + 1; x++)
		{
			for(int i = 0; i < length; i++)
			{
				switch(x)
				{
					case 1:
						if(YahtzeeDice.dice[i] == 1)
							countOne++;
						break;
					case 2:
						if(YahtzeeDice.dice[i] == 2)
							countTwo++;
						break;
					case 3:
						if(YahtzeeDice.dice[i] == 3)
							countThree++;
						break;
					case 4:
						if(YahtzeeDice.dice[i] == 4)
							countFour++;
						break;
					case 5:
						if(YahtzeeDice.dice[i] == 5)
							countFive++;
						break;
					case 6:
						if(YahtzeeDice.dice[i] == 6)
							countSix++;
						break;
				}
			}
		}
		
	if(countOne == 3 || countTwo == 3 || countThree == 3 || countFour == 3 || countFive == 3 || countSix == 3)
	{
		if(countOne == 2 || countTwo == 2 || countThree == 2 || countFour == 2 || countFive == 2 || countSix == 2)
		{
			return 25;
		}
	}
		return 0;
	}
	
	/** Checks if there is a 4 or 5 die straight and returns
	 * appropriate score based on dice[] array
	 * @param num 4: smallStraight, 5: largeStraight
	 * @return 30: smallStraight 40: largeStraight 0: none
	 */
	public static int checkStraight(int num)
	{
		YahtzeeDice.sortDice();
		byte counter = 0;
		int length = YahtzeeDice.dice.length;
		
		try
		{
			for(int x = 0; x < length; x++)
			{
				if(counter == num-1)
				{ 
					if(num == 4) { return 30; }
					else if(num == 5) { return 40; }
				}
				if(YahtzeeDice.dice[x] + 1 == YahtzeeDice.dice[(x+1)])
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
		{
			return 0;
		}
		
		return 0;
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
		int length = YahtzeeDice.dice.length;
		int sides = YahtzeeDice.sidesNum;
		
		byte counter = 0;
		for(int x = 0; x < sides + 1; x++)
		{
			for(int i = 0; i < length; i++)
			{
				if(YahtzeeDice.dice[i] == x) 
				{ 
					counter++; 
				}
			}
			if(counter == 5)
			{ 
				return 50;
			}
			else 
			{ 
				counter = 0; 
			}
		}
		
		return 0;
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
		//TODO: MAKE DIFFERENT COLORS FOR SCORED VS UNSCORED
		//TODO: Condense....
		
		JLabel one = new JLabel(Integer.toString(players.get(currentPlayer).upperScores[0]));
		one.setBounds(285, -5, 50, 50);
		one.setFont(one.getFont().deriveFont(32.0f));
		YahtzeeFrame.f.add(one);
		JLabel two = new JLabel(Integer.toString(players.get(currentPlayer).upperScores[1]));
		two.setBounds(285,30, 50, 50);
		two.setFont(two.getFont().deriveFont(32.0f));
		YahtzeeFrame.f.add(two);
		JLabel three = new JLabel(Integer.toString(players.get(currentPlayer).upperScores[2]));
		three.setBounds(285, 65, 50, 50);
		three.setFont(three.getFont().deriveFont(32.0f));
		YahtzeeFrame.f.add(three);
		JLabel four = new JLabel(Integer.toString(players.get(currentPlayer).upperScores[3]));
		four.setBounds(285, 100, 50, 50);
		four.setFont(four.getFont().deriveFont(32.0f));
		YahtzeeFrame.f.add(four);
		JLabel five = new JLabel(Integer.toString(players.get(currentPlayer).upperScores[4]));
		five.setBounds(285, 135, 50, 50);
		five.setFont(five.getFont().deriveFont(32.0f));
		YahtzeeFrame.f.add(five);
		JLabel six = new JLabel(Integer.toString(players.get(currentPlayer).upperScores[5]));
		six.setBounds(285, 170, 50, 50);
		six.setFont(six.getFont().deriveFont(32.0f));
		YahtzeeFrame.f.add(six);
		JLabel totalUp = new JLabel(Integer.toString(players.get(currentPlayer).getUpScore()));
		totalUp.setBounds(285, 260, 50, 50);
		totalUp.setFont(totalUp.getFont().deriveFont(32.0f));
		YahtzeeFrame.f.add(totalUp);
		
		JLabel threeKind = new JLabel(Integer.toString(players.get(currentPlayer).threeOfKind));
		threeKind.setBounds(285, 340, 50, 50);
		threeKind.setFont(threeKind.getFont().deriveFont(32.0f));
		YahtzeeFrame.f.add(threeKind);
		JLabel fourKind = new JLabel(Integer.toString(players.get(currentPlayer).fourOfKind));
		fourKind.setBounds(285, 375, 50, 50);
		fourKind.setFont(fourKind.getFont().deriveFont(32.0f));
		YahtzeeFrame.f.add(fourKind);
		JLabel fullHouse = new JLabel(Integer.toString(players.get(currentPlayer).fullHouse));
		fullHouse.setBounds(285, 410, 50, 50);
		fullHouse.setFont(fullHouse.getFont().deriveFont(32.0f));
		YahtzeeFrame.f.add(fullHouse);
		JLabel smStraight = new JLabel(Integer.toString(players.get(currentPlayer).smallStraight));
		smStraight.setBounds(285, 445, 50, 50);
		smStraight.setFont(smStraight.getFont().deriveFont(32.0f));
		YahtzeeFrame.f.add(smStraight);
		JLabel lgStraight = new JLabel(Integer.toString(players.get(currentPlayer).largeStraight));
		lgStraight.setBounds(285, 480, 50, 50);
		lgStraight.setFont(lgStraight.getFont().deriveFont(32.0f));
		YahtzeeFrame.f.add(lgStraight);
		JLabel yahtzee = new JLabel(Integer.toString(players.get(currentPlayer).yahtzee));
		yahtzee.setBounds(285, 515, 50, 50);
		yahtzee.setFont(yahtzee.getFont().deriveFont(32.0f));
		YahtzeeFrame.f.add(yahtzee);
		JLabel chance = new JLabel(Integer.toString(players.get(currentPlayer).chance));
		chance.setBounds(285, 550, 50, 50);
		chance.setFont(chance.getFont().deriveFont(32.0f));
		YahtzeeFrame.f.add(chance);
		JLabel totalLow = new JLabel(Integer.toString(players.get(currentPlayer).getLowScore()));
		totalLow.setBounds(285, 580, 50, 50);
		totalLow.setFont(totalLow.getFont().deriveFont(32.0f));
		YahtzeeFrame.f.add(totalLow);
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
		
		if(tempScore >= 63) 
			{ tempScore += 35; } 
		
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
			turnCounter++; 
			
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
		
		YahtzeeContent.playerLabel.setText(Integer.toString(currentPlayer + 1));
	}
}

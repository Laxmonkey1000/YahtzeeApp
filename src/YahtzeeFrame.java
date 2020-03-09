import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/** Class which calls different methods and extends YahtzeeContent
 * for easy access to labels and buttons
 * @author Holt, Mary */
public class YahtzeeFrame extends YahtzeeContent implements ActionListener
{
	/** Frame named f used for adding and deleting components for display.
	 */
	public static JFrame f = new JFrame();
	
	public static boolean confirm;
	public static boolean backToggle;
	
	/** Used to call constructors and begin menu Seqeuence
	 * @param args Unused */
	public static void main(String[] args)
	{	
		new YahtzeeContent();
		new YahtzeeDice();
		new YahtzeeFrame();
	}
	
	/** Creates the frame and sets the size, used when needed to
	 * reload/create the frame. */
	public static void Frame()
	{
		f = new JFrame("Yahtzee");
		f.setSize(900, 700);
		f.setVisible(true);
		f.setLayout(null);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	/** Creates the frame and adds 4 player buttons */
	YahtzeeFrame()
	{
		Frame();
		f.add(onePlayer);
		f.add(twoPlayer);
		f.add(threePlayer);
		f.add(fourPlayer);
		f.add(menuBackground);
	}
	
	/** Adds everthing for turn one: score/roll buttons,
	 * calls dice display method, and adds labels */
	public static void turnOne()
	{	
		if(backToggle == false)
		{
			YahtzeeDice.rollAllDie();
		}	
		YahtzeeDice.displayDice();
		backToggle = false;
		
		for(int x = 0; x < diceSelectors.length; x++)
		{
			diceSelectors[x].setSelected(false);
		}
		
		scoreButton.setBounds(450, 500, 300, 100);
		playerText.setBounds(0, 25, 300, 50);
		playerLabel.setBounds(275,25,50,50);
		rollLabel.setBounds(500, 25, 150, 50);
		xIcon1.setBounds(650,25,50,50);
		f.add(rollLabel);
		f.add(xIcon1);
		f.add(turnLabel);
		f.add(playerLabel);
		f.add(playerText);
		f.add(reRoll);
		f.add(scoreButton);
		f.add(tableBackground);
	}
	
	/** Adds everthing for turn two: score/roll buttons,
	 * calls dice display method, and adds labels */
	public static void turnTwo()
	{
		YahtzeeDice.displayDice();
		playerText.setBounds(0, 25, 300, 50);
		playerLabel.setBounds(275,25,50,50);
		rollLabel.setBounds(500, 25, 150, 50);
		xIcon1.setBounds(650,25,50,50);
		xIcon2.setBounds(700,25,50,50);
		f.add(rollLabel);
		f.add(xIcon1);
		f.add(xIcon2);
		f.add(turnLabel);
		f.add(playerLabel);
		f.add(playerText);
		f.add(reRoll);
		f.add(scoreButton);
		
		if(diceSelectors[0].isSelected())
			{ f.add(die1); }
		if(diceSelectors[1].isSelected())
			{ f.add(die2); }
		if(diceSelectors[2].isSelected())
			{ f.add(die3); }
		if(diceSelectors[3].isSelected())
			{ f.add(die4); }
		if(diceSelectors[4].isSelected())
			{ f.add(die5); }
		
		f.add(tableBackground);
	}
	
	/** Adds score menu and current values for currentPlayer
	 * data, displays current die rolls, and displays available
	 * scoring boxes*/
	public static void scoreCard()
	{
		YahtzeeDice.displayScoreDie();
		YahtzeeData.displayScoreBox();
		f.validate();
		f.repaint();
		YahtzeeData.displayScores();
		playerLabel.setBounds(600, 15, 150, 50);
		playerText.setBounds(325, 15, 300, 50);
		rollLabel.setBounds(375, 575, 150, 50);
		xIcon1.setBounds(525, 575, 50, 50);
		xIcon2.setBounds(575, 575, 50, 50);
		
		switch(YahtzeeData.turnCounter)
		{
			case 3:
				f.add(xIcon3);
			case 2:
				f.add(xIcon2);
			case 1:
				f.add(xIcon1);
		}
		
		if(YahtzeeData.turnCounter < 3)
			{ f.add(backButton); }
		
		f.add(rollLabel);
		f.add(playerLabel);
		f.add(playerText);
		f.add(scoreCard);
		f.add(tableBackground);
	}
	
	/** Displays final scores for each player on the screen */
	public static void finalScore()
	{
		//TODO: DO FINAL SCORES DISPLAY MECH.
		switch(YahtzeeData.numOfPlayers)
		{
			case 4:
				JLabel p4Score = new JLabel(Integer.toString(YahtzeeData.players.get(3).calculateScore()));
				p4Score.setFont(p4Score.getFont().deriveFont(32.0f));
				p4Score.setBounds(600, 445, 500, 100);
				f.add(p4Score);
				f.add(p4ScoreLabel);
			case 3:
				JLabel p3Score = new JLabel(Integer.toString(YahtzeeData.players.get(2).calculateScore()));
				p3Score.setFont(p3Score.getFont().deriveFont(32.0f));
				p3Score.setBounds(600, 345, 500, 100);
				f.add(p3Score);
				f.add(p3ScoreLabel);
			case 2:
				JLabel p2Score = new JLabel(Integer.toString(YahtzeeData.players.get(1).calculateScore()));
				p2Score.setFont(p2Score.getFont().deriveFont(32.0f));
				p2Score.setBounds(600, 245, 500, 100);
				f.add(p2Score);
				f.add(p2ScoreLabel);
			case 1:
				JLabel p1Score = new JLabel(Integer.toString(YahtzeeData.players.get(0).calculateScore()));
				p1Score.setFont(p1Score.getFont().deriveFont(32.0f));
				p1Score.setBounds(600, 145, 500, 100);
				f.add(p1Score);
				f.add(p1ScoreLabel);
		}
		
		f.add(finalScores);
		f.add(tableBackground);
	}

	@Override
	/** Used to call other methods depending on action value 
	 * @param action Used to determine which button was pressed */
	public void actionPerformed(ActionEvent action) 
	{
		String command = action.getActionCommand();
		//TODO: Condense into a function?
		
		switch(command)
		{
			case "0":
			{
				System.out.println("0");
				if(diceSelectors[0].isSelected())
				{
					f.remove(tableBackground);
					f.validate();
					f.repaint();
					f.add(die1);
					f.add(tableBackground);
				}
				else
				{
					f.remove(die1);
					f.validate();
					f.repaint();
				}
			}
			break;
			
			case "1":
			{
				if(diceSelectors[1].isSelected())
				{
					f.remove(tableBackground);
					f.validate();
					f.repaint();
					f.add(die2);
					f.add(tableBackground);
				}
				else
				{
					f.remove(die2);
					f.validate();
					f.repaint();
				}
			}
			break;
			
			case "2":
			{
				if(diceSelectors[2].isSelected())
				{
					f.remove(tableBackground);
					f.validate();
					f.repaint();
					f.add(die3);
					f.add(tableBackground);
				}
				else
				{
					f.remove(die3);
					f.validate();
					f.repaint();
				}
			}
			break;
			
			case "3":
			{
				if(diceSelectors[3].isSelected())
				{
					f.remove(tableBackground);
					f.validate();
					f.repaint();
					f.add(die4);
					f.add(tableBackground);
				}
				else
				{
					f.remove(die4);
					f.validate();
					f.repaint();
				}
			}
			break;
			
			case "4":
			{
				if(diceSelectors[4].isSelected())
				{
					f.remove(tableBackground);
					f.validate();
					f.repaint();
					f.add(die5);
					f.add(tableBackground);
				}
				else
				{
					f.remove(die5);
					f.validate();
					f.repaint();
				}
			}
			break;
			
			case "oneBox":
				{
					int score = YahtzeeData.checkScoreUpper(1);
					confirm = YahtzeeData.confirmBox(score, "ONES");
					if(confirm == true) 
					{ 
						YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScored[0] = true;
						YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScores[0] = score;
					}	
				}
			break;
			
			case "twoBox":
				{
					int score = YahtzeeData.checkScoreUpper(2);
					confirm = YahtzeeData.confirmBox(score, "TWOS");
					if(confirm)
					{
						YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScored[1] = true;
						YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScores[1] = score;			}
				}
				break;
				
			case "threeBox":
				{
					int score = YahtzeeData.checkScoreUpper(3);
					confirm = YahtzeeData.confirmBox(score, "THREES");
					if(confirm)
					{
						YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScored[2] = true;
						YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScores[2] = score;
					}
				}
				break;
				
			case "fourBox":
				{
					int score = YahtzeeData.checkScoreUpper(4);
					confirm = YahtzeeData.confirmBox(score, "FOURS");
					if(confirm)
					{
						YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScored[3] = true;
						YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScores[3] = score;
					}
				}
				break;
			
			case "fiveBox":
				{
					int score = YahtzeeData.checkScoreUpper(5);
					confirm = YahtzeeData.confirmBox(score, "FIVES");
					if(confirm)
					{
						YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScored[4] = true;
						YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScores[4] = score;
					}
				}
				break;
			
			case "sixBox":
				{
					int score = YahtzeeData.checkScoreUpper(6);
					confirm = YahtzeeData.confirmBox(score, "SIXES");
					if(confirm)
					{
						YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScored[5] = true;
						YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScores[5] = score;
					}
				}
				break;
				
			case "threeOfKind":
				{
					int score = YahtzeeData.checkNumOfKind(3);
					confirm = YahtzeeData.confirmBox(score, "3 of a Kind");
					if(confirm)
					{
						YahtzeeData.players.get(YahtzeeData.currentPlayer).threeOfKindScored = true;
						YahtzeeData.players.get(YahtzeeData.currentPlayer).threeOfKind = score;
					}
				}
				break;
				
			case "fourOfKind":
				{
					int score = YahtzeeData.checkNumOfKind(4);
					confirm = YahtzeeData.confirmBox(score, "4 of a Kind");
					if(confirm)
					{
						YahtzeeData.players.get(YahtzeeData.currentPlayer).fourOfKindScored = true;
						YahtzeeData.players.get(YahtzeeData.currentPlayer).fourOfKind = score;
					}
				}
			break;
			
			case "fullHouse":
				{
					int score = YahtzeeData.checkFullHouse();
					confirm = YahtzeeData.confirmBox(score, "Full House");
					if(confirm)
					{
						YahtzeeData.players.get(YahtzeeData.currentPlayer).fullHouseScored = true;
						YahtzeeData.players.get(YahtzeeData.currentPlayer).fullHouse = score;
					}
				}
				break;
				
			case "smallStraight":
				{
					int score = YahtzeeData.checkStraight(4);
					confirm = YahtzeeData.confirmBox(score, "Small Straight");
					if(confirm)
					{
						YahtzeeData.players.get(YahtzeeData.currentPlayer).smallStraightScored = true;
						YahtzeeData.players.get(YahtzeeData.currentPlayer).smallStraight = score;
					}
				}
				break;
			
			case "largeStraight":
				{
					int score = YahtzeeData.checkStraight(5);
					confirm = YahtzeeData.confirmBox(score,  "Large Straight");
					if(confirm)
					{
						YahtzeeData.players.get(YahtzeeData.currentPlayer).largeStraightScored = true;
						YahtzeeData.players.get(YahtzeeData.currentPlayer).largeStraight = score;
					}
				}
			break;
			
			case "chance":
				{
					int score = YahtzeeData.checkChance();
					confirm = YahtzeeData.confirmBox(score, "Chance");
					if(confirm)
					{
						YahtzeeData.players.get(YahtzeeData.currentPlayer).chanceScored = true;
						YahtzeeData.players.get(YahtzeeData.currentPlayer).chance = score;
					}
				}
				break;
			
			case "yahtzee":
				{
					int score = YahtzeeData.checkYahtzee();
					confirm = YahtzeeData.confirmBox(score, "Yahtzee");
					if(confirm)
					{
						YahtzeeData.players.get(YahtzeeData.currentPlayer).yahtzeeScored = true;
						YahtzeeData.players.get(YahtzeeData.currentPlayer).yahtzee = score;
					}
				}
				break;
				
			case "reRoll":
				{		
					f.getContentPane().removeAll();
					f.repaint();
					
					//TODO: Do in for each loop?
					
					for(int x = 0; x < diceSelectors.length; x++)
					{
						if(diceSelectors[x].isSelected() == false)
						{
							YahtzeeDice.rollSingleDie(x);
						}
					}
					YahtzeeData.setTurnCounter();
				}
				break;
				
			case "scoreButton":
				{
					f.getContentPane().removeAll();
					scoreCard();
				}
				break;
			
			case "backButton":
				{
					backToggle = true;
					f.getContentPane().removeAll();
					f.repaint();
					if(YahtzeeData.turnCounter == 1)
						{ turnOne(); }
					else
						{ turnTwo(); }
				}
				break;
				
			case "onePlayer":
				{
					YahtzeeData.setPlayers(1);
				}
				break;
				
			case "twoPlayer":
				{
					YahtzeeData.setPlayers(2);
				}
				break;
				
			case "threePlayer":
				{
					YahtzeeData.setPlayers(3);
				}
				break;
			
			case "fourPlayer":
				{
					YahtzeeData.setPlayers(4);
				}
				break;
				
			default:
				 break;
		}
		
		if(command == "onePlayer" || command == "twoPlayer" 
				|| command == "threePlayer" || command == "fourPlayer")
				{
					f.getContentPane().removeAll();
					f.repaint();
					YahtzeeData.setTurnCounter();
				}
		else if(command == "oneBox" || command == "twoBox" || command == "threeBox" || command == "fourBox" 
				|| command == "fiveBox" || command == "sixBox" || command == "threeOfKind" || command == "fourOfKind" 
				|| command == "fullHouse" || command == "smallStraight" || command == "largeStraight" || command == "chance"
				|| command == "yahtzee")
		{
			
			if(confirm)
			{
				f.getContentPane().removeAll();
				f.repaint();
				YahtzeeData.switchPlayers();
				YahtzeeData.setTurnCounter();
			}
		}
		
	}
	
}

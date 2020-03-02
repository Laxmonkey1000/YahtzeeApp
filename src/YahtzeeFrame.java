import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
	
	/** Creates the frame and adds number of player buttons */
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
		YahtzeeDice.rollAllDie();
		YahtzeeDice.displayDice();
		
		for(int x = 0; x < diceSelectors.length; x++)
		{
			diceSelectors[x].setSelected(false);
		}
		
		scoreButton.setBounds(450, 500, 300, 100);
		playerText.setBounds(25, 25, 250, 50);
		playerLabel.setBounds(225,25,50,50);
		xIcon1.setBounds(700,50,50,50);
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
		xIcon2.setBounds(750,50,50,50);
		f.add(xIcon1);
		f.add(xIcon2);
		f.add(turnLabel);
		f.add(playerLabel);
		f.add(playerText);
		f.add(reRoll);
		f.add(scoreButton);
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
		playerLabel.setBounds(575, 15, 50, 50);
		playerText.setBounds(375, 15, 300, 50);
		xIcon1.setBounds(700, 10, 50, 50);
		xIcon2.setBounds(750, 10, 50, 50);
		
		switch(YahtzeeData.turnCounter)
		{
			case 3:
				f.add(xIcon3);
			case 2:
				f.add(xIcon2);
			case 1:
				f.add(xIcon1);
		}
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
			int p4Score = YahtzeeData.players.get(3).calculateScore();
			JLabel p4Label = new JLabel("Player 4 Score is: " + p4Score);
			p4Label.setFont(p4Label.getFont().deriveFont(32.0f));
			p4Label.setBounds(300, 350, 500, 100);
			f.add(p4Label);
		case 3:
			int p3Score = YahtzeeData.players.get(2).calculateScore();
			JLabel p3Label = new JLabel("Player 3 Score is: " + p3Score);
			p3Label.setFont(p3Label.getFont().deriveFont(32.0f));
			p3Label.setBounds(300, 250, 500, 100);
			f.add(p3Label);
		case 2:
			int p2Score = YahtzeeData.players.get(1).calculateScore();
			JLabel p2Label = new JLabel("Player 2 Score is: " + p2Score);
			p2Label.setFont(p2Label.getFont().deriveFont(32.0f));
			p2Label.setBounds(300, 150, 500, 100);
			f.add(p2Label);
		case 1:
			int p1Score = YahtzeeData.players.get(0).calculateScore();
			JLabel p1Label = new JLabel("Player 1 Score is: " + p1Score);
			p1Label.setFont(p1Label.getFont().deriveFont(32.0f));
			p1Label.setBounds(300, 50, 500, 100);
			f.add(p1Label);
		}
	
		f.add(tableBackground);
	}

	@Override
	/** Used to call other methods depending on action value 
	 * @param action Used to determine which button was pressed */
	public void actionPerformed(ActionEvent action) 
	{
		String command = action.getActionCommand();
		//TODO: Condense into a function?
		
		if(command == "oneBox")
		{
			int score = YahtzeeData.checkScoreUpper(1);
			boolean confirm = YahtzeeData.confirmBox(score, "ONES");
			if(confirm == true) 
			{ 
				YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScored[0] = true;
				YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScores[0] = score;
				f.getContentPane().removeAll();
				f.repaint();
				YahtzeeData.switchPlayers();
				YahtzeeData.setTurnCounter();
			}	
		}
		else if(command == "twoBox")
		{
			int score = YahtzeeData.checkScoreUpper(2);
			boolean confirm = YahtzeeData.confirmBox(score, "TWOS");
			if(confirm)
			{
				YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScored[1] = true;
				YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScores[1] = score;
				f.getContentPane().removeAll();
				f.repaint();
				YahtzeeData.switchPlayers();
				YahtzeeData.setTurnCounter();
			}
		}
		else if(command == "threeBox")
		{
			int score = YahtzeeData.checkScoreUpper(3);
			boolean confirm = YahtzeeData.confirmBox(score, "THREES");
			if(confirm)
			{
				YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScored[2] = true;
				YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScores[2] = score;
				f.getContentPane().removeAll();
				f.repaint();
				YahtzeeData.switchPlayers();
				YahtzeeData.setTurnCounter();
			}
		}
		else if(command == "fourBox")
		{
			int score = YahtzeeData.checkScoreUpper(4);
			boolean confirm = YahtzeeData.confirmBox(score, "FOURS");
			if(confirm)
			{
				YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScored[3] = true;
				YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScores[3] = score;
				f.getContentPane().removeAll();
				f.repaint();
				YahtzeeData.switchPlayers();
				YahtzeeData.setTurnCounter();
			}
		}
		else if(command == "fiveBox")
		{
			int score = YahtzeeData.checkScoreUpper(5);
			boolean confirm = YahtzeeData.confirmBox(score, "FIVES");
			if(confirm)
			{
				YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScored[4] = true;
				YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScores[4] = score;
				f.getContentPane().removeAll();
				f.repaint();
				YahtzeeData.switchPlayers();
				YahtzeeData.setTurnCounter();
			}
		}
		else if(command == "sixBox")
		{
			int score = YahtzeeData.checkScoreUpper(6);
			boolean confirm = YahtzeeData.confirmBox(score, "SIXES");
			if(confirm)
			{
				YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScored[5] = true;
				YahtzeeData.players.get(YahtzeeData.currentPlayer).upperScores[5] = score;
				f.getContentPane().removeAll();
				f.repaint();
				YahtzeeData.switchPlayers();
				YahtzeeData.setTurnCounter();
			}
		}
		else if(command == "threeOfKind")
		{
			int score = YahtzeeData.checkNumOfKind(3);
			boolean confirm = YahtzeeData.confirmBox(score, "3 of a Kind");
			if(confirm)
			{
				YahtzeeData.players.get(YahtzeeData.currentPlayer).threeOfKindScored = true;
				YahtzeeData.players.get(YahtzeeData.currentPlayer).threeOfKind = score;
				f.getContentPane().removeAll();
				f.repaint();
				YahtzeeData.switchPlayers();
				YahtzeeData.setTurnCounter();
			}
		}
		else if(command == "fourOfKind")
		{
			int score = YahtzeeData.checkNumOfKind(4);
			boolean confirm = YahtzeeData.confirmBox(score, "4 of a Kind");
			if(confirm)
			{
				YahtzeeData.players.get(YahtzeeData.currentPlayer).fourOfKindScored = true;
				YahtzeeData.players.get(YahtzeeData.currentPlayer).fourOfKind = score;
				f.getContentPane().removeAll();
				f.repaint();
				YahtzeeData.switchPlayers();
				YahtzeeData.setTurnCounter();
			}
		}
		else if(command == "fullHouse")
		{
			int score = YahtzeeData.checkFullHouse();
			boolean confirm = YahtzeeData.confirmBox(score, "Full House");
			if(confirm)
			{
				YahtzeeData.players.get(YahtzeeData.currentPlayer).fullHouseScored = true;
				YahtzeeData.players.get(YahtzeeData.currentPlayer).fullHouse = score;
				f.getContentPane().removeAll();
				f.repaint();
				YahtzeeData.switchPlayers();
				YahtzeeData.setTurnCounter();
			}
		}
		else if(command == "smallStraight")
		{
			int score = YahtzeeData.checkStraight(4);
			boolean confirm = YahtzeeData.confirmBox(score, "Small Straight");
			if(confirm)
			{
				YahtzeeData.players.get(YahtzeeData.currentPlayer).smallStraightScored = true;
				YahtzeeData.players.get(YahtzeeData.currentPlayer).smallStraight = score;
				f.getContentPane().removeAll();
				f.repaint();
				YahtzeeData.switchPlayers();
				YahtzeeData.setTurnCounter();
			}
		}
		else if(command == "largeStraight")
		{
			int score = YahtzeeData.checkStraight(5);
			boolean confirm = YahtzeeData.confirmBox(score,  "Large Straight");
			if(confirm)
			{
				YahtzeeData.players.get(YahtzeeData.currentPlayer).largeStraightScored = true;
				YahtzeeData.players.get(YahtzeeData.currentPlayer).largeStraight = score;
				f.getContentPane().removeAll();
				f.repaint();
				YahtzeeData.switchPlayers();
				YahtzeeData.setTurnCounter();
			}
		}
		else if(command == "chance")
		{
			int score = YahtzeeData.checkChance();
			boolean confirm = YahtzeeData.confirmBox(score, "Chance");
			if(confirm)
			{
				YahtzeeData.players.get(YahtzeeData.currentPlayer).chanceScored = true;
				YahtzeeData.players.get(YahtzeeData.currentPlayer).chance = score;
				f.getContentPane().removeAll();
				f.repaint();
				YahtzeeData.switchPlayers();
				YahtzeeData.setTurnCounter();
			}
		}
		else if(command == "yahtzee")
		{
			int score = YahtzeeData.checkYahtzee();
			boolean confirm = YahtzeeData.confirmBox(score, "Yahtzee");
			if(confirm)
			{
				YahtzeeData.players.get(YahtzeeData.currentPlayer).yahtzeeScored = true;
				YahtzeeData.players.get(YahtzeeData.currentPlayer).yahtzee = score;
				f.getContentPane().removeAll();
				f.repaint();
				YahtzeeData.switchPlayers();
				YahtzeeData.setTurnCounter();
			}
		}
		if(command == "reRoll")
		{
			f.getContentPane().removeAll();
			f.repaint();
			
			for(int x = 0; x < diceSelectors.length; x++)
			{
				if(diceSelectors[x].isSelected() == false)
				{
					YahtzeeDice.rollSingleDie(x);
				}
			}
			YahtzeeData.setTurnCounter();
		}
		else if(command == "scoreButton")
		{
			f.getContentPane().removeAll();
			f.repaint();
			scoreCard();
		}
		else if(command == "onePlayer")
		{
			f.getContentPane().removeAll();
			f.repaint();
			YahtzeeData.setPlayers(1);
			YahtzeeData.setTurnCounter();
		}
		else if(command == "twoPlayer")
		{
			f.getContentPane().removeAll();
			f.repaint();
			YahtzeeData.setPlayers(2);
			YahtzeeData.setTurnCounter();
		}
		else if(command == "threePlayer")
		{
			f.getContentPane().removeAll();
			f.repaint();
			YahtzeeData.setPlayers(3);
			YahtzeeData.setTurnCounter();
		}
		else if(command == "fourPlayer")
		{
			f.getContentPane().removeAll();
			f.repaint();
			YahtzeeData.setPlayers(4);
			YahtzeeData.setTurnCounter();
		}
	}
	
}

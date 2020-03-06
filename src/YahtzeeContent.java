import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

/** Holds images and paramaters of JLables and Buttons
 * @author Holt, Mary */
public class YahtzeeContent implements ActionListener
{
	/** JCheckBox array used to determine which die to roll */
	public static JCheckBox[] diceSelectors = new JCheckBox[5];
	
	static JButton
	/** Transfers from score screen to roll */
	backButton = new JButton(),
	/** If selected, numOfPlayers is set to 1 */
	onePlayer = new JButton(),
	/** If selected, numOfPlayers is set to 2 */
	twoPlayer = new JButton(),
	/** If selected, numOfPlayers is set to 3 */
	threePlayer = new JButton(),
	/** If selected, numOfPlayers is set to 4 */
	fourPlayer = new JButton(),
	/** If selected, certain dice are rolled */
	reRoll = new JButton(),
	/** Used to transfer to score screen */
	scoreButton = new JButton(),
	/** Used to score box ones */
	oneBox = new JButton(),
	/** Used to score box twos */
	twoBox = new JButton(),
	/** Used to score box threes */
	threeBox = new JButton(),
	/** Used to score box fours */
	fourBox = new JButton(),
	/** Used to score box fives */
	fiveBox = new JButton(),
	/** Used to score box sixes */
	sixBox = new JButton(),
	/** Used to score box three of a kind */
	threeOfKind = new JButton(),
	/** Used to score box four of a kind */
	fourOfKind = new JButton(),
	/**Used to score box full House */
	fullHouse = new JButton(),
	/** Used to score box small Straight */
	smallStraight = new JButton(),
	/** Used to score box large straight */
	largeStraight = new JButton(),
	/** Used to score box chance */
	chance = new JButton(),
	/** Used to score box  yahtzee */
	yahtzee = new JButton();
	
	static JLabel
	die1 = new JLabel(),
	die2 = new JLabel(),
	die3 = new JLabel(),
	die4 = new JLabel(),
	die5 = new JLabel(),
	finalScores = new JLabel(),
	p1ScoreLabel = new JLabel(),
	p2ScoreLabel = new JLabel(),
	p3ScoreLabel = new JLabel(),
	p4ScoreLabel = new JLabel(),
	/** Stores x image for showing turnCounter visually */
	xIcon1 = new JLabel(),
	/** Stores x image for showing turnCounter visually */
	xIcon2 = new JLabel(),
	/** Stores x image for showing turnCounter visually */
	xIcon3 = new JLabel(),
	/** Adds instruction for player on what checkBoxes do */
	turnLabel = new JLabel(),
	/** Adds a turn: Player label to know who is rolling */
	playerText = new JLabel(),
	/** Displays which player is rolling currently */
	playerLabel = new JLabel(),
	rollLabel = new JLabel(),
	/** Image with Yahtzee Menu name and background */
	menuBackground = new JLabel(),
	/** Image with background for visual effects */
	tableBackground = new JLabel(),
	/** Score card layout image for values to appear on */
	scoreCard = new JLabel();
	
	/** Constructor which loads all images and sets paramters */
	YahtzeeContent()
	{
		for(int x = 0; x < diceSelectors.length; x++)
		{
			diceSelectors[x] = new JCheckBox();
			diceSelectors[x].setBounds(140*(x+1), 375, 64, 64);
			diceSelectors[x].setContentAreaFilled(false);
			diceSelectors[x].setBorderPainted(false);
			diceSelectors[x].addActionListener(this);
			diceSelectors[x].setActionCommand(Integer.toString(x));
		}
		
		die1.setIcon(new ImageIcon("H:/git/Yahtzee/res/dieBorder.png"));
		die1.setBounds(138, 373, 68, 68);
		die2.setIcon(new ImageIcon("H:/git/Yahtzee/res/dieBorder.png"));
		die2.setBounds(278, 373, 68, 68);
		die3.setIcon(new ImageIcon("H:/git/Yahtzee/res/dieBorder.png"));
		die3.setBounds(418, 373, 68, 68);
		die4.setIcon(new ImageIcon("H:/git/Yahtzee/res/dieBorder.png"));
		die4.setBounds(558, 373, 68, 68);
		die5.setIcon(new ImageIcon("H:/git/Yahtzee/res/dieBorder.png"));
		die5.setBounds(698, 373, 68, 68);
		
		xIcon1.setIcon(new ImageIcon("H:/git/Yahtzee/res/x.png"));
		xIcon2.setIcon(new ImageIcon("H:/git/Yahtzee/res/x.png"));
		xIcon3.setIcon(new ImageIcon("H:/git/Yahtzee/res/x.png"));
		xIcon3.setBounds(625,575,50,50);
		
		finalScores.setIcon(new ImageIcon("H:/git/Yahtzee/res/finalScoresLabel.png"));
		finalScores.setBounds(150, 50, 600, 50);
		
		p1ScoreLabel.setIcon(new ImageIcon("H:/git/Yahtzee/res/p1ScoreLabel.png"));
		p1ScoreLabel.setBounds(300, 150, 500, 100);
		p2ScoreLabel.setIcon(new ImageIcon("H:/git/Yahtzee/res/p2ScoreLabel.png"));
		p2ScoreLabel.setBounds(300, 250, 500, 100);
		p3ScoreLabel.setIcon(new ImageIcon("H:/git/Yahtzee/res/p3ScoreLabel.png"));
		p3ScoreLabel.setBounds(300, 350, 500, 100);
		p4ScoreLabel.setIcon(new ImageIcon("H:/git/Yahtzee/res/p4ScoreLabel.png"));
		p4ScoreLabel.setBounds(300, 450, 500, 100);
		
		playerText.setIcon(new ImageIcon("H:/git/Yahtzee/res/playerText.png"));
		playerLabel.setIcon(new ImageIcon("H:/git/Yahtzee/res/1Label.png"));
		rollLabel.setIcon(new ImageIcon("H:/git/Yahtzee/res/rollsLabel.png"));
		
		backButton.setIcon(new ImageIcon("H:/git/Yahtzee/res/backButton.png"));
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setBounds(650, 500, 150, 50);
		backButton.addActionListener(this);
		backButton.setActionCommand("backButton");
		
		turnLabel.setIcon(new ImageIcon("H:/git/Yahtzee/res/turnLabel.png"));
		turnLabel.setBounds(0, 0, 900, 700);
		
		onePlayer.setIcon(new ImageIcon("H:/git/Yahtzee/res/playerOne.png"));
		onePlayer.setContentAreaFilled(false);
		onePlayer.setBorderPainted(false); 
		onePlayer.setBounds(125, 400, 128, 128);
		onePlayer.addActionListener(this);
		onePlayer.setActionCommand("onePlayer");
		
		twoPlayer.setIcon(new ImageIcon("H:/git/Yahtzee/res/playerTwo.png"));
		twoPlayer.setContentAreaFilled(false);
		twoPlayer.setBorderPainted(false);
		twoPlayer.setBounds(300, 400, 128, 128);
		twoPlayer.addActionListener(this);
		twoPlayer.setActionCommand("twoPlayer");
		
		threePlayer.setIcon(new ImageIcon("H:/git/Yahtzee/res/playerThree.png"));
		threePlayer.setContentAreaFilled(false);
		threePlayer.setBorderPainted(false);
		threePlayer.setBounds(475, 400, 128, 128);
		threePlayer.addActionListener(this);
		threePlayer.setActionCommand("threePlayer");
		
		fourPlayer.setIcon(new ImageIcon("H:/git/Yahtzee/res/playerFour.png"));
		fourPlayer.setContentAreaFilled(false);
		fourPlayer.setBorderPainted(false);
		fourPlayer.setBounds(650, 400, 128, 128);
		fourPlayer.addActionListener(this);
		fourPlayer.setActionCommand("fourPlayer");
		
		menuBackground.setIcon(new ImageIcon("H:/git/Yahtzee/res/YahtzeeMenu.jpg"));
		menuBackground.setBounds(0, 0, 900, 700);
		menuBackground.setVisible(true);
		
		tableBackground.setIcon(new ImageIcon("H:/git/Yahtzee/res/YahtzeeTable.jpg"));
		tableBackground.setBounds(0,0,900,700);
		tableBackground.setVisible(true);
		
		scoreCard.setIcon(new ImageIcon("H:/git/Yahtzee/res/YahtzeeScoreCard1.jpg"));
		scoreCard.setBounds(0, 0, 331, 700);
		scoreCard.setVisible(true);
		
		reRoll.setIcon(new ImageIcon("H:/git/Yahtzee/res/rollButton.png"));
		reRoll.setContentAreaFilled(false);
		reRoll.setBorderPainted(false);
		reRoll.setBounds(150, 500, 300, 100);
		reRoll.addActionListener(this);
		reRoll.setActionCommand("reRoll");
		
		scoreButton.setIcon(new ImageIcon("H:/git/Yahtzee/res/scoreButton.png"));
		scoreButton.setContentAreaFilled(false);
		scoreButton.setBorderPainted(false);
		scoreButton.addActionListener(this);
		scoreButton.setActionCommand("scoreButton");
		
		oneBox.setIcon(new ImageIcon("H:/git/Yahtzee/res/ones.png"));
		oneBox.setContentAreaFilled(false);
		oneBox.setBorderPainted(false);
		oneBox.setBounds(425, 175, 150, 50);
		oneBox.addActionListener(this);
		oneBox.setActionCommand("oneBox");
		
		twoBox.setIcon(new ImageIcon("H:/git/Yahtzee/res/twos.png"));
		twoBox.setContentAreaFilled(false);
		twoBox.setBorderPainted(false);
		twoBox.setBounds(425, 225, 150, 50);
		twoBox.addActionListener(this);
		twoBox.setActionCommand("twoBox");
		
		threeBox.setIcon(new ImageIcon("H:/git/Yahtzee/res/threes.png"));
		threeBox.setContentAreaFilled(false);
		threeBox.setBorderPainted(false);
		threeBox.setBounds(425, 275, 150, 50);
		threeBox.addActionListener(this);
		threeBox.setActionCommand("threeBox");

		fourBox.setIcon(new ImageIcon("H:/git/Yahtzee/res/fours.png"));
		fourBox.setContentAreaFilled(false);
		fourBox.setBorderPainted(false);
		fourBox.setBounds(650, 175, 150, 50);
		fourBox.addActionListener(this);
		fourBox.setActionCommand("fourBox");
		
		fiveBox.setIcon(new ImageIcon("H:/git/Yahtzee/res/fives.png"));
		fiveBox.setContentAreaFilled(false);
		fiveBox.setBorderPainted(false);
		fiveBox.setBounds(650, 225, 150, 50);
		fiveBox.addActionListener(this);
		fiveBox.setActionCommand("fiveBox");
		
		sixBox.setIcon(new ImageIcon("H:/git/Yahtzee/res/sixes.png"));
		sixBox.setContentAreaFilled(false);
		sixBox.setBorderPainted(false);
		sixBox.setBounds(650, 275, 150, 50);
		sixBox.addActionListener(this);
		sixBox.setActionCommand("sixBox");
		
		threeOfKind.setIcon(new ImageIcon("H:/git/Yahtzee/res/3ofakind.png"));
		threeOfKind.setContentAreaFilled(false);
		threeOfKind.setBorderPainted(false);
		threeOfKind.setBounds(425, 350, 150, 50);
		threeOfKind.addActionListener(this);
		threeOfKind.setActionCommand("threeOfKind");
		
		fourOfKind.setIcon(new ImageIcon("H:/git/Yahtzee/res/4ofakind.png"));
		fourOfKind.setContentAreaFilled(false);
		fourOfKind.setBorderPainted(false);
		fourOfKind.setBounds(425, 400, 150, 50);
		fourOfKind.addActionListener(this);
		fourOfKind.setActionCommand("fourOfKind");
		
		fullHouse.setIcon(new ImageIcon("H:/git/Yahtzee/res/fullHouse.png"));
		fullHouse.setContentAreaFilled(false);
		fullHouse.setBorderPainted(false);
		fullHouse.setBounds(425, 450, 150, 50);
		fullHouse.addActionListener(this);
		fullHouse.setActionCommand("fullHouse");
		
		smallStraight.setIcon(new ImageIcon("H:/git/Yahtzee/res/smallStraight.png"));
		smallStraight.setContentAreaFilled(false);
		smallStraight.setBorderPainted(false);
		smallStraight.setBounds(650, 350, 150, 50);
		smallStraight.addActionListener(this);
		smallStraight.setActionCommand("smallStraight");
		
		largeStraight.setIcon(new ImageIcon("H:/git/Yahtzee/res/largeStraight.png"));
		largeStraight.setContentAreaFilled(false);
		largeStraight.setBorderPainted(false);
		largeStraight.setBounds(650, 400, 150, 50);
		largeStraight.addActionListener(this);
		largeStraight.setActionCommand("largeStraight");
		
		chance.setIcon(new ImageIcon("H:/git/Yahtzee/res/chance.png"));
		chance.setContentAreaFilled(false);
		chance.setBorderPainted(false);
		chance.setBounds(650, 450, 150, 50);
		chance.addActionListener(this);
		chance.setActionCommand("chance");
		
		yahtzee.setIcon(new ImageIcon("H:/git/Yahtzee/res/yahtzee.png"));
		yahtzee.setContentAreaFilled(false);
		yahtzee.setBorderPainted(false);
		yahtzee.setBounds(425, 500, 150, 50);
		yahtzee.addActionListener(this);
		yahtzee.setActionCommand("yahtzee");
	}
	
	@Override
	/** Unused Method for button actions */
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

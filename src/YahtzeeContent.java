import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class YahtzeeContent extends KeyAdapter implements ActionListener
{
	
	public static JCheckBox[] diceSelectors = new JCheckBox[5];
	
	static JButton
	onePlayer = new JButton(),
	twoPlayer = new JButton(),
	threePlayer = new JButton(),
	fourPlayer = new JButton(),
	reRoll = new JButton(),
	scoreButton = new JButton(),
	oneBox = new JButton("Ones"),
	twoBox = new JButton("Twos"),
	threeBox = new JButton("Threes"),
	fourBox = new JButton("Fours"),
	fiveBox = new JButton("Fives"),
	sixBox = new JButton("Sixes"),
	threeOfKind = new JButton("Three of a Kind"),
	fourOfKind = new JButton("Four of a Kind"),
	fullHouse = new JButton("Full House"),
	smallStraight = new JButton("Small Straight"),
	largeStraight = new JButton("Large Straight"),
	chance = new JButton("Chance"),
	yahtzee = new JButton("YAHTZEE");
	
	static JLabel
	xIcon1 = new JLabel(),
	xIcon2 = new JLabel(),
	xIcon3 = new JLabel(),
	turnLabel = new JLabel("Select Die to Save"),
	playerText = new JLabel("Turn: Player"),
	playerLabel = new JLabel("1"),
	menuBackground = new JLabel(),
	tableBackground = new JLabel(),
	scoreCard = new JLabel();
	
	YahtzeeContent()
	{
		for(int x = 0; x < diceSelectors.length; x++)
		{
			diceSelectors[x] = new JCheckBox();
			diceSelectors[x].setBounds(140*(x+1), 300, 64, 64);
			diceSelectors[x].setVisible(true);
			diceSelectors[x].addActionListener(this);
			diceSelectors[x].setActionCommand(Integer.toString(x));
		}
		
		xIcon1.setIcon(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/x.png"));
		xIcon2.setIcon(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/x.png"));
		xIcon3.setIcon(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/x.png"));
		xIcon3.setBounds(800,10,50,50);
		//TODO: MAKE INTO PICTURES WITH REVUE FONT
		
		turnLabel.setFont(turnLabel.getFont().deriveFont(42.0f));
		turnLabel.setBounds(275, 200, 600, 50);
		
		playerText.setFont(playerText.getFont().deriveFont(32.0f));
		
		playerLabel.setFont(playerLabel.getFont().deriveFont(32.0f));
		
		onePlayer.setIcon(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/playerOne.png"));
		onePlayer.setContentAreaFilled(false);
		onePlayer.setBorderPainted(false); 
		onePlayer.setBounds(125, 400, 128, 128);
		onePlayer.addActionListener(this);
		onePlayer.setActionCommand("onePlayer");
		
		twoPlayer.setIcon(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/playerTwo.png"));
		twoPlayer.setContentAreaFilled(false);
		twoPlayer.setBorderPainted(false);
		twoPlayer.setBounds(300, 400, 128, 128);
		twoPlayer.addActionListener(this);
		twoPlayer.setActionCommand("twoPlayer");
		
		threePlayer.setIcon(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/playerThree.png"));
		threePlayer.setContentAreaFilled(false);
		threePlayer.setBorderPainted(false);
		threePlayer.setBounds(475, 400, 128, 128);
		threePlayer.addActionListener(this);
		threePlayer.setActionCommand("threePlayer");
		
		fourPlayer.setIcon(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/playerFour.png"));
		fourPlayer.setContentAreaFilled(false);
		fourPlayer.setBorderPainted(false);
		fourPlayer.setBounds(650, 400, 128, 128);
		fourPlayer.addActionListener(this);
		fourPlayer.setActionCommand("fourPlayer");
		
		menuBackground.setIcon(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/YahtzeeMenu.jpg"));
		menuBackground.setBounds(0, 0, 900, 700);
		menuBackground.setVisible(true);
		
		tableBackground.setIcon(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/YahtzeeTable.jpg"));
		tableBackground.setBounds(0,0,900,700);
		tableBackground.setVisible(true);
		
		scoreCard.setIcon(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/YahtzeeScoreCard1.jpg"));
		scoreCard.setBounds(0, 0, 331, 700);
		scoreCard.setVisible(true);
		
		reRoll.setIcon(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/rollButton.png"));
		reRoll.setContentAreaFilled(false);
		reRoll.setBorderPainted(false);
		reRoll.setBounds(150, 500, 300, 100);
		reRoll.addActionListener(this);
		reRoll.setActionCommand("reRoll");
		
		scoreButton.setIcon(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/scoreButton.png"));
		scoreButton.setContentAreaFilled(false);
		scoreButton.setBorderPainted(false);
		scoreButton.addActionListener(this);
		scoreButton.setActionCommand("scoreButton");
		
		oneBox.setBounds(425, 175, 150, 50);
		oneBox.addActionListener(this);
		oneBox.setActionCommand("oneBox");
		
		twoBox.setBounds(425, 225, 150, 50);
		twoBox.addActionListener(this);
		twoBox.setActionCommand("twoBox");
		
		threeBox.setBounds(425, 275, 150, 50);
		threeBox.addActionListener(this);
		threeBox.setActionCommand("threeBox");

		fourBox.setBounds(650, 175, 150, 50);
		fourBox.addActionListener(this);
		fourBox.setActionCommand("fourBox");
		
		fiveBox.setBounds(650, 225, 150, 50);
		fiveBox.addActionListener(this);
		fiveBox.setActionCommand("fiveBox");
		
		sixBox.setBounds(650, 275, 150, 50);
		sixBox.addActionListener(this);
		sixBox.setActionCommand("sixBox");
		
		threeOfKind.setBounds(425, 350, 150, 50);
		threeOfKind.addActionListener(this);
		threeOfKind.setActionCommand("threeOfKind");
		
		fourOfKind.setBounds(425, 400, 150, 50);
		fourOfKind.addActionListener(this);
		fourOfKind.setActionCommand("fourOfKind");
		
		fullHouse.setBounds(425, 450, 150, 50);
		fullHouse.addActionListener(this);
		fullHouse.setActionCommand("fullHouse");
		
		smallStraight.setBounds(650, 350, 150, 50);
		smallStraight.addActionListener(this);
		smallStraight.setActionCommand("smallStraight");
		
		largeStraight.setBounds(650, 400, 150, 50);
		largeStraight.addActionListener(this);
		largeStraight.setActionCommand("largeStraight");
		
		chance.setBounds(650, 450, 150, 50);
		chance.addActionListener(this);
		chance.setActionCommand("chance");
		
		yahtzee.setBounds(460, 525, 300, 100);
		yahtzee.addActionListener(this);
		yahtzee.setActionCommand("yahtzee");
	}
	
	public static JButton getButton(String buttonName)
	{
		return null;
	}
	
	public static JLabel getLabel(String labelName)
	{
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ESCAPE)
		{
			System.exit(1);
		}
	}

}

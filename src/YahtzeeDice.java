import java.util.Arrays;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

/** Class which deals with the dice array and rolls
 * depending on differnt paramaters 
 * @author Holt, Mary */
public class YahtzeeDice 
{
	public static JLabel[] dicePics = new JLabel[5];
	
	/** Holds values for 5 dice */
	public static byte[] dice = new byte[5];
	/** Random Number generator named random */
	public static Random random = new Random();
	/** Holds value of number of sides of the dice */
	public static byte sidesNum = 6;
	
	/** Constructor Unused */
	YahtzeeDice()
	{ }
	
	/** Rolls values for all die and saves the new 
	 * values w/ setDice() */
	public static void rollAllDie() 
	{ 
		for(int x = 0; x < 5; x++)
		{
			int genNum = random.nextInt(sidesNum);
			genNum += 1;
			setDice(x, genNum);
		}
		
	}
	
	/** Rolls a single die and saves its new value w/ setDice()
	 * @param index Used for which die to roll from dice[] */
	public static void rollSingleDie(int index)
	{
		int genNum = random.nextInt(sidesNum);
		genNum += 1;
		setDice(index, genNum);
	}
	
	/** Sets value of a single dice based on paramaters
	 * @param x Used to determine die in array to use
	 * @param genNum Use to determine what new value is */
	public static void setDice(int x, int genNum)
	{
		dice[x] = (byte) genNum;
	}
	
	/** Displays all dice on the Rolling/Turn screen */
	public static void displayDice()
	{
		for(int x = 0; x < dice.length; x++)
		{
			
			switch(dice[x])
			{
				case 1:
					dicePics[x] = new JLabel(new ImageIcon("H:/git/Yahtzee/res//sideOne.png"));
					break;
				case 2:
					dicePics[x] = new JLabel(new ImageIcon("H:/git/Yahtzee/res//sideTwo.png"));
					break;
				case 3:
					dicePics[x] = new JLabel(new ImageIcon("H:/git/Yahtzee/res//sideThree.png"));
					break;
				case 4:
					dicePics[x] = new JLabel(new ImageIcon("H:/git/Yahtzee/res//sideFour.png"));
					break;
				case 5:
					dicePics[x] = new JLabel(new ImageIcon("H:/git/Yahtzee/res//sideFive.png"));
					break;
				case 6:
					dicePics[x] = new JLabel(new ImageIcon("H:/git/Yahtzee/res//sideSix.png"));
					break;
			}
			
			dicePics[x].setBounds(140*(x+1), 400, 64, 64);
			YahtzeeFrame.f.add(dicePics[x]);
		}
		
		for(int x = 0; x < YahtzeeContent.diceSelectors.length; x++)
		{
			YahtzeeFrame.f.add(YahtzeeContent.diceSelectors[x]);
		}
	}
	
	/** Displays all the dice on the scoreCard screen */
	public static void displayScoreDie()
	{
		for(int x = 0; x < dice.length; x++)
		{
			switch(dice[x])
			{
				case 1:
					dicePics[x] = new JLabel(new ImageIcon("H:/git/Yahtzee/res/sideOne.png"));
					break;
				case 2:
					dicePics[x] = new JLabel(new ImageIcon("H:/git/Yahtzee/res/sideTwo.png"));
					break;
				case 3:
					dicePics[x] = new JLabel(new ImageIcon("H:/git/Yahtzee/res/sideThree.png"));
					break;
				case 4:
					dicePics[x] = new JLabel(new ImageIcon("H:/git/Yahtzee/res/sideFour.png"));
					break;
				case 5:
					dicePics[x] = new JLabel(new ImageIcon("H:/git/Yahtzee/res/sideFive.png"));
					break;
				case 6:
					dicePics[x] = new JLabel(new ImageIcon("H:/git/Yahtzee/res/sideSix.png"));
					break;
			}
			
			dicePics[x].setBounds((100*(x+1)) + 275, 75, 64, 64);
			YahtzeeFrame.f.add(dicePics[x]);
			
		}
		
	}

	/** Sorts dice into sequential order */
	public static void sortDice()
	{
		Arrays.sort(dice);	
	}
	
}

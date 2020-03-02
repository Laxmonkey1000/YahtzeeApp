import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class YahtzeeDice 
{
	static JLabel
	sideOne = new JLabel(),
	sideTwo = new JLabel(),
	sideThree = new JLabel(),
	sideFour = new JLabel(),
	sideFive = new JLabel(),
	sideSix = new JLabel();
	
	public static JLabel[] dicePics = new JLabel[5];
	
	/** Holds values for 5 dice */
	public static byte[] dice = new byte[5];
	public static Random random = new Random();
	public static byte sidesNum = 6;
	
	
	/** Constructor loads images of 6 dice sides */
	YahtzeeDice()
	{
		
	}
	
	public static void rollAllDie() 
	{ 
		for(int x = 0; x < 5; x++)
		{
			int genNum = random.nextInt(sidesNum);
			genNum += 1;
			setDice(x, genNum);
		}
		
	}
	
	public static void rollSingleDie(int index)
	{
		int genNum = random.nextInt(sidesNum);
		genNum += 1;
		setDice(index, genNum);
	}
	
	public static void setDice(int x, int genNum)
	{
		dice[x] = (byte) genNum;
	}
	
	public static void displayDice()
	{
		for(int x = 0; x < dice.length; x++)
		{
			
			switch(dice[x])
			{
				case 1:
					dicePics[x] = new JLabel(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/sideOne.png"));
					break;
				case 2:
					dicePics[x] = new JLabel(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/sideTwo.png"));
					break;
				case 3:
					dicePics[x] = new JLabel(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/sideThree.png"));
					break;
				case 4:
					dicePics[x] = new JLabel(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/sideFour.png"));
					break;
				case 5:
					dicePics[x] = new JLabel(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/sideFive.png"));
					break;
				case 6:
					dicePics[x] = new JLabel(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/sideSix.png"));
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
	
	public static void displayScoreDie()
	{
		for(int x = 0; x < dice.length; x++)
		{
			switch(dice[x])
			{
				case 1:
					dicePics[x] = new JLabel(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/sideOne.png"));
					break;
				case 2:
					dicePics[x] = new JLabel(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/sideTwo.png"));
					break;
				case 3:
					dicePics[x] = new JLabel(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/sideThree.png"));
					break;
				case 4:
					dicePics[x] = new JLabel(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/sideFour.png"));
					break;
				case 5:
					dicePics[x] = new JLabel(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/sideFive.png"));
					break;
				case 6:
					dicePics[x] = new JLabel(new ImageIcon("C:/Users/laxmo/eclipse-workspace/YahtzeeFX/res/sideSix.png"));
					break;
			}
			
			dicePics[x].setBounds((100*(x+1)) + 275, 75, 64, 64);
			YahtzeeFrame.f.add(dicePics[x]);
			
		}
		
	}

	public static void sortDice()
	{
		Arrays.sort(dice);	
	}
	
	
}

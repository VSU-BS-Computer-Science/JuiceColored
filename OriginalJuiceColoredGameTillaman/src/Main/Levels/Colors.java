package Main.Levels;

import java.util.Random;

public enum Colors {
	Red,Blue,Yellow,Orange,Green,Violet,Brown;
	
	public static Colors getRandomPrimaryColor()
	{
		Random random = new Random();
		return values()[random.nextInt(3)];
	}
}

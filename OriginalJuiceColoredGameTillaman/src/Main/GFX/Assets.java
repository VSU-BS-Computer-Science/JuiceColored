package Main.GFX;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	
	public static Font font28;
	public static Font font18;
	public static Font font10;
	public static Font font64;
	public static Font fontExo2Bold14,fontExo2Bold24,fontExo2Bold18,font3;
	
	public static BufferedImage playButton,restartButton,levelsButton,homeButton;
	public static BufferedImage homeState,menuState,timesUpState,loadingState;
	public static BufferedImage redReload,blueReload,yellowReload;
	public static BufferedImage [] spriteClock  = new BufferedImage[7];
	public static BufferedImage [] level = new BufferedImage[5];
	public static BufferedImage [] levelBought = new BufferedImage [5]; 
	public static BufferedImage level1,instructions,black,startHover;
	public static BufferedImage player,customer,background,dialog;
	public static BufferedImage clock,tag,cashcounter,trashcan;
	public static BufferedImage emptyGlass,redGlass,blueGlass,yellowGlass,orangeGlass,greenGlass,violetGlass,brownGlass;
	public static BufferedImage [] customerArr = new BufferedImage[4];
	public static BufferedImage [] juice = new BufferedImage [3];
	
	public static void init()
	{
		
		spriteClock[0] =  ImageLoader.loadImage("/misc/0.png");
		spriteClock[1] =  ImageLoader.loadImage("/misc/1.png");
		spriteClock[2] =  ImageLoader.loadImage("/misc/2.png");
		spriteClock[3] =  ImageLoader.loadImage("/misc/3.png");
		spriteClock[4] =  ImageLoader.loadImage("/misc/4.png");
		spriteClock[5] =  ImageLoader.loadImage("/misc/5.png");
		spriteClock[6] =  ImageLoader.loadImage("/misc/6.png");
		
		
		
		dialog =  ImageLoader.loadImage("/customer/dialog.png");
		
		//CUSTOMER ARRAY
		customerArr[0] = ImageLoader.loadImage("/customer/c2.png");
		customerArr[1] = ImageLoader.loadImage("/customer/c3.png");
		customerArr[2] = ImageLoader.loadImage("/customer/c4.png");
		customerArr[3] = ImageLoader.loadImage("/customer/c6.png");
		
		
		//LEVELS
		level[0] = ImageLoader.loadImage("/STATES/1.png");
		level[1] = ImageLoader.loadImage("/STATES/2.png");
		level[2] = ImageLoader.loadImage("/STATES/3.png");
		level[3] = ImageLoader.loadImage("/STATES/4.png");
		level[4] = ImageLoader.loadImage("/STATES/5.png");
		
		levelBought[0] = ImageLoader.loadImage("/STATES/firstLevelState.png");
		levelBought[1] = ImageLoader.loadImage("/STATES/2ndLevelState.png");
		levelBought[2] = ImageLoader.loadImage("/STATES/3rdLevelState.png");
		levelBought[3] = ImageLoader.loadImage("/STATES/4thLevelState.png");
		levelBought[4] = ImageLoader.loadImage("/STATES/5thLevelState.png");
		
		
		//JUICES
		
		juice [0] = ImageLoader.loadImage("/juice/red.png");
		juice [1] = ImageLoader.loadImage("/juice/blue.png");
		juice [2] = ImageLoader.loadImage("/juice/yellow.png");
		
		
		level1 = ImageLoader.loadImage("/STATES/LEVEL1.png");
		instructions = ImageLoader.loadImage("/instructions.png");
		instructions = ImageLoader.loadImage("/black.png");
		startHover = ImageLoader.loadImage("/START.png");
		
		
		
		
		//BACKGROUND
		background = ImageLoader.loadImage("/background/bg2.png");
	
	
		//FONTS
		font28 = FontLoader.loadFont("fonts/slkscr.ttf", 24);
		font18 = FontLoader.loadFont("fonts/slkscr.ttf", 18);
		font64 = FontLoader.loadFont("fonts/slkscr.ttf", 64);
		font10 = FontLoader.loadFont("fonts/slkscr.ttf", 6);
		font3 = FontLoader.loadFont("fonts/slkscr.ttf", 3);
		fontExo2Bold24 = FontLoader.loadFont("fonts/EXO2-SEMIBOLD.OTF", 24);
		fontExo2Bold18 = FontLoader.loadFont("fonts/EXO2-SEMIBOLD.OTF", 18);
		fontExo2Bold14 = FontLoader.loadFont("fonts/EXO2-SEMIBOLD.OTF", 14);
		
		//Customer Glass
		emptyGlass = ImageLoader.loadImage("/customer/Glass/emptyGlass.png");
		redGlass = ImageLoader.loadImage("/customer/Glass/redGlass.png");
		blueGlass = ImageLoader.loadImage("/customer/Glass/blueGlass.png");
		yellowGlass = ImageLoader.loadImage("/customer/Glass/yellowGlass.png");
		orangeGlass = ImageLoader.loadImage("/customer/Glass/orangeGlass.png");
		greenGlass = ImageLoader.loadImage("/customer/Glass/greenGlass.png");
		violetGlass = ImageLoader.loadImage("/customer/Glass/violetGlass.png");
		brownGlass = ImageLoader.loadImage("/customer/Glass/brownGlass.png");
		
		//TRASHCAN
		trashcan =  ImageLoader.loadImage("/trashcan/trashcan.png");
		
		//CLOCK
		clock =  ImageLoader.loadImage("/misc/timer.png");
		//TAG
		tag = ImageLoader.loadImage("/misc/TAG.png");
		
		//CASHCOUNTER
		cashcounter= ImageLoader.loadImage("/misc/cash.png");
		
		//STATES
		menuState = ImageLoader.loadImage("/STATES/menuState.png");
		homeState= ImageLoader.loadImage("/STATES/homeState.png");
		timesUpState = ImageLoader.loadImage("/STATES/timesUp.png");
		loadingState = ImageLoader.loadImage("/STATES/loadingState.jpg");
		
		playButton = ImageLoader.loadImage("/STATES/playButton.png");
		restartButton = ImageLoader.loadImage("/STATES/restartHover.png");
		levelsButton = ImageLoader.loadImage("/STATES/levelsHover.png");
		homeButton = ImageLoader.loadImage("/STATES/quitHover.png");
		
		
		//RELOADERS
		
		redReload = ImageLoader.loadImage("/juice/redReload.png");
		blueReload = ImageLoader.loadImage("/juice/blueReload.png");
		yellowReload = ImageLoader.loadImage("/juice/yellowReload.png");
	}
	

}

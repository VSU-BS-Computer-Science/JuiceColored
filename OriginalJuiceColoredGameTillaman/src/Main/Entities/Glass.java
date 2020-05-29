package Main.Entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import Main.GFX.Assets;
import Main.Levels.Colors;
import Main.States.GameState;

public class Glass extends Entity implements Animateable {
	
	
	//BOOLEAN ATTRIBUTES
	private boolean [] juiceColor;
	private boolean withColor;
	
	//GLASS CLICKING ATTRIBUTE
 	public boolean glassClicked;
	private Rectangle glassBoundary;
	
	//STATIC ATTRIBUTES
	public static boolean glassPressed = false;
	public static int glassNumber = 0;
	
	//CLASS ATTRIBUTES
	private GameState gameState;
	public static int numGlass = 0;
	public int glassID ;
	
	
	public Glass(Rectangle bounds,GameState gameState) 
	{
		super(bounds);
		this.gameState = gameState;
		this.juiceColor = new boolean[10];
		this.glassClicked = false;
		this.withColor = false;
	
		numGlass++;
		glassID = numGlass;
		if(numGlass>3)
			numGlass = 0;
	}
	
	public void addColor(Colors color)
	{	
		if(color==Colors.Red)
		{
			juiceColor[0] = true;
		}
		else if(color==Colors.Blue)
		{
			juiceColor[1] = true;
		}
		else if(color==Colors.Yellow)
		{
			juiceColor[2] = true;
		}
		withColor = true;
	
	}
	public Colors getColor()
	{
		if(juiceColor[0]&&!juiceColor[1]&&!juiceColor[2]&&!juiceColor[3]&&!juiceColor[4]&&!juiceColor[5]&&!juiceColor[6])
			return Colors.Red;
		else if(!juiceColor[0]&&juiceColor[1]&&!juiceColor[2]&&!juiceColor[3]&&!juiceColor[4]&&!juiceColor[5]&&!juiceColor[6])
			return Colors.Blue;
		else if(!juiceColor[0]&&!juiceColor[1]&&juiceColor[2]&&!juiceColor[3]&&!juiceColor[4]&&!juiceColor[5]&&!juiceColor[6])
			return Colors.Yellow;
		else if(!juiceColor[0]&&!juiceColor[1]&&!juiceColor[2]&&juiceColor[3]&&!juiceColor[4]&&!juiceColor[5]&&!juiceColor[6])
			return Colors.Orange;
		else if(!juiceColor[0]&&!juiceColor[1]&&!juiceColor[2]&&!juiceColor[3]&&juiceColor[4]&&!juiceColor[5]&&!juiceColor[6])
			return Colors.Green;
		else if(!juiceColor[0]&&!juiceColor[1]&&!juiceColor[2]&&!juiceColor[3]&&!juiceColor[4]&&juiceColor[5]&&!juiceColor[6])
			return Colors.Violet;
		else if(!juiceColor[0]&&!juiceColor[1]&&!juiceColor[2]&&!juiceColor[3]&&!juiceColor[4]&&!juiceColor[5]&&juiceColor[6])
			return Colors.Brown;
		else
			return null;
	}
	public void resetGlass()
	{
		if(!withColor)
		{
			juiceColor[0] = false;
			juiceColor[1] = false;
			juiceColor[2] = false;
			juiceColor[3] = false;
			juiceColor[4] = false;
			juiceColor[5] = false;
			juiceColor[6] = false;	
		}
	}
	
	@Override
	public void tick() {
		
		
		checkGlassPosition();
		resetGlass();
		checkGlassMouseFunctions();
		checkSecondaryColors();
		
			
	}
	@Override
	public void render(Graphics g)
	{
		//DEFAULT GLASS IMAGE
		if(!withColor)
		{
			g.drawImage(Assets.emptyGlass, bounds.x , bounds.y, bounds.width, bounds.height, null);
		}
		else
		{
			if(glassClicked)
			{
				g.drawImage(Assets.emptyGlass, (int)gameState.getGame().getMouseX()-10,(int)gameState.getGame().getMouseY()-10,bounds.width,bounds.height, null);
				
				if(juiceColor[0])
					g.drawImage(Assets.redGlass, (int)gameState.getGame().getMouseX()-10, (int)gameState.getGame().getMouseY()-10, bounds.width, bounds.height, null);
				
				if(juiceColor[1])
					g.drawImage(Assets.blueGlass, (int)gameState.getGame().getMouseX()-10, (int)gameState.getGame().getMouseY()-10, bounds.width, bounds.height, null);
				
				if(juiceColor[2])
					g.drawImage(Assets.yellowGlass,(int)gameState.getGame().getMouseX()-10 , (int)gameState.getGame().getMouseY()-10, bounds.width, bounds.height, null);
				
				if(juiceColor[3])
					g.drawImage(Assets.orangeGlass,(int)gameState.getGame().getMouseX()-10, (int)gameState.getGame().getMouseY()-10, bounds.width, bounds.height, null);
				
				if(juiceColor[4])
					g.drawImage(Assets.greenGlass,(int)gameState.getGame().getMouseX()-10, (int)gameState.getGame().getMouseY()-10, bounds.width, bounds.height, null);
				
				if(juiceColor[5])
					g.drawImage(Assets.violetGlass, (int)gameState.getGame().getMouseX()-10 , (int)gameState.getGame().getMouseY()-10, bounds.width, bounds.height, null);
				
				if(juiceColor[6])
					g.drawImage(Assets.brownGlass, (int)gameState.getGame().getMouseX()-10 , (int)gameState.getGame().getMouseY()-10, bounds.width, bounds.height, null);
			}
		
			else
			{
				g.drawImage(Assets.emptyGlass, bounds.x , bounds.y, bounds.width, bounds.height, null);
				
				//FILL THE GLASS WITH COLORS
				if(juiceColor[0])
					g.drawImage(Assets.redGlass, bounds.x , bounds.y, bounds.width, bounds.height, null);
				if(juiceColor[1])
					g.drawImage(Assets.blueGlass, bounds.x , bounds.y, bounds.width, bounds.height, null);
				if(juiceColor[2])
					g.drawImage(Assets.yellowGlass, bounds.x , bounds.y, bounds.width, bounds.height, null);
				if(juiceColor[3])
					g.drawImage(Assets.orangeGlass, bounds.x , bounds.y, bounds.width, bounds.height, null);
				if(juiceColor[4])
					g.drawImage(Assets.greenGlass, bounds.x , bounds.y, bounds.width, bounds.height, null);
				if(juiceColor[5])
					g.drawImage(Assets.violetGlass, bounds.x , bounds.y, bounds.width, bounds.height, null);
				if(juiceColor[6])
					g.drawImage(Assets.brownGlass, bounds.x , bounds.y, bounds.width, bounds.height, null);
		
			}
		}
			
	}
	public void checkGlassPosition()
	{
		if(glassID==2)
			bounds.x = bounds.x+35;
		if(glassID==3)
			bounds.x = bounds.x+70;
		
		glassBoundary = new Rectangle(bounds.x,bounds.y,bounds.width,bounds.height);
	}
	public void checkSecondaryColors()
	{
		//ORANGE
				if(juiceColor[0]&&juiceColor[2])
				{
					juiceColor[0] = false;
					juiceColor[2] = false;
					juiceColor[3] = true;
					
				}
				//GREEN
				if(juiceColor[1]&&juiceColor[2])
				{
				
					juiceColor[1] = false;
					juiceColor[2] = false;
					juiceColor[4] = true;
					
				}
				//VIOLET
				if(juiceColor[0]&&juiceColor[1])
				{
					juiceColor[0] = false;
					juiceColor[1] = false;
					juiceColor[5] = true;
				}
				//BROWN
				if(juiceColor[3]&&juiceColor[1]||juiceColor[4]&&juiceColor[0]||juiceColor[5]&&juiceColor[2])
				{
					juiceColor[0] = false;
					juiceColor[1] = false;
					juiceColor[2] = false;
					juiceColor[3] = false;
					juiceColor[4] = false;
					juiceColor[5] = false;
					juiceColor[6] = true;
				}
	}
	public void checkGlassMouseFunctions()
	{
		if(!gameState.getGame().getMouseManager().isLeftPressed())
		{
			glassPressed =false;
			glassClicked = false;
			
		}
		else if(glassBoundary.contains(gameState.getGame().getMouseX(),gameState.getGame().getMouseY())
				&&!gameState.isBlueJuicePressed()&&!gameState.isRedJuicePressed()&&!gameState.isYellowJuicePressed()&&!glassPressed&&!glassClicked)
		{
			glassPressed = true;
			glassClicked = true;
		}
		if(glassClicked&&gameState.getTrashCanBoundary().contains(gameState.getGame().getMouseX(),gameState.getGame().getMouseY()))
		{
			trashedJuiceSubtracter();
			withColor = false;
			System.out.println("TRASH");
			
		}
	}
	public void trashedJuiceSubtracter()
	{
		if(juiceColor[0])
		{
			gameState.setRedJuiceQuantity(gameState.getRedJuiceQuantity()-1);
			gameState.setThrown(gameState.getThrown()+1);
			gameState.setTime(gameState.getTime()-2);
		}
		if(juiceColor[1])
		{
			gameState.setBlueJuiceQuantity(gameState.getBlueJuiceQuantity()-1);
			gameState.setThrown(gameState.getThrown()+1);
			gameState.setTime(gameState.getTime()-2);
		}
		if(juiceColor[2])
		{
			gameState.setYellowJuiceQuantity(gameState.getYellowJuiceQuantity()-1);
			gameState.setThrown(gameState.getThrown()+1);
			gameState.setTime(gameState.getTime()-3);
		}
		if(juiceColor[3])
		{
			gameState.setRedJuiceQuantity(gameState.getRedJuiceQuantity()-1);
			gameState.setYellowJuiceQuantity(gameState.getYellowJuiceQuantity()-1);
			gameState.setThrown(gameState.getThrown()+2);
			gameState.setTime(gameState.getTime()-3);
		}
		if(juiceColor[4])
		{
			gameState.setBlueJuiceQuantity(gameState.getBlueJuiceQuantity()-1);
			gameState.setYellowJuiceQuantity(gameState.getYellowJuiceQuantity()-1);
			gameState.setThrown(gameState.getThrown()+2);
			gameState.setTime(gameState.getTime()-3);
		}
		if(juiceColor[5])
		{
			gameState.setRedJuiceQuantity(gameState.getRedJuiceQuantity()-1);
			gameState.setBlueJuiceQuantity(gameState.getBlueJuiceQuantity()-1);
			gameState.setThrown(gameState.getThrown()+2);
			gameState.setTime(gameState.getTime()-3);
		}
		if(juiceColor[6])
		{
			gameState.setRedJuiceQuantity(gameState.getRedJuiceQuantity()-1);
			gameState.setBlueJuiceQuantity(gameState.getBlueJuiceQuantity()-1);
			gameState.setYellowJuiceQuantity(gameState.getYellowJuiceQuantity()-1);
			gameState.setThrown(gameState.getThrown()+3);
			gameState.setTime(gameState.getTime()-5);
		}
	}
	
	
	public void juiceSubtracter()
	{
		if(juiceColor[0])
		{
			gameState.setRedJuiceQuantity(gameState.getRedJuiceQuantity()-1);
			
		}
		if(juiceColor[1])
		{
			gameState.setBlueJuiceQuantity(gameState.getBlueJuiceQuantity()-1);
			
		}
		if(juiceColor[2])
		{
			gameState.setYellowJuiceQuantity(gameState.getYellowJuiceQuantity()-1);
			
		}
		if(juiceColor[3])
		{
			gameState.setRedJuiceQuantity(gameState.getRedJuiceQuantity()-1);
			gameState.setYellowJuiceQuantity(gameState.getYellowJuiceQuantity()-1);
			
		}
		if(juiceColor[4])
		{
			gameState.setBlueJuiceQuantity(gameState.getBlueJuiceQuantity()-1);
			gameState.setYellowJuiceQuantity(gameState.getYellowJuiceQuantity()-1);
			
		}
		if(juiceColor[5])
		{
			gameState.setRedJuiceQuantity(gameState.getRedJuiceQuantity()-1);
			gameState.setBlueJuiceQuantity(gameState.getBlueJuiceQuantity()-1);
			
		}
		if(juiceColor[6])
		{
			gameState.setRedJuiceQuantity(gameState.getRedJuiceQuantity()-1);
			gameState.setBlueJuiceQuantity(gameState.getBlueJuiceQuantity()-1);
			gameState.setYellowJuiceQuantity(gameState.getYellowJuiceQuantity()-1);
			
		}
	}
	
	//GETTERS AND SETTERS
	public boolean[] getJuiceColor() {
		return juiceColor;
	}

	public void setJuiceColor(boolean[] juiceColor) {
		this.juiceColor = juiceColor;
	}

	public boolean isWithColor() {
		return withColor;
	}

	public void setWithColor(boolean withColor) {
		this.withColor = withColor;
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
}


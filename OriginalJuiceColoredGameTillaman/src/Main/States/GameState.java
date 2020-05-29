package Main.States;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import Main.Game;
import Main.Entities.Customer;
import Main.Entities.Glass;
import Main.GFX.Assets;
import Main.GFX.Text;
import Main.Levels.Colors;
import Main.Levels.Level;
import Main.Player.Account;
import Main.Player.Player;

public class GameState extends States{

	//CUSTOMER CLASS ATTRIBUTE
	private List<Customer> customer;
	
	//INTEGER COLOR QUANTITY ATTRIBUTES
	private int redJuiceQuantity;
	private int blueJuiceQuantity;
	private int yellowJuiceQuantity;
	
	//PLAYER CLASS
	Player player;
	public String cash;
	
	//JUICE QUANTITY STRINGS
	public String redQuantityString;
	public String blueQuantityString;
	public String yellowQuantityString ;
	
	
	//JUICE BOUNDARIES
	private Rectangle redJuiceBoundary;
	private Rectangle blueJuiceBoundary;
	private Rectangle yellowJuiceBoundary;
	private Rectangle startBoundary;
	
	
	//RELOADING ATTRIBUTES
	private boolean redReloadThis;
	private boolean blueReloadThis;
	private boolean yellowReloadThis;
	private int redReloadTime;
	private int blueReloadTime;
	private int yellowReloadTime;
	
	//ATTRIBUTES THAT DETERMINES IF THE JUICES ARE PRESSED
	private boolean redJuicePressed;
	private boolean blueJuicePressed;
	private boolean yellowJuicePressed;
	
	//TRASHCAN ATTRIBUTE
	private Rectangle trashCanBoundary;
	
	
	//LEVEL ATTRIB
	private int lvl;
	private Level level;
	private int thrown;
	
	
	//TIME ATTRIBUTES FOR LOOPING
	private boolean proceed;
	private int i;
	private int time;
	private String countdownS = Integer.toString(time);
		

	
	public GameState(Game game,Level level,int lvl) {
		
		//INITIALIZATION
		super(game);
		this.redJuiceQuantity = 5;
		this.blueJuiceQuantity = 5;
		this.yellowJuiceQuantity = 5;
		this.time = 30;
		this.i = 0;
		this.proceed = false;
		
		this.redReloadThis = false;
		this.blueReloadThis = false;
		this.yellowReloadThis = false;
		
		this.redReloadTime = 0;
		this.blueReloadTime = 0;
		this.yellowReloadTime = 0;
		
		this.redJuicePressed = false;
		this.blueJuicePressed = false;
		this.yellowJuicePressed = false;
		
		this.redJuiceBoundary = new Rectangle(55,390,55,55);
		this.blueJuiceBoundary = new Rectangle(redJuiceBoundary.x*2,390,55,55);
		this.yellowJuiceBoundary = new Rectangle(redJuiceBoundary.x*3,390,55,55);
		this.startBoundary = new Rectangle(207,366,192,72);
		
		this.redQuantityString =  Double.toString(redJuiceQuantity);
		this.blueQuantityString =  Double.toString(blueJuiceQuantity);
		this.yellowQuantityString =  Double.toString(yellowJuiceQuantity);
		
		this.customer = new ArrayList<Customer>();
		this.player = new Player();
		this.level = level;
		this.lvl = lvl;
		this.thrown = 0;
		this.trashCanBoundary = new Rectangle(500,420,100,85);
		this.cash = Double.toString(player.getEarnings());
	
	}
	
	//RENDERING
	@Override
	public void render(Graphics g) {
		
		checkProcedure(g);
	
	}
	public void checkProcedure(Graphics g)
	{
		if(!proceed)
			instructionsRender(g);
		else if(proceed)
		{ 
			backgroundRender(g);
			timerRender(g);
			cashCounterRender(g);
			juiceRender(g);
			reloadJuice(g);
			juiceQuantityRender(g);
			trashCanRender(g);
			customerRender(g);	
			checkJuiceRender(g);
		}
		
	}
	public void instructionsRender(Graphics g)
	{
		g.drawImage(Assets.instructions, 0,0,640,480, null);
		if(startBoundary.contains(game.getMouseManager().getMouseX(),game.getMouseManager().getMouseY()))
			g.drawImage(Assets.startHover, startBoundary.x,startBoundary.y, startBoundary.width, startBoundary.height,null);
	
	}
	public void backgroundRender(Graphics g)
	{
		g.drawImage(Assets.background, 0,0,640,480, null);
	}
	public void timerRender(Graphics g)
	{
		g.drawImage(Assets.clock, 286,4,76,94, null);
		Text.drawString(g, countdownS, 325, 58, true, Color.DARK_GRAY, Assets.fontExo2Bold24);
	}
	public void cashCounterRender(Graphics g)
	{
		g.drawImage(Assets.cashcounter, 495,4,120,38, null);
		Text.drawString(g, "$"+cash, 560, 25, true, Color.black, Assets.fontExo2Bold14);
	}
	public void juiceRender(Graphics g)
	{
		if(redJuiceQuantity>0)
			g.drawImage(Assets.juice[0],redJuiceBoundary.x,redJuiceBoundary.y,redJuiceBoundary.width,redJuiceBoundary.height, null);
		else if(redJuiceQuantity<1)
			g.drawImage(Assets.redReload, redJuiceBoundary.x,redJuiceBoundary.y,redJuiceBoundary.width,redJuiceBoundary.height, null);
		
		if(blueJuiceQuantity>0)
			g.drawImage(Assets.juice[1],blueJuiceBoundary.x,blueJuiceBoundary.y,blueJuiceBoundary.width,blueJuiceBoundary.height, null);
		else if(blueJuiceQuantity<1)
			g.drawImage(Assets.blueReload, blueJuiceBoundary.x,blueJuiceBoundary.y,blueJuiceBoundary.width,blueJuiceBoundary.height, null);
		
		if(yellowJuiceQuantity>0)
			g.drawImage(Assets.juice[2],yellowJuiceBoundary.x,yellowJuiceBoundary.y,yellowJuiceBoundary.width,yellowJuiceBoundary.height, null);
		else if(yellowJuiceQuantity<1)
			g.drawImage(Assets.yellowReload, yellowJuiceBoundary.x,yellowJuiceBoundary.y,yellowJuiceBoundary.width,yellowJuiceBoundary.height, null);
		
	}
	public void trashCanRender(Graphics g)
	{
		g.drawImage(Assets.trashcan,trashCanBoundary.x,trashCanBoundary.y,trashCanBoundary.width,trashCanBoundary.height,null);
	}
	public void customerRender(Graphics g)
	{
		for(int i = 0; i<customer.size();i++)
			customer.get(i).render(g);
	}
	public void reloadJuice(Graphics g)
	{
		//RED RELOAD
		if(redReloadThis)
		{
			redReloadTime++;
			
			//CLOCK
			if(redReloadTime<=50)
			{
				g.drawImage(Assets.spriteClock[0], redJuiceBoundary.x+15,redJuiceBoundary.y+60, 20, 20, null);
			}
			else if(redReloadTime<=100) {
				g.drawImage(Assets.spriteClock[1], redJuiceBoundary.x+15,redJuiceBoundary.y+60, 20, 20, null);
			}
			else if(redReloadTime<=150) {
				g.drawImage(Assets.spriteClock[2], redJuiceBoundary.x+15,redJuiceBoundary.y+60, 20, 20, null);
			}
			else if(redReloadTime<=200) {
				g.drawImage(Assets.spriteClock[3], redJuiceBoundary.x+15,redJuiceBoundary.y+60, 20, 20, null);
			}
			else if(redReloadTime<=250) {
				g.drawImage(Assets.spriteClock[4], redJuiceBoundary.x+15,redJuiceBoundary.y+60, 20, 20, null);
			}
			else if(redReloadTime>=250) {
				g.drawImage(Assets.spriteClock[5], redJuiceBoundary.x+15,redJuiceBoundary.y+60, 20, 20, null);
			}
			//END
			
			if(redReloadTime==300)
			{
				player.setEarnings((int) (player.getEarnings()-5));
				redJuiceQuantity+=3;
				redReloadTime = 0;
			}
			if(redJuiceQuantity>=3)
				redReloadThis = false;
		}
		
		
		//BLUE RELOAD
		if(blueReloadThis)
		{
			//CLOCK
			if(blueReloadTime<=50)
			{
				g.drawImage(Assets.spriteClock[0], blueJuiceBoundary.x+15,blueJuiceBoundary.y+60, 20, 20, null);
			}
			else if(blueReloadTime<=100) {
				g.drawImage(Assets.spriteClock[1], blueJuiceBoundary.x+15,blueJuiceBoundary.y+60, 20, 20, null);
			}
			else if(blueReloadTime<=150) {
				g.drawImage(Assets.spriteClock[2], blueJuiceBoundary.x+15,blueJuiceBoundary.y+60, 20, 20, null);
			}
			else if(blueReloadTime<=200) {
				g.drawImage(Assets.spriteClock[3], blueJuiceBoundary.x+15,blueJuiceBoundary.y+60, 20, 20, null);
			}
			else if(blueReloadTime<=250) {
				g.drawImage(Assets.spriteClock[4], blueJuiceBoundary.x+15,blueJuiceBoundary.y+60, 20, 20, null);
			}
			else if(blueReloadTime>=250) {
				g.drawImage(Assets.spriteClock[5], blueJuiceBoundary.x+15,blueJuiceBoundary.y+60, 20, 20, null);
			}
			//END
			
			
			blueReloadTime++;
			if(blueReloadTime==300)
			{
				player.setEarnings((int) (player.getEarnings()-5));
				blueJuiceQuantity+=3;
				blueReloadTime = 0;
			}
			if(blueJuiceQuantity>=3)
				blueReloadThis = false;
		}
		
		if(yellowReloadThis)
		{
			
			//CLOCK
			if(yellowReloadTime<=50)
			{
				g.drawImage(Assets.spriteClock[0], yellowJuiceBoundary.x+15,yellowJuiceBoundary.y+60, 20, 20, null);
			}
			else if(yellowReloadTime<=100) {
				g.drawImage(Assets.spriteClock[1], yellowJuiceBoundary.x+15,yellowJuiceBoundary.y+60, 20, 20, null);
			}
			else if(yellowReloadTime<=150) {
				g.drawImage(Assets.spriteClock[2], yellowJuiceBoundary.x+15,yellowJuiceBoundary.y+60, 20, 20, null);
			}
			else if(yellowReloadTime<=200) {
				g.drawImage(Assets.spriteClock[3], yellowJuiceBoundary.x+15,yellowJuiceBoundary.y+60, 20, 20, null);
			}
			else if(yellowReloadTime<=250) {
				g.drawImage(Assets.spriteClock[4], yellowJuiceBoundary.x+15,yellowJuiceBoundary.y+60, 20, 20, null);
			}
			else if(yellowReloadTime>=250) {
				g.drawImage(Assets.spriteClock[5], yellowJuiceBoundary.x+15,yellowJuiceBoundary.y+60, 20, 20, null);
			}
			//END
			
			yellowReloadTime++;
			if(yellowReloadTime==300)
			{
				yellowJuiceQuantity+=3;
				yellowReloadTime = 0;
				player.setEarnings((int) (player.getEarnings()-5));
			}
			if(yellowJuiceQuantity>=3)
				yellowReloadThis = false;
		}
		
	}
	public void checkJuiceRender(Graphics g)
	{
		if(redJuicePressed&&redJuiceQuantity>0)
			g.drawImage(Assets.juice[0], (int)game.getMouseX()-10,(int)game.getMouseY()-10,redJuiceBoundary.width/2,redJuiceBoundary.height/2, null);
		if(blueJuicePressed&&blueJuiceQuantity>0)
			g.drawImage(Assets.juice[1], (int)game.getMouseX()-10,(int)game.getMouseY()-10,blueJuiceBoundary.width/2,blueJuiceBoundary.height/2, null);
		if(yellowJuicePressed&&yellowJuiceQuantity>0)
			g.drawImage(Assets.juice[2], (int)game.getMouseX()-10,(int)game.getMouseY()-10,yellowJuiceBoundary.width/2,yellowJuiceBoundary.height/2, null);
	
	}
	public void juiceQuantityRender(Graphics g)
	{
		//REDJUICE
		if(redJuiceQuantity>0)
		{
			g.drawImage(Assets.tag,(int) redJuiceBoundary.x+8, (int)redJuiceBoundary.y+45,34,19, null);
			Text.drawString(g, "x"+redJuiceQuantity, (int)redJuiceBoundary.x+25, (int)redJuiceBoundary.y+55, true, Color.black, Assets.fontExo2Bold14);
		}
		
		//BLUEJUICE
		
		if(blueJuiceQuantity>0)
		{
			g.drawImage(Assets.tag,(int) blueJuiceBoundary.x+8, (int)blueJuiceBoundary.y+45,34,19, null);
			Text.drawString(g, "x"+blueJuiceQuantity, (int)blueJuiceBoundary.x+25, (int)blueJuiceBoundary.y+55, true, Color.black, Assets.fontExo2Bold14);
		}
		
		//YELLOWJUICE
		
		if(yellowJuiceQuantity>0)
		{
			g.drawImage(Assets.tag,(int) yellowJuiceBoundary.x+8, (int)yellowJuiceBoundary.y+45,34,19, null);
			Text.drawString(g, "x"+yellowJuiceQuantity, (int)yellowJuiceBoundary.x+25, (int)yellowJuiceBoundary.y+55, true, Color.black, Assets.fontExo2Bold14);
		}
		

	}
	
	//END OF RENDER
	
	
	
	
	
	//UPDATING
	@Override
	public void tick() {
		
		customerTick();
		checkProcedureTick();		
		gameTimeTick();
		checkJuice();
		cashUpdate();
		
	
	
	}
	public void cashUpdate()
	{
		cash = Double.toString(player.getEarnings());
	}
	public void checkProcedureTick()
	{
		if(!proceed)
		{
			if(startBoundary.contains(game.getMouseManager().getMouseX(),game.getMouseManager().getMouseY()))
			{
				
				if(game.getMouseManager().isLeftPressed())
				{
					proceed = true;
					customer.add(new Customer(new Rectangle(-500,195,111,116),level.getNum_orders(),this));
					customer.add(new Customer(new Rectangle(-2000,195,111,116), level.getNumOrders(),this));
						
				}
			}
			
		}
	}
	public void customerTick()
	{
		for(int i = 0;i<customer.size();i++)
			customer.get(i).tick();
	}
	public void gameTimeTick()
	{
		//IF TIME IS STILL GREATER THAN 0 THEN CONTINUE ADDING MORE CUSTOMERS
		if(time>0&&proceed)
		{
			if(i==60)
			{
				time--;
				countdownS = Integer.toString(time);
				i=0;
			}
			i++;
			
			for(int i = 0;i<customer.size();i++)
			{
				if(customer.get(i).getNext()==1)
				{
					customer.remove(i);
					if(time>0)
					{
						customer.add(new Customer(new Rectangle(-1000,195,111,116), level.getNum_orders(),this));	
					}
				}
			}
			
		}
		
		else if(time<=0)
		{
			//FOR END TIME
			Account.getAccount().setCash((int) (Account.getAccount().getCash()+player.getEarnings()));
			if(thrown==0)
			{
				Account.getAccount().setCash(Account.getAccount().getCash()+10);
			}
			else if(thrown<3)
			{
				Account.getAccount().setCash(Account.getAccount().getCash()-5);
			}
			else if(thrown<7)
			{
				Account.getAccount().setCash(Account.getAccount().getCash()-10);
			}
			else if(thrown<14)
			{
				Account.getAccount().setCash(Account.getAccount().getCash()-20);
			}
			else if(thrown>14)
			{
				Account.getAccount().setCash(Account.getAccount().getCash()-30);
			}
			
				Game.setPreviousState(new GameState(game,this.level,this.lvl));
				game.setCurrentState(game.getTimesUpState());
		}
			
		
	}
	public void checkJuice()
	{
		if(!game.getMouseManager().isLeftPressed())
		{
		
			for(int i = 0;i<customer.size();i++)
			{
				if(customer.get(i).getGlasses().size()>0&&customer.get(i).getOrders().size()>0)
				{
					for(int j = 0;j<customer.get(i).getOrders().size();j++)
					{
						if(customer.get(i).getGlasses().get(j).getBounds().contains(game.getMouseX(),game.getMouseY()))
						{
							
							if(redJuicePressed&&redJuiceQuantity>0)
								customer.get(i).getGlasses().get(j).addColor(Colors.Red);
							else if(blueJuicePressed&&blueJuiceQuantity>0)
								customer.get(i).getGlasses().get(j).addColor(Colors.Blue);
							else if(yellowJuicePressed&&yellowJuiceQuantity>0)
								customer.get(i).getGlasses().get(j).addColor(Colors.Yellow);
							
						}
					}	
				}
				
			}
			
			redJuicePressed = blueJuicePressed = yellowJuicePressed = false;
		}
		
		else if(redJuiceBoundary.contains(game.getMouseManager().getMouseX(), game.getMouseManager().getMouseY())
				&&!blueJuicePressed&&!yellowJuicePressed&&!Glass.glassPressed)
		{
			redJuicePressed = true;
			blueJuicePressed = false;
			yellowJuicePressed = false;
			Glass.glassPressed = false;
		}
		else if(blueJuiceBoundary.contains(game.getMouseManager().getMouseX(), game.getMouseManager().getMouseY())
				&&!redJuicePressed&&!yellowJuicePressed&&!Glass.glassPressed)
		{
			redJuicePressed = false;
			blueJuicePressed = true;
			yellowJuicePressed = false;
			Glass.glassPressed = false;
		}
		else if(yellowJuiceBoundary.contains(game.getMouseManager().getMouseX(), game.getMouseManager().getMouseY())
				&&!blueJuicePressed&&!redJuicePressed&&!Glass.glassPressed)
		{
			redJuicePressed = false;
			blueJuicePressed = false;
			yellowJuicePressed = true;
			Glass.glassPressed = false;
		}
		if(redJuicePressed&&redJuiceQuantity<1)
			redReloadThis = true;
		if(blueJuicePressed&&blueJuiceQuantity<1)
			blueReloadThis = true;
		if(yellowJuicePressed&&yellowJuiceQuantity<1)
			yellowReloadThis = true;
		
	}

	//END OF UPDATE
	
	
	
	
	
	//GETTERS AND SETTERS
	public int getThrown() {
		return thrown;
	}

	public void setThrown(int thrown) {
		this.thrown = thrown;
	}

	public Rectangle getStartBoundary() {
		return startBoundary;
	}

	public void setStartBoundary(Rectangle startBoundary) {
		this.startBoundary = startBoundary;
	}

	public boolean isRedReloadThis() {
		return redReloadThis;
	}

	public void setRedReloadThis(boolean redReloadThis) {
		this.redReloadThis = redReloadThis;
	}

	public boolean isBlueReloadThis() {
		return blueReloadThis;
	}

	public void setBlueReloadThis(boolean blueReloadThis) {
		this.blueReloadThis = blueReloadThis;
	}

	public boolean isYellowReloadThis() {
		return yellowReloadThis;
	}

	public void setYellowReloadThis(boolean yellowReloadThis) {
		this.yellowReloadThis = yellowReloadThis;
	}

	public int getRedReloadTime() {
		return redReloadTime;
	}

	public void setRedReloadTime(int redReloadTime) {
		this.redReloadTime = redReloadTime;
	}

	public int getBlueReloadTime() {
		return blueReloadTime;
	}

	public void setBlueReloadTime(int blueReloadTime) {
		this.blueReloadTime = blueReloadTime;
	}

	public int getYellowReloadTime() {
		return yellowReloadTime;
	}

	public void setYellowReloadTime(int yellowReloadTime) {
		this.yellowReloadTime = yellowReloadTime;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public int getRedJuiceQuantity() {
		return redJuiceQuantity;
	}

	public void setRedJuiceQuantity(int redJuiceQuantity) {
		this.redJuiceQuantity = redJuiceQuantity;
	}

	public int getBlueJuiceQuantity() {
		return blueJuiceQuantity;
	}

	public void setBlueJuiceQuantity(int blueJuiceQuantity) {
		this.blueJuiceQuantity = blueJuiceQuantity;
	}

	public int getYellowJuiceQuantity() {
		return yellowJuiceQuantity;
	}

	public void setYellowJuiceQuantity(int yellowJuiceQuantity) {
		this.yellowJuiceQuantity = yellowJuiceQuantity;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Rectangle getRedJuiceBoundary() {
		return redJuiceBoundary;
	}

	public void setRedJuiceBoundary(Rectangle redJuiceBoundary) {
		this.redJuiceBoundary = redJuiceBoundary;
	}

	public Rectangle getBlueJuiceBoundary() {
		return blueJuiceBoundary;
	}

	public void setBlueJuiceBoundary(Rectangle blueJuiceBoundary) {
		this.blueJuiceBoundary = blueJuiceBoundary;
	}

	public Rectangle getYellowJuiceBoundary() {
		return yellowJuiceBoundary;
	}

	public void setYellowJuiceBoundary(Rectangle yellowJuiceBoundary) {
		this.yellowJuiceBoundary = yellowJuiceBoundary;
	}

	public boolean isRedJuicePressed() {
		return redJuicePressed;
	}

	public void setRedJuicePressed(boolean redJuicePressed) {
		this.redJuicePressed = redJuicePressed;
	}

	public boolean isBlueJuicePressed() {
		return blueJuicePressed;
	}

	public void setBlueJuicePressed(boolean blueJuicePressed) {
		this.blueJuicePressed = blueJuicePressed;
	}

	public boolean isYellowJuicePressed() {
		return yellowJuicePressed;
	}

	public void setYellowJuicePressed(boolean yellowJuicePressed) {
		this.yellowJuicePressed = yellowJuicePressed;
	}

	public String getCash() {
		return cash;
	}

	public void setCash(String cash) {
		this.cash = cash;
	}

	public String getRedQuantityString() {
		return redQuantityString;
	}

	public void setRedQuantityString(String redQuantityString) {
		this.redQuantityString = redQuantityString;
	}

	public String getBlueQuantityString() {
		return blueQuantityString;
	}

	public void setBlueQuantityString(String blueQuantityString) {
		this.blueQuantityString = blueQuantityString;
	}

	public String getYellowQuantityString() {
		return yellowQuantityString;
	}

	public void setYellowQuantityString(String yellowQuantityString) {
		this.yellowQuantityString = yellowQuantityString;
	}

	public boolean isProceed() {
		return proceed;
	}

	public void setProceed(boolean proceed) {
		this.proceed = proceed;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getCountdownS() {
		return countdownS;
	}

	public void setCountdownS(String countdownS) {
		this.countdownS = countdownS;
	}
	
	public Rectangle getTrashCanBoundary() {
		return trashCanBoundary;
	}

	public void setTrashCanBoundary(Rectangle trashCanBoundary) {
		this.trashCanBoundary = trashCanBoundary;
	}



}

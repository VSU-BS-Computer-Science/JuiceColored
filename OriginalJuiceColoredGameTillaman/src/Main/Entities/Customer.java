package Main.Entities;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Main.GFX.Assets;
import Main.Levels.Colors;
import Main.States.GameState;

public class Customer extends Entity implements Animateable{
	
	
	//LIST TYPE ATTRIBUTES
	private List<Colors> orders ;
	private List<Glass> glasses ;
	
	//MISC ATTRIBUTE
	private int num_orders;
	private int correct;
	private int next ;
	private int timer;
	private int randNum;
	
	//CLASS ATTRIBUTE
	private GameState gameState;
	
	//POSITIONING ATTRIBUTE
	private static boolean spot1= false,spot2 =false, moving = false;
	private boolean angry;
	
	public Customer(Rectangle bounds,int num_orders,GameState gameState) {
		
		//INITIALIZATIONS
		super(bounds);																																												
		this.gameState = gameState;
		this.num_orders = num_orders;
		this.timer = 0;
		this.correct = 0;
		this.next = 0;
		this.angry = false;
		this.orders = new ArrayList<Colors>();
		this.glasses = new ArrayList<Glass>();
		Glass.numGlass = 0;
		
		
		//FOR RANDOM
		Random random = new Random();
		randNum = random.nextInt(4);
		
		//ORDER A RANDOM JUICE=
		for(int i = 0;i<num_orders;i++)
		{
			orders.add(gameState.getLevel().getColorChoices().get(random.nextInt(gameState.getLevel().getNum_choices())));
			glasses.add(new Glass(new Rectangle(300,296,32,40),gameState));
			
		}

		
	
	}
	@Override
	public void tick() {
		
		spotChecker();
		colorGiveCheck();	
	

		if(glasses.size()>0&&orders.size()>0)
		{
			for(int i = 0;i<orders.size();i++)
			{
				glasses.get(i).setX(bounds.x+30);
				glasses.get(i).tick();
				
			}
		}
		
		
	}

	@Override
	public void render(Graphics g)
	{
		//CUSTOMER IMAGE RENDER
		g.drawImage(Assets.customerArr[randNum], bounds.x , bounds.y, bounds.width, bounds.height, null);
		
		//GLASSES RENDER
			 if(bounds.x>=250)
			 { 
				timer++;
				if(timer>=100&&!angry&&correct!=num_orders)
				{
			 		if(num_orders==1)
			 		{
			 			
			 			for(int i = 0;i<orders.size();i++)
			 			{
					 		if(orders.get(i)==Colors.Red)
					 		{
					 			g.drawImage(Assets.dialog, bounds.x+50 , bounds.y-100, bounds.width-10, bounds.height-10, null);
					 			g.drawImage(Assets.redGlass, bounds.x+85 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								
					 		}
							if(orders.get(i)==Colors.Blue)
								{
									g.drawImage(Assets.dialog, bounds.x+50 , bounds.y-100, bounds.width-10, bounds.height-10, null);
									g.drawImage(Assets.blueGlass, bounds.x+85 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								}
							if(orders.get(i)==Colors.Yellow)
								{
									g.drawImage(Assets.dialog, bounds.x+50 , bounds.y-100, bounds.width-10, bounds.height-10, null);	
									g.drawImage(Assets.yellowGlass, bounds.x+85 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								}
							if(orders.get(i)==Colors.Orange)
								{	
									g.drawImage(Assets.dialog, bounds.x+50 , bounds.y-100, bounds.width-10, bounds.height-10, null);
									g.drawImage(Assets.orangeGlass, bounds.x+85 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								}
							if(orders.get(i)==Colors.Green)
								{
									g.drawImage(Assets.dialog, bounds.x+50 , bounds.y-100, bounds.width-10, bounds.height-10, null);
									g.drawImage(Assets.greenGlass, bounds.x+85 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								}
							if(orders.get(i)==Colors.Violet)
								{
									g.drawImage(Assets.dialog, bounds.x+50 , bounds.y-100, bounds.width-10, bounds.height-10, null);
									g.drawImage(Assets.violetGlass, bounds.x+85 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								}
							if(orders.get(i)==Colors.Brown)
								{
									g.drawImage(Assets.dialog, bounds.x+50 , bounds.y-100, bounds.width-10, bounds.height-10, null);
									g.drawImage(Assets.brownGlass, bounds.x+85 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								}
			 			}	
			 		
			 	
			 		}
					else if(num_orders>1) 
					{
						g.drawImage(Assets.dialog, bounds.x+55 , bounds.y-100, bounds.width+10, bounds.height-10, null);
						for(int i =0;i<orders.size();i++)
						{
							
							if(i==0)
							{
								if(orders.get(i)==Colors.Red)
									g.drawImage(Assets.redGlass, bounds.x+70 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								else if(orders.get(i)==Colors.Blue)
									g.drawImage(Assets.blueGlass, bounds.x+70 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								else if(orders.get(i)==Colors.Yellow)
									g.drawImage(Assets.yellowGlass, bounds.x+70 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								else if(orders.get(i)==Colors.Orange)
									g.drawImage(Assets.orangeGlass, bounds.x+70 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								else if(orders.get(i)==Colors.Green)
									g.drawImage(Assets.greenGlass, bounds.x+70 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								else if(orders.get(i)==Colors.Violet)
									g.drawImage(Assets.violetGlass, bounds.x+70 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								else if(orders.get(i)==Colors.Brown)
									g.drawImage(Assets.brownGlass, bounds.x+70 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								}
							else if(i==1)
							{
								if(orders.get(i)==Colors.Red)
									g.drawImage(Assets.redGlass, bounds.x+100 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								else if(orders.get(i)==Colors.Blue)
									g.drawImage(Assets.blueGlass, bounds.x+100 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								else if(orders.get(i)==Colors.Yellow)
									g.drawImage(Assets.yellowGlass, bounds.x+100 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								else if(orders.get(i)==Colors.Orange)
									g.drawImage(Assets.orangeGlass, bounds.x+100 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								else if(orders.get(i)==Colors.Green)
									g.drawImage(Assets.greenGlass, bounds.x+100 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								else if(orders.get(i)==Colors.Violet)
									g.drawImage(Assets.violetGlass, bounds.x+100 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								else if(orders.get(i)==Colors.Brown)
									g.drawImage(Assets.brownGlass, bounds.x+100 , bounds.y-80, bounds.width/4, bounds.height/3, null);
							}	
							else if(i==2)
							{
								if(orders.get(i)==Colors.Red)
									g.drawImage(Assets.redGlass, bounds.x+130 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								else if(orders.get(i)==Colors.Blue)
									g.drawImage(Assets.blueGlass, bounds.x+130 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								else if(orders.get(i)==Colors.Yellow)
									g.drawImage(Assets.yellowGlass, bounds.x+130 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								else if(orders.get(i)==Colors.Orange)
									g.drawImage(Assets.orangeGlass, bounds.x+130 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								else if(orders.get(i)==Colors.Green)
									g.drawImage(Assets.greenGlass, bounds.x+130 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								else if(orders.get(i)==Colors.Violet)
									g.drawImage(Assets.violetGlass, bounds.x+130 , bounds.y-80, bounds.width/4, bounds.height/3, null);
								else if(orders.get(i)==Colors.Brown)
									g.drawImage(Assets.brownGlass, bounds.x+130 , bounds.y-80, bounds.width/4, bounds.height/3, null);
							}	
							
						}
					
					
					
					}
			 		 if(timer>=1200)
			 		 {
			 			 g.drawImage(Assets.spriteClock[0], bounds.x+120,bounds.y-60, 20, 20, null);
			 			 angry = true;
			 			 timer = 100;
			 		 }
			 		
				 		if(timer<=200)
						{
							g.drawImage(Assets.spriteClock[6], bounds.x+50,bounds.y-25, 20, 20, null);
						}
						else if(timer<=400) {
							g.drawImage(Assets.spriteClock[5], bounds.x+50,bounds.y-25, 20, 20, null);
						}
						else if(timer<=600) {
							g.drawImage(Assets.spriteClock[4], bounds.x+50,bounds.y-25, 20, 20, null);
						}
						else if(timer<=800) {
							g.drawImage(Assets.spriteClock[3], bounds.x+50,bounds.y-25, 20, 20, null);
						}
						else if(timer<=1000) {
							g.drawImage(Assets.spriteClock[2], bounds.x+50,bounds.y-25, 20, 20, null);
						}
						else if(timer<=1200) {
							g.drawImage(Assets.spriteClock[1], bounds.x+50,bounds.y-25, 20, 20, null);
						}
				 		
					}
			 		if(glasses.size()>=0)
		 			{
		 				for(int i = 0;i<orders.size();i++)
		 				glasses.get(i).render(g);
		 				
		 			}	
			 		
			 	}
			}
	
	public void spotChecker()
	{
		if(!spot1)
		{
			
			if(bounds.x<=400)
				{
					bounds.x+=4;
					setMoving(true);
				}
			else
			{
				setMoving(false);
				spot1 = true;
				spot2 = false;		
			}	
		}
		else if(!spot2)
		{
			
			if(bounds.x<=250)
			{
				setMoving(true);
				bounds.x+=4;
			}
			else
			{
				setMoving(false);
				spot2 = true;
				spot1 = false;
			}	
		}
	}
	public void colorGiveCheck()
	{
		
		List<Glass> tempGlass = new ArrayList<Glass>(this.glasses);
		
		for(Glass g : tempGlass)
		{
			if(orders.contains(g.getColor()))
			{
				correct++;
				if(g.getColor()==Colors.Red||g.getColor()==Colors.Blue||g.getColor()==Colors.Yellow)
				{
					gameState.setTime(gameState.getTime()+1);
				}
				else if(g.getColor()==Colors.Orange||g.getColor()==Colors.Green||g.getColor()==Colors.Violet)
				{
					gameState.setTime(gameState.getTime()+2);
				}
				else 
				{
					gameState.setTime(gameState.getTime()+3);
				}
				g.juiceSubtracter();
				gameState.getPlayer().setEarnings((int) (gameState.getPlayer().getEarnings()+pay()));
				this.glasses.remove(g);
				this.orders.remove(g.getColor());
				System.out.println(correct+" "+num_orders);
			}
		}
		
		if(angry||correct==num_orders&&bounds.x<=640)
		{
			bounds.x+=4;
		}
		if(bounds.x>=640)
		{
			if(angry)
			{
				gameState.setTime(gameState.getTime()-2);
			}
			next=1;
			correct = 0;
		}
		
	}
	
	@SuppressWarnings("unused")
	public double pay()
	{
		if(angry)
		{
			gameState.setTime(gameState.getTime()-5);
			angry = false;
		}
		else if(orders.size()>0)
		{
			for(int i = 0;i<num_orders;i++)
			{
				if(orders.get(i)==Colors.Red||orders.get(i)==Colors.Blue||orders.get(i)==Colors.Yellow)
					return 5;
				else if(orders.get(i)==Colors.Orange)
					return 10;
				else if(orders.get(i)==Colors.Violet)
					return 15;
				else if(orders.get(i)==Colors.Green)
					return 20;
				else
						return 25;
			}
			
			
		}
			return 0;
			
	}
	
	//GETTERS AND SETTERS
	public List<Colors> getOrders() {
		return orders;
	}
	public void setOrders(List<Colors> orders) {
		this.orders = orders;
	}
	public int getNumOrders() {
		return num_orders;
	}
	public void setNumOrders(int num_orders) {
		this.num_orders = num_orders;
	}
	public GameState getGameState() {
		return gameState;
	}
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	public void setGlasses(List<Glass> glasses) {
		this.glasses = glasses;
	}
	
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public List<Glass>getGlasses()
	{
		return glasses;
	}
	public boolean isMoving() {
		return moving;
	}
	public int getNum_orders() {
		return num_orders;
	}
	public void setNum_orders(int num_orders) {
		this.num_orders = num_orders;
	}
	public int getCorrect() {
		return correct;
	}
	public void setCorrect(int correct) {
		this.correct = correct;
	}
	public int getTimer() {
		return timer;
	}
	public void setTimer(int timer) {
		this.timer = timer;
	}
	public int getRandNum() {
		return randNum;
	}
	public void setRandNum(int randNum) {
		this.randNum = randNum;
	}
	public boolean isSpot1() {
		return spot1;
	}
	public void setSpot1(boolean spot1) {

		Customer.spot1 = spot1;
	}
	public boolean isSpot2() {
		return spot2;
	}
	public void setSpot2(boolean spot2) {
		Customer.spot2 = spot2;
	}
	public boolean isAngry() {
		return angry;
	}
	public void setAngry(boolean angry) {
		this.angry = angry;
	}
	public boolean setMoving(boolean moving) {
		Customer.moving = moving;
		return moving;
	}

	

}

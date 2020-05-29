package Main.States;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Main.Game;
import Main.GFX.Assets;
import Main.GFX.Text;
import Main.Levels.Colors;
import Main.Levels.Level;
import Main.Player.Account;

public class MenuState extends States {

	private Level [] level ;
	private Rectangle[] bounds;

	
	
	public MenuState(Game game) {
		super(game);
		
		
		bounds = new Rectangle[5];
		bounds[0] = new Rectangle(42,240,92,121);
		bounds[1] = new Rectangle(158,222,92,121);
		bounds[2] = new Rectangle(274,211,92,121);
		bounds[3] = new Rectangle(390,222,92,121);
		bounds[4] = new Rectangle(490,240,92,121);
		
	
		//------------INITIALIZE  5 LEVELS------------
		level = new Level [5];
		
		//LEVEL ONE
		level[0] = new Level ("	Level One");
		level[0].addColorChoice(Colors.Red);
		level[0].addColorChoice(Colors.Blue);
		level[0].addColorChoice(Colors.Yellow);
		level[0].setNumOrders(1);
		level[0].setNum_choices(level[0].getColorChoices().size());
		
		
		//LEVEL TWO
		level[1] = new Level (level[0]);
		level[1].setName("Level Two");
		level[1].addColorChoice(Colors.Orange);
		level[1].setNumOrders(1);
		level[1].setNum_choices(level[1].getColorChoices().size());
		level[1].setCashRequired(50);
		
		//LEVEL THREE
		level[2] = new Level (level[1]);
		level[2].setName("Level Three");
		level[2].addColorChoice(Colors.Violet);
		level[2].setNumOrders(2);
		level[2].setNum_choices(level[2].getColorChoices().size());
		level[2].setCashRequired(300);
		
		//LEVEL FOUR
		level[3] = new Level (level[2]);
		level[3].setName("Level Four");
		level[3].addColorChoice(Colors.Green);
		level[3].setNumOrders(2);
		level[3].setNum_choices(level[3].getColorChoices().size());
		level[3].setCashRequired(500);
		//LEVEL FIVE
		level[4] = new Level (level[3]);
		level[4].setName("Level Five");
		level[4].addColorChoice(Colors.Brown);
		level[4].setNumOrders(3);
		level[4].setNum_choices(level[4].getColorChoices().size());
		level[4].setCashRequired(999);
		//-----END OF INITIALIZATIONS------------
	
		
		
	
	}
	@Override
	public void tick() {
		
		for(int i = 0 ; i<5;i++)			
		{
			if(bounds[i].getBounds().contains(game.getMouseX(),game.getMouseY()))
			{
				
				if(game.getMouseManager().isLeftPressed())
				{
					if(Account.getAccount().getLevel()>i)
					{
						game.setCurrentState(new GameState(game,level[i],i+1));	
					}
					else if(Account.getAccount().getCash()>=level[i].getCashRequired())
					{
						Account.getAccount().setLevel(Account.getAccount().getLevel()+1);
						Account.getAccount().setCash(Account.getAccount().getCash()-level[i].getCashRequired());
					}
					
				}
				
				break;
			}
		}
	}

	@Override
	public void render(Graphics g) {
		if(Account.getAccount().getLevel()==1)
			g.drawImage(Assets.levelBought[0], 0, 0, 640, 480, null);
		else if(Account.getAccount().getLevel()==2)
			g.drawImage(Assets.levelBought[1], 0, 0, 640, 480, null);
		else if(Account.getAccount().getLevel()==3)
			g.drawImage(Assets.levelBought[2], 0, 0, 640, 480, null);
		else if(Account.getAccount().getLevel()==4)
			g.drawImage(Assets.levelBought[3], 0, 0, 640, 480, null);
		else if(Account.getAccount().getLevel()==5)
			g.drawImage(Assets.levelBought[4], 0, 0, 640, 480, null);
		
		for(int i = 0 ; i<5;i++)			
		{
				if(bounds[i].getBounds().contains(game.getMouseX(),game.getMouseY()))
				{
					g.drawImage(Assets.level[i], bounds[i].x, bounds[i].y, bounds[i].width, bounds[i].height, null);	
				}
			
			
		}
		Text.drawString(g, "$"+Integer.toString(Account.getAccount().getCash()), 300, 390, true, Color.white, Assets.font28);
		
		
	}
	public Level[] getLevel() {
		return level;
	}
	public void setLevel(Level[] level) {
		this.level = level;
	}
	public Rectangle[] getBounds() {
		return bounds;
	}
	public void setBounds(Rectangle[] bounds) {
		this.bounds = bounds;
	}
	
	
	

}

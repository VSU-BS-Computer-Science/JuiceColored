package Main.States;

import java.awt.Graphics;
import java.awt.Rectangle;

import Main.Game;
import Main.GFX.Assets;

public class HomeState extends States {

	private Rectangle playButton;
	
	public HomeState(Game game) {
		super(game);
		playButton = new Rectangle(213,281,214,104);
		
	}
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.homeState, 0, 0, game.getWidth(), game.getHeight(),null);
	
		
		if(playButton.contains(game.getMouseX(),game.getMouseY()))
		{
			g.drawImage(Assets.playButton, playButton.x, playButton.y, playButton.width, playButton.height,null);
	
			
				if(game.getMouseManager().isLeftClicked())
				{
					game.setCurrentState(game.getMenuState());
				
				}
			}
			
		}
		
		
		
		
	}
	

	



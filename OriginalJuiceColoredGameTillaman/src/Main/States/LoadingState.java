package Main.States;

import java.awt.Graphics;
import Main.Game;
import Main.GFX.Assets;

public class LoadingState extends States {

		
	private int timer;
	private String stateName;
	
	public LoadingState(Game game,String stateName) {
		super(game);
		this.timer = 0;
		this.stateName = stateName;
	}
	@Override
	public void tick() {
			timer++;
			if(timer==60)
			{	game.getMouseManager().setLeftClicked(false);
				game.getMouseManager().setLeftPressed(false);
				if(stateName=="MenuState")
				game.setCurrentState(game.getMenuState());
				else if(stateName=="HomeState")
				game.setCurrentState(game.getHomeState());
				
				timer = 0;
			}
	}

	@Override
	public void render(Graphics g) {
			
		g.drawImage(Assets.loadingState, 0, 0, game.getWidth(), game.getHeight(),null);
		
			
			
			
			
			
		}
		

		



	
	
	
}

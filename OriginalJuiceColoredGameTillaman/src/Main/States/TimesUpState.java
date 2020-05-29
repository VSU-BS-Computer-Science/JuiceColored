package Main.States;

import java.awt.Graphics;
import java.awt.Rectangle;

import Main.Game;
import Main.GFX.Assets;

public class TimesUpState extends States{

	
	private Rectangle restartBoundary;
	private Rectangle levelsBoundary;
	private Rectangle homeBoundary;

	public TimesUpState(Game game) {
		super(game);
		restartBoundary = new Rectangle(205,157,237,68);
		levelsBoundary = new Rectangle(205,226,237,68);
		homeBoundary = new Rectangle(255,316,126,70);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.timesUpState, 0, 0, game.getWidth(), game.getHeight(), null);
		
		if(restartBoundary.contains(game.getMouseX(),game.getMouseY()))
		{
			g.drawImage(Assets.restartButton, restartBoundary.x, restartBoundary.y, restartBoundary.width, restartBoundary.height, null);
			if(game.getMouseManager().isLeftPressed())
			{
				game.setCurrentState(Game.getPreviousState());
			}
		
		}
		else if(levelsBoundary.contains(game.getMouseX(),game.getMouseY()))
		{
			g.drawImage(Assets.levelsButton, levelsBoundary.x, levelsBoundary.y, levelsBoundary.width, levelsBoundary.height, null);
			if(game.getMouseManager().isLeftPressed())
			{
				game.setCurrentState(game.getLoadingState());
			}
		}
		else if(homeBoundary.contains(game.getMouseX(),game.getMouseY()))
		{
			g.drawImage(Assets.homeButton, homeBoundary.x, homeBoundary.y, homeBoundary.width, homeBoundary.height, null);
			System.out.println("home");
			if(game.getMouseManager().isLeftPressed())
			{
				game.setCurrentState(game.getLoadingHome());
			}
		}
		
	
	
	
	
	}
	

	//GETTERS AND SETTERS
	public Rectangle getRestartBoundary() {
		return restartBoundary;
	}

	public void setRestartBoundary(Rectangle restartBoundary) {
		this.restartBoundary = restartBoundary;
	}

	public Rectangle getLevelsBoundary() {
		return levelsBoundary;
	}

	public void setLevelsBoundary(Rectangle levelsBoundary) {
		this.levelsBoundary = levelsBoundary;
	}

	public Rectangle getHomeBoundary() {
		return homeBoundary;
	}

	public void setHomeBoundary(Rectangle homeBoundary) {
		this.homeBoundary = homeBoundary;
	}

}

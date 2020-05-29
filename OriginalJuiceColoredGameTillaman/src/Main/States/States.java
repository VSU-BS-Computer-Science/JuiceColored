package Main.States;

import java.awt.Graphics;

import Main.Game;

public abstract class States {
	
	private static States currentState = null;
	protected Game game;
	
	//CONSTRUCTOR
		public States (Game game)
		{
			this.game = game;
		
		}
	public abstract void tick();
	public abstract void render(Graphics g);
	public static States getCurrentState() {
		return currentState;
	}
	public static void setCurrentState(States currentState) {
		States.currentState = currentState;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	
	
	

}

package Main.Entities;
import java.awt.Rectangle;

public abstract class Entity {
	
	protected Rectangle bounds;
	
	public Entity(Rectangle bounds)
	{
		this.bounds = bounds;
	}
	
	
	//GETTERS AND SETTERS
	public Rectangle getBounds()
	{
		return this.bounds;
	}
	public void setBounds(Rectangle bounds)
	{
		this.bounds = bounds;
	}
	public void setX(int x)
	{
		this.bounds.x = x;
	}
	public int getX()
	{
		return this.bounds.x;
	}
	
	

}

package Main.GFX;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage sprite;
	
	public SpriteSheet (BufferedImage player)
	{
		this.sprite = player;
	}
	public BufferedImage crop(int x, int y, int w, int h)
	{
		return sprite.getSubimage(x, y, w, h);
	}
	
}

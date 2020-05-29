package Main.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean [] keys;
	public boolean red, blue, yellow,orange,green,violet,enter,mixer,reload;
	public boolean restart;
	
	public KeyManager()
	{
		keys = new boolean [256];
		
	}
	public void tick()
	{
		//COLOR KEYS
		restart = keys[KeyEvent.VK_ESCAPE];
		red = keys[KeyEvent.VK_Q];
		blue = keys[KeyEvent.VK_W];
		yellow = keys[KeyEvent.VK_E];
		orange = keys[KeyEvent.VK_A];
		green = keys[KeyEvent.VK_S];
		violet = keys[KeyEvent.VK_D];
		
		
		//MISC
		reload = keys[KeyEvent.VK_ALT];
		enter = keys[KeyEvent.VK_ENTER];
		mixer = keys[KeyEvent.VK_SPACE];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {}



}

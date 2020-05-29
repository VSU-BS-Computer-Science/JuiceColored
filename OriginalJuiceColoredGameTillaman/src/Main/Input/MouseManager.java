package Main.Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;



public class MouseManager implements MouseListener,MouseMotionListener{

	private boolean leftPressed, rightPressed,leftClicked,rightClicked,leftDragged;
	private int mouseX, mouseY;
	private int clickCount = 0;

	
	public void mouseDown(MouseEvent e)
	{
		System.out.println("mousedown");
	}
	public void mousePressed(MouseEvent e) {
		
		if(e.getButton()==MouseEvent.BUTTON1)
		{
			leftPressed=true;
		}
			
		else if(e.getButton()==MouseEvent.BUTTON3)
			rightPressed=true;

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1)
			{
				leftPressed=false;
			
			}
		else if(e.getButton()==MouseEvent.BUTTON3)
			rightPressed=false;
		System.out.println(leftPressed);

		//System.out.println("Rel");
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		if(e.getButton()==MouseEvent.BUTTON1)
			leftDragged=true;
		//System.out.println("Dragged");
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getButton()==MouseEvent.BUTTON1)
			{
				leftClicked=true;
			}
		else if(e.getButton()==MouseEvent.BUTTON3)
			{
				rightClicked=true;
			}
		
		
			
		
		
	}


	public boolean isLeftDragged() {
		return leftDragged;
	}
	public void setLeftDragged(boolean leftDragged) {
		this.leftDragged = leftDragged;
	}
	
	public int getClickCount() {
		return clickCount;
	}
	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}
	public void setLeftPressed(boolean leftPressed) {
		this.leftPressed = leftPressed;
	}
	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}
	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}
	public boolean isRightClicked() {
		return rightClicked;
	}
	public void setRightClicked(boolean rightClicked) {
		this.rightClicked = rightClicked;
	}
	public void setRightPressed(boolean rightPressed) {
		this.rightPressed = rightPressed;
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	//GETTERS
	
	
	public boolean isLeftPressed()
	{
		return leftPressed;
	}
	public boolean isRightPressed()
	{
		return rightPressed;
	}
	public int getMouseX() {
		return mouseX;
	}
	public boolean isLeftClicked() {
		return leftClicked;
	}
	public void setLeftClicked(boolean leftClicked) {
		this.leftClicked = leftClicked;
	}
	public int getMouseY() {
		return mouseY;
	}
	//
}

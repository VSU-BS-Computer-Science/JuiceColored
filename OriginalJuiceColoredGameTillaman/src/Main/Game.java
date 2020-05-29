package Main;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JFileChooser;

import Main.Display.Display;
import Main.GFX.Assets;
import Main.GFX.SpriteSheet;
import Main.Input.MouseManager;
import Main.States.HomeState;
import Main.States.LoadingState;
import Main.States.MenuState;
import Main.States.States;
import Main.States.TimesUpState;

public class Game implements Runnable{
	
	
	//CLASSES
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	private Display display; 
	private BufferedImage test;
	private SpriteSheet sheet;
	
	//ATTRIBUTES
	public boolean running;
	private String title;
	private int width,height;
	
	//INPUT
	private MouseManager mouseManager;
	//STATES
	private States homeState, menuState,timesUpState,loadingState,loadingHome;
	private static States currentState = null,previousState = null;
	
	//MOUSE COORDINATES
	private Point mousePoint;
	private long timer;
	private int ticks;

	public Game(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		this.running = false;
		mouseManager = new MouseManager();
		mousePoint = new Point(mouseManager.getMouseX(),mouseManager.getMouseY());
	
	}
	
	public void init()
	{
		display = new Display(title,width,height);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		mousePoint = new Point(mouseManager.getMouseX(),mouseManager.getMouseY());
		Assets.init();
		
		
	
		menuState = new MenuState (this);
		homeState = new HomeState(this);
		timesUpState = new TimesUpState(this);
		loadingState = new LoadingState(this,"MenuState");
		loadingHome= new LoadingState(this,"HomeState");
		currentState = homeState;
	
	
	}
	
	
	

	public void tick()
	{
		
		
		currentState.tick();
		
	}

	public void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		if(bs==null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		//DRAW
		
		g.fillRect(0, 0, width, height);
	
		currentState.render(g);
		
		
		
		//END
		
		bs.show();
		g.dispose();
		
		
	}
	public synchronized void start()
	{
		if(running)
			return;
		running  = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop()
	{
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		init();
		
		
		//CONSISTENT GAME LOOP
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		setTimer(0);
		setTicks(0);
		
		while(running)
		{
			now = System.nanoTime();
			delta +=(now-lastTime)/timePerTick;
			setTimer(getTimer() + now-lastTime);
			lastTime = now;
			
			if(delta>=1)
			{
				tick();
				render();
				setTicks(getTicks() + 1);
				delta--;
			}
			
		}
		stop();
	}

	
	//GETTERS AND SETTERS
	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public BufferStrategy getBs() {
		return bs;
	}

	public void setBs(BufferStrategy bs) {
		this.bs = bs;
	}

	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public BufferedImage getTest() {
		return test;
	}

	public void setTest(BufferedImage test) {
		this.test = test;
	}

	public SpriteSheet getSheet() {
		return sheet;
	}

	public void setSheet(SpriteSheet sheet) {
		this.sheet = sheet;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public void setMouseManager(MouseManager mouseManager) {
		this.mouseManager = mouseManager;
	}

	public States getMenuState() {
		return menuState;
	}

	public void setMenuState(States menuState) {
		this.menuState = menuState;
	}

	public States getCurrentState() {
		return currentState;
	}

	public void setCurrentState(States currentState) {
		Game.currentState = currentState;
	}

	public float getMouseX()
	{
		return mouseManager.getMouseX();
	}
	public float getMouseY()
	{
		return mouseManager.getMouseY();
	}
	public Point getMousePoint() {
		return mousePoint;
	}

	public void setMousePoint(Point mousePoint) {
		this.mousePoint = mousePoint;
	}

	public long getTimer() {
		return timer;
	}

	public void setTimer(long timer) {
		this.timer = timer;
	}

	public int getTicks() {
		return ticks;
	}

	public void setTicks(int ticks) {
		this.ticks = ticks;
	}

	public static States getPreviousState() {
		return previousState;
	}

	public static void setPreviousState(States previousState) {
		Game.previousState = previousState;
	}

	public States getLoadingHome() {
		return loadingHome;
	}

	public void setLoadingHome(States loadingHome) {
		this.loadingHome = loadingHome;
	}

	public States getTimesUpState() {
		return timesUpState;
	}

	public void setTimesUpState(States timesUpState) {
		this.timesUpState = timesUpState;
	}

	public States getHomeState() {
		return homeState;
	}

	public void setHomeState(States homeState) {
		this.homeState = homeState;
	}
	public States getLoadingState() {
		return loadingState;
	}

	public void setLoadingState(States loadingState) {
		this.loadingState = loadingState;
	}
		
}

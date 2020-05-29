package Main.Levels;

import java.util.ArrayList;
import java.util.List;

public class Level {

	//ATTRIBUTES
	private String name;
	private List <Colors> color_choices = new ArrayList <Colors>();;
	private int num_orders;
	private int rating;
	private int num_choices;
	private int cashRequired;
	public int getCashRequired() {
		return cashRequired;
	}
	public void setCashRequired(int cashRequired) {
		this.cashRequired = cashRequired;
	}
	public Level(String name)
	{
		this.name = name;
		this.rating = 0;
	}
	public Level (Level level)
	{
		this.color_choices = level.color_choices;
		this.num_orders = level.num_orders;
		this.rating = 0;
		this.num_choices = color_choices.size();
	}
	public void addColorChoice(Colors color)
	{
		color_choices.add(color);
	}
	//GETTERS AND SETTERS
	public List<Colors> getColorChoices()
	{
		return color_choices;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getNumOrders()
	{
		return num_orders;
	}
	public void setNumOrders(int num_orders)
	{
		this.num_orders = num_orders;
	}
	public int getRating() 
	{
		return rating;
	}
	public void setRating(int rating) 
	{
		this.rating = rating;
	}
	public List<Colors> getColor_choices() {
		return color_choices;
	}
	public void setColor_choices(List<Colors> color_choices) {
		this.color_choices = color_choices;
	}
	public int getNum_orders() {
		return num_orders;
	}
	public void setNum_orders(int num_orders) {
		this.num_orders = num_orders;
	}
	public int getNum_choices() {
		return num_choices;
	}
	public void setNum_choices(int num_choices) {
		this.num_choices = num_choices;
	}


}

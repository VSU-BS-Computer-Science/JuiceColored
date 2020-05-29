package Main.Player;

public class Player {

	private int earnings;

	private Account account;
	public Player()
	{
		this.earnings = 0;
		
	}
	public void setEarnings(int earnings)
	{
		//account.setCash(account.getCash()+earnings);
		this.earnings = earnings;
		
		
	}
	public double getEarnings()
	{
		return earnings;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	

}

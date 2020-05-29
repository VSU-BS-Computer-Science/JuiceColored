package Main.Player;

public class Account {
	
	private static Account accountInstance = new Account();
	private static int level;
	private static int cash;
	
	private Account()
	{
		level = 1;
		cash = 0;
	}
	public static void setAccount(Account account)
	{
		accountInstance = account;
	}
	public static Account getAccount()
	{
		return accountInstance;
		
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		Account.level = level;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		Account.cash = cash;
	}
	
}

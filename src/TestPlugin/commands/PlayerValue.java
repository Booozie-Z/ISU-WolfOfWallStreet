package TestPlugin.commands;
/**
 * 
 * @author Diego
 *	This is the very beginnings of the maths to get the player balance.
 */
public class PlayerValue {
	
	private double balance;
	
	public void newPlayerValue(){
		//name = player.getName();
		//wolf.getConfig().set("PlayersBalance.name", balance);
	}
	public double getBalance(){
		return balance;
	}
	public void addValue(double amount){
		balance += amount;
	}
	public void subtractValue(double amount){
		balance -= amount;
	}
	public void setValue(double amount){
		balance = amount;
	}
}

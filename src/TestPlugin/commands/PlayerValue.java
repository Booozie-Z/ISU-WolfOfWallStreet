package TestPlugin.commands;

public class PlayerValue {
	
	private double balance;
	
	public void newPlayerValue(){
		balance = 0;
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

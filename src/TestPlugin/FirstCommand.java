package TestPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class FirstCommand extends JavaPlugin{
	@Override
	public void onEnable(){
		getLogger().info("WolfOfWallStreet has been enabled.");//Sends Message in console when Plugin is loaded.
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("PjSucks")) { // If the player typed /basic then do the following...
			sender.sendMessage("Yes he does.");
			return true;
		} //If this has happened the function will return true. 
	        // If this hasn't happened the value of false will be returned.
		return false; 
	}
	@Override
	public void onDisable(){
		getLogger().info("WolfOfWallStreet has been disabled.");
	}
}

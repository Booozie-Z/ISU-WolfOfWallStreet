package TestPlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class ValueCommands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
	
		if (cmd.getName().equalsIgnoreCase("Balance")) { // If the player typed /basic then do the following...
			sender.sendMessage(ChatColor.RED + player.getName() + ChatColor.GREEN + ": 0 (Balance unfinished.)");
			
			return true;
		}
		
		return false; 
	}

}

package Wolf.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class pjsucks implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("PjSucks")) { // If the player typed /basic then do the following...
			sender.sendMessage("Yes he does.");
			
			return true;
		}
		return false; 
	}

}

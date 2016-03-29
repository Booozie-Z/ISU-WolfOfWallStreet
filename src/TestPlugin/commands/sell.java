package TestPlugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class sell implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("sell")) {
			if(args.length != 4){
				sender.sendMessage("Usage: /sell :item: :amount: :price:");
				return true;
			}
			sender.sendMessage("You are trying to sell " + args[2] + " " +  args[1] + " for " + args[3]);
		}
	return false;
	}
}

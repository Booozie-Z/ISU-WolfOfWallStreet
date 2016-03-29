package TestPlugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class sellTest implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("sell")) {
			if(args.length != 3){
				sender.sendMessage("Usage: /sell :item: :amount: :price:");
				return true;
			}
			sender.sendMessage("You are trying to sell " + args[1] + " " +  args[0] + " for "
																		+ args[2] + " dolla dolla bills yall.");
			return true;
		}
	return false;
	}
}

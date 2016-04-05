package TestPlugin.commands;

import java.util.Scanner;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Sell implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("sell")) {
			if (args.length != 3) {
				sender.sendMessage(ChatColor.BOLD + "Usage: /sell :item: :amount: :price:");
				return true;
			}
			//Dolla dolla bills yall is a placeholder for currency name.
			sender.sendMessage(ChatColor.GREEN + "You are trying to sell " + args[1] + " " + args[0] + " for " + args[2]
					+ ChatColor.ITALIC + ChatColor.DARK_GREEN + " dolla dolla bills yall.");
			takeItem(sender, args);
			return true;
		}
		return false;
	}

	private void takeItem(CommandSender sender, String[] args) {
		int itemAmount = Integer.parseInt(args[1]);
		Player player = (Player) sender;
		ItemStack selling = new ItemStack(Material.matchMaterial(args[0]));
		selling.setAmount(itemAmount);
		if (!player.getInventory().contains(selling)) {
			sender.sendMessage("");
			sender.sendMessage(ChatColor.RED + "You dont have " + itemAmount + " " + args[0] + ".");
		}else{
			player.getInventory().removeItem(selling);
			player.updateInventory();
			//Add itemstack info to the players config.
		}
	}
}
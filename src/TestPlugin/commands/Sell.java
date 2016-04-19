package TestPlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Sell implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("sell")) {
			if (args.length != 3) {
				sender.sendMessage(ChatColor.BOLD + "Usage: /sell :item: :amount: :price:");
				return true;
			}
			takeItem(sender, args);
			return true;
		}
		return false;
	}

	private void takeItem(CommandSender sender, String[] args) {
		int itemAmount = Integer.parseInt(args[1]);
		Player player = (Player) sender;
		Material matSelling = Material.matchMaterial(args[0]);
		ItemStack selling = new ItemStack(matSelling);
		selling.setAmount(itemAmount);
		if (player.getInventory().contains(matSelling) && itemAmount <= getAmountOfItems(player, args)) {
			if (player.getInventory().contains(matSelling, getAmountOfItems(player, args))) {
				sender.sendMessage("Amount in inventory: " + getAmountOfItems(player, args));
				sender.sendMessage("Amount trying to sell: " + itemAmount);
				// Dolla dolla bills yall is a placeholder for currency name.
				sender.sendMessage(ChatColor.GREEN + "You are trying to sell " + args[1] + " " + args[0] + " for "
						+ args[2] + ChatColor.ITALIC + ChatColor.DARK_GREEN + " dolla dolla bills yall.");
				ItemStack sellOne = new ItemStack(matSelling);
				sellOne.setAmount(1);
				int itemsSold = 0;
				while (itemsSold <= itemAmount) {
					player.getInventory().remove(sellOne);
					itemsSold++;
					player.updateInventory();
				}
				// while (player.getInventory().contains(matSelling,
				// itemAmount)) {
				// player.getInventory().removeItem(sellOne);
				// }				
				// Add itemstack info to the players config.
			}
		} else {
			sender.sendMessage(ChatColor.RED + "You dont have " + itemAmount + " " + args[0] + ".");
		}
	}

	private int getAmountOfItems(Player p, String[] args) {
		int amount = 0;
		Material.matchMaterial(args[0]);
		for (ItemStack is : p.getInventory().all(Material.matchMaterial(args[0])).values()) {
			amount = amount + is.getAmount();
		}
		return amount;
	}
}
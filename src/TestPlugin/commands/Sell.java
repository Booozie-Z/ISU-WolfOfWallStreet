package TestPlugin.commands;

import java.io.File;

//import java.util.Scanner;

//import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
//import org.bukkit.inventory.Inventory;
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

	@SuppressWarnings("deprecation")
	private void takeItem(CommandSender sender, String[] args) {
		File f = new File("C:/Users/Digo Barreiro/Documents/plugin/BuildTools/plugins/WolfOfWallStreet/" + File.separator + sender.getName() + ".yml");
        FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		
		int itemAmount = Integer.parseInt(args[1]);
		int stacks = itemAmount/64;
		Player player = (Player) sender;
		ItemStack selling = new ItemStack(Material.matchMaterial(args[0]));
		selling.setAmount(itemAmount);
		if (!player.getInventory().contains(selling, stacks)) {
			sender.sendMessage("");
			sender.sendMessage(ChatColor.RED + "You dont have " + itemAmount + " " + args[0] + ".");
		}else{
			player.getInventory().removeItem(selling);
			player.updateInventory();
			//Add itemstack info to the players config.
			
			
			
            playerData.set("selling." + selling.getTypeId(), itemAmount);
		}
	}
}
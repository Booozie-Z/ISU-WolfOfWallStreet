package TestPlugin.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Sell implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		File f = new File("/plugins/WolfOfWallStreet/" + File.separator + sender.getName() + ".yml");
		if (cmd.getName().equalsIgnoreCase("sell")) {
			if (args.length != 3) {
				sender.sendMessage(ChatColor.BOLD + "Usage: /sell :item: :amount: :price:");
				return true;
			}
			takeItem(sender, args);
			FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
			try {
				playerData.save(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	private void takeItem(CommandSender sender, String[] args){
		File f = new File("/plugins/WolfOfWallStreet/" + File.separator + sender.getName() + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		int itemAmount = Integer.parseInt(args[1]);
		int itemPrice = Integer.parseInt(args[2]);
		Player player = (Player) sender;
		Material matSelling = Material.matchMaterial(args[0]);
		ItemStack selling = new ItemStack(matSelling);
		selling.setAmount(itemAmount);
		if (player.getInventory().contains(matSelling) && itemAmount <= getAmountOfItems(player, args)) {
			if (player.getInventory().contains(matSelling, getAmountOfItems(player, args))) {
				sender.sendMessage("Amount in inventory: " + getAmountOfItems(player, args));
				sender.sendMessage("Amount trying to sell: " + itemAmount);
				Bukkit.getServer().broadcastMessage(ChatColor.BLUE + player.getDisplayName() + " is selling " + args[1]
						+ " " + args[0] + " for $" + args[2]);
				player.getInventory().removeItem(selling);
				sender.sendMessage("Amount in inventory: " + getAmountOfItems(player, args));			
				playerData.set("selling.price", 69);
				sender.sendMessage("Amount in inventory: " + getAmountOfItems(player, args));	
				if(playerData.getString("selling.item") == " " || playerData.getInt("selling.amount") == 0){
					playerData.set("selling.item" , matSelling.toString());
					playerData.set("selling.amount", itemAmount);
					playerData.set("selling.price", itemPrice);
				} else if (playerData.getString("selling.item") == matSelling.toString()) {
					int temp = playerData.getInt("selling.amount");
					playerData.set("selling.amount", itemAmount + temp);
					playerData.set("selling.price", itemPrice);
				}
				try {
					playerData.save(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				sender.sendMessage(ChatColor.RED + "You dont have " + itemAmount + " " + args[0] + ".");
			}
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
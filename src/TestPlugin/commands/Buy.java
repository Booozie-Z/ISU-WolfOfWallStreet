package TestPlugin.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Buy implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("buy")) {
			if (args.length != 3) {
				sender.sendMessage(ChatColor.BOLD + "Usage: /buy item amount price");
				return true;
			}
			// Check for item that a random player is selling.
			// buy the item
			// update both players balance.
			getItem(sender, args);
			return true;
		}
		return false;
	}

	private void getItem(CommandSender sender, String[] args) {
		Player player = (Player) sender;
		String playerName = player.getName();
		File sent = new File("./plugins/WolfOfWallStreet/" + File.separator + playerName + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(sent);
		int buyerBal = playerData.getInt("currency.balance");
		int itemAmount = Integer.parseInt(args[1]);
		int itemPrice = Integer.parseInt(args[2]);
		if(buyerBal>=itemAmount*itemPrice){
			buyerBal -= itemAmount*itemPrice;
			playerData.set("currency.balance", buyerBal);	
			// Get item from config
			// parse item into itemstack
			ItemStack buying = new ItemStack(Material.matchMaterial(args[0]));
			// Check if seller has enough of item
			buying.setAmount(itemAmount);// itemAmount<sellAmount
			player.getInventory().addItem(buying);
			player.updateInventory();
			// remove item from seller config
		}else{
			player.sendMessage(ChatColor.RED + "You don't have enough money. :(");
			return;
		}
		
		try {
			playerData.save(sent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

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

public class Buy implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("buy")) {
			Player player = (Player) sender;
			File play = new File("./plugins/WolfOfWallStreet/" + File.separator + player.getName().toString() + ".yml");
  			FileConfiguration mplayerData = YamlConfiguration.loadConfiguration(play);
			if (args.length != 2) {
				sender.sendMessage(ChatColor.BOLD + "Usage: /buy item amount");
				return true;
			}
			
			
			for(Player p : Bukkit.getOnlinePlayers()){
				Material matSelling = Material.matchMaterial(args[0]);
				File f = new File("./plugins/WolfOfWallStreet/" + File.separator + p.getName().toString() + ".yml");
	  			FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
				if(playerData.contains("selling." + matSelling.toString())){
					String s = playerData.getString("selling." + matSelling.toString());
					int amount = Integer.parseInt(args[1]);
					int pricePer = playerData.getInt("selling.price");
					ItemStack stack = new ItemStack(matSelling, amount);
					
					p.getInventory().addItem(stack);
					
					int mbal = mplayerData.getInt("currency.balance");
					int bal = playerData.getInt("currency.balance");
					
					if(playerData.getInt("selling.amount") > amount ){
						playerData.set("selling.amount", playerData.getInt("selling.amount") - amount);
					}else{
						playerData.set("selling." + matSelling.toString(), "");
						playerData.set("selling.amount", 0);
						playerData.set("selling.price", 0);
					}
					
					
					mplayerData.set("currency.balance", mbal + (pricePer * amount));
					playerData.set("currency.balance", bal - (pricePer * amount));
					try {
						playerData.save(f);
						mplayerData.save(play);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Bukkit.getServer().broadcastMessage(player.getName().toString() + " just bought " + amount + " " + s + ". There are " + playerData.getInt("selling.amount") + " " + s + " left!");
					return true;
				}
				//mplayerData.set("currency.balance", 222);                                  //test
				player.sendMessage("This item is not being sold at the moment");
				
				try {
					mplayerData.save(play);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
			
			
			// Check for item that a random player is selling.
			// buy the item
			// update both players balance.
			//getItem(sender, args);
			
			return true;
		}
		return false;
	}

	/*private void getItem(CommandSender sender, String[] args) {
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
	}*/

}

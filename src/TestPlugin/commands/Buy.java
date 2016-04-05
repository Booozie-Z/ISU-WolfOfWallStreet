package TestPlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Buy implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("buy")){
			if(args.length != 2){
				sender.sendMessage(ChatColor.BOLD + "Usage: /buy item amount");
				return true;
			}
			//Check for item that a random player is selling.
			//buy the item
			//update both players balance.
			getItem(sender, args);
			return true;
		}
		return false;
	}
	private void getItem(CommandSender sender, String[] args){
		Player player = (Player) sender;
		int itemAmount = Integer.parseInt(args[1]);
		//Get item from config
		//parse item into itemstack
		ItemStack buying = new ItemStack(Material.matchMaterial(args[0]));
		//Check if seller has enough of item
		buying.setAmount(itemAmount);//itemAmount<sellAmount
		player.getInventory().addItem(buying);
		player.updateInventory();
		//remove item from seller config
	}
}

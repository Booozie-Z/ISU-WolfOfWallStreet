package TestPlugin.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import org.bukkit.plugin.*;
import org.bukkit.*;


public class ValueCommands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
	
		if (cmd.getName().equalsIgnoreCase("Balance")) { // If the player typed /balance then do the following...
			String playerName = player.getName();
			File f = new File("/plugins/WolfOfWallStreet/" + File.separator + playerName + ".yml");
			FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
			
			
			int value = playerData.getInt("currency.balance");
			sender.sendMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + ": " + value);
			
			return true;
		}
		//Give is already a command so I changed it to addBal
		if (cmd.getName().equalsIgnoreCase("addBal")){
			String playerName = player.getName();
			File f = new File("/plugins/WolfOfWallStreet/" + File.separator + playerName + ".yml");
			FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
			
			int value = playerData.getInt("currency.balance");
			int add = Integer.parseInt(args[0]);
			value += add;
			playerData.set("currency.balance", value);
			
			try {
				playerData.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("SetBalance")){
			String playerName = player.getName();
			File f = new File("/plugins/WolfOfWallStreet/" + File.separator + playerName + ".yml");
			FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
			
			int set = Integer.parseInt(args[0]);
			int value = set;
			int balance = playerData.getInt("currency.balance");
			playerData.set("currency.balance", value);
			try {
				playerData.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
			sender.sendMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + ": " + balance);
			return true;
		}
		
		return false; 
	}

}

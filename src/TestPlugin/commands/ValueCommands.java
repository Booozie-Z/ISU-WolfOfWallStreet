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
	
		if (cmd.getName().equalsIgnoreCase("Balance")) { // If the player typed /basic then do the following...
<<<<<<< HEAD
			String playerName = player.getName();
			File f = new File("C:/Users/Digo Barreiro/Documents/plugin/BuildTools/plugins/WolfOfWallStreet/" + File.separator + playerName + ".yml");
			FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
			
			
			int value = playerData.getInt("currency.balance");
			sender.sendMessage(ChatColor.RED + "Your name is " + player.getName() + " and you have $" + value);
			
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("Give")){
			String playerName = player.getName();
			File f = new File("C:/Users/Digo Barreiro/Documents/plugin/BuildTools/plugins/WolfOfWallStreet/" + File.separator + playerName + ".yml");
			FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
			
			int value = playerData.getInt("currency.balance");
			int add = Integer.parseInt(args[0]);
			value += add;
			playerData.set("currency.balance", value);
			
			try {
				playerData.save(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("SetBalance")){
			String playerName = player.getName();
			File f = new File("C:/Users/Digo Barreiro/Documents/plugin/BuildTools/plugins/WolfOfWallStreet/" + File.separator + playerName + ".yml");
			FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
			
			int set = Integer.parseInt(args[0]);
			int value = set;
			playerData.set("currency.balance", value);
=======
			sender.sendMessage(ChatColor.RED + player.getName() + ChatColor.GREEN + ": 0 (Balance unfinished.)");
>>>>>>> 79eb94232dd4442de31331028121cc8dd0d3c840
			
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

}

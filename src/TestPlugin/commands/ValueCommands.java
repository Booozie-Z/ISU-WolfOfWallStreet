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

//import org.bukkit.plugin.*;
import org.bukkit.*;


public class ValueCommands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("Balance") && args.length == 0) { // If the player typed /basic then do the following...
			String playerName = player.getName();
			File f = new File("C:/Users/Digo Barreiro/Documents/plugin/BuildTools/plugins/WolfOfWallStreet/" + File.separator + playerName + ".yml");
			FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
			int value = playerData.getInt("currency.balance");
			sender.sendMessage(ChatColor.GREEN + "Your balance is $" + value);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("Balance") && args.length == 1){
			if(player.isOp() == false && !(args[0].equals(player.getName()))){
				sender.sendMessage(ChatColor.RED + "Sorry, you do not have permission to use this command!");
				return false;
			}
			String playerName = args[0];
			File f = new File("C:/Users/Digo Barreiro/Documents/plugin/BuildTools/plugins/WolfOfWallStreet/" + File.separator + playerName + ".yml");
			FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
			int value = playerData.getInt("currency.balance");
			sender.sendMessage(ChatColor.GREEN + playerName + "'s balance is $" + value);
			return true;
			
		}
		
		
		
		
		
		
		if (cmd.getName().equalsIgnoreCase("Give") && args.length == 1){
			if(player.isOp() == false){
				sender.sendMessage(ChatColor.RED + "Sorry, you do not have permission to use this command!");
				return false;
			}
			String playerName = player.getName();
			File f = new File("C:/Users/Digo Barreiro/Documents/plugin/BuildTools/plugins/WolfOfWallStreet/" + File.separator + playerName + ".yml");
			FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
			int value = playerData.getInt("currency.balance");
			int add = Integer.parseInt(args[0]);
			value += add;
			playerData.set("currency.balance", value);
			sender.sendMessage(ChatColor.GREEN + "Successfully gave yourself $" + add);
			try {
				playerData.save(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}else if (cmd.getName().equalsIgnoreCase("Give") && args.length == 2 && new File("C:/Users/Digo Barreiro/Documents/plugin/BuildTools/plugins/WolfOfWallStreet/" + File.separator + args[0] + ".yml").exists()){
			if(player.isOp() == false){
				sender.sendMessage(ChatColor.RED + "Sorry, you do not have permission to use this command!");
				return false;
			}
			Player reciever = Bukkit.getPlayerExact(args[0]);
			String playerName = args[0];
			File f = new File("C:/Users/Digo Barreiro/Documents/plugin/BuildTools/plugins/WolfOfWallStreet/" + File.separator + playerName + ".yml");
			FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
			int value = playerData.getInt("currency.balance");
			int add = Integer.parseInt(args[1]);
			value += add;
			playerData.set("currency.balance", value);
			sender.sendMessage(ChatColor.GREEN + "Successfully gave " + args[0] + " $" + add);
			reciever.sendMessage(ChatColor.GREEN + player.getName() +" gave you $" + add);
			try {
				playerData.save(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}else if(cmd.getName().equalsIgnoreCase("Give") && args.length == 2 && new File("C:/Users/Digo Barreiro/Documents/plugin/BuildTools/plugins/WolfOfWallStreet/" + File.separator + args[0] + ".yml").exists() == false){
			
			if(player.isOp() == false){
				sender.sendMessage(ChatColor.RED + "Sorry, you do not have permission to use this command!");
				return false;
			}
			sender.sendMessage(ChatColor.RED + "Player does not exist! It't the thought that counts though.");
		}
		else if(cmd.getName().equalsIgnoreCase("Give")){
			
			if(player.isOp() == false){
				sender.sendMessage(ChatColor.RED + "Sorry, you do not have permission to use this command!");
				return false;
			}
			sender.sendMessage(ChatColor.RED + "Correct format /give [player] (amount)");
		}
		
		
		
		
		
		
		
		
		
		if (cmd.getName().equalsIgnoreCase("SetBalance") && args.length == 1){
			
			
			if(player.isOp() == false){
				sender.sendMessage(ChatColor.RED + "Sorry, you do not have permission to use this command!");
				return false;
			}
			
			String playerName = player.getName();
			File f = new File("C:/Users/Digo Barreiro/Documents/plugin/BuildTools/plugins/WolfOfWallStreet/" + File.separator + playerName + ".yml");
			FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
			
			int set = Integer.parseInt(args[0]);
			int value = set;
			playerData.set("currency.balance", value);
			sender.sendMessage(ChatColor.GREEN + "Your balance was successfully set to $" + set);
			try {
				playerData.save(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}else if(cmd.getName().equalsIgnoreCase("SetBalance") && args.length == 2 && new File("C:/Users/Digo Barreiro/Documents/plugin/BuildTools/plugins/WolfOfWallStreet/" + File.separator + args[0] + ".yml").exists()){
			
			if(player.isOp() == false){
				sender.sendMessage(ChatColor.RED + "Sorry, you do not have permission to use this command!");
				return false;
			}
			Player reciever = Bukkit.getPlayerExact(args[0]);
			String playerName = args[0];
			File f = new File("C:/Users/Digo Barreiro/Documents/plugin/BuildTools/plugins/WolfOfWallStreet/" + File.separator + playerName + ".yml");
			FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
			int set = Integer.parseInt(args[1]);
			int value = set;
			playerData.set("currency.balance", value);
			sender.sendMessage(ChatColor.GREEN + args[0] + "'s balance successfully set to $" + set);
			reciever.sendMessage(ChatColor.GREEN + player.getName() + " has set your balance to $" + set);
			try {
				playerData.save(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}else if(cmd.getName().equalsIgnoreCase("SetBalance") && args.length == 2 && new File("C:/Users/Digo Barreiro/Documents/plugin/BuildTools/plugins/WolfOfWallStreet/" + File.separator + args[0] + ".yml").exists() == false){
			if(player.isOp() == false){
				sender.sendMessage(ChatColor.RED + "Sorry, you do not have permission to use this command!");
				return false;
			}
			sender.sendMessage(ChatColor.RED + "Player does not exist! It't the thought that counts though.");
		}else if(cmd.getName().equalsIgnoreCase("SetBalance")){
			if(player.isOp() == false){
				sender.sendMessage(ChatColor.RED + "Sorry, you do not have permission to use this command!");
				return false;
			}
			sender.sendMessage(ChatColor.RED + "Correct format /setbalance (amount)");
		}
		
		
		
		return false; 
	}

}

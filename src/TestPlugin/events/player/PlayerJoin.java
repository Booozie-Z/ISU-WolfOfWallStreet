package TestPlugin.events.player;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;

import org.bukkit.plugin.java.JavaPlugin;

import TestPlugin.Wolf;
import TestPlugin.commands.PlayerValue;

public class PlayerJoin implements Listener{
	
	private Wolf plugin;
	
	public void playerJoin(Wolf pl){
		plugin = pl;
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = (Player) event;
		
		String message = ChatColor.AQUA + "Welcome to the Sever" + player.getName() + "!";
		event.setJoinMessage(message);
		
		//To add PlayerValue getPlayerListName() = new PlayerValue()
		//then create the actual player value class and all the methods
	}
	
	
	

}


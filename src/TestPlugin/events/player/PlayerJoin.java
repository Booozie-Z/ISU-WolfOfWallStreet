package TestPlugin.events.player;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;

import org.bukkit.plugin.java.JavaPlugin;

import TestPlugin.Wolf;
import TestPlugin.commands.PlayerValue;

public class PlayerJoin implements Listener{
	@SuppressWarnings("unused")
	private Wolf plugin;
	
	public void playerJoin(Wolf pl){
		plugin = pl;
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player play = event.getPlayer();
		
		String message = ChatColor.AQUA + "Welcome to the Sever "  + play.getDisplayName() + "!";
		event.setJoinMessage(message);
		
		
		
		//To add PlayerValue getPlayerListName() = new PlayerValue()
		//then create the actual player value class and all the methods
	}
	/*@EventHandler
	public void PlayerEggThrowEvent(org.bukkit.event.player.PlayerEggThrowEvent event){
		event.
	}*/
	
	
	

}


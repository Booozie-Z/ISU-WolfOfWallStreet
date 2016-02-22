package TestPlugin.events.player;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import TestPlugin.Wolf;

public class PlayerJoin implements Listener{
	
	private Wolf plugin;
	
	public playerJoin(Wolf pl){
		plugin = pl;
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		
		
		String message = ChatColor.DARK_RED + "Welcome to the Sever!";
		event.setJoinMessage(message);
	}
	
	

}


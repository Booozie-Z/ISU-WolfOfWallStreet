package TestPlugin.events.player;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.world.WorldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
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
	public void PlayerGrenadeThrowEvent(PlayerInteractEvent event){
		final Player player = event.getPlayer();
		World world = player.getWorld();
		if(player.getItemInHand().getType() == Material.TNT){
			if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK){
				Item grenade = world.dropItem(player.getEyeLocation(), new ItemStack(Material.TNT));
				grenade.setVelocity(player.);
				
			}
		}*/
	}


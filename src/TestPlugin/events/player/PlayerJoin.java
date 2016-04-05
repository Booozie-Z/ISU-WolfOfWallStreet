package TestPlugin.events.player;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import TestPlugin.Wolf;

public class PlayerJoin implements Listener{
	@SuppressWarnings("unused")
	private Wolf plugin;
	
	public void playerJoin(Wolf pl){
		plugin = pl;
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player play = event.getPlayer();
		
		String message = ChatColor.AQUA + "Welcome to the Server "  + play.getDisplayName() + "!";
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


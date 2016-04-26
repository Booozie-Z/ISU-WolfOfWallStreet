package TestPlugin.events.player;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import TestPlugin.Wolf;

import java.io.File;
import java.io.IOException;




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
		
		
		String playerName = play.getName();
        //File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Hub").getDataFolder(), File.separator + "PlayerDatabase");
        File f = new File("./plugins/WolfOfWallStreet/" + File.separator + playerName + ".yml");
        FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);

        //When the player file is created for the first time...
        if (!f.exists()) {
            try {
            	f.createNewFile();
            	
                playerData.createSection("currency");
                playerData.set("currency.balance", 100);
                
                playerData.createSection("selling");
                playerData.set("selling.item", " ");
                
                playerData.createSection("price");
                playerData.set("price.p", 0);
                
                playerData.createSection("amount");
                playerData.set("amount.a", 0);
               
                playerData.save(f);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
		
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


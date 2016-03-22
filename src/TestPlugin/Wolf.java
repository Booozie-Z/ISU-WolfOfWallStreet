package TestPlugin;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import TestPlugin.commands.ValueCommands;
import TestPlugin.commands.pjsucks;
import TestPlugin.events.player.PlayerJoin;

public class Wolf extends JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info("WolfOfWallStreet has been enabled.");
		
		loadCommands();
		loadEvents();
		registerConfig();
		
	}

	@Override
	public void onDisable() {
		getLogger().info("WolfOfWallStreet has been disabled.");
		registerConfig();
	}
	
	public void loadCommands(){
		getCommand("PjSucks").setExecutor(new pjsucks());
		getCommand("Balance").setExecutor(new ValueCommands());
	}
	public void loadEvents(){
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new PlayerJoin(), this);
	}
	public void registerConfig(){
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	public void setup()
	  {
	    File playersfile = new File(getDataFolder(), "playerBalance.yml");
	    if (!playersfile.exists()) {
	        try {
	            playersfile.createNewFile();
	        }
	        catch (IOException e) {
	            getLogger().severe(ChatColor.RED + "Could not create the playerBalance.yml!");
	        }
	    }
	  }
	
}

package TestPlugin;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import Wolf.commands.pjsucks;

public class Wolf extends JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info("WolfOfWallStreet has been enabled.");
		
		loadCommands();
		loadEvents();
	}

	@Override
	public void onDisable() {
		getLogger().info("WolfOfWallStreet has been disabled.");
	}
	
	public void loadCommands(){
		getCommand("PjSucks").setExecutor(new pjsucks());
	}
	public void loadEvents(){
		PluginManager pm = getServer().getPluginManager();
		
		//pm.registerEvents(new <EventJava>, this);
	}
	public void registerConfig(){
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
}

package TestPlugin;

import org.bukkit.plugin.java.JavaPlugin;

import TestPlugin.commands.pjsucks;

public class FirstCommand extends JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info("WolfOfWallStreet has been enabled.");
		
		loadCommands();
		
	}

	@Override
	public void onDisable() {
		getLogger().info("WolfOfWallStreet has been disabled.");
	}
	
	public void loadCommands(){
		getCommand("PjSucks").setExecutor(new pjsucks());
	}
	
}

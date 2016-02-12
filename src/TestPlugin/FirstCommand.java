package TestPlugin;

import java.util.Set;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import TestPlugin.commands.pjsucks;

public class FirstCommand extends JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info("WolfOfWallStreet has been enabled.");
		getCommand("PjSucks").setExecutor(new pjsucks());
	}

	@Override
	public void onDisable() {
		getLogger().info("WolfOfWallStreet has been disabled.");
	}

	public void testThingy(PlayerEggThrowEvent event) {
		Player player = event.getPlayer();
		player.getWorld().strikeLightning(player.getTargetBlock((Set<Material>) null, 200).getLocation());
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		// Get the player's location.
		Location loc = event.getPlayer().getLocation();
		// Sets loc to five above where it used to be. Note that this doesn't
		// change the player's position.
		loc.setY(loc.getY() + 5);
		// Gets the block at the new location.
		Block b = loc.getBlock();
		// Sets the block to type id 1 (stone).
		b.setType(Material.STONE);
	}
}

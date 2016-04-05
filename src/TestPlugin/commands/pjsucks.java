package TestPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class pjsucks implements CommandExecutor{
	/**
	 * Pjsucks was the first command made to get actual feedback from minecraft.
	 * Right now we used it to make a test inventory that we plan on making a command menu by making the items clickable.
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("PjSucks")) { // If the player typed /basic then do the following...
			//sender.sendMessage("Yes he does.");
			
			Player player = (Player) sender;
			Inventory inv = Bukkit.createInventory(null, 9, "Super Items");
			
			ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
			ItemStack diamondPick = new ItemStack(Material.DIAMOND_PICKAXE);
			ItemStack bow = new ItemStack(Material.BOW);
			diamondSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 69);
			diamondPick.addUnsafeEnchantment(Enchantment.DIG_SPEED, 100);
			bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
			bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 69);
			
			inv.addItem(diamondSword, bow, diamondPick);
			
			player.openInventory(inv);
			
			return true;
		}
		return false; 
	}

}

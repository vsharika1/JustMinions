package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import chestrecipeloading.CraftingInventory;

public class OpenInventory implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("justminions.spawn.*")) {
				if(args.length == 0) {
					new CraftingInventory(p);
				} p.sendMessage("§cUse </inv>");
			} p.sendMessage("§cYou don't have the permission to do that!");
		}
		
		return false;
	}

}

package listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import chestrecipeloading.CraftingInventory;

public class OpenCraftingInventory implements Listener{
	
	@EventHandler
	public void interactingWithCrafting(PlayerInteractEvent e) {
		
		Block b = e.getClickedBlock();
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(b.getType() == Material.WORKBENCH) {
				Location loc = b.getLocation();
				if(loc.getWorld().getBlockAt(loc.add(1, 0, 0)).getType() == Material.ANVIL && loc.getWorld().getBlockAt(loc.add(-2, 0, 0)).getType() == Material.ANVIL) {
					loc = b.getLocation();
					if(loc.getWorld().getBlockAt(loc.add(0, 1, 0)).getType() == Material.CHEST) {
						e.setCancelled(true);
						new CraftingInventory(e.getPlayer());
					}
				} else {
					loc = b.getLocation();
					if(loc.getWorld().getBlockAt(loc.add(0, 0, 1)).getType() == Material.ANVIL && loc.getWorld().getBlockAt(loc.add(0, 0, -2)).getType() == Material.ANVIL) {
						loc = b.getLocation();
						if(loc.getWorld().getBlockAt(loc.add(0, 1, 0)).getType() == Material.CHEST) {
							e.setCancelled(true);
							new CraftingInventory(e.getPlayer());
						}
					}
				}
				
			}
		}
		
		
	}

}

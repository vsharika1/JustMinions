package chestrecipeloading;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CraftingInventory {
	
	public static final String INVENTORY_NAME = "Crafting";
	
	public CraftingInventory(Player p) {
		
		Inventory inv = Bukkit.createInventory(null, 9 * 3, INVENTORY_NAME);
		
		for (int i = 0; i < inv.getSize(); i++) {
			
			switch(i) {
			case 0:
			case 1:
			case 2:
			case 9:
			case 10:
			case 11:
			case 18:
			case 19:
			case 20:
			case 16:
				break;
			case 14:
				inv.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 14));
				break;
			default:
				inv.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 7));
			}
			
		}
		
		p.closeInventory();
		p.openInventory(inv);
		
	}

}

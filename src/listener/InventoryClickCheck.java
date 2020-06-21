package listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import chestrecipeloading.CraftingInventory;

public class InventoryClickCheck implements Listener{
	
	@EventHandler
	public void inventoryClickChecker(InventoryClickEvent e) {
		
		Inventory inv = e.getClickedInventory();
		
		if(inv != null) {
			if(inv.getTitle() != null) {
				if(inv.getTitle().equals(CraftingInventory.INVENTORY_NAME)) {
					if(inv.getItem(e.getSlot()) != null) {
						if(inv.getItem(e.getSlot()).getType() == Material.STAINED_GLASS_PANE) {
							e.setCancelled(true);
						}	
					}
					if(e.getSlot() == 16) {
						if(inv.getItem(16) != null) {
							for(int i = 0; i < InventoryChestRecipeCheck.slot_numbers.size(); i++) {
								ItemStack is = inv.getItem(InventoryChestRecipeCheck.slot_numbers.get(i));
								is.setAmount(is.getAmount() - 1);
								inv.setItem(InventoryChestRecipeCheck.slot_numbers.get(i), is);
							}
						}
					}
				}	
			}	
		}
		
	}

}

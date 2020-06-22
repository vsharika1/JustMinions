package listener;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import chestrecipeloading.CraftingInventory;
import chestrecipeloading.RecipeLoader;
import main.Main;

public class InventoryChestRecipeCheck implements Listener{
	
	private int taskid,
				counter = 0;
	public static ArrayList<Integer> slot_numbers = new ArrayList<>();
	private boolean b = true;
	
	@EventHandler
	public void inventoryOpen(InventoryOpenEvent e) {
		
		if(slot_numbers.size() < 2) {
			slot_numbers.add(0);
			slot_numbers.add(1);
			slot_numbers.add(2);
			slot_numbers.add(9);
			slot_numbers.add(10);
			slot_numbers.add(11);
			slot_numbers.add(18);
			slot_numbers.add(19);
			slot_numbers.add(20);	
		}
		
		Inventory inv = e.getInventory();
		if(inv.getTitle().equals(CraftingInventory.INVENTORY_NAME)) {
			taskid = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {

				@Override
				public void run() {
					b = true;
					for (int i = 0; i <RecipeLoader.loadedChestRecipes.size() && b; i++) {
						for (int j = 0; j < slot_numbers.size(); j++) {

							if(inv.getItem(slot_numbers.get(j)) != null) {

								Material m = RecipeLoader.loadedChestRecipes.get(i).getMaterialAt(j);
								Material m2 = inv.getItem(slot_numbers.get(j)).getType();

								if(m != null && m2 != null) {
									if(m == m2) {
										counter++;
									}
								}
							}
						}
						if(counter == 9) {

							inv.setItem(14, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5));
							inv.setItem(16, RecipeLoader.loadedChestRecipes.get(i).getResult());
							b = false;
						} else {
							inv.setItem(14, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 14));
							inv.setItem(16, null);
							b = true;
						}
						counter = 0;

					}
				}
			}, 0, 2);
		}
		
	}
	@EventHandler
	public void inventoryClose(InventoryCloseEvent e) {
		if(e.getInventory().getTitle().equals(CraftingInventory.INVENTORY_NAME)) {
			Bukkit.getScheduler().cancelTask(taskid);
			Inventory inv = e.getInventory();
			Player p = (Player) e.getPlayer();
			p.getInventory().addItem(inv.getItem(0), inv.getItem(1), inv.getItem(2), inv.getItem(9), inv.getItem(10), inv.getItem(11),
					inv.getItem(18), inv.getItem(19), inv.getItem(20));
		}
	}

}

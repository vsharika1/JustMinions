package chestrecipeloading;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import main.Main;

public class RecipeLoader {
	
	public static ArrayList<ChestRecipe> loadedChestRecipes = new ArrayList<>();
	
	public RecipeLoader() {
		
		ItemStack iron_is = new ItemStack(Material.IRON_BLOCK);
		//ItemMeta iiron_is = iron_is.getItemMeta();
		//iiron_is.setDisplayName("§aSpecialBlock");
		//iron_is.setItemMeta(iiron_is);
		
		ChestRecipe cr1 = new ChestRecipe(ChestCraftingPatterns.patternring(Material.DIAMOND_BLOCK, Material.DIAMOND), new ItemStack(Material.IRON_BLOCK), "Iron Block");
		
		ChestRecipe cr2 = new ChestRecipe(ChestCraftingPatterns.patternring(Material.DIAMOND_BLOCK, Material.ANVIL), new ItemStack(Material.APPLE), "Apple");
		
		loadedChestRecipes.add(cr1);
		loadedChestRecipes.add(cr2);

		for (ChestRecipe loadedChestRecipe : loadedChestRecipes) {

			Main.print("Recipe \"" + loadedChestRecipe.getName() + "\" loaded");

		}
		
	}

}

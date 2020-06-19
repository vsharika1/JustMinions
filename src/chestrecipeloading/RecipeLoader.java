package chestrecipeloading;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import main.Main;

public class RecipeLoader {
	
	public static ArrayList<ChestRecipe> loadedChestRecipes = new ArrayList<>();
	
	public RecipeLoader() {
		
		ItemStack stick = new ItemStack(Material.STICK);
		ItemMeta istick = stick.getItemMeta();
		istick.setDisplayName("§aMinionPlacer");
		stick.setItemMeta(istick);

		ItemStack minionitem = new ItemStack(Material.ARMOR_STAND);
		ItemMeta iminionitem = minionitem.getItemMeta();
		iminionitem.setDisplayName("Minion");
		minionitem.setItemMeta(iminionitem);
		
		ChestRecipe cr1 = new ChestRecipe(ChestCraftingPatterns.patternring(Material.DIAMOND_BLOCK, Material.DIAMOND), new ItemStack(Material.IRON_INGOT), "Not Working");
		
		ChestRecipe cr2 = new ChestRecipe(ChestCraftingPatterns.patternring(Material.DIAMOND_BLOCK, Material.ANVIL), new ItemStack(Material.APPLE), "Apple");

		ChestRecipe cr3 = new ChestRecipe(ChestCraftingPatterns.patternring(Material.STICK, Material.ARMOR_STAND), stick, "Stick");

		ChestRecipe cr4 = new ChestRecipe(ChestCraftingPatterns.patternring(Material.GHAST_TEAR, Material.ARMOR_STAND), minionitem, "MinionItem");
		
		loadedChestRecipes.add(cr1);
		loadedChestRecipes.add(cr2);
		loadedChestRecipes.add(cr3);
		loadedChestRecipes.add(cr4);

		for (ChestRecipe loadedChestRecipe : loadedChestRecipes) {

			Main.print("Recipe \"" + loadedChestRecipe.getName() + "\" loaded");

		}
		
	}

}

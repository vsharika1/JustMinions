package chestrecipeloading;

import java.util.ArrayList;

import listener.SetMinion;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import main.Main;

public class RecipeLoader {
	
	public static ArrayList<ChestRecipe> loadedChestRecipes = new ArrayList<>();
	public static ItemStack important;
	public RecipeLoader() {
		
		ItemStack stick = new ItemStack(Material.STICK);
		ItemMeta istick = stick.getItemMeta();
		istick.setDisplayName(SetMinion.mstickname);
		stick.setItemMeta(istick);

		ItemStack minionitem = new ItemStack(Material.ARMOR_STAND);
		ItemMeta iminionitem = minionitem.getItemMeta();
		iminionitem.setDisplayName(SetMinion.minionitemname);
		minionitem.setItemMeta(iminionitem);
		important = minionitem;

		ItemStack credstone = new ItemStack(Material.REDSTONE_ORE);
		ItemMeta icredstone = credstone.getItemMeta();
		icredstone.setDisplayName(SetMinion.credstonename);
		credstone.setItemMeta(icredstone);

		ItemStack cdiamond = new ItemStack(Material.DIAMOND_ORE);
		ItemMeta icdiamond = cdiamond.getItemMeta();
		icdiamond.setDisplayName(SetMinion.cdiamondname);
		cdiamond.setItemMeta(icdiamond);

		ItemStack ciron = new ItemStack(Material.IRON_ORE);
		ItemMeta iciron = ciron.getItemMeta();
		iciron.setDisplayName(SetMinion.cironname);
		ciron.setItemMeta(iciron);

		ItemStack cgold = new ItemStack(Material.GOLD_ORE);
		ItemMeta icgold = cgold.getItemMeta();
		icgold.setDisplayName(SetMinion.cgoldname);
		cgold.setItemMeta(icgold);

		ItemStack clapis = new ItemStack(Material.LAPIS_ORE);
		ItemMeta iclapis = clapis.getItemMeta();
		iclapis.setDisplayName(SetMinion.clapisname);
		clapis.setItemMeta(iclapis);

		ItemStack cemerald = new ItemStack(Material.EMERALD_ORE);
		ItemMeta icemerald = cemerald.getItemMeta();
		icemerald.setDisplayName(SetMinion.cemeraldname);
		cemerald.setItemMeta(icemerald);

		ItemStack cwood = new ItemStack(Material.WOOD);
		ItemMeta icwood = cwood.getItemMeta();
		icwood.setDisplayName(SetMinion.cwoodname);
		cwood.setItemMeta(icwood);

		ItemStack cstone = new ItemStack(Material.STONE);
		ItemMeta icstone = cstone.getItemMeta();
		icstone.setDisplayName(SetMinion.cstonename);
		cstone.setItemMeta(icstone);

		ItemStack cslime = new ItemStack(Material.SLIME_BLOCK);
		ItemMeta icslime = cslime.getItemMeta();
		icslime.setDisplayName(SetMinion.cslimename);
		cslime.setItemMeta(icslime);

		ChestRecipe cr1 = new ChestRecipe(ChestCraftingPatterns.patternring(Material.STICK, Material.ARMOR_STAND), stick, "Stick");

		ChestRecipe cr2 = new ChestRecipe(ChestCraftingPatterns.patternring(Material.GHAST_TEAR, Material.ARMOR_STAND), minionitem, "MinionItem");

		ChestRecipe cr3 = new ChestRecipe(ChestCraftingPatterns.patternfull(Material.REDSTONE_BLOCK), credstone, "Compressed Redstone");

		ChestRecipe cr4 = new ChestRecipe(ChestCraftingPatterns.patternfull(Material.DIAMOND_BLOCK), cdiamond, "Compressed Diamond");

		ChestRecipe cr5 = new ChestRecipe(ChestCraftingPatterns.patternfull(Material.IRON_BLOCK), ciron, "Compressed Iron");

		ChestRecipe cr6 = new ChestRecipe(ChestCraftingPatterns.patternfull(Material.GOLD_BLOCK), cgold, "Compressed Gold");

		ChestRecipe cr7 = new ChestRecipe(ChestCraftingPatterns.patternfull(Material.LAPIS_BLOCK), clapis, "Compressed Lapis");

		ChestRecipe cr8 = new ChestRecipe(ChestCraftingPatterns.patternfull(Material.EMERALD_BLOCK), cemerald, "Compressed Emerald");

		ChestRecipe cr9 = new ChestRecipe(ChestCraftingPatterns.patternfull(Material.WOOD), cwood, "Compressed Wood");

		ChestRecipe cr10 = new ChestRecipe(ChestCraftingPatterns.patternfull(Material.STONE), cstone, "Compressed Stone");

		ChestRecipe cr11 = new ChestRecipe(ChestCraftingPatterns.patternfull(Material.COBBLESTONE), cstone, "Compressed Stone 2");

		ChestRecipe cr12 = new ChestRecipe(ChestCraftingPatterns.patternfull(Material.SLIME_BLOCK), cslime, "Compressed Slime");
		
		loadedChestRecipes.add(cr1);
		loadedChestRecipes.add(cr2);
		loadedChestRecipes.add(cr3);
		loadedChestRecipes.add(cr4);
		loadedChestRecipes.add(cr5);
		loadedChestRecipes.add(cr6);
		loadedChestRecipes.add(cr7);
		loadedChestRecipes.add(cr8);
		loadedChestRecipes.add(cr9);
		loadedChestRecipes.add(cr10);
		loadedChestRecipes.add(cr11);
		loadedChestRecipes.add(cr12);

		for (ChestRecipe loadedChestRecipe : loadedChestRecipes) {

			Main.print("Recipe \"" + loadedChestRecipe.getName() + "\" loaded");

		}
		
	}

}

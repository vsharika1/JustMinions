package main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import chestrecipeloading.RecipeLoader;
import commands.OpenInventory;
import listener.InventoryChestRecipeCheck;
import listener.InventoryClickCheck;
import listener.OpenCraftingInventory;

public class Main extends JavaPlugin{
	
	public static Main plugin;
	
	public void onEnable() {
		
		plugin = this;
		
		print("Plugin started");
		new RecipeLoader();
		
		getCommand("inv").setExecutor(new OpenInventory());
		
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new InventoryChestRecipeCheck(), this);
		pm.registerEvents(new InventoryClickCheck(), this);
		pm.registerEvents(new OpenCraftingInventory(), this);
		
	}
	public static void print(String text) {
		System.out.println("[Minions] " + text);
	}
	public static Main getPlugin() {
		return plugin;
	}

}

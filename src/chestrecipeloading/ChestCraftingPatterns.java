package chestrecipeloading;

import java.util.ArrayList;

import org.bukkit.Material;

public class ChestCraftingPatterns {
	
	public ChestCraftingPatterns() {
		
	}
	public static ArrayList<Material> patternring(Material ring, Material middle) {
		
		ArrayList<Material> arr = new ArrayList<>();
		
		for(int i = 0; i < 9; i++) {
			if(i == 4) {
				arr.add(middle);
			} else {
				arr.add(ring);
			}
		}
		
		return arr;
	}
	public static ArrayList<Material> patternfull(Material m) {

		ArrayList<Material> arr = new ArrayList<>();

		for(int i = 0; i < 9; i++) {
			arr.add(m);
		}

		return arr;
	}

}

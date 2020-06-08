package chestrecipeloading;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ChestRecipe {
	
	public String name;
	public ItemStack result;
	public ArrayList<Material> arr;
	
	public ChestRecipe(ArrayList<Material> arr, ItemStack result, String name) {
		this.arr = arr;
		this.result = result;
		this.name = name;
	}
	public ChestRecipe(Material m1, Material m2, Material m3, Material m4, Material m5, Material m6, Material m7, Material m8, Material m9, ItemStack result, String name) {
		
		ArrayList<Material> arr = new ArrayList<>();
		
		if(m1 != null) {
			arr.add(m1);
		}
		if(m2 != null) {
			arr.add(m2);
		}
		if(m3 != null) {
			arr.add(m3);
		}
		if(m4 != null) {
			arr.add(m4);
		}
		if(m5 != null) {
			arr.add(m5);
		}
		if(m6 != null) {
			arr.add(m6);
		}
		if(m7 != null) {
			arr.add(m7);
		}
		if(m8 != null) {
			arr.add(m8);
		}
		if(m9 != null) {
			arr.add(m9);
		}
		
		this.arr = arr;
		this.result = result;
		this.name = name;
		
	}
	public void setMaterials(ArrayList<Material> arr) {
		this.arr = arr;
	}
	public void setMaterials(Material m1, Material m2, Material m3, Material m4, Material m5, Material m6, Material m7, Material m8, Material m9) {
		
		ArrayList<Material> arr = new ArrayList<>();
		
		if(m1 != null) {
			arr.add(m1);
		}
		if(m2 != null) {
			arr.add(m2);
		}
		if(m3 != null) {
			arr.add(m3);
		}
		if(m4 != null) {
			arr.add(m4);
		}
		if(m5 != null) {
			arr.add(m5);
		}
		if(m6 != null) {
			arr.add(m6);
		}
		if(m7 != null) {
			arr.add(m7);
		}
		if(m8 != null) {
			arr.add(m8);
		}
		if(m9 != null) {
			arr.add(m9);
		}
		
		this.arr = arr;
		
	}
	public ArrayList<Material> getMaterials() {
		return this.arr;
	}
	public Material getMaterialAt(int position) {

		return this.arr.get(position);
	}
	public void setResult(ItemStack result) {
		this.result = result;
	}
	public ItemStack getResult() {
		return this.result;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

}

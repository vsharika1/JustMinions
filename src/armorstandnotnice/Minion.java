package armorstandnotnice;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public class Minion {

    public static final String ARMOR_STAND_NAME = "Minion";

    public Minion(Location loc, Material m) {

        ArmorStand as = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
        as.setHelmet(new ItemStack(m));
        as.setCustomName(ARMOR_STAND_NAME);
        as.setCustomNameVisible(true);

    }

}

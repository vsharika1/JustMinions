package armorstandnotnice;

import main.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Minion {

    public static final String ARMOR_STAND_NAME = "Minion";
    public static ArrayList<ArmorStand> stands = new ArrayList<>();

    public Minion(Location loc, Material m) {

        ArmorStand as = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
        as.setHelmet(new ItemStack(m));
        as.setCustomName(ARMOR_STAND_NAME);
        as.setCustomNameVisible(true);
        as.setSmall(true);
        as.setInvulnerable(true);
        stands.add(as);

        int number;

        if(Main.getPlugin().getConfig() != null) {
            if(Main.getPlugin().getConfig().get("Minions.number") != null) {
                number = (int) Main.getPlugin().getConfig().get("Minions.number") -1;
            } else number = -1;
        } else {
            number = -1;
        }
        number += 1;

        Block b = as.getWorld().getBlockAt(as.getLocation().add(0, -1,0));
        Location bloc = b.getLocation();
        Main.getPlugin().getConfig().set("Minion.block."+ number +".world", bloc.getWorld().getName());
        Main.getPlugin().getConfig().set("Minion.block."+ number +".x", bloc.getX());
        Main.getPlugin().getConfig().set("Minion.block."+ number +".y", bloc.getY());
        Main.getPlugin().getConfig().set("Minion.block."+ number +".z", bloc.getZ());

        Main.getPlugin().getConfig().set("Minions.number", stands.size());

        Main.getPlugin().saveConfig();

    }

}

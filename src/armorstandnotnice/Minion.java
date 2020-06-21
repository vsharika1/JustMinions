package armorstandnotnice;

import main.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

import java.util.ArrayList;

public class Minion {

    public static final String ARMOR_STAND_NAME = "Minion";
    public static ArrayList<ArmorStand> stands = new ArrayList<>();

    public Minion(Location loc, Material m) {

        Location rloc = loc.getWorld().getBlockAt(loc).getLocation().add(0.5,1,0.5);
        ArmorStand as = (ArmorStand) loc.getWorld().spawnEntity(rloc, EntityType.ARMOR_STAND);
        as.setHelmet(new ItemStack(m));
        as.setArms(true);
        as.setLeftArmPose(new EulerAngle(10,0,-5));
        as.setRightArmPose(new EulerAngle(10,0,5));
        ItemStack is1 = new ItemStack(Material.LEATHER_CHESTPLATE, 1, (byte) 4);
        as.setChestplate(is1);
        as.setBasePlate(false);
        as.setGravity(false);
        as.setCustomName(ARMOR_STAND_NAME);
        as.setCustomNameVisible(true);
        as.setSmall(true);
        as.setInvulnerable(true);
        //as.teleport(as.getWorld().getBlockAt(as.getLocation().add(0, -1,0)).getLocation().add(0.5, 1, 0.5));
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

        ArmorStandOptions.changePositions();

        new TimeStarter(as);

    }

}

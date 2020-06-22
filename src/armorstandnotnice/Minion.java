package armorstandnotnice;

import main.Main;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.util.EulerAngle;

import java.util.ArrayList;

public class Minion {

    public static final String ARMOR_STAND_NAME = "Minion";
    public static ArrayList<ArmorStand> stands = new ArrayList<>();

    public Minion(Location loc, Material m) {

        Color c;

        switch (m) {
            case DIAMOND_ORE:
                c = Color.AQUA;
                break;
            case IRON_ORE:
            case STONE:
            case COBBLESTONE:
                c = Color.GRAY;
                break;
            case GOLD_ORE:
                c = Color.YELLOW;
                break;
            case REDSTONE_ORE:
                c = Color.RED;
                break;
            case LAPIS_ORE:
                c = Color.BLUE;
                break;
            case EMERALD_ORE:
                c = Color.GREEN;
                break;
            case LOG:
            case SLIME_BLOCK:
                c = Color.LIME;
                break;
            default:
                c = Color.BLACK;
        }

        Location rloc = loc.getWorld().getBlockAt(loc).getLocation().add(0.5,1,0.5);
        ArmorStand as = (ArmorStand) loc.getWorld().spawnEntity(rloc, EntityType.ARMOR_STAND);
        as.setHelmet(new ItemStack(m));
        as.setArms(true);
        as.setLeftArmPose(new EulerAngle(10,0,-5));
        as.setRightArmPose(new EulerAngle(10,0,5));
        as.setBasePlate(false);
        as.setGravity(false);
        as.setCustomName(ARMOR_STAND_NAME);
        as.setCustomNameVisible(true);
        as.setSmall(true);
        as.setInvulnerable(true);

        ItemStack cis = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta icis = (LeatherArmorMeta) cis.getItemMeta();
        icis.setColor(c);
        cis.setItemMeta(icis);

        ItemStack lis = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta ilis = (LeatherArmorMeta) lis.getItemMeta();
        ilis.setColor(c);
        lis.setItemMeta(ilis);

        ItemStack bis = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta ibis = (LeatherArmorMeta) bis.getItemMeta();
        ibis.setColor(c);
        bis.setItemMeta(ibis);

        as.setChestplate(cis);
        as.setLeggings(lis);
        as.setBoots(bis);

        as.setItemInHand(new ItemStack(Material.DIAMOND_PICKAXE));
        as.getEquipment().setItemInOffHand(new ItemStack(Material.DIAMOND_AXE));

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

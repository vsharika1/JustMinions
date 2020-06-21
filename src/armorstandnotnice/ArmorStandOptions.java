package armorstandnotnice;

import main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class ArmorStandOptions {

    public static void changePositions() {

        for (ArmorStand a: Minion.stands) {

            Block b = a.getWorld().getBlockAt(a.getLocation().add(0, -1,0));
            Location bloc = b.getLocation();
            Main.getPlugin().getConfig().set("Minion.block."+ Minion.stands.indexOf(a) +".world", bloc.getWorld().getName());
            Main.getPlugin().getConfig().set("Minion.block."+ Minion.stands.indexOf(a) +".x", bloc.getX());
            Main.getPlugin().getConfig().set("Minion.block."+ Minion.stands.indexOf(a) +".y", bloc.getY());
            Main.getPlugin().getConfig().set("Minion.block."+ Minion.stands.indexOf(a) +".z", bloc.getZ());

            Main.getPlugin().getConfig().set("Minions.number", Minion.stands.size());

            for (int i = Minion.stands.size(); i < Minion.stands.size() + 500; i++) {
                if(Main.getPlugin().getConfig().get("Minion.block." + i + ".world") != null) {
                    Main.getPlugin().getConfig().set("Minion.block."+ i +".world", null);
                    Main.getPlugin().getConfig().set("Minion.block."+ i +".x", null);
                    Main.getPlugin().getConfig().set("Minion.block."+ i +".y", null);
                    Main.getPlugin().getConfig().set("Minion.block."+ i +".z", null);
                } else break;
            }

            Main.getPlugin().saveConfig();

        }

    }
    public static void removeArmorStands(Player p) {

        ArrayList<Entity> nearbymobs = new ArrayList<>(p.getNearbyEntities(1,1,1));

        for (Entity i : nearbymobs) {

            if(i.getType() == EntityType.ARMOR_STAND) {
                ArmorStand as = (ArmorStand) i;
                if(as.isSmall()) {
                    if(as.getHelmet() != null) {
                        AsRemoving(as);

                    }
                }
            }

        }

    }
    public static void removeArmorStands(ArmorStand as) {
        AsRemoving(as);
    }

    private static void AsRemoving(ArmorStand as) {
        as.remove();
        Block b = as.getWorld().getBlockAt(as.getLocation().add(0, -1,0));
        Main.getPlugin().getConfig().set("Minion.block."+ Minion.stands.indexOf(as) +".world", null);
        Main.getPlugin().getConfig().set("Minion.block."+ Minion.stands.indexOf(as) +".x", null);
        Main.getPlugin().getConfig().set("Minion.block."+ Minion.stands.indexOf(as) +".y", null);
        Main.getPlugin().getConfig().set("Minion.block."+ Minion.stands.indexOf(as) +".z", null);
        Main.getPlugin().saveConfig();

        Minion.stands.remove(as);
        Bukkit.broadcastMessage("" + Minion.stands.size());
        ArmorStandOptions.changePositions();

    }
}

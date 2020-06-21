package armorstandnotnice;

import main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;

public class TimeStarter {

    private int taskid,
                time;

    public TimeStarter(ArmorStand as) {

        Material m = as.getHelmet().getType();

        if(m == Material.REDSTONE_ORE) {
            time = 25;
        } else if(m == Material.DIAMOND_ORE) {
            time = 150;
        } else if(m == Material.IRON_ORE) {
            time = 60;
        } else if(m == Material.GOLD_ORE) {
            time = 90;
        } else if(m == Material.LAPIS_ORE) {
            time = 35;
        } else if(m == Material.EMERALD_ORE) {
            time = 150;
        } else if(m == Material.COBBLESTONE || m == Material.STONE) {
            time = 10;
        } else if(m == Material.LOG) {
            time = 20;
        } else {
            time = 600;
        }

        taskid = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                new MinionWorking(as, as.getHelmet().getType());
                if(as.isDead()) {
                    Bukkit.getScheduler().cancelTask(taskid);
                }
            }
        },20 * time, 20 * time);
    }
}

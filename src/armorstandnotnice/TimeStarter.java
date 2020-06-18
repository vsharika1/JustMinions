package armorstandnotnice;

import main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;

public class TimeStarter {

    private int taskid;

    public TimeStarter(ArmorStand as) {
        taskid = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                new MinionWorking(as, as.getHelmet().getType());
                if(as.isDead()) {
                    Bukkit.getScheduler().cancelTask(taskid);
                }
            }
        },0, 20 * 5);
    }
}

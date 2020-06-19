package armorstandnotnice;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;

import java.util.ArrayList;

public class MinionWorking {

    private ArrayList<Location> locs = new ArrayList<>();

    public MinionWorking(ArmorStand as, Material m) {

        locs.add(as.getLocation().add(-2,-1,-2));
        locs.add(as.getLocation().add(-2,-1,-1));
        locs.add(as.getLocation().add(-2,-1,0));
        locs.add(as.getLocation().add(-2,-1,1));
        locs.add(as.getLocation().add(-2,-1,2));
        locs.add(as.getLocation().add(-1,-1,-2));
        locs.add(as.getLocation().add(-1,-1,-1));
        locs.add(as.getLocation().add(-1,-1,0));
        locs.add(as.getLocation().add(-1,-1,1));
        locs.add(as.getLocation().add(-1,-1,2));
        locs.add(as.getLocation().add(0,-1,-2));
        locs.add(as.getLocation().add(0,-1,-1));
        locs.add(as.getLocation().add(0,-1,1));
        locs.add(as.getLocation().add(0,-1,2));
        locs.add(as.getLocation().add(1,-1,-2));
        locs.add(as.getLocation().add(1,-1,-1));
        locs.add(as.getLocation().add(1,-1,0));
        locs.add(as.getLocation().add(1,-1,1));
        locs.add(as.getLocation().add(1,-1,2));
        locs.add(as.getLocation().add(2,-1,-2));
        locs.add(as.getLocation().add(2,-1,-1));
        locs.add(as.getLocation().add(2,-1,0));
        locs.add(as.getLocation().add(2,-1,1));
        locs.add(as.getLocation().add(2,-1,2));

        int count = 0;
        int countair = 0;

        for (Location l: locs) {
            if(m == Material.REDSTONE_ORE) {
                if(l.getWorld().getBlockAt(l).getType() == Material.AIR || l.getWorld().getBlockAt(l).getType() == null) {
                    countair ++;
                } else if(l.getWorld().getBlockAt(l).getType() == m || l.getWorld().getBlockAt(l).getType() == Material.GLOWING_REDSTONE_ORE) {
                    count ++;
                } else {

                }
            } else {
                if(l.getWorld().getBlockAt(l).getType() == Material.AIR || l.getWorld().getBlockAt(l).getType() == null) {
                    countair ++;
                } else if(l.getWorld().getBlockAt(l).getType() == m) {
                    count ++;
                } else {

                }
            }
        }

        int counted = count + countair;

        if (count == 24) {
            int rnd = (int) (Math.random() * 24);
            locs.get(5).getWorld().getBlockAt(locs.get(rnd)).breakNaturally();
        } else if(counted == 24) {
            for (int i = 0; i < 10; i++) {
                int rnd = (int) (Math.random() * 24);
                Block block = locs.get(2).getWorld().getBlockAt(locs.get(rnd));

                if(block.getType() == Material.AIR) {
                    i = 12;
                    locs.get(3).getWorld().getBlockAt(locs.get(rnd)).setType(m);
                } else {
                    i = 1;
                }
            }
        }
        count = 0;
        countair = 0;
        counted = 0;

    }

}

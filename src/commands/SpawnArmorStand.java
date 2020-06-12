package commands;

import armorstandnotnice.Minion;
import main.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

import java.util.ArrayList;

public class SpawnArmorStand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("justminions.spawn.*") || p.hasPermission("justminions.spawn.armorstand")) {
                if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("place")) {

                        new Minion(p.getLocation(), Material.REDSTONE_ORE);

                    } else if(args[0].equalsIgnoreCase("remove")) {

                        ArrayList<Entity> nearbymobs = new ArrayList<>(p.getNearbyEntities(1,1,1));

                        for (Entity i : nearbymobs) {

                            if(i.getType() == EntityType.ARMOR_STAND) {
                                ArmorStand as = (ArmorStand) i;
                                if(as.isSmall()) {
                                    if(as.getHelmet() != null) {
                                        as.remove();
                                        Block b = as.getWorld().getBlockAt(as.getLocation().add(0, -1,0));

                                    }
                                }
                            }

                        }

                    }
                }
            }
        }

        return false;
    }
}

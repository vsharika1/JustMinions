package commands;

import armorstandnotnice.ArmorStandOptions;
import armorstandnotnice.Minion;
import main.Main;
import org.bukkit.Bukkit;
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

                        ArmorStandOptions.changePositions();

                    } else if(args[0].equalsIgnoreCase("remove")) {

                        ArmorStandOptions.removeArmorStands(p);

                    } else if(args[0].equalsIgnoreCase("size")) {
                        Bukkit.broadcastMessage(Minion.stands.size() + "");
                    }
                }
            }
        }

        return false;
    }
}

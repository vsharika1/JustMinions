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

                        new Minion(p.getLocation().add(0, -1,0), Material.DIAMOND_BLOCK);

                        ArmorStandOptions.changePositions();

                    } else if(args[0].equalsIgnoreCase("remove")) {

                        ArmorStandOptions.removeArmorStands(p);

                    } else if(args[0].equalsIgnoreCase("number")) {
                        Bukkit.broadcastMessage(Minion.stands.size() + "");
                    } p.sendMessage("§cUse </minion place/remove/number>");
                } p.sendMessage("§cUse </minion place/remove/number>");
            } p.sendMessage("§cYou don't have the permission to do that!");
        }

        return false;
    }
}

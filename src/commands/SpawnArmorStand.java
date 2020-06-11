package commands;

import armorstandnotnice.Minion;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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

                    }
                }
            }
        }

        return false;
    }
}

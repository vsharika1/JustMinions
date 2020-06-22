package listener;

import armorstandnotnice.ArmorStandOptions;
import armorstandnotnice.Minion;
import chestrecipeloading.RecipeLoader;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMinion implements Listener {

    public static String mstickname = "§aMinionPlacer",
                         minionitemname = "§aMinion",
                         credstonename = "§4Compressed Redstone",
                         cdiamondname = "§bCompressed Diamond",
                         cemeraldname = "§2Compressed Emerald",
                         cironname = "§7Compressed Iron",
                         cgoldname = "§6Compressed Gold",
                         clapisname = "§9Compressed Lapis",
                         cwoodname = "§cCompressed Wood",
                         cstonename = "§7Compressed Stone",
                         cslimename = "§aCompressed Slime";
    private boolean b;
    private ArrayList<String> names = new ArrayList<String>(Arrays.asList(mstickname, minionitemname,credstonename, cdiamondname, cemeraldname,cironname,
            cgoldname,clapisname,cwoodname,cstonename,cslimename));
    private ArrayList<ItemStack> stacks;

    @EventHandler
    public void clickingEvent(PlayerInteractEvent e) {

        b = false;
        Player p = e.getPlayer();

        if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(e.getHand().equals(EquipmentSlot.HAND)) {
                if(e.getClickedBlock() != null) {
                    if(p.getInventory().getItemInMainHand() != null) {
                        if(p.getInventory().getItemInMainHand().hasItemMeta()) {
                            if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(mstickname)) {
                                b = true;
                                stacks = new ArrayList<ItemStack>(Arrays.asList(p.getInventory().getContents()));
                                if(stacks.contains(RecipeLoader.important)) {
                                    b = true;
                                }
                            }
                        }
                    }
                }
                if(b) {
                    if(p.getInventory().getItemInOffHand() != null) {
                        if(p.getInventory().getItemInOffHand().hasItemMeta()) {
                            if(names.contains(p.getInventory().getItemInOffHand().getItemMeta().getDisplayName())) {
                                new Minion(e.getClickedBlock().getLocation(), p.getInventory().getItemInOffHand().getType());
                                ArmorStandOptions.changePositions();
                                p.getInventory().getItemInOffHand().setAmount(p.getInventory().getItemInOffHand().getAmount() - 1);

                                for (ItemStack is:stacks) {
                                    if(is != null) {
                                        if(is.getType() == Material.ARMOR_STAND) {
                                            if(is.hasItemMeta()) {
                                                if(is.getItemMeta().getDisplayName().equals(minionitemname)) {
                                                    is.setAmount(is.getAmount() - 1);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }

    }

}

package listener;

import armorstandnotnice.ArmorStandOptions;
import armorstandnotnice.Minion;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AsClickCheck implements Listener {

    private ArmorStand ias;

    @EventHandler
    public void playerClicking(PlayerInteractAtEntityEvent e) {

        Player p = e.getPlayer();

        if(e.getRightClicked() instanceof ArmorStand) {
            ArmorStand as = (ArmorStand) e.getRightClicked();
            if(as.getCustomName() != null) {
                if(as.getCustomName().equals(Minion.ARMOR_STAND_NAME)) {
                    if(as.isSmall()) {
                        if(as.getHelmet() != null) {
                            Inventory inv = Bukkit.createInventory(null, 9 * 3, "Minion Options");

                            ItemStack w = new ItemStack(Material.WOOL, 1, (byte) 14);
                            ItemMeta iw = w.getItemMeta();
                            iw.setDisplayName("§cRemove Minion");
                            w.setItemMeta(iw);

                            inv.setItem(13, w);
                            p.openInventory(inv);
                            ias = as;
                        }
                    }
                }
            }
        }

    }
    @EventHandler
    public void playerInventoryClicking(InventoryClickEvent e) {

        if(e.getInventory().getTitle().equals("Minion Options")) {
            if(e.getSlot() == 13) {
                ArmorStandOptions.removeArmorStands(ias);
                e.setCancelled(true);
                e.getWhoClicked().closeInventory();
            } else if(e.getSlot() == 12) {

            } else if(e.getSlot() == 14) {

            }
        }

    }

}

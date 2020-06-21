package listener;

import armorstandnotnice.Minion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

public class ArmorStandArmorChange implements Listener {

    @EventHandler
    public void changingEvent(PlayerArmorStandManipulateEvent e) {

        if(e.getRightClicked().getCustomName() != null) {
            if(e.getRightClicked().getCustomName().equals(Minion.ARMOR_STAND_NAME)) {
                e.setCancelled(true);
            }
        }

    }

}

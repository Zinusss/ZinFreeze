package ua.zinus.zinfreeze;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import static ua.zinus.zinfreeze.FreezeColor.color;
import static ua.zinus.zinfreeze.FreezeConfig.Messages.*;


public class FreezeEvent implements Listener {
    @EventHandler
    private void onMove(PlayerMoveEvent event) {
        if (!ZinFreeze.getInstance().players_check.contains(event.getPlayer()))
            return ;

        event.setCancelled(true);
    }

    @EventHandler
    private void onCommandUse(PlayerCommandPreprocessEvent event) {
        if (!ZinFreeze.getInstance().players_check.contains(event.getPlayer()))
            return;

        event.setCancelled(true);
        event.getPlayer().sendMessage(color(playernotCommand));
    }

    @EventHandler
    private void onHitYou(EntityDamageEvent event) {
        if (!ZinFreeze.getInstance().players_check.contains(event.getEntity()))
            return;
        event.getEntity().sendMessage(color(nothitPlayer));
       event.setCancelled(true);

    }

    @EventHandler
    private void onDamage(PlayerInteractEvent event) {
        if (!ZinFreeze.getInstance().players_check.contains(event.getPlayer()))
            return;

        event.setCancelled(true);

        event.getPlayer().sendMessage(color(playernotDamage));
    }
}
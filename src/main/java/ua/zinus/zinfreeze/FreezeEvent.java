package ua.zinus.zinfreeze;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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
    private void onCommandPreprocess(PlayerCommandPreprocessEvent event) {
        if (!ZinFreeze.getInstance().players_check.contains(event.getPlayer()))
            return;

        event.setCancelled(true);
        event.getPlayer().sendMessage(color(playernotCommand));
    }

    @EventHandler
    private void onEntityDamage(EntityDamageEvent event) {
        if (!ZinFreeze.getInstance().players_check.contains(event.getEntity()))
            return;
        event.getEntity().sendMessage(color(nothitPlayer));
       event.setCancelled(true);

    }

    @EventHandler
    private void onInteract(PlayerInteractEvent event) {
        if (!ZinFreeze.getInstance().players_check.contains(event.getPlayer()))
            return;

        event.setCancelled(true);

        event.getPlayer().sendMessage(color(playernotDamage));
    }

}

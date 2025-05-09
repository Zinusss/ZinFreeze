package ua.zinus.zinfreeze;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import static ua.zinus.zinfreeze.FreezeColor.color;


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
        event.getPlayer().sendMessage(color("&4⚠ Вы не можете использовать команды во время заморозки"));
    }

    @EventHandler
    private void onHitYou(EntityDamageEvent event) {
        if (!ZinFreeze.getInstance().players_check.contains(event.getEntity()))
            return;
        event.getEntity().sendMessage("&4⚠ Вы не можете бить этого игрока пока он заморожен администратором!");

        event.setCancelled(true);
    }

    @EventHandler
    private void onDamage(PlayerInteractEvent event) {
        if (!ZinFreeze.getInstance().players_check.contains(event.getPlayer()))
            return;

        event.setCancelled(true);

        event.getPlayer().sendMessage(color("&4⚠ Вы не можете бить игроков во время заморозки"));
    }
}
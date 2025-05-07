package ua.zinus.zinfreeze;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import static ua.zinus.zinfreeze.FreezeCommand.players_check;

public class FreezeEvent implements Listener {
    @EventHandler
    private void onMove(PlayerMoveEvent event){
        if(event.getPlayer().getName() == players_check.get(1) && players_check.get(2).equals(true)){
            event.setCancelled(true);
        }
        else if(event.getPlayer().getName() == players_check.get(1) && players_check.get(2).equals(false)){
            event.setCancelled(false);
        }
    }
    @EventHandler
    private void onCommandUse(PlayerCommandPreprocessEvent event){
        if(event.getPlayer().getName() == players_check.get(1) && players_check.get(2).equals(true)){
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "⚠ Вы не можете использовать команды во время заморозки");
        }
        else if(event.getPlayer().getName() == players_check.get(1) && players_check.get(2).equals(false)){
            event.setCancelled(false);
        }
    }
    @EventHandler
    private void onDamage_you(EntityDamageEvent event){
        if(event.getEntity().getName() == players_check.get(1) && players_check.get(2).equals(true)){
            event.setCancelled(true);
            event.getEntity().sendMessage(ChatColor.RED + "⚠ Вы не можете использовать команды во время заморозки");
        }
        else if(event.getEntity().getName() == players_check.get(1) && players_check.get(2).equals(false)){
            event.setCancelled(false);
        }
    }
    @EventHandler
    private void onDamage(PlayerInteractEvent event) {
        if(event.getPlayer().getName() == players_check.get(1) && players_check.get(2).equals(true)){
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "⚠ Вы не можете бить игроков во время заморозки");
        }
        else if(event.getPlayer().getName() == players_check.get(1) && players_check.get(2).equals(false)){
            event.setCancelled(false);
        }
    }
}

package ua.zinus.zinfreeze;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.util.HashMap;

public class FreezeCommand implements CommandExecutor {
    public static HashMap players_check = new HashMap<>();
    @Override
        public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = Bukkit.getPlayer(args[0]);
        if (args.length < 2){
            return false;
        };
        players_check.put(1, player.getName());
        if (args[1].equalsIgnoreCase("start")){
            Player sender_player = (Player) sender;
            players_check.put(2, true);
            player.sendTitle(ChatColor.RED + "⚠ Вас заморозил администратор! ⚠ ", ChatColor.RED +"Информация в чате", 30, 25, 30);
            player.teleport(sender_player.getLocation());
            return true;
        }
        else if (args[1].equalsIgnoreCase("stop")){
            players_check.put(2, false);
            player.sendTitle(ChatColor.GREEN + "Вас разморозили!", ChatColor.GREEN + "Приятной игры", 30, 25, 30);
            return true;
        }
        return false;
    }
}

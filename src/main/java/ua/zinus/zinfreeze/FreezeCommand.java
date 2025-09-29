package ua.zinus.zinfreeze;



import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static ua.zinus.zinfreeze.FreezeColor.color;
import static ua.zinus.zinfreeze.FreezeConfig.Messages.*;
import static ua.zinus.zinfreeze.FreezeConfig.Titles.*;

public class FreezeCommand implements TabExecutor {
    @Override
    public  boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player playersender)) {
            sender.sendMessage(color(notPlayer));
            return true;
        }
        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            sender.sendMessage(color(playernotFound));
            return true;
        }

        if (args.length < 2) {
            return false;
        }
        if (args[1].equalsIgnoreCase("start")) {
            if (ZinFreeze.getInstance().players_check.contains(target)) {
                sender.sendMessage(color(playerAlreadyFrozen));
                return true;
            }
            ZinFreeze.getInstance().players_check.add(target);
            //Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "lp user " + sender.getName() + " meta addsuffix 105 \"&#D7DE2Fн&#C3E13Aа &#9AE751п&#86EA5Cр&#72EE68о&#5EF173в&#4AF47Eе&#35F789р&#21FA95к&#0DFDA0е\"");
            target.sendTitle((color(startFreeze)), color(startFreezeSubtitle), 30, 25, 30);
            target.teleport(playersender.getLocation());
            return true;
        } else if (args[1].equalsIgnoreCase("stop")) {
            if (!ZinFreeze.getInstance().players_check.contains(target)) {
                target.sendMessage(color(playernotFrozen));
                return true;
            }
            //Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "lp user " + sender.getName() + " meta removesuffix 105");
            ZinFreeze.getInstance().players_check.remove(target);
            target.sendTitle(color(stopFreeze), color(stopFreezeSubtitle), 30, 25, 30);
            return true;
        }



        return false;

}

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

            if (args.length == 1) {
                return List.of(
                        "Player name"
                );
            }
            if (args.length == 2) {
                return List.of(
                        "start",
                        "stop"
                );
            }
            return List.of();
        }
    }



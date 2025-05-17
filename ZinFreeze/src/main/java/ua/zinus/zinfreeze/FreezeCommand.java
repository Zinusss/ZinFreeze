package ua.zinus.zinfreeze;


import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;
import java.util.List;

import static ua.zinus.zinfreeze.FreezeColor.color;
import static ua.zinus.zinfreeze.FreezeConfig.Messages.*;
import static ua.zinus.zinfreeze.FreezeConfig.Titles.*;

public class FreezeCommand implements TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

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
        if (args[1].equalsIgnoreCase("start")){
            if (ZinFreeze.getInstance().players_check.contains(target)) {
                sender.sendMessage(color(playerAlreadyFrozen));

                return true;
            }
            ZinFreeze.getInstance().players_check.add(target);
            //Title.Times times = Title.Times.of(Duration.ofSeconds(2), Duration.ofSeconds(3), Duration.ofSeconds(2));
            //Title titlee = Title.title(Component.text(color("&#64FF31В&#61F82Eа&#5DF22Aс &#57E524р&#53DE21а&#50D71Dз&#4DD11Aм&#49CA17о&#46C414р&#43BD10о&#3FB60Dз&#3CB00Aи&#39A907л&#35A303и&#329C00!")), Component.text(color("&#FF0000И&#F90000н&#F20101ф&#EC0101о&#E50202р&#DF0202м&#D80202а&#D20303ц&#CC0303и&#C50303я &#B80404в &#AB0505ч&#A50505а&#9E0606т&#980606е")), times);
            while (ZinFreeze.getInstance().players_check.contains(target)) {
                target.sendTitle((color(startFreeze)), color(startFreezeSubtitle), 30, 25, 30);
                return true;
            }
            target.teleport(playersender.getLocation());
            return true;
        }
        else if (args[1].equalsIgnoreCase("stop")) {
            if (!ZinFreeze.getInstance().players_check.contains(target)) {
                target.sendMessage(color(playernotFrozen));
                return true;
            }

            ZinFreeze.getInstance().players_check.remove(target);

            target.sendTitle(color(stopFreeze), color(stopFreezeSubtitle), 30, 25, 30);
            return true;
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1){
            return List.of(
                    "Player name"
            );
        }
        if (args.length == 2){
            return List.of(
                    "start",
                    "stop"
            );
        }
        return List.of();
    }

}

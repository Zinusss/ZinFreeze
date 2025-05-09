package ua.zinus.zinfreeze;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static ua.zinus.zinfreeze.FreezeColor.color;

public class FreezeCommand implements TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player playersender)) {
            sender.sendMessage(color("&4⚠ Вы не игрок!"));
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            sender.sendMessage(color("&4⚠ Игрок не найден!"));
            return true;
        }

        if (args.length < 2) {
            return false;
        }

        if (args[1].equalsIgnoreCase("start")){
            if (ZinFreeze.getInstance().players_check.contains(target)) {
                target.sendMessage(color("&4⚠ Этот игрок уже замороженный!"));
                return true;
            }

            ZinFreeze.getInstance().players_check.add(target);

            target.sendTitle(color("&#FF0000⚠ &#F80000В&#F50101а&#F20101с &#EB0101з&#E80101а&#E40202м&#E10202о&#DE0202р&#DA0202о&#D70202з&#D40303и&#D00303л &#CA0303а&#C70303д&#C30303м&#C00404и&#BD0404н&#B90404и&#B60404с&#B30404т&#AF0505р&#AC0505а&#A90505т&#A50505о&#A20505р&#9F0606! &#980606⚠"), color("&#FF0000И&#F90000н&#F20101ф&#EC0101о&#E50202р&#DF0202м&#D80202а&#D20303ц&#CC0303и&#C50303я &#B80404в &#AB0505ч&#A50505а&#9E0606т&#980606е"), 30, 25, 30);
            target.teleport(playersender.getLocation());
            return true;
        }
        else if (args[1].equalsIgnoreCase("stop")) {
            if (!ZinFreeze.getInstance().players_check.contains(target)) {
                target.sendMessage(color("&4⚠ Этот игрок не замороженный! "));
                return true;
            }

            ZinFreeze.getInstance().players_check.remove(target);

            target.sendTitle("&#64FF31В&#61F82Eа&#5DF22Aс &#57E524р&#53DE21а&#50D71Dз&#4DD11Aм&#49CA17о&#46C414р&#43BD10о&#3FB60Dз&#3CB00Aи&#39A907л&#35A303и&#329C00!", "&#64FF31П&#60F72Dр&#5CEF29и&#58E625я&#53DE21т&#4FD61Dн&#4BCE19о&#47C514й &#3FB50Cи&#3AAD08г&#36A404р&#329C00ы", 30, 25, 30);
            return true;
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 0){
            return List.of(
                    "Ник игрока"
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

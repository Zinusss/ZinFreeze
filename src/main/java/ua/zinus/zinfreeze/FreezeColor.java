package ua.zinus.zinfreeze;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FreezeColor {
    private static final Pattern pattern = Pattern.compile("&#[a-fA-F0-9]{6}");

    public static String color(String text) {
        if (text == null) {
            Bukkit.getLogger().warning("Error processing the message");
            return "";
        }
        for (Matcher matcher = pattern.matcher(text); matcher.find(); matcher = pattern.matcher(text)) {
            String colorCode = text.substring(matcher.start() + 1, matcher.end());
            text = text.replace(matcher.group(), String.valueOf(ChatColor.of(colorCode)));
        }
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}


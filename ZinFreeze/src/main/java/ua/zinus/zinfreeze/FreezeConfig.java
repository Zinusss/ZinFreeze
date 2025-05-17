package ua.zinus.zinfreeze;

import lombok.experimental.UtilityClass;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
@UtilityClass
public class FreezeConfig {
        public static void load (FileConfiguration file){
                final var titleSection = file.getConfigurationSection("titles");
                final var messagesSection = file.getConfigurationSection("messages");

                if (titleSection == null){
                        throw new IllegalStateException("Config yml titles section is null");
                }
                else if (messagesSection == null){
                        throw new IllegalStateException("Config yml titles section is null");
                }


            TitleParseMessages(titleSection, messagesSection);
        }
        private static void TitleParseMessages(ConfigurationSection titlesection, ConfigurationSection messagessection){
                Titles.startFreeze = titlesection.getString("startFreeze");
                Titles.startFreezeSubtitle = titlesection.getString("startFreezeSubtitle");
                Titles.stopFreeze = titlesection.getString("stopFreeze");
                Titles.stopFreezeSubtitle = titlesection.getString("stopFreezeSubtitle");
                Messages.playernotFound = messagessection.getString("playernotFound");
                Messages.notPlayer = messagessection.getString("notPlayer");
                Messages.playerAlreadyFrozen = messagessection.getString("playerAlreadyFrozen");
                Messages.playernotFrozen = messagessection.getString("playernotFrozen");
                Messages.playernotCommand = messagessection.getString("playernotCommand");
                Messages.playernotDamage = messagessection.getString("playernotDamage");
                Messages.nothitPlayer = messagessection.getString("nothitPlayer");
        }
@UtilityClass
public static class Messages{
                public static String playernotFound;
                public static String notPlayer;
                public static String playerAlreadyFrozen;
                public static String playernotFrozen;
                public static String playernotCommand;
                public static String playernotDamage;
                public static String nothitPlayer;
        }
@UtilityClass
public static class Titles{
        public static String startFreeze;
        public static String startFreezeSubtitle;
        public static String stopFreeze;
        public static String stopFreezeSubtitle;
}
}


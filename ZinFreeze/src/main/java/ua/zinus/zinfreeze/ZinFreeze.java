package ua.zinus.zinfreeze;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class ZinFreeze extends JavaPlugin {
    public static ZinFreeze getInstance() {
        return instance;
    }
    public static ZinFreeze instance;
    public List players_check = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;
        getCommand("freeze").setExecutor(new FreezeCommand());
        getServer().getPluginManager().registerEvents(new FreezeEvent(), this);
    }

    @Override
    public void onDisable() {
    }
}
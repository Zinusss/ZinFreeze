package ua.zinus.zinfreeze;

import org.bukkit.plugin.java.JavaPlugin;

public final class ZinFreeze extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("freeze").setExecutor(new FreezeCommand());
        getServer().getPluginManager().registerEvents(new FreezeEvent(), this);
    }

    @Override
    public void onDisable() {
    }
}

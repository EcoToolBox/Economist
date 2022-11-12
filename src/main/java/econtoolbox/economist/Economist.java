package econtoolbox.economist;

import econtoolbox.economist.gdp.GDPListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.kaiaccount.AccountInterface;
import org.kaiaccount.AccountInterfaceManager;

import java.io.File;

public final class Economist extends JavaPlugin {
    static AccountInterfaceManager accountInterfaceManager;
    static File dataFolder;
    private static JavaPlugin plugin;

    @Override
    public void onEnable() {
        Economist.accountInterfaceManager = AccountInterface.getManager();
        Economist.dataFolder = getDataFolder();
        getServer().getPluginManager().registerEvents(new GDPListener(), this);
        Economist.plugin = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Deprecated
    public static File getDataFolderFromGod() {
        return Economist.dataFolder;
    }

    public static JavaPlugin getPlugin() {
        return Economist.plugin;
    }

}

package econtoolbox.economist;

import econtoolbox.economist.gdp.GDPListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.kaiaccount.AccountInterface;
import org.kaiaccount.AccountInterfaceManager;

public final class Economist extends JavaPlugin {

    static AccountInterfaceManager accountInterfaceManager;
    @Override
    public void onEnable() {
        Economist.accountInterfaceManager = AccountInterface.getManager();

        getServer().getPluginManager().registerEvents(new GDPListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

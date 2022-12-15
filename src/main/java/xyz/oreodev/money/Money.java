package xyz.oreodev.money;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.oreodev.money.manager.ymlManager;

public final class Money extends JavaPlugin {
    public ymlManager moneyConfig;

    @Override
    public void onEnable() {
        this.moneyConfig = new ymlManager(this);
    }

    @Override
    public void onDisable() {
    }
}

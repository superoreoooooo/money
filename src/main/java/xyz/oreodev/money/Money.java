package xyz.oreodev.money;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.oreodev.money.command.accountCommand;
import xyz.oreodev.money.listener.accountListener;
import xyz.oreodev.money.manager.ymlManager;

public final class Money extends JavaPlugin {
    public ymlManager moneyConfig;
    private account acc;

    @Override
    public void onEnable() {
        this.moneyConfig = new ymlManager(this);
        getCommand("account").setExecutor(new accountCommand());
        Bukkit.getPluginManager().registerEvents(new accountListener(), this);
        this.acc = new account();
        initializeAccount();
    }

    @Override
    public void onDisable() {
    }

    public void initializeAccount() {
        Bukkit.getConsoleSender().sendMessage("========================================");
        for (String name : this.moneyConfig.getConfig().getConfigurationSection("account.").getKeys(false)) {
            account.accountMap.put(name, acc.getBalance(name));
            Bukkit.getConsoleSender().sendMessage("account : " + name + " | balance : " + acc.getBalance(name));
        }
        Bukkit.getConsoleSender().sendMessage("========================================");
    }
}

package xyz.oreodev.money;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class account {
    private Money plugin;
    public HashMap<String, Integer> accountMap = new HashMap<>();

    public account() {
        this.plugin = JavaPlugin.getPlugin(Money.class);
    }

    public int getBalance(String playerName) {
        if (plugin.moneyConfig.getConfig().get("account." + playerName + ".balance") != null) return plugin.moneyConfig.getConfig().getInt("account." + playerName + ".balance");
        else return 0;
    }

    public void setBalance(String playerName, int balanceToSet) {
        plugin.moneyConfig.getConfig().set("account." + playerName + ".balance", balanceToSet);
    }

    public void addBalance(String playerName, int balanceToAdd) {
        if (plugin.moneyConfig.getConfig().get("account." + playerName + ".balance") != null) {
            int balanceNow = plugin.getConfig().getInt("account." + playerName + ".balance");
            if (balanceNow - balanceToAdd < -1) {

                return;
            }
        }
    }

    public void initializeAccount() {
        for (String name : plugin.moneyConfig.getConfig().getConfigurationSection("account.").getKeys(false));
    }
}

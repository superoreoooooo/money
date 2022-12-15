package xyz.oreodev.money.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.oreodev.money.account;

public class accountListener implements Listener {
    private account account;

    public accountListener() {
        account = new account();
    }
    @EventHandler
    public void onFirstJoin(PlayerJoinEvent e) {
        if (!e.getPlayer().hasPlayedBefore()) {
            account.setBalance(e.getPlayer().getName(), 0);
        }
    }
}

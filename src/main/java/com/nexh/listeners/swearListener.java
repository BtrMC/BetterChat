package com.nexh.listeners;

import com.nexh.Util;
import com.nexh.bc.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class swearListener implements Listener {
    private Main plugin = Main.getPlugin(Main.class);
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        String m = event.getMessage();
        for(String s: m.split(" ")) {
            if(plugin.getConfig().getString("Filter_Banned_Words").contains("true")) {
                if(plugin.getConfig().getStringList("Banned_Words").contains(s)) {
                    event.setCancelled(true);
                    Util.sendPl(p, Util.cColor("&cDon't curse on this server!"));
                }
            }
        }
    }
}

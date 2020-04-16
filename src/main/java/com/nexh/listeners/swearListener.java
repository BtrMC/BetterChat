package com.nexh.listeners;

import com.nexh.Util;
import com.nexh.bc.Main;
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
            if(plugin.getConfig().getBoolean("Filter_Banned_Words")) {
                if(plugin.getConfig().getStringList("Banned_Words").contains(s)) {
                    if(!p.hasPermission("bc.swear.bypass")) {
                        event.setCancelled(true);
                        Util.sendPl(p, Util.cColor(plugin.getConfig().getString("Filter_Format")));
                    }
                }
            }
        }
    }
}

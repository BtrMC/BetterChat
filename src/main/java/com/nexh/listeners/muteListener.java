package com.nexh.listeners;

import com.nexh.Util;
import com.nexh.bc.Main;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import com.nexh.cmds.globalMute;

public class muteListener implements Listener {
    private Main plugin = Main.getPlugin(Main.class);
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        if(globalMute.mute) {
            if (!p.hasPermission("bc.mute.bypass")) {
                Util.sendPl(p, Util.cColor(plugin.getConfig().getString("Mute_Format")));
                event.setCancelled(true);
            }
        }
    }
}

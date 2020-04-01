package com.nexh.listeners;

import com.nexh.Util;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import com.nexh.cmds.globalMute;

public class muteListener implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        String m = event.getMessage();
        if(globalMute.mute) {
            if (!p.hasPermission("cx.mute.bypass")) {
                Util.sendPl(p, Util.cColor("&cChat is currently muted!"));
                event.setCancelled(true);
            } else {
                event.setCancelled(false);
            }
        }
    }
}

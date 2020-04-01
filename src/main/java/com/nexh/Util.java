package com.nexh;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Util {
        public static String cColor(String textToTranslate) {
            return ChatColor.translateAlternateColorCodes('&', textToTranslate);
        }
        public static void sendPl(Player player, String msg) {
            player.sendMessage(msg);
        }
        public static void bcMsg(String msg) {
            Bukkit.broadcastMessage(msg);
        }
}

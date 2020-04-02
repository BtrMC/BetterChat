package com.nexh.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.nexh.Util;

public class bcMsg implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player p = (Player) sender;
        if(!p.hasPermission("bc.broadcast")) {Util.sendPl(p, Util.cColor("&cYou don't have permission!")); return true;}
        if(args.length != 0) {
            StringBuilder st = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                st.append(args[i]).append(" ");
            }
            Bukkit.broadcastMessage(Util.cColor("&3&LANNOUNCEMENT &8- &7" + st.toString()));
        } else {
            Util.sendPl(p, Util.cColor("&cUsage: /ac (message)"));
        }
        return false;
    }
}

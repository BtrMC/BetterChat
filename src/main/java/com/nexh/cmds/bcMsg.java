package com.nexh.cmds;

import com.nexh.bc.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.nexh.Util;

public class bcMsg implements CommandExecutor {
    private Main plugin = Main.getPlugin(Main.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player p = (Player) sender;
        if(!p.hasPermission("bc.broadcast")) {Util.sendPl(p, Util.cColor("&cYou don't have permission!")); return true;}
        if(args.length != 0) {
            StringBuilder st = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                st.append(args[i]).append(" ");
            }
            String format = plugin.getConfig().getString("Announce_Format");
            Bukkit.broadcastMessage(Util.cColor(format + " &7" + st.toString()));
        } else {
            Util.sendPl(p, Util.cColor("&cUsage: /ac (message)"));
        }
        return false;
    }
}

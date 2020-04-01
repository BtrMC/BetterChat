package com.nexh.cmds;

import com.nexh.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class globalMute implements  CommandExecutor {
    public static boolean mute;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player p = (Player) sender;
        if(!p.hasPermission("bc.mute.global")) {Util.sendPl(p, Util.cColor("&cYou don't have permission!")); return false;}
        if (args.length == 0) {
            if(mute) {
                mute = false;
                Util.bcMsg(Util.cColor("&7Chat has been un-muted by &b" + p.getName()));
            } else {
                mute = true;
                Util.bcMsg(Util.cColor("&7Chat has been muted by &b" + p.getName()));
            }
        } else if(args[0].equalsIgnoreCase("on")) {
            mute = true;
            Util.bcMsg(Util.cColor("&7Chat has been muted by &b" + p.getName()));
        } else if(args[0].equalsIgnoreCase("off")) {
            mute = false;
            Util.bcMsg(Util.cColor("&7Chat has been un-muted by &b" + p.getName()));
        }
            return true;
    }
}

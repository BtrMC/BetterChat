package com.nexh.cmds;

import com.nexh.bc.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.nexh.Util;

public class bc implements CommandExecutor {
    private Main plugin = Main.getPlugin(Main.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player p = (Player) sender;
        if(args.length == 0) {
            Util.sendPl(p, Util.cColor("&3------ &3&lBetterChat v1.2 &7by Nexh &3------"));
            Util.sendPl(p, Util.cColor("&3/clearchat &8- &7Clear the chat"));
            Util.sendPl(p, Util.cColor("&3/mutechat &8- &7Mute server chat"));
            Util.sendPl(p, Util.cColor("&3/announce &8- &7Announce to the server!"));
            Util.sendPl(p, Util.cColor("&3/bc rl &8- &7Reload the config"));
            Util.sendPl(p, Util.cColor("&3------ &3&lBetterChat &7by Nexh &3------"));
        } else if(args[0].equalsIgnoreCase("rl")) {
            if(!p.hasPermission("bc.reload")) {Util.sendPl(p, Util.cColor("&cYou don't have permission!")); return false;}
            plugin.reloadConfig();
            Util.sendPl(p, Util.cColor("&cReloaded the config!"));
        } else if(args[0].equalsIgnoreCase("reload")) {
            if(!p.hasPermission("bc.reload")) {Util.sendPl(p, Util.cColor("&cYou don't have permission!")); return false;}
            plugin.reloadConfig();
            Util.sendPl(p, Util.cColor("&cReloaded the config!"));
        } else {
            Util.sendPl(p, Util.cColor("&3------ &3&lBetterChat v1.2 &7by Nexh &3------"));
            Util.sendPl(p, Util.cColor("&3/clearchat &8- &7Clear the chat"));
            Util.sendPl(p, Util.cColor("&3/mutechat &8- &7Mute global chat"));
            Util.sendPl(p, Util.cColor("&3/announce &8- &7Announce to the server!"));
            Util.sendPl(p, Util.cColor("&3/bc rl &8- &7Reload the config"));
            Util.sendPl(p, Util.cColor("&3------ &3&lBetterChat &7by Nexh &3------"));
        }
        return true;
    }
}

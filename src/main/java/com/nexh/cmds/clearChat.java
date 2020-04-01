package com.nexh.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.nexh.Util;

public class clearChat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Player player = (Player) sender;
        if (!player.hasPermission("bc.clearchat")) {Util.sendPl(player, Util.cColor("&cYou don't have permission!")); return true;}
        int i;
        for (i = 0; i < 300; i++) {
            Util.bcMsg(" ");
        }
        Util.bcMsg(Util.cColor("&b" + player.getName() + " &7cleared the chat!"));
        return false;
    }
}

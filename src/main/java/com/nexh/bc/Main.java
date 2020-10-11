package com.nexh.bc;

import com.nexh.Util;
import org.bukkit.plugin.java.JavaPlugin;
import com.nexh.cmds.*;
import com.nexh.listeners.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main extends JavaPlugin {

    private String key = "?key=98BE0FE67F88AB82B4C197FAF1DC3B69206EFDCC4D3B80FC83A00037510B99B4&resource=77467";

    public Main() {
    }

    @Override
    public void onEnable() {

        this.getCommand("clearchat").setExecutor(new clearChat());
        this.getCommand("globalmute").setExecutor(new globalMute());
        this.getCommand("broadcast").setExecutor(new bcMsg());
        this.getCommand("bc").setExecutor(new bc());
        getServer().getPluginManager().registerEvents(new muteListener(), this);
        getServer().getPluginManager().registerEvents(new swearListener(), this);
        versionChecker();
        loadConfig();
    }

    private void versionChecker() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL("https://raw.githubusercontent.com/btrmc/BetterChat/master/version.txt").openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
            // connection.getOutputStream().write((key + 77467).getBytes("UTF-8"));
            String version = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
            if (!version.equals("1.1.3")) {
                this.getServer().getConsoleSender().sendMessage(Util.cColor("&3[!] &7Your BetterChat version is outdated!"));
                this.getServer().broadcastMessage(Util.cColor("&3[!] &7Your BetterChat version is outdated!"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }


}

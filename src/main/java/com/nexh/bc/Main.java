package com.nexh.bc;

import org.bukkit.plugin.java.JavaPlugin;
import com.nexh.cmds.*;
import com.nexh.listeners.*;

public class Main extends JavaPlugin {

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
        loadConfig();
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }


}

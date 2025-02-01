package com.cwmmo.staffChatsPlugin;

import com.cwmmo.staffChatsPlugin.commandHandler.Handler;
import com.cwmmo.staffChatsPlugin.commandHandler.independent.ReloadCommand;
import com.cwmmo.staffChatsPlugin.utils.loader.CommandLoader;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class StaffChatsPlugin extends JavaPlugin {
    public static StaffChatsPlugin INSTANCE;
    public static Handler CMDINSTANCE;
    public static LuckPerms luckPerms;

    @Override
    public void onEnable() {
        INSTANCE = this;
        CMDINSTANCE = new Handler();

        try {
            luckPerms = LuckPermsProvider.get();
            getLogger().info("Successfully hooked into LuckPerms!");
        } catch (IllegalStateException e) {
            // no luckperms ;(
            getLogger().severe("Failed to hook into luckperms :(");
            getServer().getPluginManager().disablePlugin(this);
        }

        // load commands from config
        CommandLoader.loadCommands();
        // register manual commands
        getCommand("screload").setExecutor(new ReloadCommand());
    }

}

package com.cwmmo.staffChatsPlugin.utils.loader;

import com.cwmmo.staffChatsPlugin.StaffChatsPlugin;
import com.cwmmo.staffChatsPlugin.utils.ConfigManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.permissions.Permission;

public class CommandLoader {
    private static final ConfigManager configHandler = new ConfigManager();

    public static void loadCommands() {
        FileConfiguration config = configHandler.getConfig();

        for (var key : config.getKeys(false)) {
            // register the command
            StaffChatsPlugin.INSTANCE.getCommand(key).setExecutor(StaffChatsPlugin.CMDINSTANCE);
            StaffChatsPlugin.INSTANCE.getCommand(key).setDescription(
                    configHandler.getString(key+".command-description")
            );
            // permissions
            StaffChatsPlugin.INSTANCE.getServer().getPluginManager().addPermission(
                    new Permission(
                            configHandler.getString(key+".permissions.view-permission"),
                            "Permission to view the "+configHandler.getString(key+".display-name")+" command."
                    )
            );
            StaffChatsPlugin.INSTANCE.getServer().getPluginManager().addPermission(
                    new Permission(
                            configHandler.getString(key+".permissions.use-permission"),
                            "Permission to use the "+configHandler.getString(key+".display-name")+" command."
                    )
            );

        }
    }

}

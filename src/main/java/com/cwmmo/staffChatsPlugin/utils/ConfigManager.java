package com.cwmmo.staffChatsPlugin.utils;

import com.cwmmo.staffChatsPlugin.StaffChatsPlugin;
import com.cwmmo.staffChatsPlugin.utils.cuckPerms.cuckPermsHandler;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.text.MessageFormat;

public class ConfigManager {

    public FileConfiguration getConfig() {
        return StaffChatsPlugin.INSTANCE.getConfig();
    }

    public Component getDisplayName(CommandSender player) {
        String displayname = (player instanceof Player) ? player.getName() : "CONSOLE";

        return MiniMessage.miniMessage().deserialize(
                cuckPermsHandler.getUserPrefix((Player) player, "<white>")
                        + (displayname)
        );
    }

    public String getString(String key) {
        return StaffChatsPlugin.INSTANCE.getConfig().getString(key);
    }

    public Component getMiniMessage(String key, Object... formatArgs) {
        return MiniMessage.miniMessage().deserialize(
                MessageFormat.format(StaffChatsPlugin.INSTANCE.getConfig().getString(key), formatArgs)
        );
    }
    public Component getMiniMessage(String key) {
        return MiniMessage.miniMessage().deserialize(
                StaffChatsPlugin.INSTANCE.getConfig().getString(key)
        );
    }
}

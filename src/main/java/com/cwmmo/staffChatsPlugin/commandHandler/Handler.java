package com.cwmmo.staffChatsPlugin.commandHandler;

import com.cwmmo.staffChatsPlugin.utils.ConfigManager;
import com.cwmmo.staffChatsPlugin.utils.cuckPerms.cuckPermsHandler;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;

public class Handler implements CommandExecutor {
    private final ConfigManager configHandler = new ConfigManager();

    @Override
    public boolean onCommand(@NotNull CommandSender sender,
                             @NotNull Command channel,
                             @NotNull String label,
                             @NotNull String[] args)
    {
        if (!(sender instanceof Player) && sender.hasPermission(configHandler.getString(channel+".permissions.use-permission"))) {
            sender.sendMessage(
                    configHandler.getMiniMessage(channel+".permissions.permission-message")
            );
            return true;
        } // bozos who try to run without permission

        if (args.length < 1) {
            sender.sendMessage(configHandler.getMiniMessage(channel+".usage"));
            return true;
        } // no message 😔😔😔

        String message = String.join(" ", args);
        Component prefix = MiniMessage.miniMessage().deserialize(
                cuckPermsHandler.getUserPrefix(sender, "")
        );

        Component format = configHandler.getMiniMessage(channel+".format");

        broadcast(format, configHandler.getString(channel+".permissions.view-permission"));

        return true;
    }

    private void broadcast(Component message, String permission) {
        for (Player player : Bukkit.getOnlinePlayers())
            if (player.hasPermission(permission))
                player.sendMessage(message);
    }
}

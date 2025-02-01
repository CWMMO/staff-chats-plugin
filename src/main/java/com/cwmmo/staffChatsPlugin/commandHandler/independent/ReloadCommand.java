package com.cwmmo.staffChatsPlugin.commandHandler.independent;

import com.cwmmo.staffChatsPlugin.StaffChatsPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender,
                             @NotNull Command command,
                             @NotNull String label,
                             @NotNull String[] args)
    {
        if ((sender instanceof Player) && !sender.hasPermission("staffchat.reload")) {
            sender.sendMessage("You don't have permission to do this.");
            return true;
        }
        sender.sendMessage("Reloading configurations...");
        StaffChatsPlugin.INSTANCE.reloadConfig();
        sender.sendMessage("Reloaded configurations!!!");

        return true;
    }
}

package com.cwmmo.staffChatsPlugin.utils.cuckPerms;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

// import javax.annotation.Nullable;
import java.util.UUID;

public class cuckPermsHandler {

    public static @NotNull String getUserPrefix(CommandSender sender, String nul) {
        if (!(sender instanceof Player)) {
            return nul;
        }
        Player player = (Player) sender;

        LuckPerms luckPerms = LuckPermsProvider.get();
        UserManager userManager = luckPerms.getUserManager();

        UUID uuid = player.getUniqueId();
        User user = userManager.getUser(uuid);

        if (user == null) return nul;

        CachedMetaData metaData = user.getCachedData().getMetaData();

        return (metaData.getPrefix() == null) ? metaData.getPrefix() : nul;

    }

    /*
    public static @Nullable String getUserPrefix(Player player) {
        LuckPerms luckPerms = LuckPermsProvider.get();
        UserManager userManager = luckPerms.getUserManager();

        UUID uuid = player.getUniqueId();
        User user = userManager.getUser(uuid);

        if (user == null) return null;

        CachedMetaData metaData = user.getCachedData().getMetaData();

        return metaData.getPrefix();

    }
    */

}

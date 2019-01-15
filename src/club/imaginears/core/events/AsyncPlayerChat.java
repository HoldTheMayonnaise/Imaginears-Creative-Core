package club.imaginears.core.events;

import club.imaginears.core.utils.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String msg = Permissions.getRankPrefix(p) + "&7 " + p.getDisplayName() + ": " + Permissions.getChatColor(p) + e.getMessage();
        Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
        e.setCancelled(true);
    }
}
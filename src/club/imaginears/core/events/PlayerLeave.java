package club.imaginears.core.events;

import club.imaginears.core.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if (p.getType() != EntityType.PLAYER) return;

        e.setQuitMessage(null);
        if (p.hasPermission("core.staff") || p.hasPermission("core.character")) {
            for (Player pls : Bukkit.getOnlinePlayers()) {
                if (pls.hasPermission("core.staff")) {
                    Chat.sendMessage(pls, "StaffAnnounce", "&b" + p.getName() + " &ahas clocked out");
                }
            }

        }
    }

}
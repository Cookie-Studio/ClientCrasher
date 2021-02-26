package me.liuli.cc;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.event.server.DataPacketReceiveEvent;

import java.util.ArrayList;
import java.util.UUID;

public class PacketBlockManager implements Listener {
    private static final ArrayList<UUID> blockList = new ArrayList<>();

    public static void addBlock(Player player) {
        blockList.add(player.getUniqueId());
    }

    public static void removeBlock(Player player) {
        blockList.remove(player.getUniqueId());
    }

    public static boolean checkBlock(Player player) {
        return blockList.contains(player.getUniqueId());
    }


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPacketReceive(DataPacketReceiveEvent event) {
        if (checkBlock(event.getPlayer())) {
            event.setCancelled();
        }
    }


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerQuit(PlayerQuitEvent event) {
        removeBlock(event.getPlayer());
    }
}

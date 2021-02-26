package me.liuli.cc;

import cn.nukkit.permission.Permission;
import cn.nukkit.plugin.PluginBase;

public class ClientCrasher extends PluginBase {
    public static ClientCrasher instance;

    @Override
    public void onEnable() {
        instance = this;

        //register perm
        this.getServer().getPluginManager().addPermission(new Permission("liuli.clientcrasher.command", "Use /cc command", Permission.DEFAULT_PERMISSION));
        //register command
        this.getServer().getCommandMap().register("cc", new CommandListener("cc"));
        //register listener
        this.getServer().getPluginManager().registerEvents(new PacketBlockManager(), this);
    }
}

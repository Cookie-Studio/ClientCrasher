package me.liuli.cc;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class CommandListener extends Command {

    public CommandListener(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if (!sender.hasPermission("liuli.clientcrasher.command")) {
            sender.sendMessage("§cYOU DON'T HAVE PERMISSION TO USE THIS COMMAND");
            return false;
        }

        if (args.length < 2) {
            sender.sendMessage("Usage: /cc <player> <mode>");
            return false;
        }

        Player player = Server.getInstance().getPlayer(args[0]);
        if (player == null) {
            sender.sendMessage("§cCANNOT FOUND TARGET PLAYER");
            return false;
        }

        try {
            new Crasher(player,CrashMode.valueOf(args[1].toUpperCase()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        sender.sendMessage("§aTRYING TO CRASH " + player.getName() + "'s CLIENT");

        return false;
    }
}

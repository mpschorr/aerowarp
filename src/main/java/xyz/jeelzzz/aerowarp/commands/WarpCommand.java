package xyz.jeelzzz.aerowarp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import xyz.jeelzzz.aerowarp.AeroWarp;
import xyz.jeelzzz.aerowarp.util.SoundUtil;
import xyz.jeelzzz.aerowarp.util.TextUtil;

public class WarpCommand implements CommandExecutor {
    private final AeroWarp plugin;
    public WarpCommand(AeroWarp plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;
        if (args.length == 0) return false;

        String warpName = String.join(" ", args);
        Location warp = plugin.getWarpManager().getWarp(warpName);
        if (warp == null) {
            player.sendMessage(TextUtil.format("&cThat warp does not exist!"));
            SoundUtil.play(player, SoundUtil.SOUND_NO);
            return true;
        }

        player.teleport(warp);
        player.sendMessage(TextUtil.format("&aTeleported to warp " + warpName));
        SoundUtil.play(player, SoundUtil.SOUND_DING);
        return true;
    }
}

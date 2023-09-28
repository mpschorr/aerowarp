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

public class SetWarpCommand implements CommandExecutor{
    private final AeroWarp plugin;
    public SetWarpCommand(AeroWarp plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;
        if (args.length == 0) return false;

        String warpName = String.join(" ", args);
        Location existingWarp = plugin.getWarpManager().getWarp(warpName);
        if (existingWarp != null) {
            player.sendMessage(TextUtil.format("&cThat warp already exists!"));
            SoundUtil.play(player, SoundUtil.SOUND_NO);
            return true;
        }

        Location newWarp = player.getLocation();
        plugin.getWarpManager().setWarp(warpName, newWarp);
        player.sendMessage(TextUtil.format("&aCreated the warp " + warpName));
        SoundUtil.play(player, SoundUtil.SOUND_DING);
        return true;
    }
}
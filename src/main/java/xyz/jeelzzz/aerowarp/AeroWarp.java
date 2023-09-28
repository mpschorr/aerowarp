package xyz.jeelzzz.aerowarp;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.jeelzzz.aerowarp.commands.SetWarpCommand;
import xyz.jeelzzz.aerowarp.commands.WarpCommand;

public final class AeroWarp extends JavaPlugin {
    private WarpManager warpManager;
    public WarpManager getWarpManager() {
        return warpManager;
    }


    @Override
    public void onEnable() {
        loadConfig();
        warpManager = new WarpManager(this);
        warpManager.load();
        this.getServer().getPluginCommand("warp").setExecutor(new WarpCommand(this));
        this.getServer().getPluginCommand("setwarp").setExecutor(new SetWarpCommand(this));
    }

    @Override
    public void onDisable() {
        warpManager.save();
    }

    private void loadConfig() {
        if (!this.getDataFolder().exists()) {
            this.getDataFolder().mkdirs();
        }
        this.saveResource("config.yml", false);
    }
}

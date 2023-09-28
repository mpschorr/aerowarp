package xyz.jeelzzz.aerowarp;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.Location;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class WarpManager {
    private AeroWarp plugin;
    private final File warpsFile;
    private final YamlConfiguration config;
    private HashMap<String,Location> warps = new HashMap<>();

    public WarpManager(AeroWarp plugin) {
        this.plugin = plugin;
        warpsFile = new File(plugin.getDataFolder(), "warps.yml");
        config = new YamlConfiguration();
        try {
            if (!warpsFile.exists()) {
                warpsFile.createNewFile();
            }
            config.load(warpsFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public Location getWarp(String name) {
        return warps.get(name);
    }

    public Set<String> getWarps() {
        return warps.keySet();
    }

    public void setWarp(String name, Location location) {
        warps.put(name, location);
        config.set(name, location);
        save();
    }

    public boolean save() {
        try {
            config.save(warpsFile);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean load() {
        try {
            config.load(warpsFile);
            warps = new HashMap<>();
            for (String key : config.getKeys(false)) {
                if (config.isLocation(key)) warps.put(key, config.getLocation(key));
            }
            return true;
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
            return false;
        }
    }
}

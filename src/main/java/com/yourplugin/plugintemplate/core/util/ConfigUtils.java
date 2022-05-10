package com.yourplugin.plugintemplate.core.util;

import com.yourplugin.plugintemplate.PluginTemplate;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigUtils {

    private final String name;

    public ConfigUtils(String fileName) {
        this.name = fileName;
    }

    public FileConfiguration getConfig() {
        File file = new File(PluginTemplate.getInstance().getDataFolder(), this.name + ".yml");
        return YamlConfiguration.loadConfiguration(file);
    }
}
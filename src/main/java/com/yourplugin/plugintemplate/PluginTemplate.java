package com.yourplugin.plugintemplate;

import com.yourplugin.plugintemplate.core.Locale;
import com.yourplugin.plugintemplate.core.license.ULicense;
import com.yourplugin.plugintemplate.core.util.ConfigUtils;
import games.negative.framework.BasePlugin;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public final class PluginTemplate extends BasePlugin {

    @Getter
    private static PluginTemplate instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        super.onEnable();
        instance = this;
        loadFiles(this, "config.yml");

        FileConfiguration config = new ConfigUtils("config").getConfig();
        if (!new ULicense(this, config.getString("license-key"), "https://licences.hypews.com/api/client", "818083243aa1516f7948073da8c4d8b6f193e287").verify()) {
            Bukkit.getPluginManager().disablePlugin(this);
            Bukkit.getScheduler().cancelTasks(this);
            return;
        }

        Locale.init(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

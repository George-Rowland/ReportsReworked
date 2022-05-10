package com.yourplugin.plugintemplate.core;

import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.logging.Level;

@RequiredArgsConstructor
public enum Logger {
    INFO(Level.INFO),
    SEVERE(Level.SEVERE),
    WARNING(Level.WARNING),
    ;

    private final Level level;

    /**
     * Send a logger to the console.
     * @param message The message to send.
     */
    public void console(@NotNull String message) {
        Bukkit.getLogger().log(level, message);
    }

    /**
     * Send a logger to the console.
     * @param message The message to send.
     */
    public void console(@NotNull String... message) {
        Arrays.stream(message).forEach(this::console);
    }

    /**
     * Send a logger to the chat.
     * @param message The message to send.
     */
    public void chat(@NotNull String message) {
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    /**
     * Send a logger to the chat.
     * @param message The message to send.
     */
    public void chat(@NotNull String... message) {
        Arrays.stream(message).forEach(this::chat);
    }


}

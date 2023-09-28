package xyz.jeelzzz.aerowarp.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class TextUtil {
    private static final MiniMessage mm = MiniMessage.miniMessage();

    public static Component format(String message) {
        return mm.deserialize(translate(message));
    }

    public static Component rawFormat(String message) {
        return mm.deserialize(message);
    }

    public static String translate(String message) {
        return message
            .replace("&0", "&r<black>")
            .replace("&1", "&r<dark_blue>")
            .replace("&2", "&r<dark_green>")
            .replace("&3", "&r<dark_aqua>")
            .replace("&4", "&r<dark_red>")
            .replace("&5", "&r<dark_purple>")
            .replace("&6", "&r<gold>")
            .replace("&7", "&r<gray>")
            .replace("&8", "&r<dark_gray>")
            .replace("&9", "&r<blue>")
            .replace("&a", "&r<green>")
            .replace("&b", "&r<aqua>")
            .replace("&c", "&r<red>")
            .replace("&d", "&r<light_purple>")
            .replace("&e", "&r<yellow>")
            .replace("&f", "&r<white>")
            .replace("&k", "<obf>")
            .replace("&l", "<b>")
            .replace("&m", "<st>")
            .replace("&n", "<u>")
            .replace("&o", "<i>")
            .replace("&r", "<reset>");
    }
}

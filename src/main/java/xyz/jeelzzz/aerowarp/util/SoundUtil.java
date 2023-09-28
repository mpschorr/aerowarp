package xyz.jeelzzz.aerowarp.util;

//import org.bukkit.Sound;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import org.bukkit.entity.Player;

public class SoundUtil {
    public static final Sound SOUND_DING = Sound.sound(Key.key("block.note_block.bit"), Sound.Source.MASTER, 1F, 1.5F);
    public static final Sound SOUND_NO = Sound.sound(Key.key("entity.villager.no"), Sound.Source.MASTER, 1F, 1F);

    public static void play(Player player, String sound) {
        play(player, sound, 1.0F, 1.0F);
    }

    public static void play(Player player, String sound, float volume) {
        play(player, sound, volume, 1.0F);
    }

    public static void play(Player player, String sound, float volume, float pitch) {
        play(player, Sound.sound(Key.key(sound), Sound.Source.MASTER, volume, pitch));
    }

    public static void play(Player player, Sound sound) {
        player.playSound(sound);
    }
}
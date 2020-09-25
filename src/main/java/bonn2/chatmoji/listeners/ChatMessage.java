package bonn2.chatmoji.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatMessage implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String temp = event.getMessage();
        temp = ChatColor.translateAlternateColorCodes('&', temp);
        if (player.hasPermission("chatmoji.smile"))
            temp = temp.replaceAll(":smile:", "\u263A");
        if (player.hasPermission("chatmoji.star"))
            temp = coloredReplaceAll(temp, ":star:", ChatColor.GOLD + "\u272F");
        if (player.hasPermission("chatmoji.yes"))
            temp = coloredReplaceAll(temp, ":yes:", ChatColor.GREEN + "" + ChatColor.BOLD + "\u2713");
        if (player.hasPermission("chatmoji.no"))
            temp = coloredReplaceAll(temp, ":no:", ChatColor.RED + "\u274C");
        if (player.hasPermission("chatmoji.java"))
            temp = temp.replaceAll(":java:", "\u2615");
        if (player.hasPermission("chatmoji.shrug"))
            temp = temp.replaceAll(":shrug:", "\u00AF\\\\_(\u30C4)_/\u00AF");
        event.setMessage(temp);
    }

    /**
     * String.replaceAll() but changes the ChatColor back after the replacement
     * @param regex String to replace
     * @param replacement String with color code to put in
     */
    private String coloredReplaceAll(String string, String regex, String replacement) {
        while (string.contains(regex)) {
            String substr = string.substring(0, string.indexOf(regex));
            String color = ChatColor.getLastColors(substr);
            if (color.length() == 0)
                color = ChatColor.WHITE + "";
            string = string.replace(regex, replacement + color);
        }
        return string;
    }
}

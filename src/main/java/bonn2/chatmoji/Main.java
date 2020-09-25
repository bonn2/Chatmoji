package bonn2.chatmoji;

import bonn2.chatmoji.listeners.ChatMessage;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new ChatMessage(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

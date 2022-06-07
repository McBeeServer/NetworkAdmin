package fun.mcbee.bungee.networkadmin;

import fun.mcbee.bungee.networkadmin.commands.Checkonline;
import fun.mcbee.bungee.networkadmin.commands.MaintenanceCommand;
import fun.mcbee.bungee.networkadmin.listener.BungeeSettings;
import fun.mcbee.bungee.networkadmin.listener.PremiumChat;
import fun.mcbee.bungee.networkadmin.listener.StaffChat;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

import java.util.EventListener;

public final class NetworkAdmin extends Plugin {

    public static boolean maintenance = false;
    public static NetworkAdmin plugin;
    public Configuration config;
    public static NetworkAdmin getInstance() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;

        ProxyServer.getInstance().getPluginManager().registerListener(this, new BungeeSettings());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, (Command)new Checkonline());
        ProxyServer.getInstance().getPluginManager().registerListener(this, (Listener)new StaffChat());
        ProxyServer.getInstance().getPluginManager().registerListener(this, (Listener)new PremiumChat());
        BungeeCord.getInstance().getPluginManager().registerCommand(this, (Command)new MaintenanceCommand());

    }

    @Override
    public void onDisable() {}


}

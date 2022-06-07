package fun.mcbee.bungee.networkadmin.listener;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class StaffChat implements Listener {

    @EventHandler
    public void onChat(ChatEvent event) {
        if (event.getMessage().startsWith("##")) {
            if(event.getSender() instanceof ProxiedPlayer) {
                ProxiedPlayer player = (ProxiedPlayer) event.getSender();
                if(player.hasPermission("bee.staff.staffchat")) {
                    TextComponent text = new TextComponent(ChatColor.DARK_RED+""+ChatColor.BOLD+"SC" +ChatColor.DARK_GRAY+""+ ChatColor.BOLD +" | " +ChatColor.RED +player.getDisplayName()+ChatColor.DARK_GRAY+""+ChatColor.BOLD+" » "+ChatColor.WHITE+event.getMessage().replace("##", ""));
                    event.setCancelled(true);
                    for (ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
                        if (p.hasPermission("bee.staff.staffchat")) {
                            p.sendMessage(text);



                        }
                    }
                }
            }
        }
    }
}

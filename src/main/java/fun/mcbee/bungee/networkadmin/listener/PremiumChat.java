package fun.mcbee.bungee.networkadmin.listener;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PremiumChat implements Listener {

    @EventHandler
    public void onChat(ChatEvent event) {
        if (event.getMessage().startsWith("!p")) {
            if(event.getSender() instanceof ProxiedPlayer) {
                ProxiedPlayer player = (ProxiedPlayer) event.getSender();
                if(player.hasPermission("bee.premium.chat")) {
                    TextComponent text = new TextComponent(ChatColor.YELLOW+""+ChatColor.BOLD+"PC" +ChatColor.DARK_GRAY+""+ ChatColor.BOLD +" | " +ChatColor.AQUA +player.getDisplayName()+ChatColor.DARK_GRAY+""+ChatColor.BOLD+" » "+ChatColor.WHITE+event.getMessage().replace("!p", ""));
                    event.setCancelled(true);
                    for (ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
                        if (p.hasPermission("bee.premium.chat")) {
                            p.sendMessage(text);



                        }
                    }
                }
            }
        }
    }
}

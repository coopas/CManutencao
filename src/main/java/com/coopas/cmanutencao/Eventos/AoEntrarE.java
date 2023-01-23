package com.coopas.cmanutencao.Eventos;

import com.coopas.cmanutencao.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class AoEntrarE implements Listener {
    @EventHandler
    public void aoEntrar(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if (Bukkit.hasWhitelist()) {

            if(!p.isWhitelisted()) {
                p.kickPlayer(Main.config.getConfig().getString("Mensagens.Kick.Msg")
                        .replace("&", " §"));
            }
        }
    }

}

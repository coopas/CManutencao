package com.coopas.cmanutencao.Eventos;

import com.coopas.cmanutencao.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MotdE implements Listener {

    @EventHandler
    public void onMotd(ServerListPingEvent e) {


                if (Bukkit.hasWhitelist()) {


                    e.setMotd(Main.config.getConfig().getString("Motd.Manutencao.1").replace("&", " §") + "\n" +
                            Main.config.getConfig().getString("Motd.Manutencao.2").replace("&", " §"));
                    e.setMaxPlayers(e.getNumPlayers() + 1);

                } else {

                    e.setMotd(Main.config.getConfig().getString("Motd.Aberto.1").replace("&", " §") + "\n" +
                            Main.config.getConfig().getString("Motd.Aberto.2").replace("&", " §"));
                    e.setMaxPlayers(Main.config.getConfig().getInt("Config.MaxDePlayers"));

                }

            }

}

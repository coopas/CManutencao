package com.coopas.cmanutencao.Comandos;

import com.coopas.cmanutencao.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.coopas.cmanutencao.Main.plugin;

public class ManutencaoC implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("Manutencao")) {
            if(sender.hasPermission(Main.config.getConfig().getString("Config.Perm").replace("&", " §"))) {

                    if (args.length == 0) {
                        sender.sendMessage(Main.config.getConfig().getString("Mensagens.Erro1").replace("&", " §"));
                        return false;
                    } else {
                        if (args[0].equalsIgnoreCase("on")) {
                            if (Bukkit.hasWhitelist()) {
                                sender.sendMessage(Main.config.getConfig().getString("Mensagens.Erro3").replace("&", " §"));
                            } else {
                                Bukkit.setWhitelist(true);
                                sender.sendMessage(Main.config.getConfig().getString("Mensagens.MOn").replace("&", " §"));



                                if (Main.config.getConfig().getInt("Config.Kick") == 1) {
                                    Bukkit.broadcastMessage(" ");
                                    Bukkit.broadcastMessage(Main.config.getConfig().getString("Mensagens.Kick.Aviso")
                                            .replace("&", " §")
                                            .replace("{delay}", Integer.toString(Main.config.getConfig().getInt("Config.DelayKick"))));
                                    Bukkit.broadcastMessage(" ");
                                            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                            for (Player p : Bukkit.getOnlinePlayers()) {
                                                if (!p.isWhitelisted()) {
                                                    p.kickPlayer(Main.config.getConfig().getString("Mensagens.Kick.1").replace("&", " §") + "\n" +
                                                            Main.config.getConfig().getString("Mensagens.Kick.2").replace("&", " §") + "\n" +
                                                            Main.config.getConfig().getString("Mensagens.Kick.3").replace("&", " §") + "\n" +
                                                            Main.config.getConfig().getString("Mensagens.Kick.4").replace("&", " §"));
                                                }
                                            }
                                            }, Main.config.getConfig().getInt("Config.DelayKick")*20L);

                                }
                            }

                        } else {
                            if (args[0].equalsIgnoreCase("off")) {
                                if (!Bukkit.hasWhitelist()) {
                                    sender.sendMessage(Main.config.getConfig().getString("Mensagens.Erro4").replace("&", " §"));
                                } else {
                                    Bukkit.setWhitelist(false);
                                    sender.sendMessage(Main.config.getConfig().getString("Mensagens.MOff").replace("&", " §"));
                                }
                            } else {
                                if (args.length == 1) {
                                    sender.sendMessage(Main.config.getConfig().getString("Mensagens.Erro1").replace("&", " §"));
                                }
                            }

                        }

                    }


            } else {
                sender.sendMessage(Main.config.getConfig().getString("Mensagens.Erro2").replace("&", " §"));
            }
        }

        return false;
    }
}

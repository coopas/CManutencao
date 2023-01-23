package com.coopas.cmanutencao.Comandos;

import com.coopas.cmanutencao.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
                                    for (Player p : Bukkit.getOnlinePlayers())
                                        p.kickPlayer(Main.config.getConfig().getString("Mensagens.Kick.1").replace("&", " §") + "\n" +
                                                Main.config.getConfig().getString("Mensagens.Kick.2").replace("&", " §") + "\n" +
                                                Main.config.getConfig().getString("Mensagens.Kick.3").replace("&", " §") + "\n" +
                                                Main.config.getConfig().getString("Mensagens.Kick.4").replace("&", " §"));
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

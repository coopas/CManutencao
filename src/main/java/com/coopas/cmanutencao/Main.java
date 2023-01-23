package com.coopas.cmanutencao;

import com.coopas.cmanutencao.Comandos.ManutencaoC;
import com.coopas.cmanutencao.Eventos.AoEntrarE;
import com.coopas.cmanutencao.Eventos.MotdE;
import com.coopas.cmanutencao.Utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class Main extends JavaPlugin {

    public static Main plugin;
    public static Config config;


    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getConsoleSender().sendMessage("   ");

        comandos();
        Bukkit.getConsoleSender().sendMessage("     §a[CMANUTENCAO] COMANDOS INICIADOS");
        eventos();
        Bukkit.getConsoleSender().sendMessage("     §a[CMANUTENCAO] EVENTOS INICIADOS");
        arquivos();
        Bukkit.getConsoleSender().sendMessage("     §a[CMANUTENCAO] ARQUIVOS INICIADOS");

        Bukkit.getConsoleSender().sendMessage("   ");
        Bukkit.getConsoleSender().sendMessage("     §a - PLUGIN CMANUTENCAO INICIADO!");
        Bukkit.getConsoleSender().sendMessage("     §a - MUITO OBRIGADO POR ME APOIAR!");
        Bukkit.getConsoleSender().sendMessage("   ");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("     §c - PLUGIN CMANUTENCAO FINALIZADO!  ");
        Bukkit.getConsoleSender().sendMessage(" ");
    }


    public void eventos() {

        Bukkit.getPluginManager().registerEvents(new MotdE(), this);
        Bukkit.getPluginManager().registerEvents(new AoEntrarE(), this);
    }

    public void comandos() {
        getCommand("manutencao").setExecutor(new ManutencaoC());
    }

    public void arquivos() {
        config = new Config(this, "config.yml");
        config.saveDefaultConfig();
    }

    public void createFile(Main main, String fileName, boolean isFile) {
        try {
            File file = new File(main.getDataFolder() + File.separator + fileName);
            if (isFile) file.createNewFile();
            else if (!file.exists()) file.mkdirs();
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }
}

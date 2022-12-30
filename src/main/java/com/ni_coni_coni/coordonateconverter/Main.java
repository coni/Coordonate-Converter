package com.ni_coni_coni.coordonateconverter;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {


        this.getCommand("convertposition").setExecutor(new ConvertPosition());

    }
    @Override
    public void onDisable() {
    }
}


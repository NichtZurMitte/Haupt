package de.stan.haupt.main;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.stan.haupt.commands.ChatClear;
import de.stan.haupt.commands.Clear;
import de.stan.haupt.commands.Gm;
import de.stan.haupt.commands.Info;
import de.stan.haupt.commands.Inv;
import de.stan.haupt.commands.MuteCommand;
import de.stan.haupt.commands.Party;
import de.stan.haupt.commands.SetSpawn;
import de.stan.haupt.commands.Spawn;
import de.stan.haupt.listener.JoinListener;
import de.stan.haupt.listener.QuitListener;

public class Main extends JavaPlugin implements Listener {
	
	private static Main plugin;
	
	public void onEnable() {
		plugin = this;
		MuteCommand muteCommand = new MuteCommand();
		
		System.out.println("[Haupt]Das Plugin wurde erfolreich aktiviert");
		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new JoinListener(), this);
		pluginManager.registerEvents(new QuitListener(), this);
		pluginManager.registerEvents(muteCommand, this);
				
				
		getCommand("clear").setExecutor(new Clear());
		getCommand("inv").setExecutor(new Inv());
		getCommand("party").setExecutor(new Party());
		getCommand("setSpawn").setExecutor(new SetSpawn());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("info").setExecutor(new Info());
		getCommand("cc").setExecutor(new ChatClear());
		getCommand("mute").setExecutor(muteCommand);
		getCommand("gm").setExecutor(new Gm());

		
	}
	
	public void onDisable() {
		System.out.println("[Haupt]Das Plugin wurde erfolgreich DEAKTIVIERT");
	}
	
	public static Main getPlugin() {
		return plugin;
	}

}

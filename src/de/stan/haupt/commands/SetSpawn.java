package de.stan.haupt.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.stan.haupt.main.Main;

public class SetSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlable, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("haupt.setSpawn")) {
				if(args.length == 0) {
					FileConfiguration config = Main.getPlugin().getConfig();
					config.set("Spawn.World", p.getWorld().getName());
					config.set("Spawn.x", p.getLocation().getX());
					config.set("Spawn.y", p.getLocation().getY());
					config.set("Spawn.z", p.getLocation().getZ());
					config.set("Spawn.Yaw", p.getLocation().getYaw());
					config.set("Spawn.Pitch", p.getLocation().getPitch());
					Main.getPlugin().saveConfig();
					p.sendMessage("§aDu hast den Spawn §6§lerfolgreich §r§a gesetzt!");
				}else
					p.sendMessage("§cBitte benutze /setspawn!");
				
				
			}else
				p.sendMessage("§cEy wer gibt dir das Recht daszu das zu benutzen?!");
		}
		
		return false;
	}

}

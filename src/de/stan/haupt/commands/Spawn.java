package de.stan.haupt.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.stan.haupt.main.Main;


public class Spawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlable, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("spawn.haupt")) {
				if(args.length == 0) {
					FileConfiguration config = Main.getPlugin().getConfig();
					World world = Bukkit.getWorld(config.getString("Spawn.World"));
					double x = config.getDouble("Spawn.x");
					double y = config.getDouble("Spawn.y");
					double z = config.getDouble("Spawn.z");
					float yaw = (float) config.getDouble("Spawn.Yaw");
					float pitch = (float) config.getDouble("Spawn.pitch");
					Location loc = new Location(world, x, y, z, yaw, pitch);
					p.teleport(loc);
				}
			}
		}
		return false;
	}

}

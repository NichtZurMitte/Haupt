package de.stan.haupt.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gm implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args) {
		if(!(sender instanceof Player)) {
			System.out.println("Du bist kein Spieler!");
			return true;
		}
		Player p = (Player) sender;
		if(!(p.hasPermission("haupt.gm"))) {
			p.sendMessage("§cDazu hast du keine Rechte!");
			return true;
		}
		if(args.length == 1 && args[0].equalsIgnoreCase("0")) {
			p.setGameMode(GameMode.SURVIVAL);
			return true;
		}else if(args[0].equalsIgnoreCase("1")) {
			p.setGameMode(GameMode.CREATIVE);
			return true;
		}else if(args[0].equalsIgnoreCase("2")) {
			p.setGameMode(GameMode.ADVENTURE);
			return true;
		}else if(args[0].equalsIgnoreCase("3")) {
			p.setGameMode(GameMode.SPECTATOR);
			return true;
		}else 
			p.sendMessage("§cBitte benutze §6/gm <0|1|2|3> §c!");
		
		
		if (args.length == 2 && args[1] instanceof Player) {
			Player t = args[1];
			if(args.length == 1 && args[0].equalsIgnoreCase("0")) {
				t.setGameMode(GameMode.SURVIVAL);
				return true;
			}else if(args[0].equalsIgnoreCase("1")) {
				t.setGameMode(GameMode.CREATIVE);
				return true;
			}else if(args[0].equalsIgnoreCase("2")) {
				t.setGameMode(GameMode.ADVENTURE);
				return true;
			}else if(args[0].equalsIgnoreCase("3")) {
				t.setGameMode(GameMode.SPECTATOR);
				return true;
			}else
				t.sendMessage("�cBitte benutze �6/gm <0|1|2|3> <Player>�c!");
		}

		
		return false;
	}

}

package de.stan.haupt.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Info implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlable, String[] args) {
		
		if(!(sender instanceof Player)) {
			System.out.println("Du bist kein Spieler!");
			return true;
		}
			Player p = (Player) sender;
			
		if(args.length == 1 && args[0].equalsIgnoreCase("server")) {
			
			p.sendMessage("§6Der Server gehört §lHizzyyy §r§6!");
				return true;
			}
		if(args.length == 1 && args[0].equalsIgnoreCase("discord")) {
			
			p.sendMessage("§6Um dem Discord beizutreten benutze diesen Link: §a§lhttps://discord.gg/byzqvcv §r§6!");
			return true;
		}
		
		
		return false;
	}

}

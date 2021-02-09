package de.stan.haupt.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Clear implements CommandExecutor{


	public boolean onCommand(CommandSender sender, Command cmd, String cmdlable, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("clear")) {
			if(p.hasPermission("haupt.clear"))  {
				if(args.length ==0) {
					p.getInventory().clear();
				}else if(args.length ==1) {
					Player t = Bukkit.getPlayer(args[0]);
					if(t != null) {
						t.getInventory().clear();
						t.sendMessage("§cDu warst böse also wurde dein Inventar gecleart!");
						p.sendMessage("§e[Clear]" + "§2Das Inventar von " + "§e" + t.getName() + "§2 wurde gecleart!");
					}else {
						p.sendMessage("§a[Clear]" + "§6Der Spieler " + "§e" + args[0] + " §6ist nicht online!");
					}
					
				}else {
					p.sendMessage("§a[Clear]" + "§2Bittr Benutze /clear <player>");
				}
				
			}else {
				p.sendMessage("§4§lDazu hast du nicht die benötigten Rechte!");
			}
		}
		return false;
	}
}	
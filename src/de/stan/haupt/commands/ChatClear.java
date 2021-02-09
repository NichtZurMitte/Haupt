package de.stan.haupt.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatClear implements CommandExecutor {
	


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlable, String[] args) {
		
		if(!(sender instanceof Player)) {
			System.out.println("Du bist kein Spieler");
			return true;
		}
		
		Player p =(Player) sender;
		
		if(!(p.hasPermission("Haupt.cc"))) {
			p.sendMessage("§6[ClearChat] §cDazu hast du keine Rechte!");
			return true;
			}
			
		for(Player current : Bukkit.getOnlinePlayers()) {
			for(int i = 0; i <=150; i++) {
				
				current.sendMessage(" ");
			}
			current.sendMessage("§6[ChatClear] §aDer Chat wurde erfolgreich gecleart!");
			}

		
		
		
		
		return false;
	

	}

}

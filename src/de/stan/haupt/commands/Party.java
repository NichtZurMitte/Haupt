package de.stan.haupt.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.stan.haupt.main.Main;

public class Party implements CommandExecutor {

	private int taskID;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlable, String[] args) {
		if(sender instanceof Player) {
			if(sender.hasPermission("haupt.party"))
			taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
				int countdown = 5;
				
				@Override
				public void run() {
					if(countdown <= 0) {
						Bukkit.broadcastMessage("§6§lDIE PARTY BEGINNT!");
						Bukkit.getScheduler().cancelTask(taskID);
						return;
					}
						Bukkit.broadcastMessage("§7Die Party behinnt in §6" + countdown + " Sekunden§7.");
						countdown--;
					
				}
			}, 0, 20);
		}
		return false;
	}

}

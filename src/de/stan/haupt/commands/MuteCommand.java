package de.stan.haupt.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MuteCommand implements CommandExecutor, Listener{
	
	private ArrayList<String> mutedPlayers = new ArrayList<>();
	
	@EventHandler
	public void onMute(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(mutedPlayers.contains(p.getName())) {
			p.sendMessage("§6[Mute] §l§4Du bist gemutet!");
			e.setCancelled(true);
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args) {
		
		if(!(sender instanceof Player)) {
			System.out.println("Du bist kein Spieler!");
			return true;
		}
		Player p = (Player) sender;
		if(!(p.hasPermission("haupt.mute"))) {
			p.sendMessage("§6[Mute] §cDazu hast du keine Rechte!");
			System.out.println("Der Spieler " + p.getName() + "hat gerade versucht den /mute command auszuführen!");
			return true;
		}
		if(!(args.length == 1)) {
			p.sendMessage("§6[Mute] §cBitte benutze /mute <Player>!");
			return true;
		}
		Player t = Bukkit.getPlayer(args[0]);
		if(!(t != null)) {
			p.sendMessage("§6[Mute] §cDer Spieler §6§l" + args[0] + " §r§cist nicht online!") ;
			return true;
		}
		if(!(mutedPlayers.contains(t.getName()))) {
			mutedPlayers.add(t.getName());
			p.sendMessage("§6[Mute] §aDer Spieler §2§l" + t.getName() + "§r§a wurde erfolgreich gemutet!");
			t.sendMessage("§6[Mute] §cDu warst böse also wurdest du von §6§l" + p.getName() + " §r§cgemutet!");
		}else {
			mutedPlayers.remove(t.getName());
			p.sendMessage("§6[Mute] §aDer Spierler §2§l" + t.getName() + " §r§awurde erfolgreich entmutet!");
			t.sendMessage("§6[Mute] §aDu wurdest endmutet, doch gib acht was du schreibst, wir werden dich im Auge behalten!");
			return true;
		}
		
		
		return false;
	}

}

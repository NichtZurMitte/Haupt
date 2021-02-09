package de.stan.haupt.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent ej) {
		if(ej.getPlayer().isOp()) {
			ej.setJoinMessage("§2§l[>>] " + "§4" + ej.getPlayer().getName());
		}else {
			ej.setJoinMessage("§2§l[>>] " + "§6" + ej.getPlayer().getName());
		} 
	}

}

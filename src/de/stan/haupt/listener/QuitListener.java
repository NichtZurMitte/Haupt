package de.stan.haupt.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener{
	
	@EventHandler
	public void onQuit(PlayerQuitEvent eq) {
		if(eq.getPlayer().isOp()) {
			eq.setQuitMessage("§4[<<] §4" + eq.getPlayer().getName());
	}else
		eq.setQuitMessage("§4[<<] §6" + eq.getPlayer().getName());
		
	}
}



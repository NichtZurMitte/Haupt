package de.stan.haupt.commands;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Inv implements CommandExecutor {
	
	private HashMap<UUID, ItemStack[]> inventorys = new HashMap<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlable, String[] args) {
		if(!(sender instanceof Player)) {
			System.out.println("Du bist kein Spieler!");
			return true;
		}
		Player p = (Player) sender;
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("save")) {
				inventorys.put(p.getUniqueId(), p.getInventory().getContents());
				p.getInventory().clear();
				p.sendMessage("§aDeine Items sind bei uns in §6§lsicheren§r§a Händen!");
			}else if(args[0].equalsIgnoreCase("get")) {
				if(inventorys.containsKey(p.getUniqueId())) {
					p.getInventory().setContents(inventorys.get(p.getUniqueId()));
					inventorys.remove(p.getUniqueId());
					p.sendMessage("§aOk, ok du bekommst deine §6§lItems §r§awieder!");
				}else
					p.sendMessage("§cDu hast garkeine Items gespeichert. §lVerschwinde§r!");
				
			
			}else
				p.sendMessage("§cBitte benutze §6/inv <save|get>§c!");
			
		}else
			p.sendMessage("§c Bitte benutze §6/inv <save|get>§c!");
		

		return false;
	}

}

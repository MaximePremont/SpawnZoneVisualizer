package fr.mpremont.SpawnZoneVisualizer.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.mpremont.SpawnZoneVisualizer.MainClass;

public class JoinEvents implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		if(MainClass.update) {
			
			Player p = e.getPlayer();
			if(p.hasPermission("spawnzonevisualizer.update")) {
				p.sendMessage("§a[§eSpawnZoneVisualizer§a] §r"+MainClass.getInstance().getConfig().getString("Text.NewVersion").replaceAll("&", "§").replaceAll("===", "\n"));
			}
			
		}
		
	}

}

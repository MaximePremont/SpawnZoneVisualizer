package fr.mpremont.SpawnZoneVisualizer.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.mpremont.SpawnZoneVisualizer.managers.PlayersManager;

public class QuitEvents implements Listener {
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		
		Player p = e.getPlayer();
		
		if(PlayersManager.containsPlayer(p)) {
			
			PlayersManager.removePlayer(p);
			
		}
		
	}

}

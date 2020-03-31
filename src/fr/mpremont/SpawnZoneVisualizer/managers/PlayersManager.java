package fr.mpremont.SpawnZoneVisualizer.managers;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class PlayersManager {
	
	private static ArrayList<Player> players = new ArrayList<Player>();
	
	public static void addPlayer(Player p) {
		
		players.add(p);
		
	}
	
	public static boolean containsPlayer(Player p) {
		
		if(players.contains(p)) {
			
			return true;
			
		}else {
			
			return false;
			
		}
		
	}
	
	public static void removePlayer(Player p) {
		
		players.remove(p);
		
	}
	
	public static ArrayList<Player> getPlayers() {
		
		return players;
		
	}

}

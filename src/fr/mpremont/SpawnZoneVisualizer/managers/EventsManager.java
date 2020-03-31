package fr.mpremont.SpawnZoneVisualizer.managers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import fr.mpremont.SpawnZoneVisualizer.MainClass;
import fr.mpremont.SpawnZoneVisualizer.events.QuitEvents;

public class EventsManager {
	
	public static void registerEvents() {
		
		Plugin p = MainClass.getInstance();
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new QuitEvents(), p);
		
	}

}

package fr.mpremont.SpawnZoneVisualizer.managers;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;

import fr.mpremont.SpawnZoneVisualizer.MainClass;

public class ConfigManager {
	
	public static boolean checkConfig() {
		
		boolean result = true;
		
		String confv = MainClass.getInstance().getConfig().getString("ConfigVersion");
		if(confv == null || confv == "" || (!confv.contains("#"))) {
			
			Bukkit.getConsoleSender().sendMessage("§a[§eSpawnZoneVisualize§a] §cInvalid configuration file !");
			result = false;
			
		}else {
			
			Configuration c = MainClass.getInstance().getConfig();
			String version = c.getString("ConfigVersion").split("#")[0];
			
			if(!version.equalsIgnoreCase("1.0.0")) {
				
				result = false;
				
			}
			
		}
		
		return result;
		
	}

}

package fr.mpremont.SpawnZoneVisualizer;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.mpremont.SpawnZoneVisualizer.managers.CommandsManager;
import fr.mpremont.SpawnZoneVisualizer.managers.ConfigManager;
import fr.mpremont.SpawnZoneVisualizer.managers.EventsManager;
import fr.mpremont.SpawnZoneVisualizer.managers.PlayersManager;
import fr.mpremont.SpawnZoneVisualizer.managers.SchedulersManager;
import fr.mpremont.SpawnZoneVisualizer.managers.VersionsManager;
import fr.mpremont.SpawnZoneVisualizer.utils.Metrics;

public class MainClass extends JavaPlugin{
	
	private static Plugin plugin;
	
	public void onEnable() {
		
		plugin = this;
		
		if(VersionsManager.setupVersion()) {
			
			File f = new File(getDataFolder(), "config.yml");
			if(!f.exists()) {
				
				getConfig().options().copyDefaults(true);
				saveDefaultConfig();
				Bukkit.getConsoleSender().sendMessage("§a[§eSpawnZoneVisualize§a] §aConfiguration file created !");
				
			}
			
			if(ConfigManager.checkConfig()) {
				
				EventsManager.registerEvents();
				SchedulersManager.registerSchedulers();
				CommandsManager.registerCommands();
				
				int pluginId = 6940;
				@SuppressWarnings("unused")
				Metrics metrics = new Metrics(this, pluginId);
				
			}else {
				
				Bukkit.getPluginManager().disablePlugin(this);
				
			}
			
		}else {
			
			Bukkit.getConsoleSender().sendMessage("§a[§eSpawnZoneVisualize§a] §cUnsupported minecraft version !");
			Bukkit.getPluginManager().disablePlugin(this);
			
		}
		
	}
	
	public void onDisable() {
		
		for(Player pls : PlayersManager.getPlayers()) {
			
			pls.sendMessage("§a[§eSpawnZoneVisualize§a] §cDisplay of spawn zones disabled !");
			
		}
		
	}
	
	public static Plugin getInstance() {
		
		return plugin;
		
	}

}

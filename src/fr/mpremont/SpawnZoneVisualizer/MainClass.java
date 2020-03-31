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
import fr.mpremont.SpawnZoneVisualizer.utils.UpdateChecker;

public class MainClass extends JavaPlugin{
	
	private static Plugin plugin;
	
	public void onEnable() {
		
		plugin = this;
		
		if(VersionsManager.setupVersion()) {
			
			File f = new File(getDataFolder(), "config.yml");
			if(!f.exists()) {
				
				getConfig().options().copyDefaults(true);
				saveDefaultConfig();
				Bukkit.getConsoleSender().sendMessage("§a[§eSpawnZoneVisualizer§a] §aConfiguration file created !");
				
			}
			
			if(ConfigManager.checkConfig()) {
				
				EventsManager.registerEvents();
				SchedulersManager.registerSchedulers();
				CommandsManager.registerCommands();
				
				int pluginId = 6940;
				@SuppressWarnings("unused")
				Metrics metrics = new Metrics(this, pluginId);
				
				try {
					
					UpdateChecker updater = new UpdateChecker(this, 76762);
					if(updater.checkForUpdates()) {
						Bukkit.getConsoleSender().sendMessage("§a[§eSpawnZoneVisualizer§a] §eA new version of the plugin is available !");
					}
					
				}catch (Exception e) {
					Bukkit.getConsoleSender().sendMessage("§a[§eSpawnZoneVisualizer§a] §cCould not check for updates !");
				}
				
			}else {
				
				Bukkit.getPluginManager().disablePlugin(this);
				
			}
			
		}else {
			
			Bukkit.getConsoleSender().sendMessage("§a[§eSpawnZoneVisualizer§a] §cUnsupported minecraft version !");
			Bukkit.getPluginManager().disablePlugin(this);
			
		}
		
	}
	
	public void onDisable() {
		
		for(Player pls : PlayersManager.getPlayers()) {
			
			pls.sendMessage("§a[§eSpawnZoneVisualizer§a] §cDisplay of spawn zones disabled !");
			
		}
		
	}
	
	public static Plugin getInstance() {
		
		return plugin;
		
	}

}

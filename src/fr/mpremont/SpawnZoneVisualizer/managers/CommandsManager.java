package fr.mpremont.SpawnZoneVisualizer.managers;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.Plugin;

import fr.mpremont.SpawnZoneVisualizer.MainClass;

public class CommandsManager {
	
	public static void registerCommands() {
		
		Plugin p = MainClass.getInstance();
		
		PluginCommand VisualizeCMD = p.getServer().getPluginCommand("visualize");
		VisualizeCMD.setExecutor(new fr.mpremont.SpawnZoneVisualizer.commands.VisualizeCMD());
		
	}

}

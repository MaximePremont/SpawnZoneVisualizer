package fr.mpremont.SpawnZoneVisualizer.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import fr.mpremont.SpawnZoneVisualizer.MainClass;
import fr.mpremont.SpawnZoneVisualizer.managers.PlayersManager;

public class VisualizeCMD implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("spawnzonevisualizer.visualize")) {
				
				if(PlayersManager.containsPlayer(p)) {
					
					PlayersManager.removePlayer(p);
					p.sendMessage("§a[§eSpawnZoneVisualizer§a] §r"+MainClass.getInstance().getConfig().getString("Text.OffMessage").replaceAll("&", "§").replaceAll("===", "\n"));
					
				}else {
					
					PlayersManager.addPlayer(p);
					p.sendMessage("§a[§eSpawnZoneVisualizer§a] §r"+MainClass.getInstance().getConfig().getString("Text.OnMessage").replaceAll("&", "§").replaceAll("===", "\n"));
					
				}
				
			}else {
				
				p.sendMessage("§a[§eSpawnZoneVisualizer§a] §r"+MainClass.getInstance().getConfig().getString("Text.NoPermission").replaceAll("&", "§").replaceAll("===", "\n"));
				
			}
			
		}
		
		if(sender instanceof ConsoleCommandSender) {
			
			Bukkit.getConsoleSender().sendMessage("§a[§eSpawnZoneVisualizer§a] §r"+MainClass.getInstance().getConfig().getString("Text.NoConsole").replaceAll("&", "§").replaceAll("===", "\n"));
			
		}
		
		return false;
		
	}

}

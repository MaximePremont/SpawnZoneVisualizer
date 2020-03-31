package fr.mpremont.SpawnZoneVisualizer.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import fr.mpremont.SpawnZoneVisualizer.managers.PlayersManager;

public class VisualizeCMD implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("spawnzonevisualizer.visualize")) {
				
				if(PlayersManager.containsPlayer(p)) {
					
					PlayersManager.removePlayer(p);
					p.sendMessage("§a[§eSpawnZoneVisualize§a] §cDisplay of spawn zones disabled !");
					
				}else {
					
					PlayersManager.addPlayer(p);
					p.sendMessage("§a[§eSpawnZoneVisualize§a] §aDisplay of spawn zones enabled !\n§lTIP:§r §aUsing this mode is easier at night.");
					
				}
				
			}else {
				
				p.sendMessage("§a[§eSpawnZoneVisualize§a] §cYou don't have the permission !");
				
			}
			
		}
		
		if(sender instanceof ConsoleCommandSender) {
			
			Bukkit.getConsoleSender().sendMessage("§a[§eSpawnZoneVisualize§a] §cThis command cannot be used in the console !");
			
		}
		
		return false;
		
	}

}

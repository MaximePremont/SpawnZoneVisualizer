package fr.mpremont.SpawnZoneVisualizer.schedulers;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import fr.mpremont.SpawnZoneVisualizer.MainClass;
import fr.mpremont.SpawnZoneVisualizer.managers.PlayersManager;
import fr.mpremont.SpawnZoneVisualizer.managers.VersionsManager;
import fr.mpremont.SpawnZoneVisualizer.utils.LocationsUtils;

public class ParticlesScheduler {
	
	public static void start() {
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(MainClass.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				
				for(Player pls : PlayersManager.getPlayers()) {
					
					ArrayList<Block> blocks = new ArrayList<Block>();
					
					for(Location ls : LocationsUtils.getLocInRad(MainClass.getInstance().getConfig().getInt("Radius"), pls.getLocation())) {
						
						World w = pls.getLocation().getWorld();
						Block b = w.getBlockAt(ls.add(0, -1, 0));
						
						if(b.getLightLevel() <= 6 && VersionsManager.use().isTransparent(b)) {
							
							Block v = w.getBlockAt(b.getLocation().add(0, -1, 0));
							if(VersionsManager.use().isSpawnableType(v)) {
								blocks.add(b);
							}
							
						}
						
					}
					
					for(Block bs : blocks) {
						
						VersionsManager.use().showParticle((float) 0.2, (float) 0.2, (float) 0.2, 0, 3, bs.getLocation().add(0.5, 0.5, 0.5), pls);
						
					}
					
				}
				
			}
			
		}, 20, 20);
		
	}

}

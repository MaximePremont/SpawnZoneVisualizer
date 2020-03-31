package fr.mpremont.SpawnZoneVisualizer.interfaces;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public interface Version {

	public Sound getSound(String sound);
	
	public boolean isSpawnableType(Block block);
	
	public boolean isTransparent(Block block);
	
	public void showParticle(float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, Player player);
	
}

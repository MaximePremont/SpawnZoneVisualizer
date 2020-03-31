package fr.mpremont.SpawnZoneVisualizer.utils;

import java.util.ArrayList;

import org.bukkit.Location;

public class LocationsUtils {
	
	public static ArrayList<Location> getLocInRad(int radius, Location center){
		
		ArrayList<Location> locs = new ArrayList<Location>();
		
		int x = center.getBlockX()-radius;
		int y = center.getBlockY()-radius;
		int z  = center.getBlockZ()-radius;
		
		for(int a = x; a <= (x+radius); a++) {
			
			for(int b = y; b <= (y+radius); b++) {
				
				for(int c = z; c <= (z+radius); c++) {
					
					Location loc = new Location(center.getWorld(), a, b, c).add((radius/2)+1.5, (radius/2)+1.5, (radius/2)+1.5);
					locs.add(loc);
					
					
				}
				
			}
			
		}
		
		return locs;
		
	}

}

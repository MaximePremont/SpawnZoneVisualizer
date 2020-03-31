package fr.mpremont.SpawnZoneVisualizer.managers;

import fr.mpremont.SpawnZoneVisualizer.schedulers.ParticlesScheduler;

public class SchedulersManager {
	
	public static void registerSchedulers() {
		
		ParticlesScheduler.start();
		
	}

}

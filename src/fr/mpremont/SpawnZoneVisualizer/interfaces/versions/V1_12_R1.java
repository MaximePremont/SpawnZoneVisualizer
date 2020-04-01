package fr.mpremont.SpawnZoneVisualizer.interfaces.versions;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import fr.mpremont.SpawnZoneVisualizer.interfaces.Version;

public class V1_12_R1 implements Version{

	public Sound getSound(String sound) {
		
		return Sound.valueOf(sound);
		
	}
	
	private static ArrayList<Material> spt = new ArrayList<Material>();
	public boolean isSpawnableType(Block block) {
		
		boolean result = true;
		if(spt.size() == 0) {
			spt.add(Material.LEAVES);
			spt.add(Material.LEAVES_2);
			spt.add(Material.FENCE);
			spt.add(Material.WOODEN_DOOR);
			spt.add(Material.IRON_DOOR_BLOCK);
			spt.add(Material.BRICK_STAIRS);
			spt.add(Material.COBBLESTONE_STAIRS);
			spt.add(Material.NETHER_BRICK_STAIRS);
			spt.add(Material.QUARTZ_STAIRS);
			spt.add(Material.RED_SANDSTONE_STAIRS);
			spt.add(Material.SANDSTONE_STAIRS);
			spt.add(Material.SMOOTH_STAIRS);
			spt.add(Material.WOOD_STAIRS);
			spt.add(Material.CHEST);
			spt.add(Material.TRAPPED_CHEST);
			spt.add(Material.ENDER_CHEST);
			spt.add(Material.STONE_BUTTON);
			spt.add(Material.WOOD_BUTTON);
			spt.add(Material.GLASS);
			spt.add(Material.STAINED_GLASS);
			spt.add(Material.THIN_GLASS);
			spt.add(Material.STAINED_GLASS_PANE);
			spt.add(Material.BED);
			spt.add(Material.STEP);
			spt.add(Material.WOOD_STEP);
			spt.add(Material.WOOD_DOUBLE_STEP);
			spt.add(Material.DOUBLE_STEP);
			spt.add(Material.DAYLIGHT_DETECTOR);
			spt.add(Material.DAYLIGHT_DETECTOR_INVERTED);
			spt.add(Material.IRON_TRAPDOOR);
			spt.add(Material.TRAP_DOOR);
			spt.add(Material.BARRIER);
			spt.add(Material.COCOA);
			spt.add(Material.CACTUS);
			spt.add(Material.SEA_LANTERN);
			spt.add(Material.ICE);
			spt.add(Material.PACKED_ICE);
			spt.add(Material.GLOWSTONE);
			spt.add(Material.TNT);
			spt.add(Material.ANVIL);
			spt.add(Material.BREWING_STAND);
			spt.add(Material.CAKE_BLOCK);
			spt.add(Material.CAULDRON);
			spt.add(Material.LADDER);
			spt.add(Material.VINE);
			spt.add(Material.JACK_O_LANTERN);
			spt.add(Material.ENDER_PORTAL_FRAME);
			spt.add(Material.BURNING_FURNACE);
			spt.add(Material.TORCH);
			spt.add(Material.REDSTONE_TORCH_ON);
			spt.add(Material.REDSTONE_TORCH_OFF);
			spt.add(Material.COBBLE_WALL);
			spt.add(Material.IRON_FENCE);
			spt.add(Material.RAILS);
			spt.add(Material.ACTIVATOR_RAIL);
			spt.add(Material.DETECTOR_RAIL);
			spt.add(Material.POWERED_RAIL);
			spt.add(Material.REDSTONE_WIRE);
			spt.add(Material.REDSTONE_COMPARATOR);
			spt.add(Material.REDSTONE);
			spt.add(Material.CARPET);
			spt.add(Material.WOOD_PLATE);
			spt.add(Material.IRON_PLATE);
			spt.add(Material.WATER_LILY);
			spt.add(Material.WEB);
			spt.add(Material.MOB_SPAWNER);
			spt.add(Material.DIODE);
			spt.add(Material.DIODE_BLOCK_ON);
			spt.add(Material.DIODE_BLOCK_OFF);
			spt.add(Material.MYCEL);
			spt.add(Material.BROWN_MUSHROOM);
			spt.add(Material.RED_MUSHROOM);
			spt.add(Material.FIRE);
			spt.add(Material.SLIME_BLOCK);
			spt.add(Material.SKULL);
			spt.add(Material.DRAGON_EGG);
			spt.add(Material.END_ROD);
			spt.add(Material.PURPUR_SLAB);
			spt.add(Material.PURPUR_STAIRS);
			spt.add(Material.GRASS_PATH);
			spt.add(Material.CHORUS_FLOWER);
			spt.add(Material.CHORUS_PLANT);
			spt.add(Material.CHORUS_FRUIT_POPPED);
			spt.add(Material.CHORUS_FRUIT);
			spt.add(Material.END_CRYSTAL);
			spt.add(Material.MAGMA);
			spt.add(Material.BLACK_SHULKER_BOX);
			spt.add(Material.BLUE_SHULKER_BOX);
			spt.add(Material.BROWN_SHULKER_BOX);
			spt.add(Material.CYAN_SHULKER_BOX);
			spt.add(Material.GRAY_SHULKER_BOX);
			spt.add(Material.GREEN_SHULKER_BOX);
			spt.add(Material.LIGHT_BLUE_SHULKER_BOX);
			spt.add(Material.LIME_SHULKER_BOX);
			spt.add(Material.MAGENTA_SHULKER_BOX);
			spt.add(Material.ORANGE_SHULKER_BOX);
			spt.add(Material.PINK_SHULKER_BOX);
			spt.add(Material.PURPLE_SHULKER_BOX);
			spt.add(Material.RED_SHULKER_BOX);
			spt.add(Material.SILVER_SHULKER_BOX);
			spt.add(Material.WHITE_SHULKER_BOX);
			spt.add(Material.YELLOW_SHULKER_BOX);
			
		}
		
		Material m = block.getType();
		
		if(block.isLiquid() || spt.contains(m) || isTransparent(block)) {
			
			result = false;
			
		}
		
		return result;
		
	}
	
	private static ArrayList<Material> is = new ArrayList<Material>();
	public boolean isTransparent(Block block) {
		
		if(is.size() == 0) {
			is.add(Material.AIR);
			is.add(Material.LONG_GRASS);
			is.add(Material.DOUBLE_PLANT);
			is.add(Material.YELLOW_FLOWER);
			is.add(Material.RED_ROSE);
			is.add(Material.SUGAR_CANE_BLOCK);
			is.add(Material.SNOW);
			is.add(Material.CROPS);
			is.add(Material.CARROT);
			is.add(Material.MELON_SEEDS);
			is.add(Material.MELON_STEM);
			is.add(Material.POTATO);
			is.add(Material.STANDING_BANNER);
			is.add(Material.WALL_BANNER);
			is.add(Material.DEAD_BUSH);
		}
		
		Material m = block.getType();
		if(is.contains(m)) {
			
			return true;
			
		}else {
			
			return false;
			
		}
		
	}

	public void showParticle(float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, Player player) {
		
		for(int i = 0; i <= amount; i++) {
			double x = center.getX()+((new Random().nextInt(5)+0.0)/10)-offsetX;
			double y = center.getY()+((new Random().nextInt(5)+0.0)/10)-offsetY;
			double z = center.getZ()+((new Random().nextInt(5)+0.0)/10)-offsetZ;
			
			player.spawnParticle(Particle.FLAME, x, y, z, 0, 0, 0, 0);
			
		}
		
	}

}
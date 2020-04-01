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

public class V1_13_R1 implements Version{

	public Sound getSound(String sound) {
		
		return Sound.valueOf(sound);
		
	}
	
	private static ArrayList<Material> spt = new ArrayList<Material>();
	public boolean isSpawnableType(Block block) {
		
		boolean result = true;
		if(spt.size() == 0) {
			spt.add(Material.ACACIA_LEAVES);
			spt.add(Material.BIRCH_LEAVES);
			spt.add(Material.DARK_OAK_LEAVES);
			spt.add(Material.JUNGLE_LEAVES);
			spt.add(Material.OAK_LEAVES);
			spt.add(Material.OAK_LEAVES);
			spt.add(Material.ACACIA_DOOR);
			spt.add(Material.BIRCH_DOOR);
			spt.add(Material.DARK_OAK_DOOR);
			spt.add(Material.JUNGLE_DOOR);
			spt.add(Material.OAK_DOOR);
			spt.add(Material.SPRUCE_DOOR);
			spt.add(Material.IRON_DOOR);
			spt.add(Material.BRICK_STAIRS);
			spt.add(Material.COBBLESTONE_STAIRS);
			spt.add(Material.NETHER_BRICK_STAIRS);
			spt.add(Material.QUARTZ_STAIRS);
			spt.add(Material.RED_SANDSTONE_STAIRS);
			spt.add(Material.SANDSTONE_STAIRS);
			spt.add(Material.ACACIA_STAIRS);
			spt.add(Material.BIRCH_STAIRS);
			spt.add(Material.DARK_OAK_STAIRS);
			spt.add(Material.DARK_PRISMARINE_STAIRS);
			spt.add(Material.JUNGLE_STAIRS);
			spt.add(Material.OAK_STAIRS);
			spt.add(Material.PRISMARINE_BRICK_STAIRS);
			spt.add(Material.PRISMARINE_STAIRS);
			spt.add(Material.PURPUR_STAIRS);
			spt.add(Material.SANDSTONE_STAIRS);
			spt.add(Material.SPRUCE_STAIRS);
			spt.add(Material.STONE_BRICK_STAIRS);
			spt.add(Material.CHEST);
			spt.add(Material.TRAPPED_CHEST);
			spt.add(Material.ENDER_CHEST);
			spt.add(Material.STONE_BUTTON);
			spt.add(Material.ACACIA_BUTTON);
			spt.add(Material.BIRCH_BUTTON);
			spt.add(Material.DARK_OAK_BUTTON);
			spt.add(Material.JUNGLE_BUTTON);
			spt.add(Material.OAK_BUTTON);
			spt.add(Material.SPRUCE_BUTTON);
			spt.add(Material.STONE_BUTTON);
			spt.add(Material.GLASS);
			spt.add(Material.BLACK_STAINED_GLASS);
			spt.add(Material.BLACK_STAINED_GLASS_PANE);
			spt.add(Material.BLUE_STAINED_GLASS);
			spt.add(Material.BLUE_STAINED_GLASS_PANE);
			spt.add(Material.BROWN_STAINED_GLASS);
			spt.add(Material.BROWN_STAINED_GLASS_PANE);
			spt.add(Material.CYAN_STAINED_GLASS);
			spt.add(Material.CYAN_STAINED_GLASS_PANE);
			spt.add(Material.GLASS_PANE);
			spt.add(Material.GRAY_STAINED_GLASS);
			spt.add(Material.GRAY_STAINED_GLASS_PANE);
			spt.add(Material.GREEN_STAINED_GLASS);
			spt.add(Material.GREEN_STAINED_GLASS_PANE);
			spt.add(Material.LIGHT_BLUE_STAINED_GLASS);
			spt.add(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
			spt.add(Material.LIGHT_GRAY_STAINED_GLASS);
			spt.add(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
			spt.add(Material.LIME_STAINED_GLASS);
			spt.add(Material.LIME_STAINED_GLASS_PANE);
			spt.add(Material.MAGENTA_STAINED_GLASS);
			spt.add(Material.MAGENTA_STAINED_GLASS_PANE);
			spt.add(Material.ORANGE_STAINED_GLASS);
			spt.add(Material.ORANGE_STAINED_GLASS_PANE);
			spt.add(Material.PINK_STAINED_GLASS);
			spt.add(Material.PINK_STAINED_GLASS_PANE);
			spt.add(Material.PURPLE_STAINED_GLASS);
			spt.add(Material.PURPLE_STAINED_GLASS_PANE);
			spt.add(Material.RED_STAINED_GLASS);
			spt.add(Material.RED_STAINED_GLASS_PANE);
			spt.add(Material.WHITE_STAINED_GLASS);
			spt.add(Material.WHITE_STAINED_GLASS_PANE);
			spt.add(Material.YELLOW_STAINED_GLASS);
			spt.add(Material.YELLOW_STAINED_GLASS_PANE);
			spt.add(Material.BLACK_BED);
			spt.add(Material.BLUE_BED);
			spt.add(Material.BROWN_BED);
			spt.add(Material.CYAN_BED);
			spt.add(Material.GRAY_BED);
			spt.add(Material.GREEN_BED);
			spt.add(Material.LIGHT_BLUE_BED);
			spt.add(Material.LIGHT_GRAY_BED);
			spt.add(Material.LIME_BED);
			spt.add(Material.MAGENTA_BED);
			spt.add(Material.ORANGE_BED);
			spt.add(Material.PINK_BED);
			spt.add(Material.PURPLE_BED);
			spt.add(Material.RED_BED);
			spt.add(Material.WHITE_BED);
			spt.add(Material.YELLOW_BED);
			spt.add(Material.ACACIA_SLAB);
			spt.add(Material.BIRCH_SLAB);
			spt.add(Material.BRICK_SLAB);
			spt.add(Material.COBBLESTONE_SLAB);
			spt.add(Material.DARK_OAK_SLAB);
			spt.add(Material.DARK_PRISMARINE_SLAB);
			spt.add(Material.JUNGLE_SLAB);
			spt.add(Material.NETHER_BRICK_SLAB);
			spt.add(Material.OAK_SLAB);
			spt.add(Material.PETRIFIED_OAK_SLAB);
			spt.add(Material.PRISMARINE_BRICK_SLAB);
			spt.add(Material.PRISMARINE_SLAB);
			spt.add(Material.PURPUR_SLAB);
			spt.add(Material.QUARTZ_SLAB);
			spt.add(Material.RED_SANDSTONE_SLAB);
			spt.add(Material.SANDSTONE_SLAB);
			spt.add(Material.SPRUCE_SLAB);
			spt.add(Material.STONE_BRICK_SLAB);
			spt.add(Material.STONE_SLAB);
			spt.add(Material.DAYLIGHT_DETECTOR);
			spt.add(Material.IRON_TRAPDOOR);
			spt.add(Material.ACACIA_TRAPDOOR);
			spt.add(Material.BIRCH_TRAPDOOR);
			spt.add(Material.DARK_OAK_TRAPDOOR);
			spt.add(Material.JUNGLE_TRAPDOOR);
			spt.add(Material.OAK_TRAPDOOR);
			spt.add(Material.SPRUCE_TRAPDOOR);
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
			spt.add(Material.CAKE);
			spt.add(Material.CAULDRON);
			spt.add(Material.LADDER);
			spt.add(Material.VINE);
			spt.add(Material.JACK_O_LANTERN);
			spt.add(Material.END_PORTAL_FRAME);
			spt.add(Material.TORCH);
			spt.add(Material.REDSTONE_TORCH);
			spt.add(Material.ACACIA_FENCE);
			spt.add(Material.ACACIA_FENCE_GATE);
			spt.add(Material.BIRCH_FENCE);
			spt.add(Material.BIRCH_FENCE_GATE);
			spt.add(Material.DARK_OAK_FENCE);
			spt.add(Material.DARK_OAK_FENCE_GATE);
			spt.add(Material.JUNGLE_FENCE);
			spt.add(Material.JUNGLE_FENCE_GATE);
			spt.add(Material.NETHER_BRICK_FENCE);
			spt.add(Material.OAK_FENCE);
			spt.add(Material.OAK_FENCE_GATE);
			spt.add(Material.SPRUCE_FENCE);
			spt.add(Material.SPRUCE_FENCE_GATE);
			spt.add(Material.RAIL);
			spt.add(Material.ACTIVATOR_RAIL);
			spt.add(Material.DETECTOR_RAIL);
			spt.add(Material.POWERED_RAIL);
			spt.add(Material.REDSTONE_WIRE);
			spt.add(Material.COMPARATOR);
			spt.add(Material.REDSTONE);
			spt.add(Material.BLACK_CARPET);
			spt.add(Material.BLUE_CARPET);
			spt.add(Material.BROWN_CARPET);
			spt.add(Material.CYAN_CARPET);
			spt.add(Material.GRAY_CARPET);
			spt.add(Material.GREEN_CARPET);
			spt.add(Material.LIGHT_BLUE_CARPET);
			spt.add(Material.LIGHT_GRAY_CARPET);
			spt.add(Material.LIME_CARPET);
			spt.add(Material.MAGENTA_CARPET);
			spt.add(Material.ORANGE_CARPET);
			spt.add(Material.PINK_CARPET);
			spt.add(Material.PURPLE_CARPET);
			spt.add(Material.RED_CARPET);
			spt.add(Material.WHITE_CARPET);
			spt.add(Material.YELLOW_CARPET);
			spt.add(Material.ACACIA_PRESSURE_PLATE);
			spt.add(Material.BIRCH_PRESSURE_PLATE);
			spt.add(Material.DARK_OAK_PRESSURE_PLATE);
			spt.add(Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
			spt.add(Material.JUNGLE_PRESSURE_PLATE);
			spt.add(Material.LIGHT_WEIGHTED_PRESSURE_PLATE);
			spt.add(Material.OAK_PRESSURE_PLATE);
			spt.add(Material.OAK_PRESSURE_PLATE);
			spt.add(Material.SPRUCE_PRESSURE_PLATE);
			spt.add(Material.STONE_PRESSURE_PLATE);
			spt.add(Material.LILY_PAD);
			spt.add(Material.COBWEB);
			spt.add(Material.SPAWNER);
			spt.add(Material.COMPARATOR);
			spt.add(Material.MYCELIUM);
			spt.add(Material.BROWN_MUSHROOM);
			spt.add(Material.RED_MUSHROOM);
			spt.add(Material.FIRE);
			spt.add(Material.SLIME_BLOCK);
			spt.add(Material.CREEPER_HEAD);
			spt.add(Material.CREEPER_WALL_HEAD);
			spt.add(Material.DRAGON_HEAD);
			spt.add(Material.DRAGON_WALL_HEAD);
			spt.add(Material.PLAYER_HEAD);
			spt.add(Material.PLAYER_WALL_HEAD);
			spt.add(Material.ZOMBIE_HEAD);
			spt.add(Material.ZOMBIE_WALL_HEAD);
			spt.add(Material.DRAGON_EGG);
			spt.add(Material.END_ROD);
			spt.add(Material.GRASS_PATH);
			spt.add(Material.CHORUS_FLOWER);
			spt.add(Material.CHORUS_PLANT);
			spt.add(Material.CHORUS_FRUIT);
			spt.add(Material.END_CRYSTAL);
			spt.add(Material.MAGMA_BLOCK);
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
			spt.add(Material.LIGHT_GRAY_SHULKER_BOX);
			spt.add(Material.WHITE_SHULKER_BOX);
			spt.add(Material.YELLOW_SHULKER_BOX);
			spt.add(Material.SHULKER_BOX);
			
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
			is.add(Material.TALL_GRASS);
			is.add(Material.GRASS);
			is.add(Material.SUNFLOWER);
			is.add(Material.ROSE_BUSH);
			is.add(Material.ROSE_RED);
			is.add(Material.SUGAR_CANE);
			is.add(Material.SNOW);
			is.add(Material.BEETROOT_SEEDS);
			is.add(Material.MELON_SEEDS);
			is.add(Material.PUMPKIN_SEEDS);
			is.add(Material.WHEAT_SEEDS);
			is.add(Material.CARROT);
			is.add(Material.MELON_SEEDS);
			is.add(Material.MELON_STEM);
			is.add(Material.POTATO);
			is.add(Material.DEAD_BUSH);
			is.add(Material.BLACK_BANNER);
			is.add(Material.BLACK_WALL_BANNER);
			is.add(Material.BLUE_BANNER);
			is.add(Material.BLUE_WALL_BANNER);
			is.add(Material.BROWN_BANNER);
			is.add(Material.BROWN_WALL_BANNER);
			is.add(Material.CYAN_BANNER);
			is.add(Material.CYAN_WALL_BANNER);
			is.add(Material.GRAY_BANNER);
			is.add(Material.GRAY_WALL_BANNER);
			is.add(Material.GREEN_BANNER);
			is.add(Material.GREEN_WALL_BANNER);
			is.add(Material.LIGHT_BLUE_BANNER);
			is.add(Material.LIGHT_BLUE_WALL_BANNER);
			is.add(Material.LIGHT_GRAY_BANNER);
			is.add(Material.LIGHT_GRAY_WALL_BANNER);
			is.add(Material.LIME_BANNER);
			is.add(Material.LIME_WALL_BANNER);
			is.add(Material.MAGENTA_BANNER);
			is.add(Material.MAGENTA_WALL_BANNER);
			is.add(Material.ORANGE_BANNER);
			is.add(Material.ORANGE_WALL_BANNER);
			is.add(Material.PINK_BANNER);
			is.add(Material.PINK_WALL_BANNER);
			is.add(Material.PURPLE_BANNER);
			is.add(Material.PURPLE_WALL_BANNER);
			is.add(Material.RED_BANNER);
			is.add(Material.RED_WALL_BANNER);
			is.add(Material.WHITE_BANNER);
			is.add(Material.WHITE_WALL_BANNER);
			is.add(Material.YELLOW_BANNER);
			is.add(Material.YELLOW_WALL_BANNER);
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

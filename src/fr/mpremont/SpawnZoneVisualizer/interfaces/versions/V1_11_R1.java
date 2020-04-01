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
import fr.mpremont.SpawnZoneVisualizer.utils.XMaterial;

public class V1_11_R1 implements Version{

	public Sound getSound(String sound) {
		
		return Sound.valueOf(sound);
		
	}
	
	private static ArrayList<Material> spt = new ArrayList<Material>();
	public boolean isSpawnableType(Block block) {
		
		boolean result = true;
		if(spt.size() == 0) {
			spt.add(XMaterial.ACACIA_LEAVES.parseMaterial());
			spt.add(XMaterial.OAK_LEAVES.parseMaterial());
			spt.add(XMaterial.OAK_FENCE.parseMaterial());
			spt.add(XMaterial.OAK_DOOR.parseMaterial());
			spt.add(XMaterial.IRON_DOOR.parseMaterial());
			spt.add(Material.BRICK_STAIRS);
			spt.add(Material.COBBLESTONE_STAIRS);
			spt.add(Material.NETHER_BRICK_STAIRS);
			spt.add(Material.QUARTZ_STAIRS);
			spt.add(Material.RED_SANDSTONE_STAIRS);
			spt.add(Material.SANDSTONE_STAIRS);
			spt.add(XMaterial.STONE_BRICK_STAIRS.parseMaterial());
			spt.add(XMaterial.OAK_STAIRS.parseMaterial());
			spt.add(Material.CHEST);
			spt.add(Material.TRAPPED_CHEST);
			spt.add(Material.ENDER_CHEST);
			spt.add(Material.STONE_BUTTON);
			spt.add(XMaterial.OAK_BUTTON.parseMaterial());
			spt.add(Material.GLASS);
			spt.add(XMaterial.WHITE_STAINED_GLASS.parseMaterial());
			spt.add(XMaterial.WHITE_STAINED_GLASS_PANE.parseMaterial());
			spt.add(XMaterial.WHITE_BED.parseMaterial());
			spt.add(XMaterial.BRICK_SLAB.parseMaterial());
			spt.add(XMaterial.ACACIA_SLAB.parseMaterial());
			spt.add(XMaterial.DAYLIGHT_DETECTOR.parseMaterial());
			spt.add(Material.IRON_TRAPDOOR);
			spt.add(XMaterial.ACACIA_TRAPDOOR.parseMaterial());
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
			spt.add(XMaterial.CAKE.parseMaterial());
			spt.add(Material.CAULDRON);
			spt.add(Material.LADDER);
			spt.add(Material.VINE);
			spt.add(Material.JACK_O_LANTERN);
			spt.add(XMaterial.END_PORTAL_FRAME.parseMaterial());
			spt.add(XMaterial.BLAST_FURNACE.parseMaterial());
			spt.add(Material.TORCH);
			spt.add(XMaterial.REDSTONE_TORCH.parseMaterial());
			spt.add(XMaterial.COBBLESTONE_WALL.parseMaterial());
			spt.add(XMaterial.IRON_BARS.parseMaterial());
			spt.add(XMaterial.RAIL.parseMaterial());
			spt.add(Material.ACTIVATOR_RAIL);
			spt.add(Material.DETECTOR_RAIL);
			spt.add(Material.POWERED_RAIL);
			spt.add(Material.REDSTONE_WIRE);
			spt.add(XMaterial.COMPARATOR.parseMaterial());
			spt.add(Material.REDSTONE);
			spt.add(XMaterial.ORANGE_CARPET.parseMaterial());
			spt.add(XMaterial.ACACIA_PRESSURE_PLATE.parseMaterial());
			spt.add(XMaterial.HEAVY_WEIGHTED_PRESSURE_PLATE.parseMaterial());
			spt.add(XMaterial.LILY_PAD.parseMaterial());
			spt.add(XMaterial.COBWEB.parseMaterial());
			spt.add(XMaterial.SPAWNER.parseMaterial());
			spt.add(XMaterial.REPEATER.parseMaterial());
			spt.add(XMaterial.MYCELIUM.parseMaterial());
			spt.add(Material.BROWN_MUSHROOM);
			spt.add(Material.RED_MUSHROOM);
			spt.add(Material.FIRE);
			spt.add(Material.SLIME_BLOCK);
			spt.add(XMaterial.CREEPER_HEAD.parseMaterial());
			spt.add(Material.DRAGON_EGG);
			spt.add(Material.END_ROD);
			spt.add(Material.PURPUR_SLAB);
			spt.add(Material.PURPUR_STAIRS);
			spt.add(Material.GRASS_PATH);
			spt.add(Material.CHORUS_FLOWER);
			spt.add(Material.CHORUS_PLANT);
			spt.add(Material.CHORUS_FRUIT);
			spt.add(Material.END_CRYSTAL);
			spt.add(XMaterial.MAGMA_BLOCK.parseMaterial());
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
			spt.add(XMaterial.LIGHT_GRAY_SHULKER_BOX.parseMaterial());
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
			is.add(XMaterial.FERN.parseMaterial());
			is.add(XMaterial.TALL_GRASS.parseMaterial());
			is.add(XMaterial.SUNFLOWER.parseMaterial());
			is.add(XMaterial.ALLIUM.parseMaterial());
			is.add(XMaterial.BAMBOO.parseMaterial());
			is.add(Material.SNOW);
			is.add(XMaterial.WHEAT.parseMaterial());
			is.add(Material.CARROT);
			is.add(Material.MELON_SEEDS);
			is.add(Material.MELON_STEM);
			is.add(Material.POTATO);
			is.add(XMaterial.DANDELION.parseMaterial());
			is.add(XMaterial.WHITE_BANNER.parseMaterial());
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

/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2020 Crypto Morin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package fr.mpremont.SpawnZoneVisualizer.XSeries;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.*;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.material.Openable;
import org.bukkit.material.*;

import java.util.EnumSet;
import java.util.List;

/**
 * <b>XBlock</b> - MaterialData/BlockData Support<br>
 * BlockState (Old): https://hub.spigotmc.org/javadocs/spigot/org/bukkit/block/BlockState.html
 * BlockData (New): https://hub.spigotmc.org/javadocs/spigot/org/bukkit/block/data/BlockData.html
 * MaterialData (Old): https://hub.spigotmc.org/javadocs/spigot/org/bukkit/material/MaterialData.html
 *
 * @author Crypto Morin
 * @version 1.0.0
 * @see Block
 * @see BlockData
 * @see BlockState
 * @see MaterialData
 * @see XMaterial
 */
@SuppressWarnings("deprecation")
public final class XBlock {
    public static final EnumSet<XMaterial> CROPS = EnumSet.of(
            XMaterial.CARROT, XMaterial.POTATO, XMaterial.NETHER_WART, XMaterial.WHEAT_SEEDS, XMaterial.PUMPKIN_SEEDS,
            XMaterial.MELON_SEEDS, XMaterial.BEETROOT_SEEDS, XMaterial.SUGAR_CANE, XMaterial.BAMBOO_SAPLING, XMaterial.CHORUS_PLANT,
            XMaterial.KELP, XMaterial.SEA_PICKLE, XMaterial.BROWN_MUSHROOM, XMaterial.RED_MUSHROOM
    );
    public static final EnumSet<XMaterial> DANGEROUS = EnumSet.of(
            XMaterial.MAGMA_BLOCK, XMaterial.LAVA, XMaterial.CAMPFIRE, XMaterial.FIRE
    );
    public static final int CAKE_SLICES = 6;
    private static final boolean ISFLAT = XMaterial.isNewVersion();

    public static boolean isLit(Block block) {
        if (ISFLAT) {
            if (!(block.getBlockData() instanceof Lightable)) return false;
            Lightable lightable = (Lightable) block.getBlockData();
            return lightable.isLit();
        }

        return isMaterial(block, "REDSTONE_LAMP_ON", "REDSTONE_TORCH_ON", "BURNING_FURNACE");
    }

    /**
     * Checks if the block is a container.
     * Containers are chests, hoppers, enderchests and everything that
     * has an inventory.
     *
     * @param block the block to check.
     * @return true if the block is a container, otherwise false.
     */
    public static boolean isContainer(Block block) {
        return block.getState() instanceof InventoryHolder;
    }

    /**
     * Can be furnaces or redstone lamps.
     */
    public static void setLit(Block block, boolean lit) {
        if (ISFLAT) {
            if (!(block.getBlockData() instanceof Lightable)) return;
            Lightable lightable = (Lightable) block.getBlockData();
            lightable.setLit(lit);
            return;
        }

        String name = block.getType().name();
        if (name.endsWith("FURNACE")) block.setType(Material.getMaterial("BURNING_FURNACE"));
        else if (name.startsWith("REDSTONE_LAMP")) block.setType(Material.getMaterial("REDSTONE_LAMP_ON"));
        else block.setType(Material.getMaterial("REDSTONE_TORCH_ON"));
    }

    /**
     * Any material that can be planted.
     */
    public static boolean isCrops(Material material) {
        return CROPS.contains(XMaterial.matchXMaterial(material));
    }

    /**
     * Any material that can damage the player.
     */
    public static boolean isDangerous(Block block) {
        return DANGEROUS.contains(XMaterial.matchXMaterial(block.getType()));
    }

    /**
     * Wool and Dye. But Dye is not a block itself.
     */
    public static DyeColor getColor(Block block) {
        if (ISFLAT) {
            if (!(block.getBlockData() instanceof Colorable)) return null;
            Colorable colorable = (Colorable) block.getBlockData();
            return colorable.getColor();
        }

        BlockState state = block.getState();
        MaterialData data = state.getData();
        if (data instanceof Wool) {
            Wool wool = (Wool) data;
            return wool.getColor();
        }
        return null;
    }

    public static boolean isCake(Material material) {
        return ISFLAT ? material == Material.CAKE : material.name().equals("CAKE_BLOCK");
    }

    public static boolean isWheat(Material material) {
        return ISFLAT ? material == Material.WHEAT : material.name().equals("CROPS");
    }

    public static boolean isSugarCane(Material material) {
        return ISFLAT ? material == Material.SUGAR_CANE : material.name().equals("SUGAR_CANE_BLOCK");
    }

    public static boolean isBeetroot(Material material) {
        return ISFLAT ? material == Material.SUGAR_CANE : material.name().equals("BEETROOT_BLOCK");
    }

    public static boolean isNetherWart(Material material) {
        return ISFLAT ? material == Material.NETHER_WART : material.name().equals("NETHER_WARTS");
    }

    public static boolean isCarrot(Material material) {
        return ISFLAT ? material.name().equals("CARROTS") : material == Material.CARROT;
    }

    public static boolean isPotato(Material material) {
        return ISFLAT ? material.name().equals("POTATOES") : material == Material.POTATO;
    }

    public static BlockFace getDirection(Block block) {
        if (ISFLAT) {
            if (!(block.getBlockData() instanceof Directional)) return BlockFace.SELF;
            Directional direction = (Directional) block.getBlockData();
            return direction.getFacing();
        }

        BlockState state = block.getState();
        MaterialData data = state.getData();
        if (data instanceof org.bukkit.material.Directional) {
            return ((org.bukkit.material.Directional) data).getFacing();
        }
        return null;
    }

    public static boolean setDirection(Block block, BlockFace facing) {
        if (ISFLAT) {
            if (!(block.getBlockData() instanceof Directional)) return false;
            Directional direction = (Directional) block.getBlockData();
            direction.setFacing(facing);
            return true;
        }

        BlockState state = block.getState();
        MaterialData data = state.getData();
        if (data instanceof org.bukkit.material.Directional) {
            ((org.bukkit.material.Directional) data).setFacingDirection(facing);
            state.update(true);
            return true;
        }
        return false;
    }

    public static int getAge(Block block) {
        if (ISFLAT) {
            if (!(block.getBlockData() instanceof Ageable)) return 0;
            Ageable ageable = (Ageable) block.getBlockData();
            return ageable.getAge();
        }

        BlockState state = block.getState();
        MaterialData data = state.getData();
        return data.getData();
    }

    public static void setAge(Block block, int age) {
        if (ISFLAT) {
            if (!(block.getBlockData() instanceof Ageable)) return;
            Ageable ageable = (Ageable) block.getBlockData();
            ageable.setAge(age);
        }

        BlockState state = block.getState();
        MaterialData data = state.getData();
        data.setData((byte) age);
        state.update(true);
    }

    /**
     * Sets the type of any block that can be colored.
     *
     * @param block the block to color.
     * @param color the color to use.
     * @return true if the block can be colored, otherwise false.
     */
    public static boolean setColor(Block block, DyeColor color) {
        if (ISFLAT) {
            String type = block.getType().name();
            if (type.endsWith("WOOL")) block.setType(Material.getMaterial(color.name() + "_WOOL"));
            else if (type.endsWith("BED")) block.setType(Material.getMaterial(color.name() + "_BED"));
            else if (type.endsWith("STAINED_GLASS")) block.setType(Material.getMaterial(color.name() + "_STAINED_GLASS"));
            else if (type.endsWith("STAINED_GLASS_PANE")) block.setType(Material.getMaterial(color.name() + "_STAINED_GLASS_PANE"));
            else if (type.endsWith("TERRACOTTA")) block.setType(Material.getMaterial(color.name() + "_TERRACOTTA"));
            else if (type.endsWith("GLAZED_TERRACOTTA")) block.setType(Material.getMaterial(color.name() + "_GLAZED_TERRACOTTA"));
            else if (type.endsWith("BANNER")) block.setType(Material.getMaterial(color.name() + "_BANNER"));
            else if (type.endsWith("WALL_BANNER")) block.setType(Material.getMaterial(color.name() + "_WALL_BANNER"));
            else if (type.endsWith("CARPET")) block.setType(Material.getMaterial(color.name() + "_CARPET"));
            else if (type.endsWith("SHULKER_BOX")) block.setType(Material.getMaterial(color.name() + "_SHULKERBOX"));
            else if (type.endsWith("CONCRETE")) block.setType(Material.getMaterial(color.name() + "_CONCRETE"));
            else if (type.endsWith("CONCRETE_POWDER")) block.setType(Material.getMaterial(color.name() + "_CONCRETE_POWDER"));
            else return false;
            return true;
        }

        BlockState state = block.getState();
        state.setRawData(color.getWoolData());
        state.update(true);
        return false;
    }

    /**
     * Can be used on cauldron.
     */
    public static boolean setFluidLevel(Block block, int level) {
        if (ISFLAT) {
            if (!(block.getBlockData() instanceof Levelled)) return false;
            Levelled levelled = (Levelled) block.getBlockData();
            levelled.setLevel(level);
            return true;
        }

        BlockState state = block.getState();
        MaterialData data = state.getData();
        data.setData((byte) level);
        state.update(true);
        return false;
    }

    public static int getFluidLevel(Block block) {
        if (ISFLAT) {
            if (!(block.getBlockData() instanceof Levelled)) return -1;
            Levelled levelled = (Levelled) block.getBlockData();
            return levelled.getLevel();
        }

        BlockState state = block.getState();
        MaterialData data = state.getData();
        return data.getData();
    }

    public static boolean isWaterStationary(Block block) {
        return ISFLAT ? getFluidLevel(block) < 7 : block.getType().name().equals("STATIONARY_WATER");
    }

    public static boolean isWater(Material material) {
        String name = material.name();
        return name.equals("WATER") || name.equals("STATIONARY_WATER");
    }

    public static boolean isOneOf(Block block, List<String> blocks) {
        return XMaterial.isOneOf(block.getType(), blocks);
    }

    public static void setCakeSlices(Block block, int amount) {
        if (!isCake(block.getType())) throw new IllegalArgumentException("Block is not a cake: " + block.getType());
        if (ISFLAT) {
            BlockData bd = block.getBlockData();
            if (bd instanceof org.bukkit.block.data.type.Cake) {
                org.bukkit.block.data.type.Cake cake = (org.bukkit.block.data.type.Cake) bd;

                if (amount <= cake.getMaximumBites()) {
                    cake.setBites(cake.getBites() + 1);
                } else {
                    block.breakNaturally();
                    return;
                }

                block.setBlockData(bd);
            }
            return;
        }

        BlockState state = block.getState();
        if (state instanceof Cake) {
            Cake cake = (Cake) state.getData();

            if (amount <= 1) {
                cake.setSlicesRemaining(amount);
            } else {
                block.breakNaturally();
                return;
            }

            state.update();
        }
    }

    public static int addCakeSlices(Block block, int slices) {
        if (!isCake(block.getType())) throw new IllegalArgumentException("Block is not a cake: " + block.getType());
        if (ISFLAT) {
            BlockData bd = block.getBlockData();
            org.bukkit.block.data.type.Cake cake = (org.bukkit.block.data.type.Cake) bd;

            if (cake.getBites() + slices <= cake.getMaximumBites()) {
                cake.setBites(cake.getBites() + slices);
            } else {
                block.breakNaturally();
                return cake.getMaximumBites() - cake.getBites();
            }

            block.setBlockData(bd);
            return cake.getMaximumBites() - cake.getBites();
        }

        BlockState state = block.getState();
        Cake cake = (Cake) state.getData();

        if (cake.getSlicesEaten() + slices < CAKE_SLICES) {
            cake.setSlicesEaten(cake.getSlicesEaten() + slices);
        } else {
            block.breakNaturally();
            return cake.getSlicesRemaining();
        }
        state.update();
        return cake.getSlicesRemaining();
    }

    public static boolean setWooden(Block block, XMaterial species) {
        block.setType(species.parseMaterial());
        if (ISFLAT) return true;

        TreeSpecies type = species == XMaterial.SPRUCE_LOG ? TreeSpecies.REDWOOD :
                TreeSpecies.valueOf(species.name().substring(0, species.name().indexOf('_')));

        BlockState state = block.getState();
        MaterialData data = state.getData();
        ((Wood) data).setSpecies(type);
        state.update(true);
        return true;
    }

    /**
     * <b>Universal Method</b>
     * <p>
     * Check if the block type matches the specified XMaterial
     *
     * @param block    the block to check.
     * @param material the XMaterial similar to this block type.
     * @return true if the block type is similar to the material.
     */
    @SuppressWarnings("incomplete-switch")
	public static boolean isType(Block block, XMaterial material) {
        Material mat = block.getType();

        switch (material) {
            case CAKE:
                return isCake(mat);
            case NETHER_WART:
                return isNetherWart(mat);
            case CARROT:
            case CARROTS:
                return isCarrot(mat);
            case POTATO:
            case POTATOES:
                return isPotato(mat);
            case WHEAT:
            case WHEAT_SEEDS:
                return isWheat(mat);
            case BEETROOT:
            case BEETROOT_SEEDS:
            case BEETROOTS:
                return isBeetroot(mat);
            case SUGAR_CANE:
                return isSugarCane(mat);
            case WATER:
                return isWater(mat);
            case AIR:
                return isAir(mat);
        }

        return false;
    }

    public static boolean isAir(Material material) {
        // Only air material names end with "IR"
        return material.name().endsWith("IR");
    }

    public static boolean isPowered(Block block) {
        if (ISFLAT) {
            if (!(block.getBlockData() instanceof Powerable)) return false;
            Powerable powerable = (Powerable) block.getBlockData();
            return powerable.isPowered();
        }

        String name = block.getType().name();
        if (name.startsWith("REDSTONE_COMPARATOR"))
            return isMaterial(block, "REDSTONE_COMPARATOR_ON");

        return false;
    }

    public static void setPowered(Block block, boolean powered) {
        if (ISFLAT) {
            if (!(block.getBlockData() instanceof Powerable)) return;
            Powerable powerable = (Powerable) block.getBlockData();
            powerable.setPowered(powered);
            return;
        }

        String name = block.getType().name();
        if (name.startsWith("REDSTONE_COMPARATOR")) block.setType(Material.getMaterial("REDSTONE_COMPARATOR_ON"));
    }

    public static boolean isOpen(Block block) {
        if (ISFLAT) {
            if (!(block.getBlockData() instanceof org.bukkit.block.data.Openable)) return false;
            org.bukkit.block.data.Openable openable = (org.bukkit.block.data.Openable) block.getBlockData();
            return openable.isOpen();
        }

        BlockState state = block.getState();
        if (!(state instanceof Openable)) return false;
        Openable openable = (Openable) state.getData();
        return openable.isOpen();
    }

    public static void setOpened(Block block, boolean opened) {
        if (ISFLAT) {
            if (!(block.getBlockData() instanceof org.bukkit.block.data.Openable)) return;
            org.bukkit.block.data.Openable openable = (org.bukkit.block.data.Openable) block.getBlockData();
            openable.setOpen(opened);
            return;
        }

        BlockState state = block.getState();
        if (!(state instanceof Openable)) return;
        Openable openable = (Openable) state.getData();
        openable.setOpen(opened);
        state.setData((MaterialData) openable);
        state.update();
    }

    public static BlockFace getRotation(Block block) {
        if (ISFLAT) {
            if (!(block.getBlockData() instanceof Rotatable)) return null;
            Rotatable rotatable = (Rotatable) block.getBlockData();
            return rotatable.getRotation();
        }

        return null;
    }

    public static void setRotation(Block block, BlockFace facing) {
        if (ISFLAT) {
            if (!(block.getBlockData() instanceof Rotatable)) return;
            Rotatable rotatable = (Rotatable) block.getBlockData();
            rotatable.setRotation(facing);
        }
    }

    private static boolean isMaterial(Block block, String... materials) {
        String type = block.getType().name();
        for (String material : materials)
            if (type.equals(material)) return true;
        return false;
    }
}
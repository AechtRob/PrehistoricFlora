
package net.lepidodendron.world.structure;

import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

import net.lepidodendron.ElementsLepidodendronMod;

import net.lepidodendron.LepidodendronConfig;
import net.lepidodendron.LepidodendronDecorationHandler;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.BlockFaceShape;

import net.lepidodendron.block.BlockDollyphyton;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class StructureSpawnDollyphyton extends ElementsLepidodendronMod.ModElement {
	public StructureSpawnDollyphyton(ElementsLepidodendronMod instance) {
		super(instance, 48);
	}

	@Override
	public void generateWorld(Random random, int i2, int k2, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		boolean dimensionCriteria = false;
		boolean isNetherType = false;
		if (shouldGenerateInDimension(dimID, LepidodendronConfig.dimDollyphyton))
			dimensionCriteria = true;
		if (!LepidodendronConfig.genDollyphyton && !LepidodendronConfig.genAllPlants)
			dimensionCriteria = false;
		if (!dimensionCriteria)
			return;

		boolean biomeCriteria = false;
		Biome biome = world.getBiome(new BlockPos(i2, world.getSeaLevel(), k2));
		if ((!matchBiome(biome, LepidodendronConfig.genGlobalBlacklist)) && (!matchBiome(biome, LepidodendronConfig.genDollyphytonBlacklistBiomes))) {
			biomeCriteria = true;
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.DEAD))
				biomeCriteria = false;
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.MUSHROOM))
				biomeCriteria = false;
		}
		if (matchBiome(biome, LepidodendronConfig.genDollyphytonOverrideBiomes))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;

		int GenChance = 20000;
		double GenMultiplier = LepidodendronConfig.multiplierDollyphyton;
		if (GenMultiplier < 0) {GenMultiplier = 0;}
		GenChance = Math.min(300000, (int) Math.round((double) GenChance * GenMultiplier));
		//Is this a transformed biome?
		if (LepidodendronDecorationHandler.matchBiome(biome, LepidodendronConfig.genTransformBiomes)) {
			//if (biome.getRegistryName().toString().substring(0, biome.getRegistryName().toString().indexOf(":")).equalsIgnoreCase("minecraft"))
				GenChance = Math.min(GenChance * 5, 300000);
		}
		
		if ((random.nextInt(1000000) + 1) <= GenChance) {
			int count = random.nextInt(4) + 1;
			for (int a = 0; a < count; a++) {
				int i = i2 + random.nextInt(16) + 8;
				int k = k2 + random.nextInt(16) + 8;
				int height = 255;
				if (isNetherType) {
					boolean notpassed = true;
					while (height > 0) {
						if (notpassed && world.isAirBlock(new BlockPos(i, height, k)))
							notpassed = false;
						else if (!notpassed && !world.isAirBlock(new BlockPos(i, height, k)))
							break;
						height--;
					}
				} else {
					while (height > 0) {
						if (
							(!world.isAirBlock(new BlockPos(i, height, k)))
							&& ((world.getBlockState(new BlockPos(i, height, k))).getMaterial() != Material.VINE)
							&& ((world.getBlockState(new BlockPos(i, height, k))).getMaterial() != Material.WEB)
							&& ((world.getBlockState(new BlockPos(i, height, k))).getMaterial() != Material.PLANTS)
						)
							break;
						height--;
					}
				}
				int j = height;

				if (world.getBlockState(new BlockPos(i, j, k)).getBlockFaceShape(world, (new BlockPos(i, j, k)), EnumFacing.UP) != BlockFaceShape.SOLID)
					continue;

				if (!((world.getBlockState(new BlockPos(i, j, k)).getMaterial() == Material.SAND)
					|| (world.getBlockState(new BlockPos(i, j, k)).getMaterial() == Material.ROCK)
					|| (world.getBlockState(new BlockPos(i, j, k)).getMaterial() == Material.GROUND)
					|| (world.getBlockState(new BlockPos(i, j, k)).getMaterial() == Material.CLAY)
					|| (world.getBlockState(new BlockPos(i, j, k)).getMaterial() == Material.GLASS)
					|| (world.getBlockState(new BlockPos(i, j, k)).getMaterial() == Material.IRON)
					|| (world.getBlockState(new BlockPos(i, j, k)).getMaterial() == Material.GRASS)
					|| (world.getBlockState(new BlockPos(i, j, k)).getMaterial() == Material.WOOD)))
					continue;


				boolean watercheck = false;
				if (
					((world.getBlockState(new BlockPos(i + 1, j, k))).getMaterial() == Material.WATER)
					|| ((world.getBlockState(new BlockPos(i - 1, j, k))).getMaterial() == Material.WATER)
					|| ((world.getBlockState(new BlockPos(i, j, k + 1))).getMaterial() == Material.WATER)
					|| ((world.getBlockState(new BlockPos(i, j, k - 1))).getMaterial() == Material.WATER)
					|| ((world.getBlockState(new BlockPos(i + 1, j, k + 1))).getMaterial() == Material.WATER)
					|| ((world.getBlockState(new BlockPos(i + 1, j, k - 1))).getMaterial() == Material.WATER)
					|| ((world.getBlockState(new BlockPos(i - 1, j, k + 1))).getMaterial() == Material.WATER)
					|| ((world.getBlockState(new BlockPos(i - 1, j, k - 1))).getMaterial() == Material.WATER)
				)
				{
					watercheck = true;
				}
				
				if (!watercheck)
					continue;
		
				int maxheight = LepidodendronConfig.maxheightDollyphyton;
				int minheight = LepidodendronConfig.minheightDollyphyton;
				if (maxheight < 0) {maxheight = 0;}
				if (maxheight > 250) {maxheight = 250;}
				if (minheight < 1) {minheight = 1;}
				if (minheight > 250) {minheight = 250;}
				if (j + 1 < minheight)
					continue;
				if (j + 1 > maxheight && maxheight != 0)
					continue;
					
					
				biomeCriteria = false;
				biome = world.getBiome(new BlockPos(i, j + 1, k));
				if ((!matchBiome(biome, LepidodendronConfig.genGlobalBlacklist)) && (!matchBiome(biome, LepidodendronConfig.genDollyphytonBlacklistBiomes))) {
					biomeCriteria = true;
					if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.DEAD))
						biomeCriteria = false;
					if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.MUSHROOM))
						biomeCriteria = false;
				}
				if (matchBiome(biome, LepidodendronConfig.genDollyphytonOverrideBiomes))
					biomeCriteria = true;
				if (!biomeCriteria)
					continue;
				if (world.isRemote)
					return;

				BlockPos spawnTo = new BlockPos(i, j + 1, k);
				
				int x = spawnTo.getX();
				int y = spawnTo.getY();
				int z = spawnTo.getZ();
				if (!world.isBlockLoaded(spawnTo)) {
					continue;
				}
				if (!world.isAreaLoaded(spawnTo, 3)) {
					continue;
				}

				//System.err.println("Spawned: " + x + " " + y + " " + z);
				if ((world.canSeeSky(spawnTo)) || 
				(((world.getBlockState(spawnTo)).getMaterial() == Material.SNOW)
				&& world.canSeeSky(spawnTo.up()))) {
					world.setBlockToAir(spawnTo);
					world.setBlockToAir(spawnTo.up());
				}
				world.setBlockState(spawnTo, BlockDollyphyton.block.getDefaultState(), 3);
			}
		}
	}

	
		public boolean shouldGenerateInDimension(int id, int[] dims) {
		int[] var2 = dims;
		int var3 = dims.length;
		for (int var4 = 0; var4 < var3; ++var4) {
			int dim = var2[var4];
			if (dim == id) {
				return true;
			}
		}
		return false;
	}

 	public static boolean matchBiome(Biome biome, String[] biomesList) {
    	
    	//String regName = biome.getRegistryName().toString();
    	
        String[] var2 = biomesList;
        int var3 = biomesList.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String checkBiome = var2[var4];
            if (!checkBiome.contains(":")) {
            	//System.err.println("modid test: " + biome.getRegistryName().toString().substring(0, biome.getRegistryName().toString().indexOf(":") - 1));
	            if (checkBiome.equalsIgnoreCase(
	            	biome.getRegistryName().toString().substring(0, biome.getRegistryName().toString().indexOf(":"))
	            	)) {
	                return true;
	            }
        	}
        	if (checkBiome.equalsIgnoreCase(biome.getRegistryName().toString())) {
                return true;
            }
        }

        return false;
    }
	
}

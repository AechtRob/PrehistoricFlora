
package net.lepidodendron.world.structure;

import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;

import net.lepidodendron.procedure.ProcedureWorldGenDicroidium;
import net.lepidodendron.ElementsLepidodendronMod;

import net.lepidodendron.LepidodendronConfig;
import net.lepidodendron.LepidodendronTreeHandler;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;

import net.lepidodendron.block.BlockDicroidiumLeavesTop;
import net.lepidodendron.block.BlockDicroidiumLeavesPlaceable;
import net.lepidodendron.block.BlockDicroidiumLeavesSmallPlaceable;
import net.lepidodendron.procedure.ProcedureTreeLog;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

@ElementsLepidodendronMod.ModElement.Tag
public class StructureSpawnDicroidium extends ElementsLepidodendronMod.ModElement {
	public StructureSpawnDicroidium(ElementsLepidodendronMod instance) {
		super(instance, 48);
	}

	@Override
	public void generateWorld(Random random, int i2, int k2, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		boolean dimensionCriteria = false;
		boolean isNetherType = false;
		if (shouldGenerateInDimension(dimID, LepidodendronConfig.dimDicroidium))
			dimensionCriteria = true;
		if (!LepidodendronConfig.genDicroidium && !LepidodendronConfig.genAllPlants)
			dimensionCriteria = false;
		if (!dimensionCriteria)
			return;

		boolean biomeCriteria = false;
		Biome biome = world.getBiome(new BlockPos(i2, world.getSeaLevel(), k2));
		if ((!matchBiome(biome, LepidodendronConfig.genGlobalBlacklist)) && (!matchBiome(biome, LepidodendronConfig.genDioonBlacklistBiomes))) {
			biomeCriteria = false;
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SWAMP))
				biomeCriteria = true;
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.LUSH))
				biomeCriteria = true;
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.FOREST))
				biomeCriteria = true;
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.RIVER))
				biomeCriteria = true;
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SNOWY))
				biomeCriteria = false;
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.DEAD))
				biomeCriteria = false;
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.MUSHROOM))
				biomeCriteria = false;
		}
		if (matchBiome(biome, LepidodendronConfig.genDicroidiumOverrideBiomes))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;

		int GenChance = 20000;
		double GenMultiplier = LepidodendronConfig.multiplierDicroidium;
		if (GenMultiplier < 0) {GenMultiplier = 0;}
		GenChance = Math.min(300000, (int) Math.round((double) GenChance * GenMultiplier));
		//Is this a transformed biome?
		if (LepidodendronTreeHandler.matchBiome(biome, LepidodendronConfig.genTransformBiomes)) {
			//if (biome.getRegistryName().toString().substring(0, biome.getRegistryName().toString().indexOf(":")).equalsIgnoreCase("minecraft"))
				GenChance = Math.min(GenChance * 5, 300000);
		}
		
		if ((random.nextInt(1000000) + 1) <= GenChance) {
			int count = random.nextInt(2) + 1;
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
				//IBlockState blockAt = world.getBlockState(new BlockPos(i, j + 1, k));
				boolean blockCriteria = false;
				//Check if this is snow OVER a valid block:
				if ((world.getBlockState(new BlockPos(i, j, k))).getMaterial() == Material.SNOW)
				{
					j = j - 1;
				}
				if ((world.getBlockState(new BlockPos(i, j, k))).getMaterial() == Material.GRASS)
					blockCriteria = true;
				if ((world.getBlockState(new BlockPos(i, j, k))).getMaterial() == Material.GROUND)
					blockCriteria = true;
					
				if (!blockCriteria)
					continue;

		
				int maxheight = LepidodendronConfig.maxheightDicroidium;
				int minheight = LepidodendronConfig.minheightDicroidium;
				if (maxheight < 0) {maxheight = 0;}
				if (maxheight > 250) {maxheight = 250;}
				if (minheight < 1) {minheight = 1;}
				if (minheight > 250) {minheight = 250;}
				if (j < minheight)
					continue;
				if (j > maxheight && maxheight != 0)
					continue;
					
					
				biomeCriteria = false;
				biome = world.getBiome(new BlockPos(i, j + 1, k));
				if ((!matchBiome(biome, LepidodendronConfig.genGlobalBlacklist)) && (!matchBiome(biome, LepidodendronConfig.genDioonBlacklistBiomes))) {
					biomeCriteria = false;
					if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SWAMP))
						biomeCriteria = true;
					if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.LUSH))
						biomeCriteria = true;
					if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.FOREST))
						biomeCriteria = true;
					if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.RIVER))
						biomeCriteria = true;
					if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SNOWY))
						biomeCriteria = false;
					if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.DEAD))
						biomeCriteria = false;
					if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.MUSHROOM))
						biomeCriteria = false;
				}
				if (matchBiome(biome, LepidodendronConfig.genDicroidiumOverrideBiomes))
					biomeCriteria = true;
				if (!biomeCriteria)
					continue;
				if (world.isRemote)
					return;
				//Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
				//		new ResourceLocation("lepidodendron", "spawnvoid"));
				//if (template == null)
				//	return;
				//Rotation rotation = Rotation.NONE;
				//Mirror mirror = Mirror.NONE;
				BlockPos spawnTo = new BlockPos(i, j + 1, k);
				//IBlockState iblockstate = world.getBlockState(spawnTo);
				//world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
				//template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(rotation).setMirror(mirror)
				//		.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				int x = spawnTo.getX();
				int y = spawnTo.getY();
				int z = spawnTo.getZ();
				if (!world.isBlockLoaded(spawnTo)) {
					continue;
				}
				if (!world.isAreaLoaded(spawnTo, 3)) {
					continue;
				}

				if ((world.canSeeSky(spawnTo)) || 
				(((world.getBlockState(spawnTo)).getMaterial() == Material.SNOW)
				&& world.canSeeSky(spawnTo.up()))) {
					world.setBlockToAir(spawnTo);
					world.setBlockToAir(spawnTo.up());
				}
				if (Math.random() > 0.5) {
					if (Math.random() > 0.3) {
						ProcedureTreeLog.executeProcedure((int) i, (int) j + 1, (int) k, world, BlockDicroidiumLeavesPlaceable.block, EnumFacing.UP);
						ProcedureTreeLog.executeProcedure((int) i, (int) j + 2, (int) k, world, BlockDicroidiumLeavesTop.block, EnumFacing.UP);
						}
					else {
						ProcedureTreeLog.executeProcedure((int) i, (int) j + 1, (int) k, world, BlockDicroidiumLeavesSmallPlaceable.block, EnumFacing.UP);
					}
				}
				else {
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("x", i);
					$_dependencies.put("y", j + 1);
					$_dependencies.put("z", k);
					$_dependencies.put("world", world);
					ProcedureWorldGenDicroidium.executeProcedure($_dependencies);
				}
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
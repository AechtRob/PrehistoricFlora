package net.lepidodendron.procedure;

import net.lepidodendron.ElementsLepidodendronMod;
import net.minecraft.world.biome.Biome;
import net.lepidodendron.LepidodendronConfig;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.BiomeDictionary;
import net.lepidodendron.procedure.ProcedureWorldGenNilssoniocladus;

import java.util.Map;
import java.util.Random;
import java.util.HashMap;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;


@ElementsLepidodendronMod.ModElement.Tag
public class ProcedureSpawnNilssoniocladus extends ElementsLepidodendronMod.ModElement {
	public ProcedureSpawnNilssoniocladus(ElementsLepidodendronMod instance) {
		super(instance, 1142);
	}

	public static void executeProcedure(int x, int y, int z, World world, boolean TreeChosen, boolean SaplingSpawn) {

			//Try spawn Nilssoniocladus here?
			boolean biomeCriteria = false;
			boolean dimensionCriteria = false;
			int dimID = world.provider.getDimension();
			if (shouldGenerateInDimension(dimID, LepidodendronConfig.dimNilssoniocladus))
				dimensionCriteria = true;
			if (!TreeChosen && !LepidodendronConfig.genAllPlants)
				dimensionCriteria = false;
			if (dimensionCriteria && !SaplingSpawn) {
				Biome biome = world.getBiome(new BlockPos(x, y, z));
				if ((!matchBiome(biome, LepidodendronConfig.genGlobalBlacklist)) && (!matchBiome(biome, LepidodendronConfig.genNilssoniocladusBlacklistBiomes))) {
					if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.CONIFEROUS))
						biomeCriteria = true;
					if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.DEAD))
						biomeCriteria = false;
					if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.MUSHROOM))
						biomeCriteria = false;
				}
				if (matchBiome(biome, LepidodendronConfig.genNilssoniocladusOverrideBiomes))
					biomeCriteria = true;
				}
				if (biomeCriteria && !SaplingSpawn) {
					//Try one spot at the foot of the tree:
					//{
						//java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
						Random rnd = new Random();
						//$_dependencies.put("x", x + (rnd.nextInt(5) - 2));
						//$_dependencies.put("y", y);
						//$_dependencies.put("z", z + (rnd.nextInt(5) - 2));
						//$_dependencies.put("world", world);
					//}
					ProcedureWorldGenNilssoniocladus.executeProcedure(x + (rnd.nextInt(5) - 2), y, z + (rnd.nextInt(5) - 2), world);
					ProcedureWorldGenNilssoniocladus.executeProcedure(x + (rnd.nextInt(5) - 2), y, z + (rnd.nextInt(5) - 2), world);
				}

	}

	
	public static boolean shouldGenerateInDimension(int id, int[] dims) {
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
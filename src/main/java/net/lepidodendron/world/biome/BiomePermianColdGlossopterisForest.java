
package net.lepidodendron.world.biome;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.LepidodendronConfig;
import net.lepidodendron.block.BlockCoarseSandyDirtPangaean;
import net.lepidodendron.block.BlockCordaitesLog;
import net.lepidodendron.block.BlockGlossopterisLeafLitter;
import net.lepidodendron.block.BlockGlossopterisLog;
import net.lepidodendron.world.*;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomePermianColdGlossopterisForest extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:permian_cold_glossopteris_forest")
	public static final BiomeGenCustom biome = null;
	public BiomePermianColdGlossopterisForest(ElementsLepidodendronMod instance) {
		super(instance, 1589);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.DEAD);
		//BiomeDictionary.addTypes(biome, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD);
	}
	static class BiomeGenCustom extends Biome {
		public BiomeGenCustom() {
			super(new BiomeProperties("Permian Cold Glossopteris Forest").setRainfall(0.4F).setBaseHeight(0.05F).setHeightVariation(0.22F).setTemperature(-0.1F).setWaterColor(-5317633).setSnowEnabled());
			setRegistryName("permian_cold_glossopteris_forest");
			topBlock = BlockGlossopterisLeafLitter.block.getDefaultState();
			fillerBlock = BlockCoarseSandyDirtPangaean.block.getDefaultState();
			decorator.treesPerChunk = 10;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 20;
			decorator.gravelPatchesPerChunk = 10;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}

		protected static final WorldGenGlossopterisTree GLOSSOPTERIS_TREE = new WorldGenGlossopterisTree(false);
		protected static final WorldGenCordaitesTree CORDAITES_TREE = new WorldGenCordaitesTree(false);
		protected static final WorldGenWalchiaTree WALCHIA_TREE = new WorldGenWalchiaTree(false);
		protected static final WorldGenGlossopterisBush GLOSSOPTERIS_BUSH_GENERATOR = new WorldGenGlossopterisBush();

		protected static final WorldGenTreeLog GLOSSOPTERIS_LOG_GENERATOR = new WorldGenTreeLog(BlockGlossopterisLog.block);
		protected static final WorldGenTreeLog CORDAITES_LOG_GENERATOR = new WorldGenTreeLog(BlockCordaitesLog.block);
		protected static final WorldGenTreeLog WALCHIA_LOG_GENERATOR = new WorldGenTreeLog(BlockCordaitesLog.block);

    	protected static final WorldGenWoodHorsetail WOOD_HORSETAIL_GENERATOR = new WorldGenWoodHorsetail();
		protected static final WorldGenZygopteridaceaeShoot ZYGOPTERIDACEAE_SHOOT_GENERATOR = new WorldGenZygopteridaceaeShoot();
		protected static final WorldGenAncientMoss ANCIENT_MOSS_GENERATOR = new WorldGenAncientMoss();
		protected static final WorldGenIsoetes ISOETES_GENERATOR = new WorldGenIsoetes();

		protected static final WorldGenPrehistoricGroundCoverPangaean GROUNDCOVER_GENERATOR = new WorldGenPrehistoricGroundCoverPangaean();

		protected static final WorldGenPuddles PUDDLES_GENERATOR = new WorldGenPuddles();
		protected static final WorldGenPodzol PODZOL_GENERATOR = new WorldGenPodzol();
		protected static final WorldGenSnow SNOW_GENERATOR = new WorldGenSnow();
		
	public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	    {
			if (Math.random() > 0.08) {
				return GLOSSOPTERIS_TREE;
			}
			if (Math.random() > 0.5) {
				return CORDAITES_TREE;
			}
			return WALCHIA_TREE;
	    }

		@Override
	    public void decorate(World worldIn, Random rand, BlockPos pos)
	    {

			//Spawns forcefully borrow the bush event - why not?
			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.DEAD_BUSH))
			{
				ChunkGenSpawner.executeProcedure(false, LepidodendronConfig.dimPermianGlossopterisMobs, worldIn, topBlock, pos, rand);
			}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ICE)) {
				{
					int i = rand.nextInt(32);

					for (int j = 0; j < i; ++j)
					{
						int k = rand.nextInt(16) + 8;
						int l = rand.nextInt(16) + 8;
						BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
						SNOW_GENERATOR.generate(worldIn, rand, blockpos);
					}
				}
			}

	        if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        {
	        	int i = rand.nextInt(3);

	            for (int j = 0; j < i; ++j)
	            {
	                int k = rand.nextInt(16) + 8;
	                int l = rand.nextInt(16) + 8;
	                BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
					GLOSSOPTERIS_LOG_GENERATOR.generate(worldIn, rand, blockpos);
	            }
	        }

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
			{
				int i = rand.nextInt(3);

				for (int j = 0; j < i; ++j)
				{
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(16) + 8;
					BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
					CORDAITES_LOG_GENERATOR.generate(worldIn, rand, blockpos);
				}
			}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
			{
				int i = rand.nextInt(3);

				for (int j = 0; j < i; ++j)
				{
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(16) + 8;
					BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
					WALCHIA_LOG_GENERATOR.generate(worldIn, rand, blockpos);
				}
			}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
			{
				int i = rand.nextInt(4);

				for (int j = 0; j < i; ++j)
				{
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(16) + 8;
					BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
					GLOSSOPTERIS_BUSH_GENERATOR.generate(worldIn, rand, blockpos);
				}
			}
	        
	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        for (int i = 0; i < 64; ++i)
	        {
	            int j = rand.nextInt(16) + 8;
	            int k = rand.nextInt(16) + 8;
	            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
				PODZOL_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
	        }

	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
			for (int i = 0; i < 10; ++i)
			{
				int j = rand.nextInt(16) + 8;
				int k = rand.nextInt(16) + 8;
				int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
				PUDDLES_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
			}

	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        for (int i = 0; i < 12; ++i)
	        {
	            int j = rand.nextInt(16) + 8;
	            int k = rand.nextInt(16) + 8;
	            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
				ZYGOPTERIDACEAE_SHOOT_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
	        }

	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        for (int i = 0; i < 132; ++i)
	        {
	            int j = rand.nextInt(16) + 8;
	            int k = rand.nextInt(16) + 8;
	            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
				WOOD_HORSETAIL_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
	        }

	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        for (int i = 0; i < 100; ++i)
	        {
	            int j = rand.nextInt(16) + 8;
	            int k = rand.nextInt(16) + 8;
	            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
				GROUNDCOVER_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
	        }
	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        for (int i = 0; i < 8; ++i)
	        {
	            int j = rand.nextInt(16) + 8;
	            int k = rand.nextInt(16) + 8;
	            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
	            ANCIENT_MOSS_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
	        }

	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        for (int i = 0; i < 20; ++i)
	        {
	            int j = rand.nextInt(16) + 8;
	            int k = rand.nextInt(16) + 8;
	            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
	            ISOETES_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
	        }

	        super.decorate(worldIn, rand, pos);
	    }
	}
	
	private static Class<? extends Entity> findEntity(String entity) {
        Class<? extends Entity> entityClass;
        EntityEntry ee = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(entity));
        entityClass = ee == null ? null : ee.getEntityClass();
        if (entityClass == null) {
            System.err.println("Unknown mob requested for spawn: '" + entity + "'!");
            return null;
        }
        return entityClass;
    }		

	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}

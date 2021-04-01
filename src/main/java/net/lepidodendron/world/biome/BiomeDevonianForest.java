
package net.lepidodendron.world.biome;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.lepidodendron.LepidodendronConfig;
import net.minecraft.block.material.Material;

import net.minecraft.world.biome.Biome;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.BlockArchaeopterisLog;
import net.lepidodendron.block.BlockPrehistoricGroundCoverBasic;
import net.lepidodendron.world.WorldGenArchaeopterisTree;
import net.lepidodendron.world.WorldGenTreeLog;
import net.lepidodendron.world.WorldGenRhacophyton;
import net.lepidodendron.world.WorldGenStauropteris;
import net.lepidodendron.world.WorldGenSphenopteris;
import net.lepidodendron.world.WorldGenElkinsia;
import net.lepidodendron.world.WorldGenTetraxylopteris;
import net.lepidodendron.world.WorldGenAdoketophyton;
import net.lepidodendron.world.WorldGenAncientMoss;
import net.lepidodendron.world.WorldGenSelaginella;
import net.lepidodendron.world.WorldGenIsoetes;
import net.lepidodendron.world.WorldGenBaragwanathia;
import net.lepidodendron.world.WorldGenPrehistoricGroundCover;
import net.lepidodendron.world.WorldGenTopSoil;

import java.util.Random;
import net.minecraft.world.gen.feature.WorldGenReed;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeDevonianForest extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:devonian_forest")
	public static final BiomeGenCustom biome = null;
	public BiomeDevonianForest(ElementsLepidodendronMod instance) {
		super(instance, 1589);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.HILLS);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.FOREST);
	}
	static class BiomeGenCustom extends Biome {
		public BiomeGenCustom() {
			super(new Biome.BiomeProperties("The Devonian Period").setRainfall(0.5F).setTemperature(0.8F).setWaterColor(14745518));
			setRegistryName("devonian_forest");
			topBlock = BlockPrehistoricGroundCoverBasic.block.getDefaultState();
			fillerBlock = Blocks.STONE.getStateFromMeta(1);
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

		protected static final WorldGenArchaeopterisTree ARCHAEOPTERIS_TREE = new WorldGenArchaeopterisTree(false);
		protected static final WorldGenTreeLog ARCHAEOPTERIS_LOG_GENERATOR = new WorldGenTreeLog(BlockArchaeopterisLog.block);
    	protected static final WorldGenRhacophyton RHACOPHYTON_GENERATOR = new WorldGenRhacophyton();
		protected static final WorldGenStauropteris STAUROPTERIS_GENERATOR = new WorldGenStauropteris();
		protected static final WorldGenSphenopteris SPHENOPTERIS_GENERATOR = new WorldGenSphenopteris();
		protected static final WorldGenElkinsia ELKINSIA_GENERATOR = new WorldGenElkinsia();
		protected static final WorldGenAdoketophyton ADOKETOPHYTON_GENERATOR = new WorldGenAdoketophyton();
		protected static final WorldGenAncientMoss ANCIENT_MOSS_GENERATOR = new WorldGenAncientMoss();
		protected static final WorldGenSelaginella SELAGINELLA_GENERATOR = new WorldGenSelaginella();
		protected static final WorldGenIsoetes ISOETES_GENERATOR = new WorldGenIsoetes();
		protected static final WorldGenTetraxylopteris TETRAXYLOPTERIS_GENERATOR = new WorldGenTetraxylopteris();
		protected static final WorldGenBaragwanathia BARAGWANATHIA_GENERATOR = new WorldGenBaragwanathia();
		protected static final WorldGenTopSoil TOPSOIL_GENERATOR = new WorldGenTopSoil();
		protected static final WorldGenPrehistoricGroundCover GROUNDCOVER_GENERATOR = new WorldGenPrehistoricGroundCover();
		
		
public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	    {
	        return ARCHAEOPTERIS_TREE;
	    }

		@Override
	    public void decorate(World worldIn, Random rand, BlockPos pos)
	    {
			String mobToSpawn;
			String nbtStr = "";
			int locationID = 1;
			boolean errFound;
			boolean posCheck;
			int strPos1;
			int strPos2;
			int strPos3;
			int strPos4;
			int strPos5;
			//final int i18;

			//Spawns forcefully borrow the bush event - why not?
			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.DEAD_BUSH))
			{
				String[] var2 = LepidodendronConfig.dimDevonianMobs;
				int var3 = var2.length;
				for(int var4 = 0; var4 < var3; ++var4) {
					errFound = false;
					String checkEntity = var2[var4].trim();

					//System.err.println("checkEntity: " + checkEntity);

					strPos1 = 0;
					strPos2 = 0;
					strPos3 = 0;
					strPos4 = 0;
					strPos5 = 0;

					strPos1 = checkEntity.indexOf(":");
					if (!(strPos1 > 0)) {
						errFound = true;
					}
					else {
						String modid = checkEntity.substring(0, strPos1);

						//System.err.println("modid: " + modid);

						//Get the last two bits, first the rightmost colon:
						for(int i=checkEntity.length(); i > 0; i--){
							if(checkEntity.charAt(i - 1) == ':'){
								strPos2 = i;
								break;
							}
						}

						if (strPos2 <= strPos1) {
							//The position means that something is missing
							errFound = true;
						}
						else {
							String locationStr = checkEntity.substring(checkEntity.length()-1, checkEntity.length());
							if (!(locationStr.equals((String) "1") || locationStr.equals((String) "2") || locationStr.equals((String) "3"))) {
								errFound = true;
							}
							else {
								locationID =  (int) Integer.parseInt(locationStr);
								//System.err.println("locationID: " + locationID);

								//Get the next last bit:
								strPos3 = 0;
								String tmpStr = checkEntity.substring(0,checkEntity.length()-2);
								for(int i=tmpStr.length(); i > 0; i--){
									if(tmpStr.charAt(i - 1) == ':'){
										strPos3 = i;
										break;
									}
								}
								if (strPos3 <= strPos1) {
									//The position means that something is missing
									errFound = true;
								}
								else {
									tmpStr = tmpStr.substring(strPos3, tmpStr.length());
									if (!isNumeric(tmpStr)) {
										errFound = true;
									}
									else {
										int weight = (int) Integer.parseInt(tmpStr);
										if (weight < 0 || weight > 100) {
											errFound = true;
										}
										else {

											//Get the next last bit:
											strPos5 = 0;
											tmpStr = checkEntity.substring(0, strPos3 - 1);
											for(int i=tmpStr.length(); i > 0; i--){
												if(tmpStr.charAt(i - 1) == ':'){
													strPos5 = i;
													break;
												}
											}
											if (strPos5 <= strPos1) {
												//The position means that something is missing
												errFound = true;
											}
											else {
												tmpStr = tmpStr.substring(strPos5, tmpStr.length());
												if (!isNumeric(tmpStr)) {
													errFound = true;
												} else {
													int maxSpawn = (int) Integer.parseInt(tmpStr);
													if (maxSpawn < 1 || maxSpawn > 20) {
														errFound = true;
													}


													//Everything left is the mod plus nbt (which may be wrong of course!)
													else { //Get the mob:

														mobToSpawn = checkEntity.substring(0, strPos5 - 1);
														//Is there nbt?
														strPos4 = 0;
														strPos4 = mobToSpawn.indexOf("{");
														if (strPos4 > 0) {
															//we have nbt:
															nbtStr = mobToSpawn.substring(strPos4, mobToSpawn.length());
															mobToSpawn = mobToSpawn.substring(0, strPos4);
														}
														//System.err.println("mobToSpawn: " + mobToSpawn);
														//System.err.println("nbt: " + nbtStr);

														if (findEntity(mobToSpawn) != null) {
															//Spawn routine (finally!)

															int k7 = rand.nextInt(16) + 8;
															int j11 = rand.nextInt(16) + 8;
															int l14 = worldIn.getHeight(pos.add(k7, 0, j11)).getY() * 2;
															int i2;

															if (l14 > 0) {
																int i18 = rand.nextInt(l14);

																switch (locationID) {

																	case 1: //Land
																	default:
																		//System.err.println("Case: 1");
																		//We'll check a block is the biome topblock and that there are at least 4 blocks of non-solid blocks above it:
																		posCheck = false;
																		i2 = 0;
																		while (i2 < 14 && !posCheck) {
																			k7 = rand.nextInt(16) + 8;
																			j11 = rand.nextInt(16) + 8;

																			i18 = worldIn.getSeaLevel() - 1;
																			while (i18 < 255 && !posCheck) {
																				i18 = i18 + 1;
																				BlockPos pos1 = new BlockPos(pos.getX() + k7, i18, pos.getZ() + j11);
																				//System.err.println("y: " + i18);
																				//System.err.println("block: " + (worldIn.getBlockState(pos1).getBlock()));
																				//System.err.println("topblock: " + topBlock.getBlock());
																				if ((worldIn.getBlockState(pos1.down()).getBlock() == topBlock.getBlock())
																						&& ((worldIn.isAirBlock(pos1)) || (worldIn.getBlockState(pos1).getMaterial() == Material.PLANTS))
																						&& ((worldIn.isAirBlock(pos1.up())) || (worldIn.getBlockState(pos1.up()).getMaterial() == Material.PLANTS))
																						&& ((worldIn.isAirBlock(pos1.up(2))) || (worldIn.getBlockState(pos1.up(2)).getMaterial() == Material.PLANTS))
																						&& ((worldIn.isAirBlock(pos1.up(3))) || (worldIn.getBlockState(pos1.up(3)).getMaterial() == Material.PLANTS))
																				) {
																					posCheck = true;
																					//System.err.println("Spawnable " + checkEntity);
																					//break;
																				}
																			}
																			i2 = i2 + 1;
																		}
																		break;

																	case 2: //Deep water
																		//System.err.println("Case: 2");
																		posCheck = false;
																		i2 = 0;
																		while (i2 < 14 && !posCheck) {
																			k7 = rand.nextInt(16) + 8;
																			j11 = rand.nextInt(16) + 8;

																			i18 = 1;
																			while (i18 < 255 && !posCheck) {
																				i18 = i18 + 1;
																				BlockPos pos1 = new BlockPos(pos.getX() + k7, i18, pos.getZ() + j11);
																				//System.err.println("y: " + i18);
																				//System.err.println("block: " + (worldIn.getBlockState(pos1).getBlock()));
																				//System.err.println("topblock: " + topBlock.getBlock());
																				if ((worldIn.getBlockState(pos1).getMaterial() == Material.WATER)
																						&& (worldIn.isAirBlock(pos1.up(3)))
																						&& (worldIn.getBlockState(pos1.up()).getMaterial() == Material.WATER)
																						&& (worldIn.getBlockState(pos1.up(2)).getMaterial() == Material.WATER)
																						&& (worldIn.getBlockState(pos1.down()).getMaterial() == Material.WATER)
																						&& (worldIn.getBlockState(pos1.down(2)).getMaterial() == Material.WATER)
																				) {
																					posCheck = true;
																				}
																				int xx = -4;
																				while (xx <= 4 && posCheck) {
																					int zz = -4;
																					while (zz <= 4 && posCheck) {
																						if (worldIn.getBlockState(pos1.add(xx, 0, zz)).getMaterial() != Material.WATER) {
																							posCheck = false;
																						}
																						zz = zz + 1;
																					}
																					xx = xx + 1;
																				}
																			}
																			i2 = i2 + 1;
																		}
																		break;

																	case 3: //Shallow water
																		//System.err.println("Case: 3");
																		posCheck = false;
																		i2 = 0;
																		while (i2 < 14 && !posCheck) {
																			k7 = rand.nextInt(16) + 8;
																			j11 = rand.nextInt(16) + 8;

																			i18 = 1;
																			while (i18 < 255 && !posCheck) {
																				i18 = i18 + 1;
																				BlockPos pos1 = new BlockPos(pos.getX() + k7, i18, pos.getZ() + j11);
																				//System.err.println("y: " + i18);
																				//System.err.println("block: " + (worldIn.getBlockState(pos1).getBlock()));
																				//System.err.println("topblock: " + topBlock.getBlock());
																				if ((worldIn.getBlockState(pos1).getMaterial() == Material.WATER)
																						&& (worldIn.isAirBlock(pos1.up()))
																						&& (pos1.up().getY() >= worldIn.getSeaLevel())
																						&& (worldIn.getBlockState(pos1.down(4)).getMaterial() != Material.WATER)
																				) {
																					posCheck = true;
																				}
																				int xx = -1;
																				while (xx <= 1 && posCheck) {
																					int zz = -1;
																					while (zz <= 1 && posCheck) {
																						if (worldIn.getBlockState(pos1.add(xx, 0, zz)).getMaterial() != Material.WATER) {
																							posCheck = false;
																						}
																						zz = zz + 1;
																					}
																					xx = xx + 1;
																				}
																			}
																			i2 = i2 + 1;
																		}
																		break;

																}

																//System.err.println("Poscheck: " + posCheck);
																//System.err.println("errFound: " + errFound);
																if (posCheck && !errFound) {
																	//System.err.println("Spawning " + mobToSpawn + " at: " + pos.add(k7, i18, j11).getX() + " " + pos.add(k7, i18, j11).getY() + " " + pos.add(k7, i18, j11).getZ());
																	//System.err.println("maxSpawn: " + maxSpawn);
																	//System.err.println("weight: " + weight);
																	double weighter = 500;
																	if (locationID == 2) {
																		weighter = 800;
																	}
																	if ((Math.random() * weighter) <= weight) {
																		//System.err.println("Trying......");
																		int spawnQty = rand.nextInt(maxSpawn) + 1;
																		//System.err.println("spawnQty: " + spawnQty);
																		for (int i = 0; i < spawnQty; ++i) {
																			//Spawn the mob via a command to facilitate water spawns:
																			if (!worldIn.isRemote && worldIn.getMinecraftServer() != null) {
																				//System.err.println("summon " + mobToSpawn + " " + pos.add(k7, i18, j11).getX() + " " + pos.add(k7, i18, j11).getY() + " " + pos.add(k7, i18, j11).getZ() + " " + nbtStr);
																				worldIn.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
																					@Override
																					public String getName() {
																						return "";
																					}

																					@Override
																					public boolean canUseCommand(int permission, String command) {
																						return true;
																					}

																					@Override
																					public World getEntityWorld() {
																						return worldIn;
																					}

																					@Override
																					public MinecraftServer getServer() {
																						return worldIn.getMinecraftServer();
																					}

																					@Override
																					public boolean sendCommandFeedback() {
																						return false;
																					}

																					//@Override
																					//public BlockPos getPosition() {
																					//	return pos.add(k7, i18, j11);
																					//}

																					//@Override
																					//public Vec3d getPositionVector() {
																					//	return new Vec3d(pos.add(k7, i18, j11).getX(), pos.add(k7, i18, j11).getY(), pos.add(k7, i18, j11).getZ());
																					//}
																				}, "summon " + mobToSpawn + " " + pos.add(k7, i18, j11).getX() + " " + pos.add(k7, i18, j11).getY() + " " + pos.add(k7, i18, j11).getZ() + " " + nbtStr);
																			}
																			//System.err.println("Spawned");
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					if (errFound) {
						System.err.println("Syntax error in mob spawn config: '" + checkEntity + "'!");
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
	                ARCHAEOPTERIS_LOG_GENERATOR.generate(worldIn, rand, blockpos);
	            }
	        }
	        
	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        for (int i = 0; i < 5; ++i)
	        {
	            int j = rand.nextInt(16) + 8;
	            int k = rand.nextInt(16) + 8;
	            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
	            TOPSOIL_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
	        }
	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        for (int i = 0; i < 9; ++i)
	        {
	            int j = rand.nextInt(16) + 8;
	            int k = rand.nextInt(16) + 8;
	            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
	            ELKINSIA_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
	        }
	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        for (int i = 0; i < 5; ++i)
	        {
	            int j = rand.nextInt(16) + 8;
	            int k = rand.nextInt(16) + 8;
	            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
	            TETRAXYLOPTERIS_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
	        }
	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        for (int i = 0; i < 5; ++i)
	        {
	            int j = rand.nextInt(16) + 8;
	            int k = rand.nextInt(16) + 8;
	            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
	            ADOKETOPHYTON_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
	        }
	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        for (int i = 0; i < 120; ++i)
	        {
	            int j = rand.nextInt(16) + 8;
	            int k = rand.nextInt(16) + 8;
	            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
	            RHACOPHYTON_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
	        }
	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        for (int i = 0; i < 40; ++i)
	        {
	            int j = rand.nextInt(16) + 8;
	            int k = rand.nextInt(16) + 8;
	            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
	          	STAUROPTERIS_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
	        }
	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        for (int i = 0; i < 20; ++i)
	        {
	            int j = rand.nextInt(16) + 8;
	            int k = rand.nextInt(16) + 8;
	            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
	            SPHENOPTERIS_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
	        }
	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        for (int i = 0; i < 120; ++i)
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
	        for (int i = 0; i < 8; ++i)
	        {
	            int j = rand.nextInt(16) + 8;
	            int k = rand.nextInt(16) + 8;
	            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
	            SELAGINELLA_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
	        }
	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        for (int i = 0; i < 20; ++i)
	        {
	            int j = rand.nextInt(16) + 8;
	            int k = rand.nextInt(16) + 8;
	            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
	            ISOETES_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
	        }
	        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
	        for (int i = 0; i < 15; ++i)
	        {
	            int j = rand.nextInt(16) + 8;
	            int k = rand.nextInt(16) + 8;
	            int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
	            BARAGWANATHIA_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
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

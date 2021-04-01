
package net.lepidodendron.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;

import net.minecraft.block.BlockSand;
import net.minecraft.block.IGrowable;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.IPlantable;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;

import java.util.Random;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;
import net.minecraft.block.IGrowable;

import net.lepidodendron.creativetab.TabLepidodendron;
import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.LepidodendronConfig;

import net.lepidodendron.block.BlockPrehistoricGroundCover;
import net.lepidodendron.block.BlockPrehistoricGroundCoverBasic;
import net.lepidodendron.block.BlockPrehistoricGroundCoverSand;

@ElementsLepidodendronMod.ModElement.Tag
public class BlockPrehistoricGroundCoverSand extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:sandy_prehistoric_ground_cover")
	public static final Block block = null;
	public BlockPrehistoricGroundCoverSand(ElementsLepidodendronMod instance) {
		super(instance, 526);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("sandy_prehistoric_ground_cover"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("lepidodendron:sandy_prehistoric_ground_cover", "inventory"));
	}

	public static final PropertyBool SNOWY = PropertyBool.create("snowy");
	
	public static class BlockCustom extends BlockFalling implements IGrowable {
		public BlockCustom() {
			super(Material.SAND);
			setTranslationKey("sandy_prehistoric_ground_cover");
			setSoundType(SoundType.SAND);
        	setDefaultState(this.blockState.getBaseState().withProperty(SNOWY, Boolean.valueOf(false)));
        	setTickRandomly(true);
			setCreativeTab(TabLepidodendron.tab);
			setHarvestLevel("shovel", 1);
			setHardness(0.5F);
			setResistance(0.5F);
        	//useNeighborBrightness = true;
		}

		@Override    
		public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	    {
	        Block block = worldIn.getBlockState(pos.up()).getBlock();
	        return state.withProperty(SNOWY, Boolean.valueOf(block == Blocks.SNOW || block == Blocks.SNOW_LAYER));
	    }

		//@Override
	    //public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    //{
	    //    return Item.getItemFromBlock(Blocks.SAND.getDefaultState().getBlock());
	    //}

	    @Override
	    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	    {
	    	super.updateTick(worldIn, pos, state, rand);
	    	
	        if (!worldIn.isRemote)
	        {
	            if (!worldIn.isAreaLoaded(pos, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
	            if (((worldIn.getLightFromNeighbors(pos.up()) < 4 && worldIn.getBlockState(pos.up()).getLightOpacity(worldIn, pos.up()) > 2))
	            	)
	            {
	                worldIn.setBlockState(pos, Blocks.SAND.getDefaultState());
	            }
	            else
	            {
	            	boolean waterCriteria = false;
					int waterDist = LepidodendronConfig.waterSandHorizontal;
					if (waterDist > 16) waterDist = 16;
					if (waterDist < 0) waterDist = 0;

					int waterDown = LepidodendronConfig.waterSandVertical;
					if (waterDown > 6) waterDown = 6;
					if (waterDown < 0) waterDown = 0;
					
					//Is there water nearby?
					int xct = -waterDist;
					int yct;
					int zct;
					while ((xct <= waterDist) && (!waterCriteria)) {
						yct = -waterDown;
						while ((yct <= 1) && (!waterCriteria)) {
							zct = -waterDist;
							while ((zct <= waterDist) && (!waterCriteria)) {
								if ((Math.pow((int) Math.abs(xct),2) + Math.pow((int) Math.abs(zct),2) <= Math.pow((int) waterDist,2)) && ((worldIn.getBlockState(new BlockPos(pos.getX() + xct, pos.getY() + yct, pos.getZ() + zct))).getMaterial() == Material.WATER)) {
									waterCriteria = true;
								}
								zct = zct + 1;
							}
							yct = yct + 1;
						}
						xct = xct + 1;
					}
					if (!waterCriteria){
	                	worldIn.setBlockState(pos, Blocks.SAND.getDefaultState());
	            	}
					else
					{

		                if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
		                {
		                    for (int i = 0; i < 4; ++i)
		                    {
		                        BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
		
		                        if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos))
		                        {
		                            return;
		                        }
		
		                        IBlockState iblockstate = worldIn.getBlockState(blockpos.up());
		                        IBlockState iblockstate1 = worldIn.getBlockState(blockpos);
		
		                        if (iblockstate1.getBlock() == Blocks.SAND && worldIn.getLightFromNeighbors(blockpos.up()) >= 4 && iblockstate.getLightOpacity(worldIn, pos.up()) <= 2)
		                        {


									waterDown = LepidodendronConfig.waterSandVertical;
									if (waterDown > 6) waterDown = 6;
									if (waterDown < 0) waterDown = 0;
					
									waterCriteria = false;
									waterDist = LepidodendronConfig.waterSandHorizontal;
									if (waterDist > 16) waterDist = 16;
									if (waterDist < 0) waterDist = 0;
									//Is there water nearby?
									xct = -waterDist;
									while ((xct <= waterDist) && (!waterCriteria)) {
										yct = -waterDown;
										while ((yct <= 1) && (!waterCriteria)) {
											zct = -waterDist;
											while ((zct <= waterDist) && (!waterCriteria)) {
												if ((Math.pow((int) Math.abs(xct),2) + Math.pow((int) Math.abs(zct),2) <= Math.pow((int) waterDist,2)) && ((worldIn.getBlockState(new BlockPos(blockpos.getX() + xct, blockpos.getY() + yct, blockpos.getZ() + zct))).getMaterial() == Material.WATER)) {
													waterCriteria = true;
												}
												zct = zct + 1;
											}
											yct = yct + 1;
										}
										xct = xct + 1;
									}
									if (waterCriteria)
		                            	worldIn.setBlockState(blockpos, BlockPrehistoricGroundCoverSand.block.getDefaultState());
		                        }
		                    }
	                    }
	                }
	            }
	        }
	    }


	    @SideOnly(Side.CLIENT)
	    public BlockRenderLayer getRenderLayer()
	   	{
	        return BlockRenderLayer.CUTOUT_MIPPED;
	    }
	
	
	    @Override
	    public int getMetaFromState(IBlockState state)
	    {
	        return 0;
	    }

		@Override
	    protected BlockStateContainer createBlockState()
	    {
	        return new BlockStateContainer(this, new IProperty[] {SNOWY});
	    }

		@Override
		public boolean isOpaqueCube(IBlockState state)
	    {
	        return true;
	    }

	    @Override
		public boolean isFullBlock(IBlockState state)
	    {
	        return true;
	    }

	   	@Override
		public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
			return layer == BlockRenderLayer.CUTOUT_MIPPED;
		}
	    
	    @Override
	    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
			return true;
	    }

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			drops.add(new ItemStack(Blocks.SAND, (int) (1), 0));
			if (Math.random() > 0.95) {
				drops.add(new ItemStack(BlockPrehistoricGroundCoverPlantsSandy.block, (int) (1), 0));
	        }
		}

		@Override
		protected boolean canSilkHarvest()
	    {
	        return true;
	    }

		@Override
	    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
	    {
	        return true;
	    }

		@Override
	    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
	    {
	        return true;
	    }
	    
		@Override
	    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
	    {
	        BlockPos blockpos = pos.up();
	
	        for (int i = 0; i < 128; ++i)
	        {
	            BlockPos blockpos1 = blockpos;
	            int j = 0;
	
	            while (true)
	            {
	                if (j >= i / 16)
	                {
	                    if (worldIn.isAirBlock(blockpos1))
	                    {

                            IBlockState iblockstate1 = BlockPrehistoricGroundCoverPlantsSandy.block.getDefaultState();

                            if (worldIn.getBlockState(blockpos1.down()).getBlock() == this)
                            {
                                worldIn.setBlockState(blockpos1, iblockstate1, 3);
                            }

	                    }
	
	                    break;
	                }
	
	                blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
	
	                if (worldIn.getBlockState(blockpos1.down()).getBlock() != this || worldIn.getBlockState(blockpos1).isNormalCube())
	                {
	                    break;
	                }
	
	                ++j;
	            }
	        }
	    }
	    
	}
}


package net.lepidodendron.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.NonNullList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.Block;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.entity.item.EntityItem;

import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.BlockDirectional;
import net.minecraft.util.Mirror;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.BlockFaceShape;

import net.lepidodendron.creativetab.TabLepidodendron;
import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.LepidodendronConfig;

@ElementsLepidodendronMod.ModElement.Tag
public class BlockTempskyaLeaves extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:tempskya_leaves_worldgen")
	public static final Block block = null;
	public BlockTempskyaLeaves(ElementsLepidodendronMod instance) {
		super(instance, 274);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("tempskya_leaves_worldgen"));
		//elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		//ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
		//		new ModelResourceLocation("lepidodendron:tempskya_leaves_worldgen", "inventory"));
		ModelLoader.setCustomStateMapper(block, (new StateMap.Builder()).ignore(BlockLeaves.DECAYABLE, BlockLeaves.CHECK_DECAY).build());
	}
	public static class BlockCustom extends BlockLeaves {
		public static final PropertyDirection FACING = BlockDirectional.FACING;

		public BlockCustom() {
			//super();
			setTranslationKey("pf_tempskya_leaves_worldgen");
			setSoundType(SoundType.PLANT);
			setHardness(0.2F);
			setResistance(0.2F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(null);
			this.setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, true).withProperty(DECAYABLE, true).withProperty(FACING, EnumFacing.UP));
		}

		@Override
		public BlockPlanks.EnumType getWoodType(int meta) {
			return null;
		}

		@Override
		public NonNullList<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
			return NonNullList.withSize(1, new ItemStack(BlockTempskyaLeavesPlaceable.block, (int) (1)));
		}

		@Override
		public IBlockState withRotation(IBlockState state, Rotation rot) {
			return state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
		}
		
		@Override
		public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
			return state.withRotation(mirrorIn.toRotation((EnumFacing) state.getValue(FACING)));
		}
		
		@Override
		protected net.minecraft.block.state.BlockStateContainer createBlockState() {
			return new net.minecraft.block.state.BlockStateContainer(this, new IProperty[]{CHECK_DECAY, DECAYABLE, FACING});
		}

		//public IBlockState getStateFromMeta(int meta) {
		//	return this.getDefaultState().withProperty(DECAYABLE, (meta & 1) != 0).withProperty(CHECK_DECAY, (meta & 2) != 0);
		//}

		//public int getMetaFromState(IBlockState state) {
		//	int i = 0;
		//	if (!(Boolean) state.getValue(DECAYABLE))
		//		i |= 1;
		//	if ((Boolean) state.getValue(CHECK_DECAY))
		//		i |= 2;
		//	return i;
		//}

		@Override
		public IBlockState getStateFromMeta(int meta) {
			return this.getDefaultState().withProperty(FACING, EnumFacing.byIndex(meta));
		}

		@Override
		public int getMetaFromState(IBlockState state) {
			return ((EnumFacing) state.getValue(FACING)).getIndex();
		}

		//@Override
		//public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta,
		//		EntityLivingBase placer) {
		//	return this.getDefaultState().withProperty(CHECK_DECAY, false).withProperty(DECAYABLE, false).withProperty(FACING, facing);
		//}

		@SideOnly(Side.CLIENT)
		@Override
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
		
		@Override
		public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
			return layer == BlockRenderLayer.CUTOUT_MIPPED;
		}

		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}

		public boolean isFullCube(IBlockState state)
	    {
	        return false;
	    }

		@Override
		public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
			return 60;
		}

		@Override
		public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
			return 30;
		}

		@Override
		public MapColor getMapColor(IBlockState state, IBlockAccess blockAccess, BlockPos pos) {
			return MapColor.FOLIAGE;
		}
		
		@Override
		protected int getSaplingDropChance(IBlockState state) {
			return 2;
		}

		@Override
		public Item getItemDropped(IBlockState state, java.util.Random rand, int fortune) {
			if (LepidodendronConfig.doSpores) {
				// Drop air and use the spores method instead:
				return new ItemStack(Blocks.AIR, (int) (1)).getItem();
			}
			else {
				return Item.getItemFromBlock(BlockTempskyaSapling.block);
			}
		}
		
		public boolean isLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
        	return false;
    	}
		
		@Override
		protected boolean canSilkHarvest()
	    {
	        return true;
	    }
		
		@Override
        public ItemStack getSilkTouchDrop(IBlockState state)  {
            return new ItemStack(BlockTempskyaLeavesPlaceable.block, (int) (1));
        }

        @Override
		public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
			return new ItemStack(BlockTempskyaLeavesPlaceable.block, (int) (1));
		}


		@Override
		public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighborBlock, BlockPos fromPos) {
			if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue() && ((Boolean)state.getValue(DECAYABLE)).booleanValue())
				{
				//Test the orientation of this block and then check if it is still connected:
				if ((EnumFacing) state.getValue(BlockDirectional.FACING) == EnumFacing.NORTH) {
					Block block = world.getBlockState(pos.south()).getBlock();
					if (block != BlockTempskyaLog.block)
						{
							world.setBlockToAir(pos);
							if ((Math.random() >= 0.5) && (!LepidodendronConfig.doSpores)) {
									//Spawn another sapling:
									if (!world.isRemote) {
										EntityItem entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockTempskyaSapling.block, (int) (1)));
										entityToSpawn.setPickupDelay(10);
										world.spawnEntity(entityToSpawn);
									}
								}
						}
					}
				
				
				if ((EnumFacing) state.getValue(BlockDirectional.FACING) == EnumFacing.SOUTH) {
					Block block = world.getBlockState(pos.north()).getBlock();
					if (block != BlockTempskyaLog.block)
						{
							world.setBlockToAir(pos);
							if ((Math.random() >= 0.5) && (!LepidodendronConfig.doSpores)) {
									//Spawn another sapling:
									if (!world.isRemote) {
										EntityItem entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockTempskyaSapling.block, (int) (1)));
										entityToSpawn.setPickupDelay(10);
										world.spawnEntity(entityToSpawn);
									}
								}
						}
					}
			
				
				if ((EnumFacing) state.getValue(BlockDirectional.FACING) == EnumFacing.EAST) {
					Block block = world.getBlockState(pos.west()).getBlock();
					if (block != BlockTempskyaLog.block)
						{
							world.setBlockToAir(pos);
							if ((Math.random() >= 0.5) && (!LepidodendronConfig.doSpores)) {
									//Spawn another sapling:
									if (!world.isRemote) {
										EntityItem entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockTempskyaSapling.block, (int) (1)));
										entityToSpawn.setPickupDelay(10);
										world.spawnEntity(entityToSpawn);
									}
								}
						}
					}
				
				if ((EnumFacing) state.getValue(BlockDirectional.FACING) == EnumFacing.WEST) {
					Block block = world.getBlockState(pos.east()).getBlock();
					if (block != BlockTempskyaLog.block)
						{
							world.setBlockToAir(pos);
							if ((Math.random() >= 0.5) && (!LepidodendronConfig.doSpores)) {
									//Spawn another sapling:
									if (!world.isRemote) {
										EntityItem entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockTempskyaSapling.block, (int) (1)));
										entityToSpawn.setPickupDelay(10);
										world.spawnEntity(entityToSpawn);
									}
								}
						}
					}
				
				if ((EnumFacing) state.getValue(BlockDirectional.FACING) == EnumFacing.UP) {
					Block block = world.getBlockState(pos.down()).getBlock();
					if (block != BlockTempskyaLog.block)
						{
							world.setBlockToAir(pos);
							if ((Math.random() >= 0.5) && (!LepidodendronConfig.doSpores)) {
									//Spawn another sapling:
									if (!world.isRemote) {
										EntityItem entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockTempskyaSapling.block, (int) (1)));
										entityToSpawn.setPickupDelay(10);
										world.spawnEntity(entityToSpawn);
									}
								}
						}
					}
				
				if ((EnumFacing) state.getValue(BlockDirectional.FACING) == EnumFacing.DOWN) {
					Block block = world.getBlockState(pos.up()).getBlock();
					if (block != BlockTempskyaLog.block)
						{
							world.setBlockToAir(pos);
							if ((Math.random() >= 0.5) && (!LepidodendronConfig.doSpores)) {
									//Spawn another sapling:
									if (!world.isRemote) {
										EntityItem entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockTempskyaSapling.block, (int) (1)));
										entityToSpawn.setPickupDelay(10);
										world.spawnEntity(entityToSpawn);
									}
								}
						}
					}
			}
			
		}
		
		@Override
		public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) 
		{
			if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue() && ((Boolean)state.getValue(DECAYABLE)).booleanValue())
				{
				//Test the orientation of this block and then check if it is still connected:
				if ((EnumFacing) state.getValue(BlockDirectional.FACING) == EnumFacing.NORTH) {
					Block block = worldIn.getBlockState(pos.south()).getBlock();
					if (block != BlockTempskyaLog.block)
						{
							worldIn.setBlockToAir(pos);
							if ((Math.random() >= 0.5) && (!LepidodendronConfig.doSpores)) {
									//Spawn another sapling:
									if (!worldIn.isRemote) {
										EntityItem entityToSpawn = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockTempskyaSapling.block, (int) (1)));
										entityToSpawn.setPickupDelay(10);
										worldIn.spawnEntity(entityToSpawn);
									}
								}
						}
					}
				
				
				if ((EnumFacing) state.getValue(BlockDirectional.FACING) == EnumFacing.SOUTH) {
					Block block = worldIn.getBlockState(pos.north()).getBlock();
					if (block != BlockTempskyaLog.block)
						{
							worldIn.setBlockToAir(pos);
							if ((Math.random() >= 0.5) && (!LepidodendronConfig.doSpores)) {
									//Spawn another sapling:
									if (!worldIn.isRemote) {
										EntityItem entityToSpawn = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockTempskyaSapling.block, (int) (1)));
										entityToSpawn.setPickupDelay(10);
										worldIn.spawnEntity(entityToSpawn);
									}
								}
						}
					}
			
				
				if ((EnumFacing) state.getValue(BlockDirectional.FACING) == EnumFacing.EAST) {
					Block block = worldIn.getBlockState(pos.west()).getBlock();
					if (block != BlockTempskyaLog.block)
						{
							worldIn.setBlockToAir(pos);
							if ((Math.random() >= 0.5) && (!LepidodendronConfig.doSpores)) {
									//Spawn another sapling:
									if (!worldIn.isRemote) {
										EntityItem entityToSpawn = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockTempskyaSapling.block, (int) (1)));
										entityToSpawn.setPickupDelay(10);
										worldIn.spawnEntity(entityToSpawn);
									}
								}
						}
					}
				
				if ((EnumFacing) state.getValue(BlockDirectional.FACING) == EnumFacing.WEST) {
					Block block = worldIn.getBlockState(pos.east()).getBlock();
					if (block != BlockTempskyaLog.block)
						{
							worldIn.setBlockToAir(pos);
							if ((Math.random() >= 0.5) && (!LepidodendronConfig.doSpores)) {
									//Spawn another sapling:
									if (!worldIn.isRemote) {
										EntityItem entityToSpawn = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockTempskyaSapling.block, (int) (1)));
										entityToSpawn.setPickupDelay(10);
										worldIn.spawnEntity(entityToSpawn);
									}
								}
						}
					}
				
				if ((EnumFacing) state.getValue(BlockDirectional.FACING) == EnumFacing.UP) {
					Block block = worldIn.getBlockState(pos.down()).getBlock();
					if (block != BlockTempskyaLog.block)
						{
							worldIn.setBlockToAir(pos);
							if ((Math.random() >= 0.5) && (!LepidodendronConfig.doSpores)) {
									//Spawn another sapling:
									if (!worldIn.isRemote) {
										EntityItem entityToSpawn = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockTempskyaSapling.block, (int) (1)));
										entityToSpawn.setPickupDelay(10);
										worldIn.spawnEntity(entityToSpawn);
									}
								}
						}
					}
				
				if ((EnumFacing) state.getValue(BlockDirectional.FACING) == EnumFacing.DOWN) {
					Block block = worldIn.getBlockState(pos.up()).getBlock();
					if (block != BlockTempskyaLog.block)
						{
							worldIn.setBlockToAir(pos);
							if ((Math.random() >= 0.5) && (!LepidodendronConfig.doSpores)) {
									//Spawn another sapling:
									if (!worldIn.isRemote) {
										EntityItem entityToSpawn = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockTempskyaSapling.block, (int) (1)));
										entityToSpawn.setPickupDelay(10);
										worldIn.spawnEntity(entityToSpawn);
									}
								}
						}
					}
			}
			
		}

		
		@Override
	    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
	    {
	        return BlockFaceShape.UNDEFINED;
	    }

		@Override
	    public boolean canBeReplacedByLeaves(IBlockState state, IBlockAccess world, BlockPos pos)
	    {
	        return true;
	    }

	}
}
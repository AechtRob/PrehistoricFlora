
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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.state.BlockFaceShape;

import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.BlockDirectional;
import net.minecraft.util.Mirror;
import net.minecraft.init.Blocks;
import net.minecraft.entity.item.EntityItem;

import net.lepidodendron.creativetab.TabLepidodendron;
import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.LepidodendronConfig;
import net.lepidodendron.item.ItemUtrechtiaFruit;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraftforge.items.ItemHandlerHelper;

@ElementsLepidodendronMod.ModElement.Tag
public class BlockUtrechtiaLeavesTop extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:utrechtia_leaves_top")
	public static final Block block = null;
	public BlockUtrechtiaLeavesTop(ElementsLepidodendronMod instance) {
		super(instance, 355);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("utrechtia_leaves_top"));
		//elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		//ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
		//		new ModelResourceLocation("lepidodendron:utrechtia_leaves_top", "inventory"));
		ModelLoader.setCustomStateMapper(block, (new StateMap.Builder()).ignore(BlockLeaves.DECAYABLE, BlockLeaves.CHECK_DECAY).build());
	}
	public static class BlockCustom extends BlockLeaves {
		public static final PropertyDirection FACING = BlockDirectional.FACING;
		public BlockCustom() {
			//super(Material.PLANTS);
			setTranslationKey("utrechtia_leaves_top");
			setSoundType(SoundType.PLANT);
			setHardness(0.2F);
			setResistance(0.2F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(null);
			this.setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, false).withProperty(DECAYABLE, false).withProperty(FACING, EnumFacing.UP));
			//setTickRandomly(true);
		}

		@Override
		public BlockPlanks.EnumType getWoodType(int meta) {
			return null;
		}
		
		@Override
		public NonNullList<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
			return NonNullList.withSize(1, new ItemStack(BlockUtrechtiaLeavesPlaceable.block, (int) (1)));
		}


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
		@javax.annotation.Nullable
		public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
			return NULL_AABB;
		}

		@Override
		public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
			return true;
		}

		@Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
			switch ((EnumFacing) state.getValue(BlockDirectional.FACING)) {
				case SOUTH :
				default :
					return new AxisAlignedBB(0.0D, 0.4D, 0D, 1D, 0.6D, 1.0D);
				case NORTH :
					return new AxisAlignedBB(0.0D, 0.4D, 0D, 1D, 0.6D, 1.0D);
				case WEST :
					return new AxisAlignedBB(0.0D, 0.4D, 0D, 1D, 0.6D, 1.0D);
				case EAST :
					return new AxisAlignedBB(0.0D, 0.4D, 0D, 1D, 0.6D, 1.0D);
				case UP :
					return new AxisAlignedBB(0D, 0D, 0.0D, 1D, 1D, 1D);
				case DOWN :
					return new AxisAlignedBB(0D, 0D, 0.0, 1D, 1D, 1D);
			}
		}

		@Override
		protected net.minecraft.block.state.BlockStateContainer createBlockState() {
			return new net.minecraft.block.state.BlockStateContainer(this, new IProperty[]{CHECK_DECAY, DECAYABLE, FACING});
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
		public IBlockState getStateFromMeta(int meta) {
			return this.getDefaultState().withProperty(FACING, EnumFacing.byIndex(meta));
		}

		@Override
		public int getMetaFromState(IBlockState state) {
			return ((EnumFacing) state.getValue(FACING)).getIndex();
		}

		@Override
		public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta,
				EntityLivingBase placer) {
			return this.getDefaultState().withProperty(FACING, facing);
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
			return 5;
		}

		@Override
		public Item getItemDropped(IBlockState state, java.util.Random rand, int fortune) {
			if (LepidodendronConfig.doFruits) {
				return new ItemStack(ItemUtrechtiaFruit.block, (int) (1)).getItem();
			}
			else {
				return Item.getItemFromBlock(BlockUtrechtiaSapling.block);
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
            return new ItemStack(BlockUtrechtiaLeavesPlaceable.block, (int) (1));
        }

		@Override
		public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
			return new ItemStack(BlockUtrechtiaLeavesPlaceable.block, (int) (1));
		}

	    @Override
		public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighborBlock, BlockPos fromPos) {
			
			super.neighborChanged(state, world, pos, neighborBlock, fromPos);
			EntityItem entityToSpawn;
			//Test the orientation of this block and then check if it is still connected:
			if ((EnumFacing) state.getValue(BlockDirectional.FACING) == EnumFacing.NORTH) {
				Block block = world.getBlockState(pos.south()).getBlock();
				if ((block == BlockUtrechtiaLeaves.block) || (block == BlockUtrechtiaLeavesPlaceable.block))
				{
					if (new Object() {
					public EnumFacing getEnumFacing(BlockPos pos1) {
						try {
							IBlockState _bs = world.getBlockState(pos1);
							for (IProperty<?> prop : _bs.getProperties().keySet()) {
								if (prop.getName().equals("facing"))
									return _bs.getValue((PropertyDirection) prop);
							}
							return EnumFacing.NORTH;
						} catch (Exception e) {
							return EnumFacing.NORTH;
						}
					}
				}.getEnumFacing(pos.south()) != EnumFacing.NORTH)
					{
						world.setBlockToAir(pos);
						if ((Math.random() >= 0.8) &&  (!world.isRemote)) {
							if (!LepidodendronConfig.doFruits) {
								entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockUtrechtiaSapling.block, (int) (1)));
							}
							else {
								entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemUtrechtiaFruit.block, (int) (1)));
							}
							entityToSpawn.setPickupDelay(10);
							world.spawnEntity(entityToSpawn);
						}
					}
				}
				else {
					world.setBlockToAir(pos);
					if ((Math.random() >= 0.8) &&  (!world.isRemote)) {
						if (!LepidodendronConfig.doFruits) {
							entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockUtrechtiaSapling.block, (int) (1)));
						}
						else {
							entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemUtrechtiaFruit.block, (int) (1)));
						}
						entityToSpawn.setPickupDelay(10);
						world.spawnEntity(entityToSpawn);
					}
				}
			}
			
			if ((EnumFacing) state.getValue(BlockDirectional.FACING) == EnumFacing.SOUTH) {
				Block block = world.getBlockState(pos.north()).getBlock();
				if ((block == BlockUtrechtiaLeaves.block) || (block == BlockUtrechtiaLeavesPlaceable.block))
				{
					if (new Object() {
					public EnumFacing getEnumFacing(BlockPos pos1) {
						try {
							IBlockState _bs = world.getBlockState(pos1);
							for (IProperty<?> prop : _bs.getProperties().keySet()) {
								if (prop.getName().equals("facing"))
									return _bs.getValue((PropertyDirection) prop);
							}
							return EnumFacing.SOUTH;
						} catch (Exception e) {
							return EnumFacing.SOUTH;
						}
					}
				}.getEnumFacing(pos.north()) != EnumFacing.SOUTH)
					{
						world.setBlockToAir(pos);
						if ((Math.random() >= 0.8) &&  (!world.isRemote)) {
							if (!LepidodendronConfig.doFruits) {
								entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockUtrechtiaSapling.block, (int) (1)));
							}
							else {
								entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemUtrechtiaFruit.block, (int) (1)));
							}
							entityToSpawn.setPickupDelay(10);
							world.spawnEntity(entityToSpawn);
						}
					}
				}
				else {
					world.setBlockToAir(pos);
					if ((Math.random() >= 0.8) &&  (!world.isRemote)) {
						if (!LepidodendronConfig.doFruits) {
							entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockUtrechtiaSapling.block, (int) (1)));
						}
						else {
							entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemUtrechtiaFruit.block, (int) (1)));
						}
						entityToSpawn.setPickupDelay(10);
						world.spawnEntity(entityToSpawn);
					}
				}
			}
			
			if ((EnumFacing) state.getValue(BlockDirectional.FACING) == EnumFacing.EAST) {
				Block block = world.getBlockState(pos.west()).getBlock();
				if ((block == BlockUtrechtiaLeaves.block) || (block == BlockUtrechtiaLeavesPlaceable.block))
				{
					if (new Object() {
					public EnumFacing getEnumFacing(BlockPos pos1) {
						try {
							IBlockState _bs = world.getBlockState(pos1);
							for (IProperty<?> prop : _bs.getProperties().keySet()) {
								if (prop.getName().equals("facing"))
									return _bs.getValue((PropertyDirection) prop);
							}
							return EnumFacing.EAST;
						} catch (Exception e) {
							return EnumFacing.EAST;
						}
					}
				}.getEnumFacing(pos.west()) != EnumFacing.EAST)
					{
						world.setBlockToAir(pos);
						if ((Math.random() >= 0.8) &&  (!world.isRemote)) {
							if (!LepidodendronConfig.doFruits) {
								entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockUtrechtiaSapling.block, (int) (1)));
							}
							else {
								entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemUtrechtiaFruit.block, (int) (1)));
							}
							entityToSpawn.setPickupDelay(10);
							world.spawnEntity(entityToSpawn);
						}
					}
				}
				else {
					world.setBlockToAir(pos);
					if ((Math.random() >= 0.8) &&  (!world.isRemote)) {
						if (!LepidodendronConfig.doFruits) {
							entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockUtrechtiaSapling.block, (int) (1)));
						}
						else {
							entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemUtrechtiaFruit.block, (int) (1)));
						}
						entityToSpawn.setPickupDelay(10);
						world.spawnEntity(entityToSpawn);
					}
				}
			}
			
			if ((EnumFacing) state.getValue(BlockDirectional.FACING) == EnumFacing.WEST) {
				Block block = world.getBlockState(pos.east()).getBlock();
				if ((block == BlockUtrechtiaLeaves.block) || (block == BlockUtrechtiaLeavesPlaceable.block))
				{
					if (new Object() {
					public EnumFacing getEnumFacing(BlockPos pos1) {
						try {
							IBlockState _bs = world.getBlockState(pos1);
							for (IProperty<?> prop : _bs.getProperties().keySet()) {
								if (prop.getName().equals("facing"))
									return _bs.getValue((PropertyDirection) prop);
							}
							return EnumFacing.WEST;
						} catch (Exception e) {
							return EnumFacing.WEST;
						}
					}
				}.getEnumFacing(pos.east()) != EnumFacing.WEST)
					{
						world.setBlockToAir(pos);
						if ((Math.random() >= 0.8) &&  (!world.isRemote)) {
							if (!LepidodendronConfig.doFruits) {
								entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockUtrechtiaSapling.block, (int) (1)));
							}
							else {
								entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemUtrechtiaFruit.block, (int) (1)));
							}
							entityToSpawn.setPickupDelay(10);
							world.spawnEntity(entityToSpawn);
						}
					}
				}
				else {
					world.setBlockToAir(pos);
					if ((Math.random() >= 0.8) &&  (!world.isRemote)) {
						if (!LepidodendronConfig.doFruits) {
							entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockUtrechtiaSapling.block, (int) (1)));
						}
						else {
							entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemUtrechtiaFruit.block, (int) (1)));
						}
						entityToSpawn.setPickupDelay(10);
						world.spawnEntity(entityToSpawn);
					}
				}
			}
			
			if ((EnumFacing) state.getValue(BlockDirectional.FACING) == EnumFacing.UP) {
				Block block = world.getBlockState(pos.down()).getBlock();
				if ((block == BlockUtrechtiaLeaves.block) || (block == BlockUtrechtiaLeavesPlaceable.block))
				{
					if (new Object() {
					public EnumFacing getEnumFacing(BlockPos pos1) {
						try {
							IBlockState _bs = world.getBlockState(pos1);
							for (IProperty<?> prop : _bs.getProperties().keySet()) {
								if (prop.getName().equals("facing"))
									return _bs.getValue((PropertyDirection) prop);
							}
							return EnumFacing.UP;
						} catch (Exception e) {
							return EnumFacing.UP;
						}
					}
				}.getEnumFacing(pos.down()) != EnumFacing.UP)
					{
						world.setBlockToAir(pos);
						if ((Math.random() >= 0.8) &&  (!world.isRemote)) {
							if (!LepidodendronConfig.doFruits) {
								entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockUtrechtiaSapling.block, (int) (1)));
							}
							else {
								entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemUtrechtiaFruit.block, (int) (1)));
							}
							entityToSpawn.setPickupDelay(10);
							world.spawnEntity(entityToSpawn);
						}
					}
				}
				else {
					world.setBlockToAir(pos);
					if ((Math.random() >= 0.8) &&  (!world.isRemote)) {
						if (!LepidodendronConfig.doFruits) {
							entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockUtrechtiaSapling.block, (int) (1)));
						}
						else {
							entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemUtrechtiaFruit.block, (int) (1)));
						}
						entityToSpawn.setPickupDelay(10);
						world.spawnEntity(entityToSpawn);
					}
				}
			}
			
			if ((EnumFacing) state.getValue(BlockDirectional.FACING) == EnumFacing.DOWN) {
				Block block = world.getBlockState(pos.up()).getBlock();
				if ((block == BlockUtrechtiaLeaves.block) || (block == BlockUtrechtiaLeavesPlaceable.block))
				{
					if (new Object() {
					public EnumFacing getEnumFacing(BlockPos pos1) {
						try {
							IBlockState _bs = world.getBlockState(pos1);
							for (IProperty<?> prop : _bs.getProperties().keySet()) {
								if (prop.getName().equals("facing"))
									return _bs.getValue((PropertyDirection) prop);
							}
							return EnumFacing.DOWN;
						} catch (Exception e) {
							return EnumFacing.DOWN;
						}
					}
				}.getEnumFacing(pos.up()) != EnumFacing.DOWN)
					{
						world.setBlockToAir(pos);
						if ((Math.random() >= 0.8) &&  (!world.isRemote)) {
							if (!LepidodendronConfig.doFruits) {
								entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockUtrechtiaSapling.block, (int) (1)));
							}
							else {
								entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemUtrechtiaFruit.block, (int) (1)));
							}
							entityToSpawn.setPickupDelay(10);
							world.spawnEntity(entityToSpawn);
						}
					}
				}
				else {
					world.setBlockToAir(pos);
					if ((Math.random() >= 0.8) &&  (!world.isRemote)) {
						if (!LepidodendronConfig.doFruits) {
							entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockUtrechtiaSapling.block, (int) (1)));
						}
						else {
							entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemUtrechtiaFruit.block, (int) (1)));
						}
						entityToSpawn.setPickupDelay(10);
						world.spawnEntity(entityToSpawn);
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
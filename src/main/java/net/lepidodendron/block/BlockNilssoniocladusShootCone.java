
package net.lepidodendron.block;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.LepidodendronConfig;
import net.lepidodendron.LepidodendronSorter;
import net.lepidodendron.item.ItemNilssoniocladusCone;
import net.minecraft.block.*;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemHandlerHelper;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BlockNilssoniocladusShootCone extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:nilssoniocladus_shoot_cone")
	public static final Block block = null;
	public BlockNilssoniocladusShootCone(ElementsLepidodendronMod instance) {
		super(instance, LepidodendronSorter.nilssoniocladus_shoot_cone);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("nilssoniocladus_shoot_cone"));
		//elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		//ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
		//		new ModelResourceLocation("lepidodendron:nilssoniocladus_shoot_cone", "inventory"));
		ModelLoader.setCustomStateMapper(block, (new StateMap.Builder()).ignore(BlockLeaves.DECAYABLE, BlockLeaves.CHECK_DECAY).build());
	}
	public static class BlockCustom extends BlockLeaves {
		public static final PropertyDirection FACING = BlockDirectional.FACING;
		public static final PropertyBool VINE = PropertyBool.create("vine");
		
		public BlockCustom() {
			super();
			setTranslationKey("pf_nilssoniocladus_shoot_cone");
			setSoundType(SoundType.PLANT);
			setHardness(0.2F);
			setResistance(0.2F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(null);
			this.setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, true).withProperty(DECAYABLE, true).withProperty(FACING, EnumFacing.UP).withProperty(VINE, false));
		}

		@Override
		public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos){

			if (worldIn.getBlockState(pos).getBlock() != this) {
				return state;
			}

			//Testing if this shoot is properly attached to a plant/vine in the right direction for a visual connection:
			
			boolean onvine = false;

	        Block blockn = worldIn.getBlockState(pos.north()).getBlock();
	        Block blocke = worldIn.getBlockState(pos.east()).getBlock();
	        Block blocks = worldIn.getBlockState(pos.south()).getBlock();
	        Block blockw = worldIn.getBlockState(pos.west()).getBlock();

			IBlockState blockStaten = worldIn.getBlockState(pos.north());
			IBlockState blockStatee = worldIn.getBlockState(pos.east());
			IBlockState blockStates = worldIn.getBlockState(pos.south());
			IBlockState blockStatew = worldIn.getBlockState(pos.west());

			if ((state.getValue(FACING) == EnumFacing.SOUTH) && (blockn == BlockNilssoniocladusStem.block)) {
				if ((blockStaten.getValue(FACING) == EnumFacing.SOUTH) && (worldIn.getBlockState(pos.north().up()).getBlock() != BlockNilssoniocladusShootPlaceable.block) && (worldIn.getBlockState(pos.north().up()).getBlock() != this)) {
					onvine = true;
				}
			}

			if ((state.getValue(FACING) == EnumFacing.NORTH) && (blocks == BlockNilssoniocladusStem.block)) {
				if ((blockStates.getValue(FACING) == EnumFacing.NORTH) && (worldIn.getBlockState(pos.south().up()).getBlock() != BlockNilssoniocladusShootPlaceable.block) && (worldIn.getBlockState(pos.south().up()).getBlock() != this)) {
					onvine = true;
				}
			}

			if ((state.getValue(FACING) == EnumFacing.EAST) && (blockw == BlockNilssoniocladusStem.block)) {
				if ((blockStatew.getValue(FACING) == EnumFacing.EAST) && (worldIn.getBlockState(pos.west().up()).getBlock() != BlockNilssoniocladusShootPlaceable.block) && (worldIn.getBlockState(pos.west().up()).getBlock() != this)) {
					onvine = true;
				}
			}

			if ((state.getValue(FACING) == EnumFacing.WEST) && (blocke == BlockNilssoniocladusStem.block)) {
				if ((blockStatee.getValue(FACING) == EnumFacing.WEST) && (worldIn.getBlockState(pos.east().up()).getBlock() != BlockNilssoniocladusShootPlaceable.block) && (worldIn.getBlockState(pos.east().up()).getBlock() != this)) {
					onvine = true;
				}
			}

			//up and down don't do anything fancy to their models:
			if ((state.getValue(FACING) == EnumFacing.DOWN) || (state.getValue(FACING) == EnumFacing.UP)) {
				onvine = false;
			}
			
			return state.withProperty(VINE, onvine);
		}

		@Override
		public BlockPlanks.EnumType getWoodType(int meta) {
			return null;
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
			return new net.minecraft.block.state.BlockStateContainer(this, new IProperty[]{CHECK_DECAY, DECAYABLE, FACING, VINE});
		}

		@Override
		public IBlockState getStateFromMeta(int meta) {
			return this.getDefaultState().withProperty(FACING, EnumFacing.byIndex(meta));
		}

		@Override
		public int getMetaFromState(IBlockState state) {
			return ((EnumFacing) state.getValue(FACING)).getIndex();
		}

		@SideOnly(Side.CLIENT)
		@Override
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT;
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
		public Item getItemDropped(IBlockState state, Random rand, int fortune) {
			if (!LepidodendronConfig.doFruits) {
				return Item.getItemFromBlock(BlockNilssoniocladusSapling.block);
			}
			return null;
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
            return new ItemStack(BlockNilssoniocladusShootPlaceable.block, (int) (1));
        }

        @Override
		public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
			return new ItemStack(BlockNilssoniocladusShootPlaceable.block, (int) (1));
		}

		@Override
		public NonNullList<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
			return NonNullList.withSize(1, new ItemStack(BlockNilssoniocladusShootPlaceable.block, (int) (1)));
		}
		
		@Override
		public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighborBlock, BlockPos fromPos) {
		if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue() && ((Boolean)state.getValue(DECAYABLE)).booleanValue())
			{
			if (
				(!getActualState(state, world, pos).getValue(VINE))
				&& (!(state.getValue(FACING) == EnumFacing.UP && world.getBlockState(pos.down()).getBlock() == BlockNilssoniocladusStem.block))
				&& (!(state.getValue(FACING) == EnumFacing.DOWN && world.getBlockState(pos.up()).getBlock() == BlockNilssoniocladusStem.block))
				)
				{
					world.setBlockToAir(pos);
					if ((Math.random() >= 0.5) && (!LepidodendronConfig.doFruits)) {
						//Spawn another sapling:
						if (!world.isRemote) {
							EntityItem entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockNilssoniocladusSapling.block, (int) (1)));
							entityToSpawn.setPickupDelay(10);
							world.spawnEntity(entityToSpawn);
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
			if (
				(!getActualState(state, worldIn, pos).getValue(VINE))
				&& (!(state.getValue(FACING) == EnumFacing.UP && worldIn.getBlockState(pos.down()).getBlock() == BlockNilssoniocladusStem.block))
				&& (!(state.getValue(FACING) == EnumFacing.DOWN && worldIn.getBlockState(pos.up()).getBlock() == BlockNilssoniocladusStem.block))
				)
				{
					worldIn.setBlockToAir(pos);
					if (!worldIn.isRemote) {
						EntityItem entityToSpawn = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockNilssoniocladusSapling.block, (int) (1)));
						entityToSpawn.setPickupDelay(10);
						worldIn.spawnEntity(entityToSpawn);
					}
				}
				else if (Math.random()>0.8 && Math.random()>0.8) {
					worldIn.setBlockState(pos, BlockNilssoniocladusShoot.block.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
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
	    
	    @Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
			switch ((EnumFacing) state.getValue(BlockDirectional.FACING)) {
				case SOUTH :
				default :
					if (getActualState(state, source, pos).getValue(VINE)) {
						return new AxisAlignedBB(0.0D, 0.0D, -0.9D, 1.0D, 1.0D, -0.5D);
					}
					else {
						return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.4D);
					}
					
				case NORTH :
					if (getActualState(state, source, pos).getValue(VINE)) {
						return new AxisAlignedBB(0.0D, 0.0D, 1.9D, 1.0D, 1.0D, 1.5D);
					}
					else {
						return new AxisAlignedBB(0.0D, 0.0D, 0.6, 1.0D, 1.0D, 1.0D);
					}
					
				case WEST :
					if (getActualState(state, source, pos).getValue(VINE)) {
						return new AxisAlignedBB(1.9D, 0.0D, 0D, 1.5D, 1.0D, 1.0D);
					}
					else {
						return new AxisAlignedBB(0.6D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
					}

				case EAST :
					if (getActualState(state, source, pos).getValue(VINE)) {
						return new AxisAlignedBB(-0.9D, 0.0D, 0.0D, -0.5D, 1.0D, 1.0D);
					}
					else {
						return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.4D, 1.0D, 1.0D);
					}
					
				case UP :
					return new AxisAlignedBB(0.0D, 0D, 0.0D, 1.0D, 0.4D, 1.0D);
					
				case DOWN :
					return new AxisAlignedBB(0.0D, 1.0D, 0.0D, 1.0D, 0.6D, 1.0D);
			}
		}

		@Override
		public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
		{
			if ((!player.capabilities.allowEdit) || (!player.getHeldItemMainhand().isEmpty()) || !LepidodendronConfig.doFruits)
			{
				return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
			}
			else {
				if (!((hand != player.getActiveHand()) && (hand == EnumHand.MAIN_HAND))) {
					ItemStack stackSeed = new ItemStack(ItemNilssoniocladusCone.block, (int) (1));
					stackSeed.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(player, stackSeed);
					if (Math.random() > 0.95) {
						world.destroyBlock(pos, false);
					}
					else {
						world.setBlockState(pos, BlockNilssoniocladusShoot.block.getDefaultState().withProperty(FACING, state.getValue(FACING)));
					}
					return true;
				}
				return true;
			}
		}
	}
}
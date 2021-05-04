
package net.lepidodendron.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.NonNullList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.Block;
import net.lepidodendron.block.BlockQuasistrobusSideCentre;
import java.util.Random;
import net.minecraft.entity.item.EntityItem;
import java.util.List;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.properties.PropertyInteger;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.creativetab.TabLepidodendron;
import net.lepidodendron.LepidodendronConfig;
import net.minecraft.util.math.AxisAlignedBB;

@ElementsLepidodendronMod.ModElement.Tag
public class BlockQuasistrobusSide extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:quasistrobus_side")
	public static final Block block = null;
	public BlockQuasistrobusSide(ElementsLepidodendronMod instance) {
		super(instance, 287);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("quasistrobus_side"));
		//elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		//ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
		//		new ModelResourceLocation("lepidodendron:quasistrobus_side", "inventory"));
		ModelLoader.setCustomStateMapper(block, (new StateMap.Builder()).ignore(BlockLeaves.DECAYABLE, BlockLeaves.CHECK_DECAY).build());
	}

	public static final PropertyInteger SIDE = PropertyInteger.create("side", 0, 7);
	
	public static class BlockCustom extends BlockLeaves {
		public BlockCustom() {
			super();
			setTranslationKey("pf_quasistrobus_side");
			setSoundType(SoundType.PLANT);
			setHardness(0.2F);
			setResistance(0.2F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(TabLepidodendron.tab);
			this.setDefaultState(this.blockState.getBaseState().withProperty(SIDE, 0).withProperty(CHECK_DECAY, false).withProperty(DECAYABLE, false));
		}

		@Override
		public BlockPlanks.EnumType getWoodType(int meta) {
			return null;
		}

		@Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
			return new AxisAlignedBB(0.0D, 0D, 0D, 0.0D, 0D, 0.0D);
		}
		
		@Override
		public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
			return true;
		}

		@Override
		public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	    {
	        if (worldIn.getBlockState(pos.south()).getBlock() == BlockQuasistrobus.block) {
	        	return state.withProperty(SIDE, 1);
	        }

	        if (worldIn.getBlockState(pos.north()).getBlock() == BlockQuasistrobus.block) {
	        	return state.withProperty(SIDE, 6);
	        }

	        if (worldIn.getBlockState(pos.west()).getBlock() == BlockQuasistrobus.block) {
	        	return state.withProperty(SIDE, 4);
	        }

	        if (worldIn.getBlockState(pos.east()).getBlock() == BlockQuasistrobus.block) {
	        	return state.withProperty(SIDE, 3);
	        }

	        if (worldIn.getBlockState(pos.south().east()).getBlock() == BlockQuasistrobus.block) {
	        	return state.withProperty(SIDE, 0);
	        }

	        if (worldIn.getBlockState(pos.south().west()).getBlock() == BlockQuasistrobus.block) {
	        	return state.withProperty(SIDE, 2);
	        }

	        if (worldIn.getBlockState(pos.north().east()).getBlock() == BlockQuasistrobus.block) {
	        	return state.withProperty(SIDE, 5);
	        }

	        if (worldIn.getBlockState(pos.north().west()).getBlock() == BlockQuasistrobus.block) {
	        	return state.withProperty(SIDE, 7);
	        }

			return state;
	        
	    }

		@Override
		protected net.minecraft.block.state.BlockStateContainer createBlockState() {
			return new net.minecraft.block.state.BlockStateContainer(this, new IProperty[]{CHECK_DECAY, DECAYABLE, SIDE});
		}

		@Override
		public NonNullList<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
			return NonNullList.withSize(1, new ItemStack(BlockQuasistrobus.block, (int) (1)));
		}

		public IBlockState getStateFromMeta(int meta) {
			return this.getDefaultState().withProperty(DECAYABLE, (meta & 1) != 0).withProperty(CHECK_DECAY, (meta & 2) != 0);
		}

		public int getMetaFromState(IBlockState state) {
			int i = 0;
			if (!(Boolean) state.getValue(DECAYABLE))
				i |= 1;
			if ((Boolean) state.getValue(CHECK_DECAY))
				i |= 2;
			return i;
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
		public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
			return 60;
		}

		@Override
		public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
			return 30;
		}

		@Override
		public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
			return new ItemStack(BlockQuasistrobus.block, (int) (1));
		}

		@Override
		public MapColor getMapColor(IBlockState state, IBlockAccess blockAccess, BlockPos pos) {
			return MapColor.FOLIAGE;
		}

		@Override
		protected int getSaplingDropChance(IBlockState state) {
			return 1;
		}

		@Override
		public Item getItemDropped(IBlockState state, java.util.Random rand, int fortune) {
			return new ItemStack(Blocks.AIR, (int) (1)).getItem();
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
            return new ItemStack(BlockQuasistrobus.block, (int) (1));
        }
		
	    @Override
		public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
			super.updateTick(world, pos, state, random);
			
			if (
				(world.getBlockState(pos.north()).getBlock() != BlockQuasistrobus.block) 
				&& (world.getBlockState(pos.south()).getBlock() != BlockQuasistrobus.block)
				&& (world.getBlockState(pos.east()).getBlock() != BlockQuasistrobus.block)
				&& (world.getBlockState(pos.west()).getBlock() != BlockQuasistrobus.block)
				&& (world.getBlockState(pos.north().east()).getBlock() != BlockQuasistrobus.block)
				&& (world.getBlockState(pos.north().west()).getBlock() != BlockQuasistrobus.block)
				&& (world.getBlockState(pos.south().east()).getBlock() != BlockQuasistrobus.block)
				&& (world.getBlockState(pos.south().west()).getBlock() != BlockQuasistrobus.block)
			)
			{
				world.setBlockToAir(pos);
			}
		}

		@Override
		public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighborBlock, BlockPos fromPos) {
			super.neighborChanged(state, world, pos, neighborBlock, fromPos);
			world.scheduleUpdate(pos, this, 1);
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

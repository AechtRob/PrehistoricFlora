
package net.lepidodendron.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.Rotation;
import net.minecraft.util.NonNullList;
import net.minecraft.util.Mirror;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.network.NetworkManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.Container;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockFaceShape;

import net.lepidodendron.procedure.ProcedureBothrodendronStrobilusNeighbourBlockChanges;
import net.lepidodendron.creativetab.TabLepidodendron;
import net.lepidodendron.ElementsLepidodendronMod;
import java.util.Random;

import java.util.Map;
import java.util.HashMap;

@ElementsLepidodendronMod.ModElement.Tag
public class BlockBothrodendronStrobilus extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:bothrodendron_strobilus")
	public static final Block block = null;
	public BlockBothrodendronStrobilus(ElementsLepidodendronMod instance) {
		super(instance, 105);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("bothrodendron_strobilus"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerTileEntity(TileEntityCustom.class, "lepidodendron:tileentitybothrodendron_strobilus");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("lepidodendron:bothrodendron_strobilus", "inventory"));
	}
	public static class BlockCustom extends Block implements ITileEntityProvider {
		public static final PropertyDirection FACING = BlockDirectional.FACING;
		public BlockCustom() {
			super(Material.PLANTS);
			setTranslationKey("pf_bothrodendron_strobilus");
			setSoundType(SoundType.PLANT);
			setHardness(0F);
			setResistance(0F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(TabLepidodendron.tab);
			this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.DOWN));
			setTickRandomly(true);
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
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
			switch ((EnumFacing) state.getValue(BlockDirectional.FACING)) {
				case SOUTH :
				default :
					return new AxisAlignedBB(0.25D, 0.25D, 0D, 0.75D, 0.75D, 1D);
				case NORTH :
					return new AxisAlignedBB(0.25D, 0.25D, 1D, 0.75D, 0.75D, 0D);
				case WEST :
					return new AxisAlignedBB(1D, 0.25D, 0.25D, 0D, 0.75D, 0.75D);
				case EAST :
					return new AxisAlignedBB(0D, 0.25D, 0.25D, 1D, 0.75D, 0.75D);
				case UP :
					return new AxisAlignedBB(0.25D, 0D, 0.75D, 0.75D, 1D, 0.25D);
				case DOWN :
					return new AxisAlignedBB(0.25D, 1D, 0.75D, 0.75D, 0D, 0.25D);
			}
		}

		@Override
		protected net.minecraft.block.state.BlockStateContainer createBlockState() {
			return new net.minecraft.block.state.BlockStateContainer(this, new IProperty[]{FACING});
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
		public boolean isReplaceable(IBlockAccess blockAccess, BlockPos pos) {
			return true;
		}

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			drops.add(new ItemStack(Blocks.AIR, (int) (1)));
		}

		@Override
		protected boolean canSilkHarvest()
	    {
	        return true;
	    }

		@Override
		public TileEntity createNewTileEntity(World worldIn, int meta) {
			return new TileEntityCustom();
		}

		@Override
		public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int eventID, int eventParam) {
			super.eventReceived(state, worldIn, pos, eventID, eventParam);
			TileEntity tileentity = worldIn.getTileEntity(pos);
			return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
		}

		@Override
		public EnumBlockRenderType getRenderType(IBlockState state) {
			return EnumBlockRenderType.MODEL;
		}

		@Override
		public void breakBlock(World world, BlockPos pos, IBlockState state) {
			TileEntity tileentity = world.getTileEntity(pos);
			//if (tileentity instanceof TileEntityCustom)
			//	InventoryHelper.dropInventoryItems(world, pos, (TileEntityCustom) tileentity);
			world.removeTileEntity(pos);
			super.breakBlock(world, pos, state);
		}

		@Override
		public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighborBlock, BlockPos fromPos) {
			super.neighborChanged(state, world, pos, neighborBlock, fromPos);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();

			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();

				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				
				ProcedureBothrodendronStrobilusNeighbourBlockChanges.executeProcedure($_dependencies);
			}
		}

		@Override
		public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing face) {
			return BlockFaceShape.UNDEFINED;
		}

		public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
			super.updateTick(worldIn, pos, state, rand);
		    if (!worldIn.isRemote) {
		    int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			//if (world.isBlockIndirectlyGettingPowered(new BlockPos(x, y, z)) > 0) {
			//	} else {
			//	}
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", worldIn);
					ProcedureBothrodendronStrobilusNeighbourBlockChanges.executeProcedure($_dependencies);
				}
		    }
	    }
	    
	}

	public static class TileEntityCustom extends TileEntity {
		
	}
}


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
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
//import net.lepidodendron.block.BlockPleuromeiaShootTopFlower;
//import net.lepidodendron.block.BlockPleuromeiaShootTopNoflower;
import java.util.Random;
import net.minecraft.entity.item.EntityItem;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.creativetab.TabLepidodendron;
import net.lepidodendron.LepidodendronConfig;
import net.lepidodendron.item.ItemGigantopteridSeeds;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraftforge.items.ItemHandlerHelper;

@ElementsLepidodendronMod.ModElement.Tag
public class BlockGigantopteridShootPlaceable extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:gigantopterid_shoot")
	public static final Block block = null;
	public BlockGigantopteridShootPlaceable(ElementsLepidodendronMod instance) {
		super(instance, 287);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("gigantopterid_shoot"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("lepidodendron:gigantopterid_shoot", "inventory"));
		ModelLoader.setCustomStateMapper(block, (new StateMap.Builder()).ignore(BlockLeaves.DECAYABLE, BlockLeaves.CHECK_DECAY).build());
	}

	public static final PropertyBool STEM = PropertyBool.create("stem");
    public static final PropertyBool TOP = PropertyBool.create("top");
    
	public static class BlockCustom extends BlockLeaves {
		public BlockCustom() {
			super();
			setTranslationKey("pf_gigantopterid_shoot");
			setSoundType(SoundType.PLANT);
			setHardness(0.2F);
			setResistance(0.2F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(TabLepidodendron.tab);
			this.setDefaultState(this.blockState.getBaseState().withProperty(STEM, false).withProperty(TOP, false).withProperty(CHECK_DECAY, false).withProperty(DECAYABLE, false));
		}

		@Override
		public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos){
			
	    	Block block = worldIn.getBlockState(pos.up()).getBlock();
	        
			boolean airtop = false;
			if (worldIn.isAirBlock(pos.up())) {
				airtop = true;
	    	}
			
	        return state.withProperty(STEM, Boolean.valueOf(block == this || block == BlockGigantopteridShoot.block || block == BlockGigantopteridLog.block)).withProperty(TOP, airtop);
	    }
	    
		@Override
		public BlockPlanks.EnumType getWoodType(int meta) {
			return null;
		}

		@Override
		public NonNullList<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
			return NonNullList.withSize(1, new ItemStack(BlockGigantopteridShootPlaceable.block, (int) (1)));
		}

		@Override
		protected net.minecraft.block.state.BlockStateContainer createBlockState() {
			return new net.minecraft.block.state.BlockStateContainer(this, new IProperty[]{CHECK_DECAY, DECAYABLE, STEM, TOP});
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
			return new ItemStack(BlockGigantopteridShootPlaceable.block, (int) (1));
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
			if (LepidodendronConfig.doSeeds) {
				// Drop air and use the seeds method instead:
				return new ItemStack(Blocks.AIR, (int) (1)).getItem();
			}
			else {
				return Item.getItemFromBlock(BlockGigantopteridSapling.block);
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
            return new ItemStack(BlockGigantopteridShootPlaceable.block, (int) (1));
        }
		
		@Override
		public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
	        return super.canPlaceBlockAt(worldIn, pos);
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

	    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	    {
        if ((!player.capabilities.allowEdit) || (!player.getHeldItemMainhand().isEmpty()) || !LepidodendronConfig.doSeeds)
	        {
	            return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
	        }
	        else {
	        	if (!((hand != player.getActiveHand()) && (hand == EnumHand.MAIN_HAND))) {
					if (Math.random() > 0.5) {
						ItemStack stackSeed = new ItemStack(ItemGigantopteridSeeds.block, (int) (1));
						stackSeed.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(player, stackSeed);
						if (Math.random() > 0.75) {
							world.destroyBlock(pos, false);
						}
						return true;
					}
					else {
						if (Math.random() > 0.75) {
							world.destroyBlock(pos, false);
		    				return true;
						}
					}	
				}
	        	return true;
	        }
	    }

	}
}


package net.lepidodendron.block;

import net.lepidodendron.LepidodendronConfig;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.NonNullList;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockBush;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.EntityPlayer;

import net.lepidodendron.procedure.ProcedureWorldGenWattieza;
import net.lepidodendron.creativetab.TabLepidodendron;
import net.lepidodendron.ElementsLepidodendronMod;

//import net.minecraft.init.Blocks;
import java.util.Random;
import java.util.List;
import net.minecraft.client.util.ITooltipFlag;

@ElementsLepidodendronMod.ModElement.Tag
public class BlockWattiezaSapling extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:wattieza_sapling")
	public static final Block block = null;
	public BlockWattiezaSapling(ElementsLepidodendronMod instance) {
		super(instance, 286);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("wattieza_sapling"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}
	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("lepidodendron:wattieza_sapling", "inventory"));
	}

	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);

	public static class BlockCustom extends BlockBush implements IGrowable {
		public BlockCustom() {
			super(Material.PLANTS);
			setSoundType(SoundType.PLANT);
			setCreativeTab(TabLepidodendron.tab);
			setHardness(0.2F);
        	setResistance(1F);
			setTranslationKey("wattieza_sapling");
			setDefaultState(this.blockState.getBaseState().withProperty(STAGE, Integer.valueOf(0)));
		}

		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	    {
	        return SAPLING_AABB;
	    }

		@Override
		public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	    {
	        if (!worldIn.isRemote)
	        {
	            super.updateTick(worldIn, pos, state, rand);
	
	            if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
	            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
	            {
	                this.grow(worldIn, rand, pos, state);
	            }
	        }
	    }

		public void grow(World world, Random rand, BlockPos pos, IBlockState state)
	    {
	        if (((Integer)state.getValue(STAGE)).intValue() == 0)
	        {
	            world.setBlockState(pos, state.cycleProperty(STAGE), 4);
	        }
	        else
	        {
	            int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					ProcedureWorldGenWattieza.executeProcedure($_dependencies);
				}
	        }
	    }
	    
		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			drops.add(new ItemStack(this));
		}

		@Override
		public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
			return new ItemStack(Item.getItemFromBlock(this), 1, this.damageDropped(state));
		}
		
		@Override
		public boolean canPlaceBlockAt(World world, BlockPos pos) {
			Block block2 = world.getBlockState(pos.down()).getBlock();
			return (((world.getBlockState(pos.down())).getMaterial() == Material.SAND && isReplaceable(world, pos)) || block2.canSustainPlant(world.getBlockState(pos.down()), world, pos.down(), EnumFacing.UP, this) || block2 == null);
		}

		@Override
		public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
			Block block2 = worldIn.getBlockState(pos.down()).getBlock();
			return ((worldIn.getBlockState(pos.down())).getMaterial() == Material.SAND || block2.canSustainPlant(worldIn.getBlockState(pos.down()), worldIn, pos.down(), EnumFacing.UP, this));
	    }

		public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
		{
		    return true;
		}
			
		public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
		{
		    return (double)worldIn.rand.nextFloat() < 0.45D;
		}

		public IBlockState getStateFromMeta(int meta)
	    {
	        return this.getDefaultState().withProperty(STAGE, Integer.valueOf(meta));
	    }
		
		public int getMetaFromState(IBlockState state)
	    {
	        int i = 0;
	        i = i | ((Integer)state.getValue(STAGE)).intValue();
	        return i;
	    }
	
		protected BlockStateContainer createBlockState()
	    {
	        return new BlockStateContainer(this, new IProperty[] {STAGE});
	    }   

	    @SideOnly(Side.CLIENT)
		@Override
	    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
	        if (LepidodendronConfig.showTooltips) {
				tooltip.add("Type: Proto-tree");
				tooltip.add("Periods: mid Devonian");
				tooltip.add("Propagation: spores");}
	        super.addInformation(stack, player, tooltip, advanced);
	    }
	}
}

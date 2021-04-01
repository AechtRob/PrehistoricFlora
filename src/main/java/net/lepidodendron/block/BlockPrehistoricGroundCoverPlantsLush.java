
package net.lepidodendron.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.block.BlockBush;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;
import javax.annotation.Nullable;

import net.lepidodendron.creativetab.TabLepidodendron;
import net.lepidodendron.ElementsLepidodendronMod;

import java.util.List;
import net.minecraft.client.util.ITooltipFlag;

@ElementsLepidodendronMod.ModElement.Tag
public class BlockPrehistoricGroundCoverPlantsLush extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:prehistoric_ground_cover_plants_lush")
	public static final Block block = null;
	public BlockPrehistoricGroundCoverPlantsLush(ElementsLepidodendronMod instance) {
		super(instance, 1012);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("prehistoric_ground_cover_plants_lush"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("lepidodendron:prehistoric_ground_cover_plants_lush", "inventory"));
	}
	public static class BlockCustom extends BlockBush implements net.minecraftforge.common.IShearable {
		public BlockCustom() {
			super(Material.PLANTS);
			setTranslationKey("prehistoric_ground_cover_plants_lush");
			setSoundType(SoundType.PLANT);
			setHardness(0F);
			setResistance(0F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(TabLepidodendron.tab);
		}

		@Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	    {
	        return new AxisAlignedBB(0.0D, 0.0D, 0D, 1.0D, 0.3D, 1.0D);
	    }
	
	    @Nullable
	    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
	    {
	        return NULL_AABB;
	    }

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			drops.add(new ItemStack(Blocks.AIR, (int) (1)));
		}

		@Override public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos){ return true; }
		
		@Override
		public NonNullList<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
			return NonNullList.withSize(1, new ItemStack(this, (int) (1)));
		}
	    
	    @Override
		protected boolean canSilkHarvest()
	    {
	        return false;
	    }

	    @Override
	    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
	    {
	        return net.minecraftforge.common.EnumPlantType.Plains;
	    }

		@Override
	    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
	    {
	        return super.canBlockStay(worldIn, pos, state);
	    }

		@Override
	    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos)
	    {
	        return true;
	    }

	    @SideOnly(Side.CLIENT)
		@Override
	    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
	        tooltip.add("Provides a randomised ground-cover texture");
	        super.addInformation(stack, player, tooltip, advanced);
	    }

		@Override
	    public Block.EnumOffsetType getOffsetType()
	    {
	        return Block.EnumOffsetType.XZ;
	    }

	}
}

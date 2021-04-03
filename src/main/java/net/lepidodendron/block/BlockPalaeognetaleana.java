
package net.lepidodendron.block;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.LepidodendronConfig;
import net.lepidodendron.creativetab.TabLepidodendron;
import net.lepidodendron.item.ItemCallistophytalesSeeds;
import net.lepidodendron.item.ItemEphedraFruit;
import net.lepidodendron.item.ItemPalaeognetaleanaFruit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemHandlerHelper;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BlockPalaeognetaleana extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:palaeognetaleana")
	public static final Block block = null;
	public BlockPalaeognetaleana(ElementsLepidodendronMod instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("palaeognetaleana"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	public static final PropertyBool UP = PropertyBool.create("up");
    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");
    
	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("lepidodendron:palaeognetaleana", "inventory"));
	}
	public static class BlockCustom extends BlockVine {
		public BlockCustom() {
			//super(Material.VINE);
			setSoundType(SoundType.PLANT);
			setTranslationKey("palaeognetaleana");
			setDefaultState(this.blockState.getBaseState().withProperty(UP, Boolean.valueOf(false)).withProperty(NORTH, Boolean.valueOf(false)).withProperty(EAST, Boolean.valueOf(false)).withProperty(SOUTH, Boolean.valueOf(false)).withProperty(WEST, Boolean.valueOf(false)));
        	setTickRandomly(true);
			setCreativeTab(TabLepidodendron.tab);
		}

		protected BlockStateContainer createBlockState()
	    {
	        return new BlockStateContainer(this, new IProperty[] {UP, NORTH, EAST, SOUTH, WEST});
	    }

	    @Override
	   	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos)
	    { 
	    	return false;
	    	//if (LepidodendronConfig.doSpores) {
	    	//	return false;
	    	//}
	    	//else {return true; }
	    }

		@Override
		public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
	    {
	        if (!LepidodendronConfig.doFruits && !worldIn.isRemote && stack.getItem() == Items.SHEARS)
	        {
	            player.addStat(StatList.getBlockStats(this));
	            spawnAsEntity(worldIn, pos, new ItemStack(this, 1, 0));
	        }
	        else {
	        	if (!LepidodendronConfig.doFruits) {
	           		super.harvestBlock(worldIn, player, pos, state, te, stack);
	        	}
	        	else {
					spawnAsEntity(worldIn, pos, new ItemStack(ItemPalaeognetaleanaFruit.block, 1, 0));
				}
	        }
	    }

	    @Override
		protected boolean canSilkHarvest()
	    { 
	    	if (LepidodendronConfig.doFruits) {
	    		return false;
	    	}
	    	else {return true; }
	    }

	    @SideOnly(Side.CLIENT)
		@Override
	    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
	        if (LepidodendronConfig.showTooltips) {
				tooltip.add("Type: Gnetale vine");
				tooltip.add("Periods: Permian [- Triassic - Jurassic - Cretaceous - Paleogene - Neogene - Quaternary]");
				tooltip.add("Propagation: fruit/cone");}
	        super.addInformation(stack, player, tooltip, advanced);
	    }

	}
}


package net.lepidodendron.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.lepidodendron.creativetab.TabLepidodendron;
import net.lepidodendron.ElementsLepidodendronMod;

@ElementsLepidodendronMod.ModElement.Tag
public class BlockDominicanAmberBricks extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:dominican_amber_bricks")
	public static final Block block = null;
	public BlockDominicanAmberBricks(ElementsLepidodendronMod instance) {
		super(instance, 479);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("dominican_amber_bricks"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("lepidodendron:dominican_amber_bricks", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setTranslationKey("dominican_amber_bricks");
			setSoundType(SoundType.STONE);
			setHarvestLevel("pickaxe", 1);
			setHardness(8F);
			setResistance(3F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabLepidodendron.tab);
		}

		//@Override
		//public int tickRate(World world) {
		//	return 0;
		//}

		//@Override
		//public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		//	return 5;
		//}

		@Override
		public MapColor getMapColor(IBlockState state, IBlockAccess blockAccess, BlockPos pos) {
			return MapColor.STONE;
		}
	}
}

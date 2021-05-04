
package net.lepidodendron.block;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.creativetab.TabLepidodendron;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@ElementsLepidodendronMod.ModElement.Tag
public class BlockVolcanicAshDark extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:volcanic_ash_dark")
	public static final Block block = null;
	public BlockVolcanicAshDark(ElementsLepidodendronMod instance) {
		super(instance, 526);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("volcanic_ash_dark"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("lepidodendron:volcanic_ash_dark", "inventory"));
	}
	
	public static class BlockCustom extends BlockFalling {
		public BlockCustom() {
			super(Material.SAND);
			this.setSoundType(SoundType.SAND);
			setHardness(0.2F);
			setResistance(0.2F);
			setHarvestLevel("shovel", 0);
			setTranslationKey("pf_volcanic_ash_dark");
			setCreativeTab(TabLepidodendron.tab);
		}
	    
	}
}

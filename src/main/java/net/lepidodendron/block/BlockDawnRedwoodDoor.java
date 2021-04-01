
package net.lepidodendron.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.entity.player.EntityPlayer;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.item.ItemDawnRedwoodDoorItem;

@ElementsLepidodendronMod.ModElement.Tag
public class BlockDawnRedwoodDoor extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:dawn_redwood_door")
	public static final Block block = null;
	public BlockDawnRedwoodDoor(ElementsLepidodendronMod instance) {
		super(instance, 1375);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("dawn_redwood_door"));
		//elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		//ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
		//		new ModelResourceLocation("lepidodendron:lepidodendron_door", "inventory"));
		ModelLoader.setCustomStateMapper(block, (new StateMap.Builder()).ignore(BlockCustom.POWERED).build());
	}
	
	public static class BlockCustom extends BlockDoor {
		public BlockCustom() {
			super(Material.WOOD);
			//setTranslationKey("dawn_redwood_door");
			setSoundType(SoundType.WOOD);
			setHarvestLevel("axe", 1);
			setHardness(3F);
			setResistance(3F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(null);
		}

		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}

		@Override
		public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	    {
	        return new ItemStack(ItemDawnRedwoodDoorItem.block, (int) (1));
	    }

		@Override
	    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
	    {
	        return new ItemStack(ItemDawnRedwoodDoorItem.block, (int) (1));
	    }

		@Override
	    public String getTranslationKey()
	    {
	        return "tile.dawn_redwood_door.name";
	    }

		@Override
	    public String getLocalizedName()
   	 	{
        	return I18n.translateToLocal("item.dawn_redwood_door_item.name");
    	}
    	
		@Override
		public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    {
	        return state.getValue(HALF) == BlockCustom.EnumDoorHalf.UPPER ? Items.AIR : (new ItemStack(ItemDawnRedwoodDoorItem.block, (int) (1))).getItem();
	    }

	}
}
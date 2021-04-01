package net.lepidodendron.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;

import net.lepidodendron.block.BlockMagnoliaLeaves;
import net.lepidodendron.ElementsLepidodendronMod;

import java.util.Map;

@ElementsLepidodendronMod.ModElement.Tag
public class ProcedureMagnoliaFlowerNeighbourBlockChanges extends ElementsLepidodendronMod.ModElement {
	public ProcedureMagnoliaFlowerNeighbourBlockChanges(ElementsLepidodendronMod instance) {
		super(instance, 73);
	}

		public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MagnoliaFlowerNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MagnoliaFlowerNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MagnoliaFlowerNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MagnoliaFlowerNeighbourBlockChanges!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BlockMagnoliaLeaves.block.getDefaultState()
				.getBlock())) && ((new Object() {
					public boolean getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getBoolean(tag);
						return false;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "decayable")) == (true)))) {
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
		}
	}
}

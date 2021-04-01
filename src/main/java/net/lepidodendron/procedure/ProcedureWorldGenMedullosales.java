package net.lepidodendron.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.Block;

import net.lepidodendron.block.BlockMedullosalesShoot;
import net.lepidodendron.block.BlockMedullosalesLog;
import net.lepidodendron.ElementsLepidodendronMod;

@ElementsLepidodendronMod.ModElement.Tag
public class ProcedureWorldGenMedullosales extends ElementsLepidodendronMod.ModElement {
	public ProcedureWorldGenMedullosales(ElementsLepidodendronMod instance) {
		super(instance, 42);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WorldGenMedullosales!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WorldGenMedullosales!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WorldGenMedullosales!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WorldGenMedullosales!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double TrunkHeight = 0;
		double counter = 0;
		
		if ((world.canSeeSky(new BlockPos((int) x, (int) y, (int) z)))
			) {			
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
			
			//Trunk:
			if (Math.random() > 0.3) {
				TrunkHeight = 1 + Math.round(Math.random() * 7);
			}
			else {
				TrunkHeight = 1 + Math.round(Math.random() * 2);
			}

			counter = 0;
			while (counter <= TrunkHeight) {
				ProcedureTreeLog.executeProcedure((int) x, (int) (y + counter), (int) z, world, BlockMedullosalesLog.block, EnumFacing.DOWN);
				counter = counter + 1;
				}

			Block block = world.getBlockState(new BlockPos((int) x, (int) (y + counter), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) (y + counter), (int) z)), world, new BlockPos((int) x, (int) (y + counter), (int) z))) {
				world.setBlockState(new BlockPos((int) x, (int) (y + counter), (int) z), BlockMedullosalesShoot.block.getDefaultState(), 3);
			}
		}
			
	}
}
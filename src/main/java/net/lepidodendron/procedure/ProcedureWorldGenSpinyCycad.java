package net.lepidodendron.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.Block;

import net.lepidodendron.block.BlockSpinyCycadShootTop;
import net.lepidodendron.block.BlockSpinyCycadShoot;
import net.lepidodendron.block.BlockSpinyCycadShootPlaceable;
import net.lepidodendron.block.BlockSpinyCycadLog;
import net.lepidodendron.ElementsLepidodendronMod;

@ElementsLepidodendronMod.ModElement.Tag
public class ProcedureWorldGenSpinyCycad extends ElementsLepidodendronMod.ModElement {
	public ProcedureWorldGenSpinyCycad(ElementsLepidodendronMod instance) {
		super(instance, 42);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WorldGenSpinyCycad!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WorldGenSpinyCycad!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WorldGenSpinyCycad!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WorldGenSpinyCycad!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double TrunkHeight = 0;
		double counter = 0;
		double randomiser = 0;
		
		if ((world.canSeeSky(new BlockPos((int) x, (int) y, (int) z)))
			) {			
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
			
			//Trunk:
			TrunkHeight = Math.round(Math.random());

			counter = 0;
			while (counter < TrunkHeight) {
				ProcedureTreeLog.executeProcedure((int) x, (int) (y + counter), (int) z, world, BlockSpinyCycadLog.block, EnumFacing.DOWN);
				counter = counter + 1;
				}

			//Shoots:
			if (TrunkHeight < 1) {
				Block block = world.getBlockState(new BlockPos((int) x, (int) (y + counter), (int) z)).getBlock();
				if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) (y + counter), (int) z)), world, new BlockPos((int) x, (int) (y + counter), (int) z))) {
					block = world.getBlockState(new BlockPos((int) x, (int) (y + counter + 1), (int) z)).getBlock();
					if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) (y + counter + 1), (int) z)), world, new BlockPos((int) x, (int) (y + counter + 1), (int) z))) {
						world.setBlockState(new BlockPos((int) x, (int) (y + counter), (int) z), BlockSpinyCycadShootPlaceable.block.getDefaultState(), 3);
						world.setBlockState(new BlockPos((int) x, (int) (y + counter + 1), (int) z), BlockSpinyCycadShootTop.block.getDefaultState(), 3);
					}
				}
			}

			if (TrunkHeight == 1) {
				Block block = world.getBlockState(new BlockPos((int) x, (int) (y + counter), (int) z)).getBlock();
				if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) (y + counter), (int) z)), world, new BlockPos((int) x, (int) (y + counter), (int) z))) {
					block = world.getBlockState(new BlockPos((int) x, (int) (y + counter + 1), (int) z)).getBlock();
					if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) (y + counter + 1), (int) z)), world, new BlockPos((int) x, (int) (y + counter + 1), (int) z))) {
						world.setBlockState(new BlockPos((int) x, (int) (y + counter), (int) z), BlockSpinyCycadShoot.block.getDefaultState(), 3);
						world.setBlockState(new BlockPos((int) x, (int) (y + counter + 1), (int) z), BlockSpinyCycadShootTop.block.getDefaultState(), 3);
					}
				}
			}
		}	
	}
}
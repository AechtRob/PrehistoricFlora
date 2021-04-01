package net.lepidodendron.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.Block;

import net.lepidodendron.block.BlockDicksoniaLeaves2;
import net.lepidodendron.block.BlockDicksoniaLeaves3;
import net.lepidodendron.block.BlockDicksoniaLeaves4;
import net.lepidodendron.block.BlockDicksoniaLeaves;
import net.lepidodendron.block.BlockDicksoniaLog;
import net.lepidodendron.ElementsLepidodendronMod;

@ElementsLepidodendronMod.ModElement.Tag
public class ProcedureWorldGenDicksonia extends ElementsLepidodendronMod.ModElement {
	public ProcedureWorldGenDicksonia(ElementsLepidodendronMod instance) {
		super(instance, 42);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WorldGenDicksonia!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WorldGenDicksonia!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WorldGenDicksonia!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WorldGenDicksonia!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		int xx = x;
		int yy = y;
		int zz = z;
		World world = (World) dependencies.get("world");
		int TrunkHeight = 0;
		double counter = 0;
		Boolean TreeCheck = true;
		
		if ((world.canSeeSky(new BlockPos((int) x, (int) y, (int) z)))
			) {			
			
			//Trunk:
			TrunkHeight = 3 + (int) Math.round(Math.random() * 6);
			//Check there is room:
			counter = -4;
			while (counter <= 4 && TreeCheck) {
				if (!world.isAirBlock(new BlockPos((int) x + counter, (int) y + TrunkHeight, (int) z))) TreeCheck = false;
				counter = counter + 1;
			}
			counter = -4;
			while (counter <= 4 && TreeCheck) {
				if (!world.isAirBlock(new BlockPos((int) x, (int) y + TrunkHeight, (int) z + counter))) TreeCheck = false;
				counter = counter + 1;
			}
			
			if (!TreeCheck) return;
			
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));

			counter = 0;
			while (counter <= TrunkHeight) {
				ProcedureTreeLog.executeProcedure((int) x, (int) (y + counter), (int) z, world, BlockDicksoniaLog.block, EnumFacing.DOWN);
				counter = counter + 1;
				}

			ProcedureTreeLog.executeProcedure((int) x, (int) (y + TrunkHeight + 1), (int) z, world, BlockDicksoniaLeaves.block, EnumFacing.UP);

			ProcedureTreeLog.executeProcedure((int) x, (int) (y + TrunkHeight), (int) z - 1, world, BlockDicksoniaLeaves.block, EnumFacing.NORTH);
			ProcedureTreeLog.executeProcedure((int) x, (int) (y + TrunkHeight), (int) z - 2, world, BlockDicksoniaLeaves2.block, EnumFacing.NORTH);
			ProcedureTreeLog.executeProcedure((int) x, (int) (y + TrunkHeight), (int) z - 3, world, BlockDicksoniaLeaves3.block, EnumFacing.NORTH);
			ProcedureTreeLog.executeProcedure((int) x, (int) (y + TrunkHeight), (int) z - 4, world, BlockDicksoniaLeaves4.block, EnumFacing.NORTH);

			ProcedureTreeLog.executeProcedure((int) x, (int) (y + TrunkHeight), (int) z + 1, world, BlockDicksoniaLeaves.block, EnumFacing.SOUTH);
			ProcedureTreeLog.executeProcedure((int) x, (int) (y + TrunkHeight), (int) z + 2, world, BlockDicksoniaLeaves2.block, EnumFacing.SOUTH);
			ProcedureTreeLog.executeProcedure((int) x, (int) (y + TrunkHeight), (int) z + 3, world, BlockDicksoniaLeaves3.block, EnumFacing.SOUTH);
			ProcedureTreeLog.executeProcedure((int) x, (int) (y + TrunkHeight), (int) z + 4, world, BlockDicksoniaLeaves4.block, EnumFacing.SOUTH);

			ProcedureTreeLog.executeProcedure((int) x - 1, (int) (y + TrunkHeight), (int) z, world, BlockDicksoniaLeaves.block, EnumFacing.WEST);
			ProcedureTreeLog.executeProcedure((int) x - 2, (int) (y + TrunkHeight), (int) z, world, BlockDicksoniaLeaves2.block, EnumFacing.WEST);
			ProcedureTreeLog.executeProcedure((int) x - 3, (int) (y + TrunkHeight), (int) z, world, BlockDicksoniaLeaves3.block, EnumFacing.WEST);
			ProcedureTreeLog.executeProcedure((int) x - 4, (int) (y + TrunkHeight), (int) z, world, BlockDicksoniaLeaves4.block, EnumFacing.WEST);

			ProcedureTreeLog.executeProcedure((int) x + 1, (int) (y + TrunkHeight), (int) z, world, BlockDicksoniaLeaves.block, EnumFacing.EAST);
			ProcedureTreeLog.executeProcedure((int) x + 2, (int) (y + TrunkHeight), (int) z, world, BlockDicksoniaLeaves2.block, EnumFacing.EAST);
			ProcedureTreeLog.executeProcedure((int) x + 3, (int) (y + TrunkHeight), (int) z, world, BlockDicksoniaLeaves3.block, EnumFacing.EAST);
			ProcedureTreeLog.executeProcedure((int) x + 4, (int) (y + TrunkHeight), (int) z, world, BlockDicksoniaLeaves4.block, EnumFacing.EAST);

		}
	
	}	
}
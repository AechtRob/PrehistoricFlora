package net.lepidodendron.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.BlockHorizontal;

import net.lepidodendron.block.BlockWattiezaLog;
import net.lepidodendron.block.BlockWattiezaShoot;
import net.lepidodendron.block.BlockWattiezaShoot02;
import net.lepidodendron.block.BlockWattiezaShoot03;
import net.lepidodendron.block.BlockWattiezaShootSide02;
import net.lepidodendron.block.BlockWattiezaShootSide03;
import net.lepidodendron.ElementsLepidodendronMod;

@ElementsLepidodendronMod.ModElement.Tag
public class ProcedureWorldGenWattieza extends ElementsLepidodendronMod.ModElement {
	public ProcedureWorldGenWattieza(ElementsLepidodendronMod instance) {
		super(instance, 42);
	}

	public static final PropertyDirection FACING = BlockHorizontal.FACING;

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WorldGenWattieza!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WorldGenWattieza!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WorldGenWattieza!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WorldGenWattieza!");
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
		boolean TreeCheck = true;
		
		if ((world.canSeeSky(new BlockPos((int) x, (int) y, (int) z)))
			) {			

			//Trunk:
			TrunkHeight = 5 + (int) Math.round(Math.random() * 4);

			//Check there is space:
			counter = -3;
			while (counter <= 3 && TreeCheck) {
				if (!world.isAirBlock(new BlockPos((int) x + counter, (int) y + TrunkHeight + 2, (int) z))) TreeCheck = false;
				counter = counter + 1;
			}
			counter = -3;
			while (counter <= 3 && TreeCheck) {
				if (!world.isAirBlock(new BlockPos((int) x, (int) y + TrunkHeight + 2, (int) z + counter))) TreeCheck = false;
				counter = counter + 1;
			}
			counter = -3;
			while (counter <= 3 && TreeCheck) {
				if (!world.isAirBlock(new BlockPos((int) x + counter, (int) y + TrunkHeight + 3, (int) z))) TreeCheck = false;
				counter = counter + 1;
			}
			counter = -3;
			while (counter <= 3 && TreeCheck) {
				if (!world.isAirBlock(new BlockPos((int) x, (int) y + TrunkHeight + 3, (int) z + counter))) TreeCheck = false;
				counter = counter + 1;
			}
			
			if (!TreeCheck) return;
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));

			counter = 0;
			while (counter <= TrunkHeight) {
				xx = x;
				yy = y + (int) counter;
				zz = z;
				ProcedureTreeLog.executeProcedure((int) xx, (int) yy, (int) zz, world, BlockWattiezaLog.block, EnumFacing.UP);
				
				counter = counter + 1;
			}

			//Place the crown:
			xx = x;
			yy = y + TrunkHeight + 1;
			zz = z;
			world.setBlockState(new BlockPos((int) xx, (int) yy, (int) zz), BlockWattiezaShoot.block.getDefaultState(), 3);

			xx = x;
			yy = y + TrunkHeight + 2;
			zz = z;
			world.setBlockState(new BlockPos((int) xx, (int) yy, (int) zz), BlockWattiezaShoot02.block.getDefaultState(), 3);

			xx = x;
			yy = y + TrunkHeight + 3;
			zz = z;
			world.setBlockState(new BlockPos((int) xx, (int) yy, (int) zz), BlockWattiezaShoot03.block.getDefaultState(), 3);

			xx = x - 2;
			yy = y + TrunkHeight + 2;
			zz = z;
			world.setBlockState(new BlockPos((int) xx, (int) yy, (int) zz), BlockWattiezaShootSide02.block.getDefaultState().withProperty(FACING, EnumFacing.WEST), 3);

			xx = x + 2;
			yy = y + TrunkHeight + 2;
			zz = z;
			world.setBlockState(new BlockPos((int) xx, (int) yy, (int) zz), BlockWattiezaShootSide02.block.getDefaultState().withProperty(FACING, EnumFacing.EAST), 3);
			
			xx = x;
			yy = y + TrunkHeight + 2;
			zz = z + 2;
			world.setBlockState(new BlockPos((int) xx, (int) yy, (int) zz), BlockWattiezaShootSide02.block.getDefaultState().withProperty(FACING, EnumFacing.SOUTH), 3);
			
			xx = x;
			yy = y + TrunkHeight + 2;
			zz = z - 2;
			world.setBlockState(new BlockPos((int) xx, (int) yy, (int) zz), BlockWattiezaShootSide02.block.getDefaultState().withProperty(FACING, EnumFacing.NORTH), 3);

			xx = x - 2;
			yy = y + TrunkHeight + 3;
			zz = z;
			world.setBlockState(new BlockPos((int) xx, (int) yy, (int) zz), BlockWattiezaShootSide03.block.getDefaultState().withProperty(FACING, EnumFacing.WEST), 3);

			xx = x + 2;
			yy = y + TrunkHeight + 3;
			zz = z;
			world.setBlockState(new BlockPos((int) xx, (int) yy, (int) zz), BlockWattiezaShootSide03.block.getDefaultState().withProperty(FACING, EnumFacing.EAST), 3);
			
			xx = x;
			yy = y + TrunkHeight + 3;
			zz = z + 2;
			world.setBlockState(new BlockPos((int) xx, (int) yy, (int) zz), BlockWattiezaShootSide03.block.getDefaultState().withProperty(FACING, EnumFacing.SOUTH), 3);
			
			xx = x;
			yy = y + TrunkHeight + 3;
			zz = z - 2;
			world.setBlockState(new BlockPos((int) xx, (int) yy, (int) zz), BlockWattiezaShootSide03.block.getDefaultState().withProperty(FACING, EnumFacing.NORTH), 3);

		}
	}

}
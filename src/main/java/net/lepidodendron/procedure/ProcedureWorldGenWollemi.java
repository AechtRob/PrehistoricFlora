package net.lepidodendron.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;

import net.lepidodendron.block.BlockWollemiLeaves;
import net.lepidodendron.block.BlockWollemiLog;
import net.lepidodendron.ElementsLepidodendronMod;

import net.minecraft.tileentity.TileEntity;


@ElementsLepidodendronMod.ModElement.Tag
public class ProcedureWorldGenWollemi extends ElementsLepidodendronMod.ModElement {
	public ProcedureWorldGenWollemi(ElementsLepidodendronMod instance) {
		super(instance, 42);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WorldGenWollemi!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WorldGenWollemi!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WorldGenWollemi!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WorldGenWollemi!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		int xx = (int) dependencies.get("x");
		int yy = (int) dependencies.get("y");
		int zz = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double TrunkHeight = 0;
		double counter = 0;
		if ((world.canSeeSky(new BlockPos((int) x, (int) y, (int) z)))
			) {			
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
			
			//Trunk:
			TrunkHeight = 10;
			TrunkHeight = TrunkHeight + Math.round(Math.random() * (Math.round((Math.random() * 100) / 5)));

			counter = 0;
			while (counter <= TrunkHeight) {
				ProcedureTreeLog.executeProcedure(x, (int) (y + counter), z, world, BlockWollemiLog.block, EnumFacing.NORTH);
				counter = counter + 1;
				}
			
		//And now branches:
		xx = x;
		yy = y + (int) TrunkHeight + 1;
		zz = z;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
		xx = x;
		yy = yy + 1;
		zz = z;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
		xx = x;
		yy = yy + 1;
		zz = z;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
		
		xx = x + 1;
		yy = y + (int) TrunkHeight + 1;
		zz = z;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
		xx = x - 1;
		yy = y + (int) TrunkHeight + 1;
		zz = z;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
		xx = x;
		yy = y + (int) TrunkHeight + 1;
		zz = z + 1;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
		xx = x;
		yy = y + (int) TrunkHeight + 1;
		zz = z - 1;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);

		counter = (int) TrunkHeight + y;
		
		while (counter >= y + 2) {
			//Top of tree:
			if (((counter - y) / TrunkHeight) >= 0.8) {				
				xx = x + 1;
				yy = (int) counter;
				zz = z;
				ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
				xx = x + 2;
				yy = (int) counter;
				zz = z;
				ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
				xx = x - 1;
				yy = (int) counter;
				zz = z;
				ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
				xx = x - 2;
				yy = (int) counter;
				zz = z;
				ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);

				xx = x;
				yy = (int) counter;
				zz = z + 1;
				ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
				xx = x;
				yy = (int) counter;
				zz = z + 2;
				ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
				xx = x;
				yy = (int) counter;
				zz = z - 1;
				ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
				xx = x;
				yy = (int) counter;
				zz = z - 2;
				ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
				counter = counter - 2;
			}

			else {
				//Next chunk of tree:				
				if (((counter - y) / TrunkHeight) >= 0.3) {
					xx = x + 1;
					yy = (int) counter;
					zz = z;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x + 2;
					yy = (int) counter;
					zz = z;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x - 1;
					yy = (int) counter;
					zz = z;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x - 2;
					yy = (int) counter;
					zz = z;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
	
					xx = x;
					yy = (int) counter;
					zz = z + 1;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x;
					yy = (int) counter;
					zz = z + 2;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x;
					yy = (int) counter;
					zz = z - 1;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x;
					yy = (int) counter;
					zz = z - 2;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					
					xx = x + 2;
					yy = (int) counter - 1;
					zz = z;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x + 3;
					yy = (int) counter - 1;
					zz = z;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x - 2;
					yy = (int) counter - 1;
					zz = z;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x - 3;
					yy = (int) counter - 1;
					zz = z;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
	
					xx = x;
					yy = (int) counter - 1;
					zz = z + 2;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x;
					yy = (int) counter - 1;
					zz = z + 3;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x;
					yy = (int) counter - 1;
					zz = z - 2;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x;
					yy = (int) counter - 1;
					zz = z - 3;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
	
					xx = x + 1;
					yy = (int) counter - 2;
					zz = z;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x - 1;
					yy = (int) counter - 2;
					zz = z;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x;
					yy = (int) counter - 2;
					zz = z + 1;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x;
					yy = (int) counter - 2;
					zz = z - 1;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
	
					counter = counter - 3;
				}

				else {
					//Lower part of tree:
					xx = x + 1;
					yy = (int) counter;
					zz = z;
					ProcedureTreeLog.executeProcedure(xx, yy, zz, world, BlockWollemiLog.block, EnumFacing.UP);
						
					xx = x + 2;
					yy = (int) counter;
					zz = z;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x + 3;
					yy = (int) counter;
					zz = z;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x - 1;
					yy = (int) counter;
					zz = z;
					ProcedureTreeLog.executeProcedure(xx, yy, zz, world, BlockWollemiLog.block, EnumFacing.UP);
					xx = x - 2;
					yy = (int) counter;
					zz = z;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x - 3;
					yy = (int) counter;
					zz = z;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);

					xx = x;
					yy = (int) counter;
					zz = z + 1;
					ProcedureTreeLog.executeProcedure(xx, yy, zz, world, BlockWollemiLog.block, EnumFacing.WEST);
					xx = x;
					yy = (int) counter;
					zz = z + 2;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x;
					yy = (int) counter;
					zz = z + 3;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x;
					yy = (int) counter;
					zz = z - 1;
					ProcedureTreeLog.executeProcedure(xx, yy, zz, world, BlockWollemiLog.block, EnumFacing.WEST);
					xx = x;
					yy = (int) counter;
					zz = z - 2;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x;
					yy = (int) counter;
					zz = z - 3;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
						
					xx = x + 3;
					yy = (int) counter - 1;
					zz = z;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x + 4;
					yy = (int) counter - 1;
					zz = z;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x - 3;
					yy = (int) counter - 1;
					zz = z;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x - 4;
					yy = (int) counter - 1;
					zz = z;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);

					xx = x;
					yy = (int) counter - 1;
					zz = z + 3;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x;
					yy = (int) counter - 1;
					zz = z + 4;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x;
					yy = (int) counter - 1;
					zz = z - 3;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x;
					yy = (int) counter - 1;
					zz = z - 4;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);

					xx = x + 1;
					yy = (int) counter;
					zz = z + 1;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x + 1;
					yy = (int) counter;
					zz = z - 1;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x - 1;
					yy = (int) counter;
					zz = z + 1;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					xx = x - 1;
					yy = (int) counter;
					zz = z - 1;
					ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);


					if ((counter - y) > 4) {
						xx = x + 1;
						yy = (int) counter - 2;
						zz = z;
						ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
						xx = x - 1;
						yy = (int) counter - 2;
						zz = z;
						ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
						xx = x;
						yy = (int) counter - 2;
						zz = z + 1;
						ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
						xx = x;
						yy = (int) counter - 2;
						zz = z - 1;
						ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
					}
					
					counter = counter - 3;
				}
			}

		}

		//Now the tree is built, flesh out that bottom-most layer with a few more leaves:
		counter = counter + 3;
		xx = x + 1;
		yy = (int) counter;
		zz = z + 2;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
			
		xx = x - 1;
		yy = (int) counter;
		zz = z + 2;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
			
		xx = x + 1;
		yy = (int) counter;
		zz = z - 2;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
			
		xx = x - 1;
		yy = (int) counter;
		zz = z - 2;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);


		xx = x + 2;
		yy = (int) counter;
		zz = z + 1;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
			
		xx = x - 2;
		yy = (int) counter;
		zz = z + 1;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
			
		xx = x + 2;
		yy = (int) counter;
		zz = z - 1;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
			
		xx = x - 2;
		yy = (int) counter;
		zz = z - 1;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);

		xx = x + 1;
		yy = (int) counter + 2;
		zz = z;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
		xx = x - 1;
		yy = (int) counter + 2;
		zz = z;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
		xx = x;
		yy = (int) counter + 2;
		zz = z + 1;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
		xx = x;
		yy = (int) counter + 2;
		zz = z - 1;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);

		xx = x + 1;
		yy = (int) counter + 1;
		zz = z + 1;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
		xx = x - 1;
		yy = (int) counter + 1;
		zz = z + 1;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
		xx = x - 1;
		yy = (int) counter + 1;
		zz = z + 1;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
		xx = x + 1;
		yy = (int) counter + 1;
		zz = z - 1;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);

		xx = x;
		yy = (int) counter + 1;
		zz = z +2;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
		xx = x;
		yy = (int) counter + 1;
		zz = z - 2;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
		xx = x + 2;
		yy = (int) counter + 1;
		zz = z;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);
		xx = x - 2;
		yy = (int) counter + 1;
		zz = z;
		ProcedureTreeLeaf.executeProcedure(xx, yy, zz, world, BlockWollemiLeaves.block);

		}			
	}
}
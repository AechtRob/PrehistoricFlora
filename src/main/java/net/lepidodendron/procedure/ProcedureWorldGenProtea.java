package net.lepidodendron.procedure;


import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;

import net.lepidodendron.ElementsLepidodendronMod;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.BlockDirectional;

import net.minecraft.tileentity.TileEntity;
import net.lepidodendron.block.BlockProteaLeaves;


@ElementsLepidodendronMod.ModElement.Tag
public class ProcedureWorldGenProtea extends ElementsLepidodendronMod.ModElement {
	public ProcedureWorldGenProtea(ElementsLepidodendronMod instance) {
		super(instance, 42);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WorldGenProtea!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WorldGenProtea!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WorldGenProtea!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WorldGenProtea!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double TreeHeight = 0;
		double counter = 0;
		int randomiser;
		int counter2 = 0;
		
		if ((world.canSeeSky(new BlockPos((int) x, (int) y, (int) z)))
			) {			
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));

			if (Math.random() > 0.8) {
				//Tree height: 2-5 blocks
				TreeHeight = 2 + Math.round(Math.random() * 3);
				counter2 = 0;
				randomiser = (int) (Math.random() * 2) + 1;
				while (counter2 <= randomiser) {
					ProcedureTreeLog.executeProcedure((int) x, (int) y, (int) z + counter2, world, BlockProteaLeaves.block, EnumFacing.NORTH);
					counter2 = counter2 + 1;
				}
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y + 1);
				$_dependencies.put("z", z + randomiser);
				$_dependencies.put("world", world);
				$_dependencies.put("TreeHeight", TreeHeight);
				$_dependencies.put("counter", counter);
				ProcedureWorldGenProteaBranch.executeProcedure($_dependencies);
			}

			if (Math.random() > 0.8) {
				//Tree height: 2-4 blocks
				TreeHeight = 2 + Math.round(Math.random() * 3);
				counter2 = 0;
				randomiser = (int) (Math.random() * 2) + 1;
				while (counter2 <= randomiser) {
					ProcedureTreeLog.executeProcedure((int) x, (int) y, (int) z - counter2, world, BlockProteaLeaves.block, EnumFacing.NORTH);
					counter2 = counter2 + 1;
				}
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y + 1);
				$_dependencies.put("z", z - randomiser);
				$_dependencies.put("world", world);
				$_dependencies.put("TreeHeight", TreeHeight);
				$_dependencies.put("counter", counter);
				ProcedureWorldGenProteaBranch.executeProcedure($_dependencies);
			}

			if (Math.random() > 0.8) {
				//Tree height: 2-4 blocks
				TreeHeight = 2 + Math.round(Math.random() * 3);
				counter2 = 0;
				randomiser = (int) (Math.random() * 2) + 1;
				while (counter2 <= randomiser) {
					ProcedureTreeLog.executeProcedure((int) x + counter2, (int) y, (int) z, world, BlockProteaLeaves.block, EnumFacing.NORTH);
					counter2 = counter2 + 1;
				}
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x + randomiser);
				$_dependencies.put("y", y + 1);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				$_dependencies.put("TreeHeight", TreeHeight);
				$_dependencies.put("counter", counter);
				ProcedureWorldGenProteaBranch.executeProcedure($_dependencies);
			}

			if (Math.random() > 0.8) {
				//Tree height: 2-4 blocks
				TreeHeight = 2 + Math.round(Math.random() * 3);
				counter2 = 0;
				randomiser = (int) (Math.random() * 2) + 1;
				while (counter2 <= randomiser) {
					ProcedureTreeLog.executeProcedure((int) x - counter2, (int) y, (int) z, world, BlockProteaLeaves.block, EnumFacing.NORTH);
					counter2 = counter2 + 1;
				}
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x - randomiser);
				$_dependencies.put("y", y + 1);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				$_dependencies.put("TreeHeight", TreeHeight);
				$_dependencies.put("counter", counter);
				ProcedureWorldGenProteaBranch.executeProcedure($_dependencies);
			}

			
			//Main height height: 2-4 blocks
			TreeHeight = 2 + Math.round(Math.random() * 4);

			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockProteaLeaves.block.getDefaultState(), 3);

			java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
			$_dependencies.put("x", x);
			$_dependencies.put("y", y + 1);
			$_dependencies.put("z", z);
			$_dependencies.put("world", world);
			$_dependencies.put("TreeHeight", TreeHeight);
			$_dependencies.put("counter", counter);
			ProcedureWorldGenProteaBranch.executeProcedure($_dependencies);
				
		}
	}
}
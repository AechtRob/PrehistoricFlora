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
import net.lepidodendron.block.BlockSahnioxylonLog;


@ElementsLepidodendronMod.ModElement.Tag
public class ProcedureWorldGenSahnioxylon extends ElementsLepidodendronMod.ModElement {
	public ProcedureWorldGenSahnioxylon(ElementsLepidodendronMod instance) {
		super(instance, 42);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WorldGenSahnioxylon!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WorldGenSahnioxylon!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WorldGenSahnioxylon!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WorldGenSahnioxylon!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double TreeHeight = 0;
		double counter = 0;
		
		if ((world.canSeeSky(new BlockPos((int) x, (int) y, (int) z)))
			) {			
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
			
			//Tree height: 13-16 blocks
			TreeHeight = 13 + Math.round(Math.random() * 3);

			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockSahnioxylonLog.block.getDefaultState(), 3);

			java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
			$_dependencies.put("x", x);
			$_dependencies.put("y", y + 1);
			$_dependencies.put("z", z);
			$_dependencies.put("world", world);
			$_dependencies.put("TreeHeight", TreeHeight);
			$_dependencies.put("counter", counter);
			ProcedureWorldGenSahnioxylonBranch.executeProcedure($_dependencies);
				
		}
	}
}
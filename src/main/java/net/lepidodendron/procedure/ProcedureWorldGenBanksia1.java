package net.lepidodendron.procedure;


import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.BlockBanksiaLog1;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


@ElementsLepidodendronMod.ModElement.Tag
public class ProcedureWorldGenBanksia1 extends ElementsLepidodendronMod.ModElement {
	public ProcedureWorldGenBanksia1(ElementsLepidodendronMod instance) {
		super(instance, 42);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WorldGenBanksia1!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WorldGenBanksia1!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WorldGenBanksia1!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WorldGenBanksia1!");
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
			
			//Tree height: 3-8 blocks
			TreeHeight = 3 + Math.round(Math.random() * 5);

			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockBanksiaLog1.block.getDefaultState(), 3);

			java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
			$_dependencies.put("x", x);
			$_dependencies.put("y", y + 1);
			$_dependencies.put("z", z);
			$_dependencies.put("world", world);
			$_dependencies.put("TreeHeight", TreeHeight);
			$_dependencies.put("counter", counter);
			ProcedureWorldGenBanksia1Branch.executeProcedure($_dependencies);
				
		}
	}
}
package net.lepidodendron.procedure;


import net.lepidodendron.ElementsLepidodendronMod;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


@ElementsLepidodendronMod.ModElement.Tag
public class ProcedureWorldGenAgathis extends ElementsLepidodendronMod.ModElement {
	public ProcedureWorldGenAgathis(ElementsLepidodendronMod instance) {
		super(instance, 42);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WorldGenAgathis!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WorldGenAgathis!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WorldGenAgathis!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WorldGenAgathis!");
			return;
		}
		if (dependencies.get("SaplingSpawn") == null) {
			System.err.println("Failed to load dependency SaplingSpawn for procedure WorldGenAgathis!");
			return;
		}

		boolean SaplingSpawn = (boolean) dependencies.get("SaplingSpawn");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");

		if ((world.canSeeSky(new BlockPos((int) x, (int) y, (int) z)))
			&& (world.canSeeSky(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z - 1))))
			&& (world.canSeeSky(new BlockPos((int) (x + 1), (int) (y + 1), (int) z)))
			&& (world.canSeeSky(new BlockPos((int) x, (int) (y + 1), (int) (z - 1))))
			) {			
				world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
				world.setBlockToAir(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)));
				world.setBlockToAir(new BlockPos((int) (x + 1), (int) y, (int) z));
				world.setBlockToAir(new BlockPos((int) x, (int) y, (int) (z - 1)));
				
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				$_dependencies.put("SaplingSpawn", SaplingSpawn);
				ProcedureWorldGenAgathisNoCheck.executeProcedure($_dependencies);
		}
	}
}
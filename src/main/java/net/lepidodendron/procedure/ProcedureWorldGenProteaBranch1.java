package net.lepidodendron.procedure;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.BlockProteaFlower1;
import net.lepidodendron.block.BlockProteaLeaves1;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

import java.util.Map;
import net.minecraft.tileentity.TileEntity;

@ElementsLepidodendronMod.ModElement.Tag
public class ProcedureWorldGenProteaBranch1 extends ElementsLepidodendronMod.ModElement {
	public ProcedureWorldGenProteaBranch1(ElementsLepidodendronMod instance) {
		super(instance, 328);
	}

	
	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WorldGenProteaBranch1!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WorldGenProteaBranch1!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WorldGenProteaBranch1!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WorldGenProteaBranch1!");
			return;
		}
		if (dependencies.get("counter") == null) {
			System.err.println("Failed to load dependency counter for procedure WorldGenProteaBranch1!");
			return;
		}
		if (dependencies.get("TreeHeight") == null) {
			System.err.println("Failed to load dependency TreeHeight for procedure WorldGenProteaBranch1!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		double counter = (double) dependencies.get("counter");
		double TreeHeight = (double) dependencies.get("TreeHeight");
		World world = (World) dependencies.get("world");
		Block block;
		boolean Trunkable;

		while (
			(counter < TreeHeight) 
			&& (world.getBlockState(new BlockPos((int) x, (int) y + counter - 1, (int) z)).getBlock() == BlockProteaLeaves1.block)
			)
		{
			//Can we trunk up?
			Trunkable = true;
			if ((world.getBlockState(new BlockPos((int) x, (int) y + counter, (int) z + 1)).getBlock() == BlockProteaLeaves1.block)
			|| (world.getBlockState(new BlockPos((int) x, (int) y + counter, (int) z - 1)).getBlock() == BlockProteaLeaves1.block)
			|| (world.getBlockState(new BlockPos((int) x + 1, (int) y + counter, (int) z)).getBlock() == BlockProteaLeaves1.block)
			|| (world.getBlockState(new BlockPos((int) x - 1, (int) y + counter, (int) z)).getBlock() == BlockProteaLeaves1.block)
			|| (world.getBlockState(new BlockPos((int) x, (int) y + counter + 1, (int) z)).getBlock() == BlockProteaLeaves1.block)
			) {Trunkable = false;}
							
			//Shall we top off here anyway?
			if (((Math.random() * (counter/TreeHeight)) > 0.2) || (counter > TreeHeight)) {
				if (world.getBlockState(new BlockPos((int) x, (int) y + counter - 1, (int) z)).getBlock() == BlockProteaLeaves1.block) {
					block = world.getBlockState(new BlockPos((int) x, (int) y + counter, (int) z)).getBlock();
					if (CanDoLeaves((int) x, (int) (y + counter), (int) z, world)) {
						world.setBlockState(new BlockPos((int) x, (int) y + counter, (int) z), BlockProteaFlower1.block.getDefaultState(), 3);
						if (!world.isRemote) {
							BlockPos _bp = new BlockPos((int)  x, (int) y + counter, (int) z);
							TileEntity _tileEntity = world.getTileEntity(_bp);
							IBlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getTileData().setBoolean("decayable", (true));
							world.notifyBlockUpdate(_bp, _bs, _bs, 3);
						}
					}
				}
				break;
			}
			else {
				if (((Math.random()) < 0.05) && Trunkable) {
					//Just trunk up:
					block = world.getBlockState(new BlockPos((int) x, (int) y + counter, (int) z)).getBlock();
					if (CanDoLeaves((int) x, (int) (y + counter), (int) z, world)) {
						world.setBlockState(new BlockPos((int) x, (int) y + counter , (int) z), BlockProteaLeaves1.block.getDefaultState(), 3);
					}
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("x", (int) x);
					$_dependencies.put("y", (int) y);
					$_dependencies.put("z", (int) z);
					$_dependencies.put("world", world);
					$_dependencies.put("TreeHeight", TreeHeight);
					$_dependencies.put("counter", counter + 1);
					ProcedureWorldGenProteaBranch1.executeProcedure($_dependencies);
					//break;
				}
				else {
					//Branch here:
					//Block block = world.getBlockState(new BlockPos((int) x, (int) y + counter, (int) z)).getBlock();
					//if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) y + counter , (int) z)), world, new BlockPos((int) x, (int) y + counter, (int) z))) {
					//	world.setBlockState(new BlockPos((int) x, (int) y + counter , (int) z), BlockProteaFlower.block.getDefaultState(), 3);
					//}
					//Which way?
					if (Math.random() > 0.5) {
						//North/South:
						block = world.getBlockState(new BlockPos((int) x, (int) y + counter - 1, (int) z - 1)).getBlock();
						if (
							(CanDoLeaves((int) x, (int) (y + counter - 1), (int) z - 1, world)) 
							&& (block != BlockProteaFlower1.block)
							&& (world.getBlockState(new BlockPos((int) x, (int) y + counter - 1 - 1, (int) z - 1)).getBlock() != BlockProteaLeaves1.block)
							&& (world.getBlockState(new BlockPos((int) x, (int) y + counter - 1, (int) z - 2)).getBlock() != BlockProteaLeaves1.block)
							&& (world.getBlockState(new BlockPos((int) x + 1, (int) y + counter - 1, (int) z - 1)).getBlock() != BlockProteaLeaves1.block)
							&& (world.getBlockState(new BlockPos((int) x - 1, (int) y + counter - 1, (int) z - 1)).getBlock() != BlockProteaLeaves1.block)
							&& (world.getBlockState(new BlockPos((int) x, (int) y + counter, (int) z - 1)).getBlock() != BlockProteaLeaves1.block)
							)
						{
							world.setBlockState(new BlockPos((int) x, (int) y + counter - 1, (int) z - 1), BlockProteaLeaves1.block.getDefaultState(), 3);
							//And start again:
							block = world.getBlockState(new BlockPos((int) x, (int) y + counter, (int) z - 1)).getBlock();
							if (CanDoLeaves((int) x, (int) (y + counter), (int) z - 1, world)) {
								world.setBlockState(new BlockPos((int) x, (int) y + counter, (int) z - 1), BlockProteaLeaves1.block.getDefaultState(), 3);		
								java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
								$_dependencies.put("x", (int) x);
								$_dependencies.put("y", (int) y);
								$_dependencies.put("z", (int) z - 1);
								$_dependencies.put("world", world);
								$_dependencies.put("TreeHeight", TreeHeight);
								$_dependencies.put("counter", counter + 1);
								ProcedureWorldGenProteaBranch1.executeProcedure($_dependencies);
							}
						}
						
						block = world.getBlockState(new BlockPos((int) x, (int) y + counter - 1, (int) z + 1)).getBlock();
						if (
							(CanDoLeaves((int) x, (int) (y + counter - 1), (int) z + 1, world)) 
							&& (block != BlockProteaFlower1.block)
							&& (world.getBlockState(new BlockPos((int) x, (int) y + counter - 1 - 1, (int) z + 1)).getBlock() != BlockProteaLeaves1.block)
							&& (world.getBlockState(new BlockPos((int) x, (int) y + counter - 1, (int) z + 2)).getBlock() != BlockProteaLeaves1.block)
							&& (world.getBlockState(new BlockPos((int) x + 1, (int) y + counter - 1, (int) z + 1)).getBlock() != BlockProteaLeaves1.block)
							&& (world.getBlockState(new BlockPos((int) x - 1, (int) y + counter - 1, (int) z + 1)).getBlock() != BlockProteaLeaves1.block)
							&& (world.getBlockState(new BlockPos((int) x, (int) y + counter, (int) z + 1)).getBlock() != BlockProteaLeaves1.block)
							)
						{
						
						//if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) y + counter - 1, (int) z + 1)), world, new BlockPos((int) x, (int) y + counter - 1, (int) z + 1))) {
							world.setBlockState(new BlockPos((int) x, (int) y + counter - 1, (int) z + 1), BlockProteaLeaves1.block.getDefaultState(), 3);
							//And start again:
							block = world.getBlockState(new BlockPos((int) x, (int) y + counter, (int) z + 1)).getBlock();
							if (CanDoLeaves((int) x, (int) (y + counter), (int) z + 1, world)) {
								world.setBlockState(new BlockPos((int) x, (int) y + counter, (int) z + 1), BlockProteaLeaves1.block.getDefaultState(), 3);		
								java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
								$_dependencies.put("x", (int) x);
								$_dependencies.put("y", (int) y);
								$_dependencies.put("z", (int) z + 1);
								$_dependencies.put("world", world);
								$_dependencies.put("TreeHeight", TreeHeight);
								$_dependencies.put("counter", counter + 1);
								ProcedureWorldGenProteaBranch1.executeProcedure($_dependencies);
							}
						}
					}
					else {
						//East/West:
						block = world.getBlockState(new BlockPos((int) x - 1, (int) y + counter - 1, (int) z)).getBlock();
						if (
							(CanDoLeaves((int) x - 1, (int) (y + counter - 1), (int) z, world)) 
							&& (block != BlockProteaFlower1.block)
							&& (world.getBlockState(new BlockPos((int) x - 1, (int) y + counter - 1 - 1, (int) z)).getBlock() != BlockProteaLeaves1.block)
							&& (world.getBlockState(new BlockPos((int) x - 2, (int) y + counter - 1, (int) z)).getBlock() != BlockProteaLeaves1.block)
							&& (world.getBlockState(new BlockPos((int) x - 1, (int) y + counter - 1, (int) z + 1)).getBlock() != BlockProteaLeaves1.block)
							&& (world.getBlockState(new BlockPos((int) x - 1, (int) y + counter - 1, (int) z - 1)).getBlock() != BlockProteaLeaves1.block)
							&& (world.getBlockState(new BlockPos((int) x - 1, (int) y + counter, (int) z)).getBlock() != BlockProteaLeaves1.block)
							)
						{
						
						//if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x - 1, (int) y + counter - 1, (int) z)), world, new BlockPos((int) x - 1, (int) y + counter - 1, (int) z))) {
							world.setBlockState(new BlockPos((int) x - 1, (int) y + counter - 1, (int) z), BlockProteaLeaves1.block.getDefaultState(), 3);
							//And start again:
							block = world.getBlockState(new BlockPos((int) x - 1, (int) y + counter, (int) z)).getBlock();
							if (CanDoLeaves((int) x - 1, (int) (y + counter), (int) z, world)) {
								world.setBlockState(new BlockPos((int) x - 1, (int) y + counter, (int) z), BlockProteaLeaves1.block.getDefaultState(), 3);		
								java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
								$_dependencies.put("x", (int) x - 1);
								$_dependencies.put("y", (int) y);
								$_dependencies.put("z", (int) z);
								$_dependencies.put("world", world);
								$_dependencies.put("TreeHeight", TreeHeight);
								$_dependencies.put("counter", counter + 1);
								ProcedureWorldGenProteaBranch1.executeProcedure($_dependencies);
							}
						}
						block = world.getBlockState(new BlockPos((int) x + 1, (int) y + counter - 1, (int) z)).getBlock();
						if (
							(CanDoLeaves((int) x + 1, (int) (y + counter - 1), (int) z, world)) 
							&& (block != BlockProteaFlower1.block)
							&& (world.getBlockState(new BlockPos((int) x + 1, (int) y + counter - 1 - 1, (int) z)).getBlock() != BlockProteaLeaves1.block)
							&& (world.getBlockState(new BlockPos((int) x + 2, (int) y + counter - 1, (int) z)).getBlock() != BlockProteaLeaves1.block)
							&& (world.getBlockState(new BlockPos((int) x + 1, (int) y + counter - 1, (int) z + 1)).getBlock() != BlockProteaLeaves1.block)
							&& (world.getBlockState(new BlockPos((int) x + 1, (int) y + counter - 1, (int) z - 1)).getBlock() != BlockProteaLeaves1.block)
							&& (world.getBlockState(new BlockPos((int) x + 1, (int) y + counter, (int) z)).getBlock() != BlockProteaLeaves1.block)
							)
						{
						//if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x + 1, (int) y + counter - 1, (int) z)), world, new BlockPos((int) x + 1, (int) y + counter - 1, (int) z))) {
							world.setBlockState(new BlockPos((int) x + 1, (int) y + counter - 1, (int) z), BlockProteaLeaves1.block.getDefaultState(), 3);
							//And start again:
							block = world.getBlockState(new BlockPos((int) x + 1, (int) y + counter, (int) z)).getBlock();
							if (CanDoLeaves((int) x + 1, (int) (y + counter), (int) z, world)) {
								world.setBlockState(new BlockPos((int) x + 1, (int) y + counter, (int) z), BlockProteaLeaves1.block.getDefaultState(), 3);		
								java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
								$_dependencies.put("x", (int) x + 1);
								$_dependencies.put("y", (int) y);
								$_dependencies.put("z", (int) z);
								$_dependencies.put("world", world);
								$_dependencies.put("TreeHeight", TreeHeight);
								$_dependencies.put("counter", counter + 1);
								ProcedureWorldGenProteaBranch1.executeProcedure($_dependencies);
							}
						}
					}
				}
			}
				
			counter = counter + 1;
		}

		if ((world.getBlockState(new BlockPos((int) x, (int) y + counter - 1, (int) z)).getBlock() == BlockProteaLeaves1.block)) {
			block = world.getBlockState(new BlockPos((int) x, (int) y + counter, (int) z)).getBlock();
			if (CanDoLeaves((int) x, (int) (y + counter), (int) z, world)) {
				world.setBlockState(new BlockPos((int) x, (int) y + counter, (int) z), BlockProteaFlower1.block.getDefaultState(), 3);
				if (!world.isRemote) {
					BlockPos _bp = new BlockPos((int)  x, (int) y + counter, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					IBlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().setBoolean("decayable", (true));
					world.notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
	}

	public static boolean CanDoLeaves(int x, int y, int z, World world) {
	Block block = world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock();
	if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), world,
		new BlockPos((int) x, (int) y, (int) z))
		|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.VINE)
		|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.SNOW)
		|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.WEB)
		|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.WATER)
		|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.PLANTS)
		|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.LEAVES)) {
			return true;
		}
		return false;
	}
}
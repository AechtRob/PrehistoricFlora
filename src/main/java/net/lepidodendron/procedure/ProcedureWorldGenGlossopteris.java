package net.lepidodendron.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

import net.lepidodendron.block.BlockGlossopterisTreeLeaves;
import net.lepidodendron.block.BlockGlossopterisLog;
import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.BlockGlossopterisStrobilus;

@ElementsLepidodendronMod.ModElement.Tag
public class ProcedureWorldGenGlossopteris extends ElementsLepidodendronMod.ModElement {
	public ProcedureWorldGenGlossopteris(ElementsLepidodendronMod instance) {
		super(instance, 42);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WorldGenGlossopteris!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WorldGenGlossopteris!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WorldGenGlossopteris!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WorldGenGlossopteris!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		int xx = x;
		int yy = y;
		int zz = z;
		World world = (World) dependencies.get("world");
		double height = 0;
		double counter = 0;
		if ((world.canSeeSky(new BlockPos((int) x, (int) y, (int) z)))) {
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockGlossopterisLog.block.getDefaultState(), 3);
			Block block = world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)), world,
					new BlockPos((int) x, (int) (y + 1), (int) z))
					|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getMaterial() == Material.VINE)
					|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getMaterial() == Material.PLANTS)
					|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getMaterial() == Material.WATER)
					|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getMaterial() == Material.SNOW)
					|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getMaterial() == Material.WEB)
					|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getMaterial() == Material.LEAVES)) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), BlockGlossopterisLog.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))), world,
					new BlockPos((int) x, (int) y, (int) (z + 1)))
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getMaterial() == Material.VINE)
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getMaterial() == Material.PLANTS)
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getMaterial() == Material.WATER)
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getMaterial() == Material.SNOW)
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getMaterial() == Material.WEB)
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getMaterial() == Material.LEAVES)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), BlockGlossopterisLog.block.getDefaultState(), 3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))), world,
					new BlockPos((int) x, (int) y, (int) (z - 1)))
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getMaterial() == Material.VINE)
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getMaterial() == Material.PLANTS)
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getMaterial() == Material.WATER)
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getMaterial() == Material.SNOW)
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getMaterial() == Material.WEB)
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getMaterial() == Material.LEAVES)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), BlockGlossopterisLog.block.getDefaultState(), 3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)), world,
					new BlockPos((int) (x + 1), (int) y, (int) z))
					|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getMaterial() == Material.VINE)
					|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getMaterial() == Material.PLANTS)
					|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getMaterial() == Material.WATER)
					|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getMaterial() == Material.SNOW)
					|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getMaterial() == Material.WEB)
					|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getMaterial() == Material.LEAVES)) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), BlockGlossopterisLog.block.getDefaultState(), 3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)), world,
					new BlockPos((int) (x - 1), (int) y, (int) z))
					|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getMaterial() == Material.VINE)
					|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getMaterial() == Material.PLANTS)
					|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getMaterial() == Material.WATER)
					|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getMaterial() == Material.SNOW)
					|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getMaterial() == Material.WEB)
					|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getMaterial() == Material.LEAVES)) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), BlockGlossopterisLog.block.getDefaultState(), 3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			height = (double) (2) + Math.round((Math.random() * 10) / 5) + Math.round((Math.random() * 10) / 5)
					+ Math.round((Math.random() * 10) / 5);
			counter = (double) 1;
			while (((counter) <= (height))) {
				block = world.getBlockState(new BlockPos((int) x, (int) ((y + 1) + (counter)), (int) z)).getBlock();
				if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((y + 1) + (counter)), (int) z)), world,
						new BlockPos((int) x, (int) ((y + 1) + (counter)), (int) z))) {
					world.setBlockState(new BlockPos((int) x, (int) ((y + 1) + (counter)), (int) z), BlockGlossopterisLog.block.getDefaultState(), 3);
				}
				counter = (double) ((counter) + 1);
			}
			// ===========================================================
			// First layer of leaves/branches:
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 1)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 1)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 1)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 2))), world,
					new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 2)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 2)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 2)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 3))), world,
					new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 3)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 3)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 3)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 3)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 4))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 4))), world,
					new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 4)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 4)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 4)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 4)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			// ===========================================================
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 1)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 1)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 1)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 2))), world,
					new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 2)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 2)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 2)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 3))), world,
					new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 3)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 3)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 3)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 3)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 4))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 4))), world,
					new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 4)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 4)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 4)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 4)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			// =====================================
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) z)), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) z)), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) z)), world,
					new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 2)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 2)), (int) z)), world,
					new BlockPos((int) (x + 4), (int) ((height) + (y + 2)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 2)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 2)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 2)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			// ===========================================================
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) z)), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) z)), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) z)), world,
					new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 2)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 2)), (int) z)), world,
					new BlockPos((int) (x - 4), (int) ((height) + (y + 2)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 2)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 2)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 2)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			// =======================================
			// Two layers of trunk and then the next of branches:
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) z)), world,
					new BlockPos((int) x, (int) ((height) + (y + 3)), (int) z))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) z), BlockGlossopterisLog.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 4)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 4)), (int) z)), world,
					new BlockPos((int) x, (int) ((height) + (y + 4)), (int) z))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 4)), (int) z), BlockGlossopterisLog.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) z)), world,
					new BlockPos((int) x, (int) ((height) + (y + 5)), (int) z))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) z), BlockGlossopterisLog.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 1)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 1)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 1)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 2))), world,
					new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 2)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 2)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 2)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 3))), world,
					new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 3)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 3)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 3)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 3)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			// ===========================================================
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 1)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 1)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 1)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 2))), world,
					new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 2)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 2)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 2)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 3))), world,
					new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 3)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 3)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 3)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 3)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) z)), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 5)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 5)), (int) z)), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 5)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 5)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 5)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 5)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 5)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 5)), (int) z)), world,
					new BlockPos((int) (x + 3), (int) ((height) + (y + 5)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 5)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 5)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 5)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			// ===================================
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) z)), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 5)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 5)), (int) z)), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 5)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 5)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 5)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 5)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 5)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 5)), (int) z)), world,
					new BlockPos((int) (x - 3), (int) ((height) + (y + 5)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 5)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 5)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 5)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			// ===========================================================
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) z)), world,
					new BlockPos((int) x, (int) ((height) + (y + 6)), (int) z))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) z), BlockGlossopterisLog.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 6)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 6)), (int) z)), world,
					new BlockPos((int) (x + 3), (int) ((height) + (y + 6)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 6)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 6)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 6)), (int) z)), world,
					new BlockPos((int) (x - 3), (int) ((height) + (y + 6)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 6)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 6)), (int) (z + 3))), world,
					new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 3)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 3)), BlockGlossopterisLog.block.getDefaultState(),
						3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 6)), (int) (z - 3))), world,
					new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 3)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 3)), BlockGlossopterisLog.block.getDefaultState(),
						3);
			}
			// ===========================================================
			block = world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 6)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 6)), (int) z)), world,
					new BlockPos((int) (x + 4), (int) ((height) + (y + 6)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 6)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 6)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 6)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 6)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 6)), (int) z)), world,
					new BlockPos((int) (x - 4), (int) ((height) + (y + 6)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 6)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 6)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 6)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 4))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 6)), (int) (z + 4))), world,
					new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 4)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 4)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 4)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 4)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 4))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 6)), (int) (z - 4))), world,
					new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 4)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 4)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 4)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 4)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			// ===================================================
			// Bit of trunk:
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) z)), world,
					new BlockPos((int) x, (int) ((height) + (y + 7)), (int) z))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) z), BlockGlossopterisLog.block.getDefaultState(), 3);
			}
			// ============================================
			// Next layer of branches:
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) z)), world,
					new BlockPos((int) x, (int) ((height) + (y + 8)), (int) z))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) z), BlockGlossopterisLog.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 8)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 8)), (int) z)), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 8)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 8)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 8)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 8)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) z)), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 8)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 8)), (int) z)), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 8)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 8)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 8)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 8)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			// ===========================================================
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) z)), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z + 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z + 1)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z + 1)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z + 1)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z + 2))), world,
					new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z + 2)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z + 2)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z + 2)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z - 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z - 1)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z - 1)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z - 1)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z - 2))), world,
					new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z - 2)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z - 2)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z - 2)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			// =========================================
			// Two layers of trunk:
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 9)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 9)), (int) z)), world,
					new BlockPos((int) x, (int) ((height) + (y + 9)), (int) z))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 9)), (int) z), BlockGlossopterisLog.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 10)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 10)), (int) z)), world,
					new BlockPos((int) x, (int) ((height) + (y + 10)), (int) z))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 10)), (int) z), BlockGlossopterisLog.block.getDefaultState(), 3);
			}
			// ===============================================
			// Last bit of branches:
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) z)), world,
					new BlockPos((int) x, (int) ((height) + (y + 11)), (int) z))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) z), BlockGlossopterisLog.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) z)), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) z)), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) z), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) z));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) z),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.UP), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z + 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z + 1)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z + 1)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z + 1)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z - 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z - 1)), BlockGlossopterisLog.block.getDefaultState(),
						3);
				try {
					IBlockState _bs = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z - 1)));
					for (IProperty<?> prop : _bs.getProperties().keySet()) {
						if (prop.getName().equals("facing")) {
							world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z - 1)),
									_bs.withProperty((PropertyDirection) prop, EnumFacing.WEST), 3);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
			// =====================================
			// Finally four bits of trunk up the middle:
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 12)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 12)), (int) z)), world,
					new BlockPos((int) x, (int) ((height) + (y + 12)), (int) z))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 12)), (int) z), BlockGlossopterisLog.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 13)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 13)), (int) z)), world,
					new BlockPos((int) x, (int) ((height) + (y + 13)), (int) z))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 13)), (int) z), BlockGlossopterisLog.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 14)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 14)), (int) z)), world,
					new BlockPos((int) x, (int) ((height) + (y + 14)), (int) z))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 14)), (int) z), BlockGlossopterisLog.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 15)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 15)), (int) z)), world,
					new BlockPos((int) x, (int) ((height) + (y + 15)), (int) z))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 15)), (int) z), BlockGlossopterisLog.block.getDefaultState(), 3);
			}
			// =======================================
			// Leaf placement:
			block = world.getBlockState(new BlockPos((int) (x + 5), (int) ((height) + (y + 2)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 5), (int) ((height) + (y + 2)), (int) z)), world,
					new BlockPos((int) (x + 5), (int) ((height) + (y + 2)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 5), (int) ((height) + (y + 2)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			
			block = world.getBlockState(new BlockPos((int) (x - 5), (int) ((height) + (y + 2)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 5), (int) ((height) + (y + 2)), (int) z)), world,
					new BlockPos((int) (x - 5), (int) ((height) + (y + 2)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 5), (int) ((height) + (y + 2)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 5))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 5))), world,
					new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 5)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z + 5)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
				
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 5))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 5))), world,
					new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 5)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 2)), (int) (z - 5)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z + 1))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) (z + 1))), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) (z + 1))), world,
					new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 2)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 2)), (int) (z + 1))), world,
					new BlockPos((int) (x + 4), (int) ((height) + (y + 2)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 2)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z - 1))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) (z - 1))), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) (z - 1))), world,
					new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 2)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 2)), (int) (z - 1))), world,
					new BlockPos((int) (x + 4), (int) ((height) + (y + 2)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 2)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z + 1))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) (z + 1))), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) (z + 1))), world,
					new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 2)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 2)), (int) (z + 1))), world,
					new BlockPos((int) (x - 4), (int) ((height) + (y + 2)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 2)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z - 1))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) (z - 1))), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) (z - 1))), world,
					new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 2)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 2)), (int) (z - 1))), world,
					new BlockPos((int) (x - 4), (int) ((height) + (y + 2)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 2)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z + 1))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z + 2))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z + 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z + 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z + 3))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z + 3)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z + 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z + 4))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z + 4))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z + 4)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z + 4)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z - 1))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z - 2))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z - 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z - 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z - 3))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z - 3)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z - 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z - 4))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z - 4))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z - 4)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 2)), (int) (z - 4)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z + 1))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z + 2))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z + 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z + 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z + 3))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z + 3)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z + 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z + 4))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z + 4))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z + 4)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z + 4)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z - 1))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z - 2))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z - 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z - 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z - 3))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z - 3)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z - 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z - 4))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z - 4))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z - 4)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 2)), (int) (z - 4)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) (z - 2))), world,
					new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) (z - 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) (z - 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) (z - 3))), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) (z - 3)))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) (z - 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) (z + 2))), world,
					new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) (z + 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) (z + 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) (z + 3))), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) (z + 3)))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) (z + 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) (z + 2))), world,
					new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 2)), (int) (z + 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) (z + 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) (z + 3))), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) (z + 3)))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 2)), (int) (z + 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) (z - 2))), world,
					new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 2)), (int) (z - 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) (z - 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) (z - 3))), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) (z - 3)))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 2)), (int) (z - 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			// ===========================================================
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 3)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 3)), (int) z)), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 3)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 3)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 3)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 3)), (int) z)), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 3)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 3)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 3)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 3)), (int) z)), world,
					new BlockPos((int) (x + 3), (int) ((height) + (y + 3)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 3)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 3)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 3)), (int) z)), world,
					new BlockPos((int) (x + 4), (int) ((height) + (y + 3)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 3)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 3)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 3)), (int) z)), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 3)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 3)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 3)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 3)), (int) z)), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 3)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 3)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 3)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 3)), (int) z)), world,
					new BlockPos((int) (x - 3), (int) ((height) + (y + 3)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 3)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 3)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 3)), (int) z)), world,
					new BlockPos((int) (x - 4), (int) ((height) + (y + 3)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 3)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z + 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z + 2))), world,
					new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z + 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z + 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z + 3))), world,
					new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z + 3)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z + 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z + 4))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z + 4))), world,
					new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z + 4)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z + 4)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z - 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z - 2))), world,
					new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z - 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z - 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z - 3))), world,
					new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z - 3)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z - 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z - 4))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z - 4))), world,
					new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z - 4)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 3)), (int) (z - 4)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 3)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 3)), (int) (z + 1))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 3)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 3)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 3)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 3)), (int) (z + 1))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 3)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 3)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 3)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 3)), (int) (z - 1))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 3)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 3)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 3)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 3)), (int) (z - 1))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 3)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 3)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			// ===========================================================
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 4)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 4)), (int) z)), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 4)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 4)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 4)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 4)), (int) z)), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 4)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 4)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 4)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 4)), (int) z)), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 4)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 4)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 4)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 4)), (int) z)), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 4)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 4)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 4)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 4)), (int) (z + 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 4)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 4)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 4)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 4)), (int) (z + 2))), world,
					new BlockPos((int) x, (int) ((height) + (y + 4)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 4)), (int) (z + 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 4)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 4)), (int) (z - 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 4)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 4)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 4)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 4)), (int) (z - 2))), world,
					new BlockPos((int) x, (int) ((height) + (y + 4)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 4)), (int) (z - 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			// =============================
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z + 1))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z + 1))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z - 1))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z - 1))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 5)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 5)), (int) (z + 1))), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 5)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 5)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 5)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 5)), (int) (z + 1))), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 5)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 5)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 5)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 5)), (int) (z - 1))), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 5)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 5)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 5)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 5)), (int) (z - 1))), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 5)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 5)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 5)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 5)), (int) (z + 1))), world,
					new BlockPos((int) (x + 3), (int) ((height) + (y + 5)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 5)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 5)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 5)), (int) (z + 1))), world,
					new BlockPos((int) (x - 3), (int) ((height) + (y + 5)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 5)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 5)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 5)), (int) (z - 1))), world,
					new BlockPos((int) (x + 3), (int) ((height) + (y + 5)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 5)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 5)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 5)), (int) (z - 1))), world,
					new BlockPos((int) (x - 3), (int) ((height) + (y + 5)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 5)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z + 2))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z + 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z - 2))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z - 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z + 2))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z + 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z - 2))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z - 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z + 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z + 3))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z + 3)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z + 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z - 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z - 3))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z - 3)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 5)), (int) (z - 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z + 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z + 3))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z + 3)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z + 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z - 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z - 3))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z - 3)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 5)), (int) (z - 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			// =======================
			block = world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 5)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 5)), (int) z)), world,
					new BlockPos((int) (x + 4), (int) ((height) + (y + 5)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 5)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 5), (int) ((height) + (y + 5)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 5), (int) ((height) + (y + 5)), (int) z)), world,
					new BlockPos((int) (x + 5), (int) ((height) + (y + 5)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 5), (int) ((height) + (y + 5)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 5)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 5)), (int) z)), world,
					new BlockPos((int) (x - 4), (int) ((height) + (y + 5)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 5)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 5), (int) ((height) + (y + 5)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 5), (int) ((height) + (y + 5)), (int) z)), world,
					new BlockPos((int) (x - 5), (int) ((height) + (y + 5)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 5), (int) ((height) + (y + 5)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 4))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 4))), world,
					new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 4)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 4)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 5))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 5))), world,
					new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 5)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z + 5)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 4))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 4))), world,
					new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 4)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 4)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 5))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 5))), world,
					new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 5)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 5)), (int) (z - 5)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			// ===========================================================
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) z)), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 6)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 6)), (int) z)), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 6)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 6)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 5), (int) ((height) + (y + 6)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 5), (int) ((height) + (y + 6)), (int) z)), world,
					new BlockPos((int) (x + 5), (int) ((height) + (y + 6)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 5), (int) ((height) + (y + 6)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 6), (int) ((height) + (y + 6)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 6), (int) ((height) + (y + 6)), (int) z)), world,
					new BlockPos((int) (x + 6), (int) ((height) + (y + 6)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 6), (int) ((height) + (y + 6)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) z)), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 6)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 6)), (int) z)), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 6)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 6)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 5), (int) ((height) + (y + 6)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 5), (int) ((height) + (y + 6)), (int) z)), world,
					new BlockPos((int) (x - 5), (int) ((height) + (y + 6)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 5), (int) ((height) + (y + 6)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 6), (int) ((height) + (y + 6)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 6), (int) ((height) + (y + 6)), (int) z)), world,
					new BlockPos((int) (x - 6), (int) ((height) + (y + 6)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 6), (int) ((height) + (y + 6)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 2))), world,
					new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 5))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 5))), world,
					new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 5)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 5)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 6))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 6))), world,
					new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 6)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z + 6)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 2))), world,
					new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 5))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 5))), world,
					new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 5)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 5)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 6))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 6))), world,
					new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 6)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 6)), (int) (z - 6)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z - 1))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z + 1))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z - 1))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z + 1))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z + 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z + 3))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z + 3)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z + 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z + 4))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z + 4))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z + 4)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z + 4)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z - 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z - 3))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z - 3)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z - 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z - 4))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z - 4))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z - 4)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 6)), (int) (z - 4)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z + 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z + 3))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z + 3)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z + 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z + 4))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z + 4))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z + 4)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z + 4)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z - 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z - 3))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z - 3)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z - 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z - 4))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z - 4))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z - 4)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 6)), (int) (z - 4)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 6)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 6)), (int) (z + 1))), world,
					new BlockPos((int) (x + 3), (int) ((height) + (y + 6)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 6)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 6)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 6)), (int) (z + 1))), world,
					new BlockPos((int) (x + 4), (int) ((height) + (y + 6)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 6)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 6)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 6)), (int) (z + 1))), world,
					new BlockPos((int) (x - 3), (int) ((height) + (y + 6)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 6)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 6)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 6)), (int) (z + 1))), world,
					new BlockPos((int) (x - 4), (int) ((height) + (y + 6)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 6)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 6)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 6)), (int) (z - 1))), world,
					new BlockPos((int) (x + 3), (int) ((height) + (y + 6)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 6)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 6)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 6)), (int) (z - 1))), world,
					new BlockPos((int) (x + 4), (int) ((height) + (y + 6)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 6)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 6)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 6)), (int) (z - 1))), world,
					new BlockPos((int) (x - 3), (int) ((height) + (y + 6)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 6)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 6)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 6)), (int) (z - 1))), world,
					new BlockPos((int) (x - 4), (int) ((height) + (y + 6)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 6)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			// ===========================================================
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z + 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z + 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z + 3))), world,
					new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z + 3)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z + 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z + 4))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z + 4))), world,
					new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z + 4)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z + 4)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z - 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z - 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z - 3))), world,
					new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z - 3)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z - 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z - 4))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z - 4))), world,
					new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z - 4)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 7)), (int) (z - 4)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 7)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 7)), (int) z)), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 7)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 7)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 7)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 7)), (int) z)), world,
					new BlockPos((int) (x + 3), (int) ((height) + (y + 7)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 7)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 7)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 7)), (int) z)), world,
					new BlockPos((int) (x + 4), (int) ((height) + (y + 7)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 7)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 7)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 7)), (int) z)), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 7)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 7)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 7)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 7)), (int) z)), world,
					new BlockPos((int) (x - 3), (int) ((height) + (y + 7)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 7)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 7)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 7)), (int) z)), world,
					new BlockPos((int) (x - 4), (int) ((height) + (y + 7)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 7)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			// ===========================================================
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z + 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z + 3))), world,
					new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z + 3)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z + 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z + 4))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z + 4))), world,
					new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z + 4)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z + 4)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z - 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z - 3))), world,
					new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z - 3)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z - 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z - 4))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z - 4))), world,
					new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z - 4)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 8)), (int) (z - 4)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 8)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 8)), (int) z)), world,
					new BlockPos((int) (x + 3), (int) ((height) + (y + 8)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 8)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 8)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 8)), (int) z)), world,
					new BlockPos((int) (x + 4), (int) ((height) + (y + 8)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 4), (int) ((height) + (y + 8)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 8)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 8)), (int) z)), world,
					new BlockPos((int) (x - 3), (int) ((height) + (y + 8)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 8)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 8)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 8)), (int) z)), world,
					new BlockPos((int) (x - 4), (int) ((height) + (y + 8)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 4), (int) ((height) + (y + 8)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) (z + 2))), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) (z + 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) (z + 2))), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) (z + 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) (z - 2))), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) (z - 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) (z - 2))), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) (z - 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 8)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 8)), (int) (z + 2))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 8)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 8)), (int) (z + 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 8)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 8)), (int) (z + 2))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 8)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 8)), (int) (z + 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 8)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 8)), (int) (z - 2))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 8)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 8)), (int) (z - 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 8)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 8)), (int) (z - 2))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 8)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 8)), (int) (z - 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) (z + 1))), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) (z - 1))), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 8)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) (z + 1))), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) (z - 1))), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 8)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			// ===========================================================
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 9)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 9)), (int) (z + 1))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 9)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 9)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 9)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 9)), (int) (z + 1))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 9)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 9)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 9)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 9)), (int) (z - 1))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 9)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 9)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 9)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 9)), (int) (z - 1))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 9)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 9)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 9)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 9)), (int) z)), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 9)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 9)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 9)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 9)), (int) z)), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 9)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 9)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 9)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 9)), (int) (z - 1))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 9)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 9)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 9)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 9)), (int) z)), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 9)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 9)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 9)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 9)), (int) (z + 2))), world,
					new BlockPos((int) x, (int) ((height) + (y + 9)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 9)), (int) (z + 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 9)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 9)), (int) (z - 2))), world,
					new BlockPos((int) x, (int) ((height) + (y + 9)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 9)), (int) (z - 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 9)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 9)), (int) (z + 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 9)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 9)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 9)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 9)), (int) (z - 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 9)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 9)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			// ===========================================================
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 10)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 10)), (int) (z + 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 10)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 10)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 10)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 10)), (int) (z - 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 10)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 10)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 10)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 10)), (int) z)), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 10)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 10)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 10)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 10)), (int) z)), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 10)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 10)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			// ===========================================================
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) (z + 1))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) (z - 1))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) (z + 1))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) (z - 1))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 11)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 11)), (int) (z - 1))), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 11)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 11)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 11)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 11)), (int) z)), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 11)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 11)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 11)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 11)), (int) (z + 1))), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 11)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 11)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 11)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 11)), (int) (z - 1))), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 11)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 11)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 11)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 11)), (int) z)), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 11)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 11)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 11)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 11)), (int) (z + 1))), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 11)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 11)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z + 2))), world,
					new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z + 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) (z + 2))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) (z + 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) (z + 2))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) (z + 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z - 2))), world,
					new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z - 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) (z - 2))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 11)), (int) (z - 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) (z - 2))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 11)), (int) (z - 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z + 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z + 3))), world,
					new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z + 3)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z + 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z - 3))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z - 3))), world,
					new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z - 3)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 11)), (int) (z - 3)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 11)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 11)), (int) z)), world,
					new BlockPos((int) (x + 3), (int) ((height) + (y + 11)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 3), (int) ((height) + (y + 11)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 11)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 11)), (int) z)), world,
					new BlockPos((int) (x - 3), (int) ((height) + (y + 11)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 3), (int) ((height) + (y + 11)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			// ===========================================================
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 12)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 12)), (int) (z + 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 12)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 12)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 12)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 12)), (int) (z - 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 12)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 12)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 12)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 12)), (int) z)), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 12)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 12)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 12)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 12)), (int) z)), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 12)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 12)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			// ===========================================================
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 13)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 13)), (int) (z + 1))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 13)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 13)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 13)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 13)), (int) (z + 1))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 13)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 13)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 13)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 13)), (int) (z - 1))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 13)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 13)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 13)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 13)), (int) (z - 1))), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 13)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 13)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 13)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 13)), (int) z)), world,
					new BlockPos((int) (x + 2), (int) ((height) + (y + 13)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) ((height) + (y + 13)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 13)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 13)), (int) z)), world,
					new BlockPos((int) (x - 2), (int) ((height) + (y + 13)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) ((height) + (y + 13)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 13)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 13)), (int) (z - 1))), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 13)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 13)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 13)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 13)), (int) z)), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 13)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 13)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 13)), (int) (z + 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 13)), (int) (z + 2))), world,
					new BlockPos((int) x, (int) ((height) + (y + 13)), (int) (z + 2)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 13)), (int) (z + 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 13)), (int) (z - 2))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 13)), (int) (z - 2))), world,
					new BlockPos((int) x, (int) ((height) + (y + 13)), (int) (z - 2)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 13)), (int) (z - 2)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 13)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 13)), (int) (z + 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 13)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 13)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 13)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 13)), (int) (z - 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 13)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 13)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			// ===========================================================
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 14)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 14)), (int) (z + 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 14)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 14)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 14)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 14)), (int) (z - 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 14)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 14)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 14)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 14)), (int) z)), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 14)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 14)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 14)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 14)), (int) z)), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 14)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 14)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			// ===========================================================
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 15)), (int) (z + 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 15)), (int) (z + 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 15)), (int) (z + 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 15)), (int) (z + 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 15)), (int) (z - 1))).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 15)), (int) (z - 1))), world,
					new BlockPos((int) x, (int) ((height) + (y + 15)), (int) (z - 1)))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 15)), (int) (z - 1)),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 15)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 15)), (int) z)), world,
					new BlockPos((int) (x + 1), (int) ((height) + (y + 15)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) ((height) + (y + 15)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			block = world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 15)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 15)), (int) z)), world,
					new BlockPos((int) (x - 1), (int) ((height) + (y + 15)), (int) z))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) ((height) + (y + 15)), (int) z),
						BlockGlossopterisTreeLeaves.block.getDefaultState(), 3);
			}
			// ===========================================================
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 16)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 16)), (int) z)), world,
					new BlockPos((int) x, (int) ((height) + (y + 16)), (int) z))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 16)), (int) z), BlockGlossopterisTreeLeaves.block.getDefaultState(),
						3);
			}
			block = world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 17)), (int) z)).getBlock();
			if (block.canBeReplacedByLeaves(world.getBlockState(new BlockPos((int) x, (int) ((height) + (y + 17)), (int) z)), world,
					new BlockPos((int) x, (int) ((height) + (y + 17)), (int) z))) {
				world.setBlockState(new BlockPos((int) x, (int) ((height) + (y + 17)), (int) z), BlockGlossopterisTreeLeaves.block.getDefaultState(),
						3);
			}


			//Random placemenet of strobili:
			counter = y;
			int xct = -5;
			int zct = -5;
			
			while (counter <= (y + 17)) {
				xct = -6;
				while (xct <= 6) {
					zct = -6;
						while (zct <= 6) {

							if ((world.getBlockState(new BlockPos((int) x + xct, (int) height + counter, (int) z + zct))).getBlock() == BlockGlossopterisTreeLeaves.block)
								{
			
								if ((Math.random() > 0.7) && (world.isAirBlock(new BlockPos(x + xct, (int) height + counter + 1, (int) z + zct)))) {
									world.setBlockState(new BlockPos((int) x + xct, (int) height + counter + 1, (int) z + zct), BlockGlossopterisStrobilus.block.getDefaultState(), 3);
									if (!world.isRemote) {
										BlockPos _bp = new BlockPos((int) x + xct, (int) height + counter + 1, (int) z + zct);
										TileEntity _tileEntity = world.getTileEntity(_bp);
										IBlockState _bs = world.getBlockState(_bp);
										if (_tileEntity != null)
											_tileEntity.getTileData().setBoolean("decayable", (true));
										world.notifyBlockUpdate(_bp, _bs, _bs, 3);
										}
									}
								}
							zct = zct + 1;
						}
					xct = xct + 1;
				}
				counter = counter + 1;
			}
		}
	}
}
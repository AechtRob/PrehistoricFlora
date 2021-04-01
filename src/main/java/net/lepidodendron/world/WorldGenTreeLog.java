package net.lepidodendron.world;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;

public class WorldGenTreeLog extends WorldGenerator
{
    private final Block block;

    public WorldGenTreeLog(Block blockIn)
    {
        super(false);
        this.block = blockIn;
    }

	public static final PropertyDirection FACING = BlockDirectional.FACING;
		
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
    	boolean flag = false;
    	BlockPos blockpos = position;

		Material material = worldIn.getBlockState(blockpos.down()).getMaterial();

        if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 254)
        && (material == Material.GROUND || material == Material.GRASS || material == Material.SAND || material == Material.ROCK))
        {
			if (Math.random() > 0.8) { //Standing log
				worldIn.setBlockState(blockpos, this.block.getDefaultState().withProperty(FACING, EnumFacing.NORTH), 4);
				worldIn.setBlockState(blockpos.up(), this.block.getDefaultState().withProperty(FACING, EnumFacing.NORTH), 4);
				if (Math.random() > 0.5) {
					worldIn.setBlockState(blockpos.up(2), this.block.getDefaultState().withProperty(FACING, EnumFacing.NORTH), 4);
					if (Math.random() > 0.5) {
						worldIn.setBlockState(blockpos.up().east(), this.block.getDefaultState().withProperty(FACING, EnumFacing.UP), 4);
					}
					if (Math.random() > 0.6) {
						worldIn.setBlockState(blockpos.up(3), this.block.getDefaultState().withProperty(FACING, EnumFacing.NORTH), 4);
					}
				}
			}
				else {
				int direction = rand.nextInt(2);
				if (direction == 1) {
					//North-South
					worldIn.setBlockState(blockpos, this.block.getDefaultState().withProperty(FACING, EnumFacing.EAST), 4);
					worldIn.setBlockState(blockpos.north(), this.block.getDefaultState().withProperty(FACING, EnumFacing.EAST), 4);
					if (Math.random() > 0.5 && !worldIn.isAirBlock(blockpos.down().north(2)) ) {
						worldIn.setBlockState(blockpos.north(2), this.block.getDefaultState().withProperty(FACING, EnumFacing.EAST), 4);
						if (Math.random() > 0.5) {
							worldIn.setBlockState(blockpos.north().up(), this.block.getDefaultState().withProperty(FACING, EnumFacing.NORTH), 4);
						}
						if (Math.random() > 0.6 && !worldIn.isAirBlock(blockpos.down().north(3)) ) {
							worldIn.setBlockState(blockpos.north(3), this.block.getDefaultState().withProperty(FACING, EnumFacing.EAST), 4);
						}
					}
				}
				else {
					//East-West
					worldIn.setBlockState(blockpos, this.block.getDefaultState().withProperty(FACING, EnumFacing.UP), 4);
					worldIn.setBlockState(blockpos.east(), this.block.getDefaultState().withProperty(FACING, EnumFacing.UP), 4);
					if (Math.random() > 0.5 && !worldIn.isAirBlock(blockpos.down().east(2))) {
						worldIn.setBlockState(blockpos.east(2), this.block.getDefaultState().withProperty(FACING, EnumFacing.UP), 4);
						if (Math.random() > 0.5) {
							worldIn.setBlockState(blockpos.east().up(), this.block.getDefaultState().withProperty(FACING, EnumFacing.NORTH), 4);
						}
						if (Math.random() > 0.6 && !worldIn.isAirBlock(blockpos.down().east(3)) ) {
							worldIn.setBlockState(blockpos.east(3), this.block.getDefaultState().withProperty(FACING, EnumFacing.UP), 4);
						}
					}
					
				}
			}
			
            flag = true;
        }
            
        return flag;
    }
}


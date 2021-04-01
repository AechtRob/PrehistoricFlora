package net.lepidodendron.world;

import java.util.Random;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import net.lepidodendron.block.BlockOmphalophloiosPlaceable;
import net.lepidodendron.block.BlockOmphalophloiosCentre;
import net.lepidodendron.block.BlockOmphalophloiosTop;
import net.lepidodendron.block.BlockOmphalophloiosBase;
import net.lepidodendron.block.BlockOmphalophloiosSapling;
import net.minecraft.block.material.Material;

public class WorldGenOmphalophloios extends WorldGenerator
{

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        boolean flag = false;
        if (position.getY() <= worldIn.getSeaLevel()+20) {
        	
	        for (int i = 0; i < 24; ++i)
	        {
	            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
	
	            if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 254) && BlockOmphalophloiosSapling.block.canPlaceBlockAt(worldIn, blockpos))
	            {
	                worldIn.setBlockState(blockpos, BlockOmphalophloiosBase.block.getDefaultState(), 2);
					worldIn.setBlockState(blockpos.up(), BlockOmphalophloiosPlaceable.block.getDefaultState(), 2);
					worldIn.setBlockState(blockpos.up(2), BlockOmphalophloiosCentre.block.getDefaultState(), 2);
					if (worldIn.isAirBlock(blockpos.up(4))) {
						if (Math.random() > 0.7) {
							worldIn.setBlockState(blockpos.up(3), BlockOmphalophloiosCentre.block.getDefaultState(), 2);
							if (worldIn.isAirBlock(blockpos.up(5)))
								if (Math.random() > 0.7) {
									worldIn.setBlockState(blockpos.up(4), BlockOmphalophloiosCentre.block.getDefaultState(), 2);
									worldIn.setBlockState(blockpos.up(5), BlockOmphalophloiosTop.block.getDefaultState(), 2);
								}
							else {
								worldIn.setBlockState(blockpos.up(4), BlockOmphalophloiosTop.block.getDefaultState(), 2);
							}
						}
					}
					else {
						worldIn.setBlockState(position.up(3), BlockOmphalophloiosTop.block.getDefaultState(), 2);
					}
	                flag = true;
	            }
	        }
        }

        return flag;
    }
}
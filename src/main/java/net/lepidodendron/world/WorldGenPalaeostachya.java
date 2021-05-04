package net.lepidodendron.world;

import java.util.Random;

import net.lepidodendron.block.*;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import net.lepidodendron.procedure.ProcedureWorldGenMedullosales;
import java.util.Map;
import java.util.HashMap;


public class WorldGenPalaeostachya extends WorldGenerator
{

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        boolean flag = false;

        for (int i = 0; i < 32; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (blockpos.getY() >= worldIn.getSeaLevel()-4 && worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 254) && BlockPalaeostachyaSapling.block.canPlaceBlockAt(worldIn, blockpos)
                    )
            {

                if ((worldIn.canSeeSky(blockpos))
                        && worldIn.isAirBlock(blockpos.up()) && worldIn.isAirBlock((blockpos.up(2))) && worldIn.isAirBlock((blockpos.up(3))) && worldIn.isAirBlock((blockpos.up(4)))) {
                    worldIn.setBlockState(blockpos, BlockPalaeostachyaStem.block.getDefaultState(), 3);
                    if (Math.random() > 0.6) {
                        worldIn.setBlockState(blockpos.up(), BlockPalaeostachyaStem.block.getDefaultState(), 3);
                        worldIn.setBlockState(blockpos.up(2), BlockPalaeostachyaBottom.block.getDefaultState(), 3);
                        worldIn.setBlockState(blockpos.up(3), BlockPalaeostachyaTop.block.getDefaultState(), 3);
                    }
                    else {
                        worldIn.setBlockState(blockpos.up(), BlockPalaeostachyaBottom.block.getDefaultState(), 3);
                        worldIn.setBlockState(blockpos.up(2), BlockPalaeostachyaTop.block.getDefaultState(), 3);
                    }
                }
                flag = true;
            }
        }

        return flag;
    }
}
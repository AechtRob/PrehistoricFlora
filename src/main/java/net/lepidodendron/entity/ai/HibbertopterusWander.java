package net.lepidodendron.entity.ai;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationAI;
import net.lepidodendron.entity.base.EntityPrehistoricFloraHibbertopterusBase;
import net.lepidodendron.entity.base.EntityPrehistoricFloraTrilobiteBottomBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

import java.util.Random;

//public class FishWander extends EntityAIBase {
public class HibbertopterusWander extends AnimationAI<EntityPrehistoricFloraHibbertopterusBase> {

    protected float probability;
    protected Animation animation;
    protected EntityPrehistoricFloraHibbertopterusBase PrehistoricFloraHibbertopterusBase;

    public HibbertopterusWander(EntityPrehistoricFloraHibbertopterusBase PrehistoricFloraHibbertopterusBase, Animation animation)
    {
        super(PrehistoricFloraHibbertopterusBase);
        setMutexBits(4);
        this.PrehistoricFloraHibbertopterusBase = PrehistoricFloraHibbertopterusBase;
        this.animation = animation;
    }

    @Override
    public Animation getAnimation()
    {
        return animation;
    }

    @Override
    public boolean isAutomatic() {
        return true;
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
    }

    @Override
    public void updateTask() {
        super.updateTask();

    }

    @Override
    public boolean shouldExecute() {
        if (this.PrehistoricFloraHibbertopterusBase.getRNG().nextFloat() < 0.5F) {
            Path path = this.PrehistoricFloraHibbertopterusBase.getNavigator().getPath();
            if (this.PrehistoricFloraHibbertopterusBase.getNavigator().noPath()) {
                //Prefer water targets:
                BlockPos vec3;
                if (Math.random() > 0.9) {
                    vec3 = this.findLandTarget();
                }
                else {
                    vec3 = this.findWaterTarget();
                }
                if (vec3 != null) {
                    this.PrehistoricFloraHibbertopterusBase.getNavigator().tryMoveToXYZ(vec3.getX() + 0.5D, Math.floor(vec3.getY())  , vec3.getZ() + 0.5D, 1.0);

                    //System.err.println("Target found: " + this.PrehistoricFloraHibbertopterusBase.world.getBlockState(vec3).getMaterial());

                    return true;
                }
            }
        }
        //System.err.println("No path found");
        return false;
    }

    @Override
    public boolean shouldContinueExecuting() {
        return false;
    }

    public boolean isAtBottom(BlockPos blockpos) {
        //System.err.println("Testing position");
        if (blockpos.getY() - 1 > 1) {
            BlockPos pos = blockpos.down();
            return (((this.PrehistoricFloraHibbertopterusBase.world.getBlockState(blockpos)).getMaterial() == Material.WATER || (this.PrehistoricFloraHibbertopterusBase.world.getBlockState(blockpos)).getMaterial() == Material.CORAL)
                    && ((this.PrehistoricFloraHibbertopterusBase.world.getBlockState(pos)).getMaterial() != Material.WATER));
        }
        return true;
    }

    public BlockPos findWaterTarget() {
        Random rand = this.PrehistoricFloraHibbertopterusBase.getRNG();
        if (this.PrehistoricFloraHibbertopterusBase.getAttackTarget() == null) {
            for (int i = 0; i < 10; i++) {
                BlockPos randPos = this.PrehistoricFloraHibbertopterusBase.getPosition().add(rand.nextInt(16) - 8, rand.nextInt(16) - 8, rand.nextInt(16) - 8);
                //Use targets which are at the bottom:
                BlockPos randPosVar = randPos;
                if (this.PrehistoricFloraHibbertopterusBase.world.getBlockState(randPos).getMaterial() == Material.WATER && !isAtBottom(randPos)) {
                    int ii = 0;
                    while ((randPos.down(ii).getY() > 1) && this.PrehistoricFloraHibbertopterusBase.world.getBlockState(randPos.down(ii)).getMaterial() == Material.WATER) {
                        randPosVar = randPos.down(ii);
                        ii = ii + 1;
                    }
                    randPos = randPosVar;
                }

                //System.err.println("Target " + randPos.getX() + " " + randPos.getY() + " " + randPos.getZ());
                if (this.PrehistoricFloraHibbertopterusBase.world.getBlockState(randPos).getMaterial() == Material.WATER) {
                    return randPos;
                }
            }
        } else { //allow attacks only under water:
            BlockPos blockpos1;
            blockpos1 = new BlockPos(this.PrehistoricFloraHibbertopterusBase.getAttackTarget());
            if (this.PrehistoricFloraHibbertopterusBase.world.getBlockState(blockpos1).getMaterial() == Material.WATER) {
                return blockpos1;
            }
        }
        return null;
    }

    public BlockPos findLandTarget() {
        BlockPos blockpos1;
        if (this.PrehistoricFloraHibbertopterusBase.getAttackTarget() == null) {
            for (int i = 0; i < 10; i++) {
                Vec3d vec3d = this.entity.getRNG().nextFloat() >= this.probability ? RandomPositionGenerator.getLandPos(this.entity, 10, 7) : RandomPositionGenerator.findRandomTarget(this.entity, 10, 7);
                if (vec3d != null) {
                    blockpos1 = new BlockPos(vec3d.x, vec3d.y, vec3d.z);
                    if ((this.PrehistoricFloraHibbertopterusBase.world.getBlockState(blockpos1).getMaterial() == Material.WATER)
                            || (this.PrehistoricFloraHibbertopterusBase.isNearWater(blockpos1))
                    )
                        return blockpos1;
                }
            }
        }
        else { //allow attacks only under water:
            blockpos1 = new BlockPos(this.PrehistoricFloraHibbertopterusBase.getAttackTarget());
            if (this.PrehistoricFloraHibbertopterusBase.world.getBlockState(blockpos1).getMaterial() == Material.WATER) {
                return blockpos1;
            }
        }
        return null;
    }
}
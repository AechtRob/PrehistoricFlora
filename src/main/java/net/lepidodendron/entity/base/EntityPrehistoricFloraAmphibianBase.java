package net.lepidodendron.entity.base;

import net.ilexiconn.llibrary.client.model.tools.ChainBuffer;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationAI;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class EntityPrehistoricFloraAmphibianBase extends EntityCreature implements IAnimatedEntity {
    public BlockPos currentTarget;
    @SideOnly(Side.CLIENT)
    public ChainBuffer chainBuffer;

    public EntityPrehistoricFloraAmphibianBase(World world) {
        super(world);
        if (this.isInWater()) {
            this.moveHelper = new EntityPrehistoricFloraAmphibianBase.SwimmingMoveHelper();
            this.navigator = new PathNavigateSwimmer(this, world);
        }
        else {
            this.moveHelper = new EntityPrehistoricFloraAmphibianBase.WanderMoveHelper();
            this.navigator = new PathNavigateGround(this, world);
        }
        if (FMLCommonHandler.instance().getSide().isClient()) {
            this.chainBuffer = new ChainBuffer();
        }
    }

    private Animation animation = NO_ANIMATION;
    private int animationTick;

    public static final Animation ANIMATION_AMPHIBIAN_WANDER = Animation.create(20);
    public static final Animation ANIMATION_AMPHIBIAN_YAWN = Animation.create(20);
    public static final Animation ANIMATION_AMPHIBIAN_DRINK = Animation.create(20);

    private static final Animation[] ANIMATIONS = {ANIMATION_AMPHIBIAN_WANDER,ANIMATION_AMPHIBIAN_YAWN,ANIMATION_AMPHIBIAN_DRINK};

    public AnimationAI currentAnim;

    @Override
    public int getAnimationTick() {
        return animationTick;
    }

    @Override
    public void setAnimationTick(int tick)
    {
        animationTick = tick;
    }

    @Override
    public Animation getAnimation()
    {
        return this.animation;
    }

    @Override
    public void setAnimation(Animation animation)
    {
        if (animation == NO_ANIMATION){
            onAnimationFinish(this.animation);
            setAnimationTick(0);
        }
        this.animation = animation;
    }

    @Override
    public Animation[] getAnimations()
    {
        return ANIMATIONS;
    }

    protected void onAnimationFinish(Animation animation)
    {}

    protected void initEntityAI() {
        //tasks.addTask(0, new FishWander(this, ANIMATION_FISH_WANDER));
        //this.tasks.addTask(0, new FishWander(this));
        //this.tasks.addTask(1, new EntityAILookIdle(this));
    }


    @Override
    public boolean isAIDisabled() {
        return false;
    }

    public abstract String getTexture();

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }

    // @Nullable
    // protected ResourceLocation getLootTable() {
    //     return PrehistoricEntityType.FISH_LOOT;
    // }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    //public void swimTowardsTarget() {
    //    if (currentTarget != null && isTargetInWater() && this.inWater) {
    //        double targetX = currentTarget.getX() + 0.5D - posX;
    //        double targetY = currentTarget.getY() + 1D - posY;
    //        double targetZ = currentTarget.getZ() + 0.5D - posZ;
    //        motionX += (Math.signum(targetX) * 0.5D - motionX) * 0.100000000372529 * getSwimSpeed(); // 0.10000000149011612D
    //        motionY += (Math.signum(targetY) * 0.5D - motionY) * 0.100000000372529 * getSwimSpeed();// 0.10000000149011612D
    //        motionZ += (Math.signum(targetZ) * 0.5D - motionZ) * 0.100000000372529 * getSwimSpeed(); // 0.10000000149011612D
    //       float angle = (float) (Math.atan2(motionZ, motionX) * 180.0D / Math.PI) - 90.0F;
    //        float rotation = MathHelper.wrapDegrees(angle - rotationYaw);
    //        moveForward = 0.5F;
    //        rotationYaw += rotation;
     //   }
    //}

    protected abstract double getSwimSpeed();

    public float getMaxTurnDistancePerTick() {
        return 20;
    }

    @Override
    public boolean isInWater() {
        return super.isInWater() || this.isInsideOfMaterial(Material.WATER) || this.isInsideOfMaterial(Material.CORAL);
    }

    public boolean isPushedByWater()
    {
        return !isInWater();
    }

    //protected boolean isTargetInWater() {
    //    return currentTarget != null && (world.getBlockState(new BlockPos(currentTarget.getX(), currentTarget.getY(), currentTarget.getZ())).getMaterial() == Material.WATER && world.getBlockState(new BlockPos(currentTarget.getX(), currentTarget.getY() + 1, currentTarget.getZ())).getMaterial() == Material.WATER);
    //}

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < (double) this.world.getSeaLevel() && isInWater();
    }

    public boolean isNotColliding() {
        return this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this);
    }

    @Override
    public int getTalkInterval() {
        return 120;
    }

    @Override
    protected int getExperiencePoints(EntityPlayer player) {
        return 1 + this.world.rand.nextInt(3);
    }

    @Override
    public boolean isOnLadder() {
        return false;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.renderYawOffset = this.rotationYaw;

        if (getAnimation() != NO_ANIMATION)
        {
            animationTick++;
        }
        if (world.isRemote && animationTick >= animation.getDuration())
        {
            setAnimation(NO_ANIMATION);
        }
    }

    public void onEntityUpdate()
    {
        super.onEntityUpdate();
    }

    public boolean isDirectPathBetweenPoints(Vec3d vec1, Vec3d vec2) {
        RayTraceResult movingobjectposition = this.world.rayTraceBlocks(vec1, new Vec3d(vec2.x, vec2.y, vec2.z), false, true, false);
        return movingobjectposition == null || movingobjectposition.typeOfHit != RayTraceResult.Type.BLOCK;
    }

    @Override
    public void travel(float strafe, float vertical, float forward) {
        float f4;
        if (this.isServerWorld()) {
            if (isInWater()) {
                this.moveRelative(strafe, vertical, forward, 0.1F);
                f4 = 0.8F;
                float speedModifier = (float) EnchantmentHelper.getDepthStriderModifier(this);
                if (speedModifier > 3.0F) {
                    speedModifier = 3.0F;
                }
                if (!this.onGround) {
                    speedModifier *= 0.5F;
                }
                if (speedModifier > 0.0F) {
                    f4 += (0.54600006F - f4) * speedModifier / 3.0F;
                }
                this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
                this.motionX *= f4;
                this.motionX *= 0.9;
                this.motionY *= 0.9;
                this.motionY *= f4;
                this.motionZ *= 0.9;
                this.motionZ *= f4;
            } else {
                super.travel(strafe, vertical, forward);
            }
        }
        this.prevLimbSwingAmount = this.limbSwingAmount;
        double deltaX = this.posX - this.prevPosX;
        double deltaZ = this.posZ - this.prevPosZ;
        double deltaY = this.posY - this.prevPosY;
        float delta = MathHelper.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ) * 4.0F;
        if (delta > 1.0F) {
            delta = 1.0F;
        }
        this.limbSwingAmount += (delta - this.limbSwingAmount) * 0.4F;
        this.limbSwing += this.limbSwingAmount;
    }

    class SwimmingMoveHelper extends EntityMoveHelper {

        private final EntityPrehistoricFloraAmphibianBase EntityBase = EntityPrehistoricFloraAmphibianBase.this;

        public SwimmingMoveHelper() {
            super(EntityPrehistoricFloraAmphibianBase.this);
        }

        @Override
        public void onUpdateMoveHelper() {
            //System.err.println("Action " + this.action);
            //System.err.println("NoPath " + this.EntityBase.getNavigator().noPath());
            if (this.action == Action.MOVE_TO && !this.EntityBase.getNavigator().noPath()) {
                double distanceX = this.posX - this.EntityBase.posX;
                double distanceY = this.posY - this.EntityBase.posY;
                double distanceZ = this.posZ - this.EntityBase.posZ;
                double distance = Math.abs(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ);
                distance = MathHelper.sqrt(distance);
                distanceY /= distance;
                float angle = (float) (Math.atan2(distanceZ, distanceX) * 180.0D / Math.PI) - 90.0F;
                //this.PrehistoricFloraFishBase.rotationYaw = this.limitAngle(this.PrehistoricFloraFishBase.rotationYaw, angle, 30.0F);
                //this.PrehistoricFloraFishBase.setAIMoveSpeed(0.65F);

                this.EntityBase.rotationYaw = this.limitAngle(this.EntityBase.rotationYaw, angle, 20.0F);
                this.EntityBase.setAIMoveSpeed(0.3F);
                //System.err.println("Setting speed!");
                //TEST:
                //this.EntityBase.setAIMoveSpeed(0.0F);

                this.EntityBase.motionY += (double) this.EntityBase.getAIMoveSpeed() * distanceY * 0.1D;
            } else {
                //System.err.println("Exception");
                this.EntityBase.setAIMoveSpeed(0.0F);
            }
        }
    }

    public class WanderMoveHelper extends EntityMoveHelper {

        private final EntityPrehistoricFloraAmphibianBase EntityBase = EntityPrehistoricFloraAmphibianBase.this;

        public WanderMoveHelper() {
            super(EntityPrehistoricFloraAmphibianBase.this);
        }

        public void onUpdateMoveHelper() {
            if (this.action == EntityMoveHelper.Action.STRAFE) {
                float f = (float) this.EntityBase.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
                float f1 = (float) this.speed * f;
                float f2 = this.moveForward;
                float f3 = this.moveStrafe;
                float f4 = MathHelper.sqrt(f2 * f2 + f3 * f3);

                if (f4 < 1.0F) {
                    f4 = 1.0F;
                }

                f4 = f1 / f4;
                f2 = f2 * f4;
                f3 = f3 * f4;
                float f5 = MathHelper.sin(this.EntityBase.rotationYaw * 0.017453292F);
                float f6 = MathHelper.cos(this.EntityBase.rotationYaw * 0.017453292F);
                float f7 = f2 * f6 - f3 * f5;
                float f8 = f3 * f6 + f2 * f5;
                PathNavigate pathnavigate = this.EntityBase.getNavigator();

                if (pathnavigate != null) {
                    NodeProcessor nodeprocessor = pathnavigate.getNodeProcessor();

                    if (nodeprocessor != null && nodeprocessor.getPathNodeType(this.EntityBase.world, MathHelper.floor(this.EntityBase.posX + (double) f7), MathHelper.floor(this.EntityBase.posY), MathHelper.floor(this.EntityBase.posZ + (double) f8)) != PathNodeType.WALKABLE) {
                        this.moveForward = 1.0F;
                        this.moveStrafe = 0.0F;
                        f1 = f;
                    }
                }

                this.EntityBase.setAIMoveSpeed(f1);
                this.EntityBase.setMoveForward(this.moveForward);
                this.EntityBase.setMoveStrafing(this.moveStrafe);
                this.action = EntityMoveHelper.Action.WAIT;
            } else if (this.action == EntityMoveHelper.Action.MOVE_TO) {
                this.action = EntityMoveHelper.Action.WAIT;
                double d0 = this.posX - this.EntityBase.posX;
                double d1 = this.posZ - this.EntityBase.posZ;
                double d2 = this.posY - this.EntityBase.posY;
                double d3 = d0 * d0 + d2 * d2 + d1 * d1;

                if (d3 < 2.500000277905201E-7D) {
                    this.EntityBase.setMoveForward(0.0F);
                    return;
                }

                float turn = (EntityBase.getMaxTurnDistancePerTick());
                float f9 = (float) (MathHelper.atan2(d1, d0) * (180D / Math.PI)) - 90;
                this.EntityBase.rotationYaw = this.limitAngle(this.EntityBase.rotationYaw, f9, turn);
                //this.EntityBase.setAIMoveSpeed((float) (this.speed * this.EntityBase.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));

                this.EntityBase.setAIMoveSpeed((float) (0.4f * this.speed * this.EntityBase.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));

                //Testing mode:
                //this.EntityBase.setAIMoveSpeed(0f);

                if (d2 > (double) this.EntityBase.stepHeight && d0 * d0 + d1 * d1 < (double) Math.max(1.0F, this.EntityBase.width)) {
                    this.EntityBase.getJumpHelper().setJumping();
                    this.action = EntityMoveHelper.Action.JUMPING;
                }
            } else if (this.action == EntityMoveHelper.Action.JUMPING) {
                this.EntityBase.setAIMoveSpeed((float) (this.speed * this.EntityBase.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));

                if (this.EntityBase.onGround) {
                    this.action = EntityMoveHelper.Action.WAIT;
                }
            } else {
                this.EntityBase.setMoveForward(0.0F);
            }
        }
    }
}
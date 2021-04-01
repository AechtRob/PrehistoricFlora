package net.lepidodendron.entity.base;

import net.ilexiconn.llibrary.client.model.tools.ChainBuffer;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class EntityPrehistoricFloraJellyfishBase extends EntityWaterMob implements IAnimatedEntity {
    public BlockPos currentTarget;
    @SideOnly(Side.CLIENT)
    public ChainBuffer chainBuffer;

    public EntityPrehistoricFloraJellyfishBase(World world) {
        super(world);
        //this.spawnableBlock = Blocks.WATER;
        this.moveHelper = new EntityPrehistoricFloraJellyfishBase.SwimmingMoveHelper();
        this.navigator = new PathNavigateSwimmer(this, world);
        if (FMLCommonHandler.instance().getSide().isClient()) {
            this.chainBuffer = new ChainBuffer();
        }
    }

    private Animation animation = NO_ANIMATION;

    public static final Animation ANIMATION_FISH_WANDER = Animation.create(0);

    protected void initEntityAI() {}

    @Override
    public boolean isAIDisabled() {
        return false;
    }

    public abstract String getTexture();

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    protected abstract float getAISpeedJelly();

    @Override
    public boolean isInWater() {
        return super.isInWater() || this.isInsideOfMaterial(Material.WATER) || this.isInsideOfMaterial(Material.CORAL);
    }

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
    }

    public void onEntityUpdate()
    {
        int i = this.getAir();
        super.onEntityUpdate();

        if (this.isEntityAlive() && !isInWater())
        {
            --i;
            this.setAir(i);

            if (this.getAir() == -20)
            {
                this.setAir(0);
                this.attackEntityFrom(DamageSource.DROWN, 2.0F);
            }
        }
        else
        {
            this.setAir(300);
        }
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
        private final EntityPrehistoricFloraJellyfishBase EntityBase = EntityPrehistoricFloraJellyfishBase.this;

        public SwimmingMoveHelper() {
            super(EntityPrehistoricFloraJellyfishBase.this);
        }

        @Override
        public void onUpdateMoveHelper() {
            if (this.action == Action.MOVE_TO && !this.EntityBase.getNavigator().noPath()) {
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

                    this.EntityBase.rotationYaw = this.limitAngle(this.EntityBase.rotationYaw, angle, 10.0F);

                    //this.EntityBase.setAIMoveSpeed(0.05F);
                    float speed = getAISpeedJelly();
                    this.EntityBase.setAIMoveSpeed(speed);

                    this.EntityBase.motionY += (double) this.EntityBase.getAIMoveSpeed() * distanceY * 0.1D;
                } else {
                    this.EntityBase.setAIMoveSpeed(0.0F);
                }
            }
        }
    }
}
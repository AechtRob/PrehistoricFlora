package net.lepidodendron.entity.base;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.lepidodendron.LepidodendronConfig;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public abstract class EntityPrehistoricFloraAgeableBase extends EntityTameable implements IAnimatedEntity  {

    private static final DataParameter<Integer> AGETICKS = EntityDataManager.createKey(EntityPrehistoricFloraAgeableBase.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> SATIETY = EntityDataManager.createKey(EntityPrehistoricFloraAgeableBase.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> HUNTING = EntityDataManager.createKey(EntityPrehistoricFloraAgeableBase.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> RESENTFUL = EntityDataManager.createKey(EntityPrehistoricFloraAgeableBase.class, DataSerializers.BOOLEAN);

    private static final DataParameter<Boolean> ISFAST = EntityDataManager.createKey(EntityPrehistoricFloraAgeableBase.class, DataSerializers.BOOLEAN);

    //public float minSize;
    public float minWidth;
    public float maxWidth;
    public float maxHeight;
    public double maxHealthAgeable;
    private int animationTick;
    public Animation ATTACK_ANIMATION;
    public Animation ROAR_ANIMATION;
    private Animation currentAnimation;

    public EntityPrehistoricFloraAgeableBase(World worldIn) {
        super(worldIn);
        this.setScaleForAge(false);
        ATTACK_ANIMATION = Animation.create(this.getAttackLength());
        ROAR_ANIMATION = Animation.create(this.getRoarLength());
    }

    @Override
    public float getEyeHeight() {
        return Math.max(super.getEyeHeight(), 0.3F);
    }

    public int getAttackLength() {
        return 20;
    }

    public int getRoarLength() {
        return 60;
    }

    @Override
    public int getAnimationTick() {
        return animationTick;
    }

    @Override
    public void setAnimationTick(int tick) {
        animationTick = tick;
    }

    @Override
    public Animation getAnimation() {
        return currentAnimation == null ? NO_ANIMATION : currentAnimation;
    }

    @Override
    public void setAnimation(Animation animation)
    {
        currentAnimation = animation;
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{ATTACK_ANIMATION};
    }

    public SoundEvent getSoundForAnimation(Animation animation) {
        return null;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(AGETICKS, getAdultAge());
        this.dataManager.register(HUNTING, false);
        this.dataManager.register(RESENTFUL, false);
        this.dataManager.register(SATIETY, 0);
        this.dataManager.register(ISFAST, false);
        this.setScaleForAge(false);
    }

    @Override
    public boolean isInWater() {
        if (this.world.isAirBlock(this.getPosition())) {return false;}
        return super.isInWater() || (this.world.getBlockState(this.getPosition()).getMaterial() == Material.WATER) || this.isInsideOfMaterial(Material.WATER) || this.isInsideOfMaterial(Material.CORAL);
    }

    public void launchAttack() {
        IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        if (getAttackTarget() != null) {
            boolean b = this.getAttackTarget().attackEntityFrom(DamageSource.causeMobDamage(this), (float) iattributeinstance.getAttributeValue());
        }
    }

    public AxisAlignedBB getAttackBoundingBox() {
        float size = this.getRenderSizeModifier() * 0.25F;
        return this.getEntityBoundingBox().grow(1.0F + size, 1.0F + size, 1.0F + size);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable entity) {
        return null;
    }

    public int getAgeTicks() {
        return this.dataManager.get(AGETICKS);
    }

    public void setAgeTicks(int ageticks) {
        this.dataManager.set(AGETICKS, ageticks);
    }

    public int getSatiety() {
        return this.dataManager.get(SATIETY);
    }

    public void setSatiety(int satiety) {
        this.dataManager.set(SATIETY, satiety);
    }

    public boolean getWillHunt() {
        return this.dataManager.get(HUNTING);
    }

    public void setWillHunt(boolean willHunt) {
        this.dataManager.set(HUNTING, willHunt);
    }

    public boolean getResentful() {
        return this.dataManager.get(RESENTFUL);
    }

    public void setResentful(boolean isResentful) {
        this.dataManager.set(RESENTFUL, isResentful);
    }

    public double getMaxHealthAgeable()
    {
        return maxHealthAgeable;
    }

    public abstract int getAdultAge();

    public boolean getIsFast() {
        return this.dataManager.get(ISFAST);
    }

    public void setIsFast(boolean isFast) {
        this.dataManager.set(ISFAST, isFast);
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        livingdata = super.onInitialSpawn(difficulty, livingdata);
        this.setAgeTicks(this.getAdultAge()-1);
        this.setResentful(false);
        this.setIsFast(false);
        this.setWillHunt(false);
        this.heal(this.getMaxHealth());
        this.setNoAI(false);
        return livingdata;
    }

    public void selectNavigator() {
        //Used for complex navigation only
        this.moveHelper = this.getMoveHelper();
        this.navigator = this.getNavigator();
    }

    @Override
    public void setScaleForAge(boolean child) {
        //System.err.println("AgeScale: " + this.getAgeScale());
        //System.err.println("width: " + (this.getAgeScale() * this.maxWidth));
        //System.err.println("height: " + (this.getAgeScale() * this.maxHeight));
        this.setSizer(this.getAgeScale() * this.maxWidth, this.getAgeScale() * this.maxHeight);
    }

    //Taken from the Entity class, not the EntityAgeable class
    protected void setSizer(float width, float height)
    {
        if (width != this.width || height != this.height)
        {
            this.width = width;
            this.height = height;

            double d0 = (double)width / 2.0D;
            this.setEntityBoundingBox(new AxisAlignedBB(this.posX - d0, this.posY, this.posZ - d0, this.posX + d0, this.posY + (double)this.height, this.posZ + d0));
        }
    }

    public float getAgeScale() {
        float step = 1F / (this.getAdultAge() + 1);
        if (this.getAgeTicks() >= this.getAdultAge()) {
            return 1;
        }
        return Math.max((this.minWidth/this.maxWidth), (step * this.getAgeTicks()));
    }

    //@Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("AgeTicks", this.getAgeTicks());
        compound.setInteger("Satiety", this.getSatiety());
        compound.setBoolean("isResentful", this.getResentful());
        compound.setBoolean("willHunt", this.getWillHunt());
        compound.setBoolean("isFast", this.getIsFast());
    }

    //@Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setAgeTicks(compound.getInteger("AgeTicks"));
        this.setSatiety(compound.getInteger("Satiety"));
        this.setResentful(compound.getBoolean("isResentful"));
        this.setWillHunt(compound.getBoolean("willHunt"));
        this.setIsFast(compound.getBoolean("isFast"));
    }

    @Override
    public boolean attackEntityFrom(DamageSource ds, float i) {
        if (ds == DamageSource.IN_WALL) {
            return false;
        }
        if (this.getHurtSound(DamageSource.GENERIC) != null && i >= 1 && ds != DamageSource.IN_WALL) {
            if (this.getAnimation() != null) {
                if (this.getAnimation() == NO_ANIMATION && world.isRemote) {
                    this.setAnimation(ROAR_ANIMATION);
                    //System.err.println("Hit");
                }
            }
        }
        return super.attackEntityFrom(ds, i);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!world.isRemote) {
            this.setIsFast(this.getAttackTarget() != null);
            //System.err.println("Entity side isFast: " + this.getIsFast());
        }
        //AnimationHandler.INSTANCE.updateAnimations(this);
    }

    public void onEntityUpdate()
    {
        AnimationHandler.INSTANCE.updateAnimations(this);
        super.onEntityUpdate();

        if (world.isRemote) {
            this.setScaleForAge(false);
        }
        if (this.getGrowingAge() < 0) {
            this.setGrowingAge(0); //Resetting vanilla methods which we don't use
        }

        int i = this.getAgeTicks();

        if (this.isEntityAlive())
        {
            ++i;
            //throttle at 100k
            if (i >= 100000) {i = 100000;}
            this.setAgeTicks(i);
        }

        double oldHealthMax = this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).getBaseValue();
        float oldHealth = this.getHealth();
        //System.err.println("Old Max Health: " + oldHealthMax);
        //System.err.println("Old Health: " + oldHealth);

        float oldHealthRatio = (float) (oldHealth / (float) oldHealthMax);
        //System.err.println("Old Health Ratio: " + oldHealthRatio);

        double newHealthMax = (double) (getMaxHealthAgeable() * getAgeScale());
        newHealthMax = Math.min((Math.round((newHealthMax * 2D)))/2D, getMaxHealthAgeable());
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(newHealthMax);

        float newHealth = (float) newHealthMax * oldHealthRatio;
        newHealth = (Math.round((newHealth * 2F)))/2.0F;
        newHealth = Math.min(newHealth,(float)newHealthMax);
        this.setHealth(newHealth);
        //System.err.println("New Health Max: " + newHealthMax);
        //System.err.println("New Health: " + newHealth);

        double aHealth = (double) LepidodendronConfig.attackHealth;
        if (aHealth > 100) {aHealth = 100;}
        if (aHealth < 0) {aHealth = 0;}
        aHealth = aHealth/100D;
        this.setWillHunt(oldHealthRatio < (float) aHealth);
        double adult = (double) LepidodendronConfig.adultAge;
        if (adult > 100) {adult = 100;}
        if (adult < 0) {adult = 0;}
        adult = adult/100D;
        if (getAgeScale() < adult) {
            setWillHunt(false);
        }

    }

    public void eatItem(ItemStack stack) {
        if (stack != null && stack.getItem() != null) {
            float itemHealth = 0.5F; //Default minimal nutrition
            if (stack.getItem() instanceof ItemFood) {
                itemHealth = ((ItemFood) stack.getItem()).getHealAmount(stack);
            }
            this.setHealth(Math.min(this.getHealth() + itemHealth, (float) this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).getBaseValue()));
            stack.shrink(1);
            if (this.getAnimation() == NO_ANIMATION && !world.isRemote) {
                this.setAnimation(ATTACK_ANIMATION);
                //AnimationHandler.INSTANCE.sendAnimationMessage(this, ATTACK_ANIMATION);
                SoundEvent soundevent = SoundEvents.ENTITY_GENERIC_EAT;
                this.getEntityWorld().playSound(null, this.getPosition(), soundevent, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
        }
    }
}


package net.lepidodendron.entity;

import net.ilexiconn.llibrary.client.model.tools.ChainBuffer;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.lepidodendron.entity.ai.JellyfishWander;
import net.lepidodendron.entity.base.EntityPrehistoricFloraJellyfishBase;
import net.lepidodendron.item.ItemBucketJellyfish1;
import net.minecraft.block.material.Material;
import net.minecraft.entity.*;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.world.World;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;

import net.minecraftforge.items.ItemHandlerHelper;

public class EntityPrehistoricFloraJellyfish1 extends EntityPrehistoricFloraJellyfishBase {

    public BlockPos currentTarget;
    @SideOnly(Side.CLIENT)
    public ChainBuffer chainBuffer;
    private int animationTick;
    private Animation animation = NO_ANIMATION;

    public EntityPrehistoricFloraJellyfish1(World world) {
        super(world);
        setSize(0.8F, 0.5F);
        experienceValue = 0;
        this.isImmuneToFire = false;
        setNoAI(!true);
        enablePersistence();
    }

    //Arbitrary for jellyfish as there is no specific AI animation:
    public static final Animation ANIMATION_JELLYFISH_WANDER = Animation.create(0);

    protected void initEntityAI() {
        tasks.addTask(0, new JellyfishWander(this, ANIMATION_JELLYFISH_WANDER));
    }

    @Override
    public String getTexture() {
        return this.getTexture();
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    protected float getAISpeedJelly() {
        return 0.05f;
    }

    @Override
    public int getAnimationTick() {
        return getAnimationTick();
    }

    @Override
    public void setAnimationTick(int tick)
    {
        animationTick = tick;
    }

    @Override
    public Animation getAnimation()
    {
        return null;
    }

    @Override
    public void setAnimation(Animation animation)
    {
        this.animation = animation;
    }

    @Override
    public Animation[] getAnimations()
    {
        return null;
    }

    @Override
    public boolean isInWater() {
        return super.isInWater() || this.isInsideOfMaterial(Material.WATER) || this.isInsideOfMaterial(Material.CORAL);
    }

    @Override
    public net.minecraft.util.SoundEvent getAmbientSound() {
        return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
    }

    @Override
    public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
        return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.hurt"));
    }

    @Override
    public net.minecraft.util.SoundEvent getDeathSound() {
        return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.death"));
    }

    @Override
    protected float getSoundVolume() {
        return 1.0F;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.renderYawOffset = this.rotationYaw;
    }

    public void onEntityUpdate()
    {
        super.onEntityUpdate();
    }

    @Override
    protected void collideWithEntity(Entity entityIn) {
        super.collideWithEntity(entityIn);
        if (entityIn instanceof EntityLivingBase && !(entityIn instanceof EntityPrehistoricFloraJellyfishBase)
            && !(entityIn instanceof EntityMob)) {
            entityIn.attackEntityFrom(DamageSource.CACTUS, (float) 2);
        }
    }

    @Override
    protected Item getDropItem() {
        //return new ItemStack(ItemJellyfishMeat.block, (int) (1)).getItem();
        return null;
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if (!itemstack.isEmpty())
        {
            if (itemstack.getItem() == Items.WATER_BUCKET)
            {
                player.inventory.clearMatchingItems(new ItemStack(Items.WATER_BUCKET, (int) (1)).getItem(), -1, (int) 1, null);
                SoundEvent soundevent = SoundEvents.ITEM_BUCKET_FILL;
                player.getEntityWorld().playSound(player, player.getPosition(), soundevent, SoundCategory.BLOCKS, 1.0F, 1.0F);
                ItemStack itemstack1 = new ItemStack(ItemBucketJellyfish1.block, (int) (1));
                itemstack1.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(player, itemstack1);
                this.setDead();
                return true;
            }
        }

        return super.processInteract(player, hand);
    }

}
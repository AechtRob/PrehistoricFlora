
package net.lepidodendron.entity;

import net.ilexiconn.llibrary.client.model.tools.ChainBuffer;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.lepidodendron.block.BlockAncientMoss;
import net.lepidodendron.block.BlockDollyphyton;
import net.lepidodendron.block.BlockEdwardsiphyton;
import net.lepidodendron.block.BlockSelaginella;
import net.lepidodendron.entity.ai.LandWander;
import net.lepidodendron.entity.base.EntityPrehistoricFloraLandBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class EntityPrehistoricFloraPneumodesmus extends EntityPrehistoricFloraLandBase {

	public BlockPos currentTarget;
	@SideOnly(Side.CLIENT)
	public ChainBuffer chainBuffer;
	private int animationTick;
	private Animation animation = NO_ANIMATION;

	public EntityPrehistoricFloraPneumodesmus(World world) {
		super(world);
		setSize(0.3F, 0.3F);
		experienceValue = 0;
		this.isImmuneToFire = false;
		setNoAI(!true);
		enablePersistence();
	}

	@Override
	public int getAnimationTick() {
		return getAnimationTick();
	}

	@Override
	protected float getAISpeedLand() {
		return 0.35f;
	}

	@Override
	public void setAnimationTick(int tick) {
		animationTick = tick;
	}

	@Override
	public Animation getAnimation() {
		return null;
	}

	@Override
	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	@Override
	public Animation[] getAnimations() {
		return null;
	}

	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new LandWander(this, NO_ANIMATION));
		tasks.addTask(2, new EntityAILookIdle(this));
	}

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	public String getTexture() {
		return this.getTexture();
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}

	@Override
	protected boolean canDespawn() {
		return false;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(0.8D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
	}

	@Override
	public net.minecraft.util.SoundEvent getAmbientSound() {
		return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
				.getObject(new ResourceLocation("lepidodendron:pneudodesmus_idle"));
	}
	//@Override
	//public net.minecraft.util.SoundEvent getAmbientSound() {
	//	return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
	//}

	@Override
	public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
		return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
				.getObject(new ResourceLocation("lepidodendron:pneudodesmus_hurt"));
	}
	//@Override
	//public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
	//	return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.hurt"));
	//}

	@Override
	public net.minecraft.util.SoundEvent getDeathSound() {
		return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
				.getObject(new ResourceLocation("lepidodendron:pneudodesmus_death"));
	}
	//@Override
	//public net.minecraft.util.SoundEvent getDeathSound() {
	//	return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.death"));
	//}

	@Override
	protected float getSoundVolume() {
		return 0.5F;
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.renderYawOffset = this.rotationYaw;

		//Eat moss!
		BlockPos pos = this.getPosition();
		if ((this.getHealth() < this.getMaxHealth())
			&& ((this.world.getBlockState(pos).getBlock() == BlockDollyphyton.block)
			|| (this.world.getBlockState(pos).getBlock() == BlockEdwardsiphyton.block)
			|| (this.world.getBlockState(pos).getBlock() == BlockAncientMoss.block)
			|| (this.world.getBlockState(pos).getBlock() == BlockSelaginella.block))
		) {
			this.world.destroyBlock(pos,false);
			this.setHealth(this.getHealth() + 0.5F);
		}

	}

	public void onEntityUpdate() {
		super.onEntityUpdate();
	}

	@Override
	protected Item getDropItem() {
		return null;
		//return new ItemStack(ItemAcanthodesMeat.block, (int) (1)).getItem();
	}

}
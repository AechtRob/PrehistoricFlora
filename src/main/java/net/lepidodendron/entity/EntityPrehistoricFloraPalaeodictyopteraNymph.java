
package net.lepidodendron.entity;

import net.ilexiconn.llibrary.client.model.tools.ChainBuffer;
import net.lepidodendron.entity.ai.EurypteridWander;
import net.lepidodendron.entity.base.EntityPrehistoricFloraEurypteridBase;
import net.lepidodendron.item.ItemBucketAsaphus;
import net.lepidodendron.item.ItemBucketPalaeodictyopteraNymph;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemHandlerHelper;

import javax.annotation.Nullable;

public class EntityPrehistoricFloraPalaeodictyopteraNymph extends EntityPrehistoricFloraEurypteridBase {

	public BlockPos currentTarget;
	@SideOnly(Side.CLIENT)
	public ChainBuffer chainBuffer;

	public EntityPrehistoricFloraPalaeodictyopteraNymph(World world) {
		super(world);
		setSize(0.2F, 0.2F);
		experienceValue = 0;
		this.isImmuneToFire = false;
		setNoAI(!true);
		enablePersistence();
		minSize = 0.8F;
		maxSize = 1.0F;
		maxHealthAgeable = 5.0D;
	}

	@Override //Spawn as baby so it grows:
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		this.setAgeTicks(0);
		this.heal(this.getMaxHealth());
		this.setNoAI(false);
		return livingdata;
	}

	@Override
	public int getAdultAge() {
		return 32000;
	}

	protected void initEntityAI() {
		tasks.addTask(0, new EurypteridWander(this, ANIMATION_FISH_WANDER));
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
		return EnumCreatureAttribute.UNDEFINED;
	}

	@Override
	protected boolean canDespawn() {
		return false;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(2.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	protected double getSwimSpeed() {
		return this.getSwimSpeed();
	}

	@Override
	public boolean isInWater() {
		return super.isInWater() || this.isInsideOfMaterial(Material.WATER) || this.isInsideOfMaterial(Material.CORAL);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		boolean isAtBottom = false;
		if (this.getPosition().getY() - 1 > 1) {
			BlockPos pos = new BlockPos(this.getPosition().getX(),this.getPosition().getY() - 1, this.getPosition().getZ());
			isAtBottom =  ((this.isInsideOfMaterial(Material.WATER) || this.isInsideOfMaterial(Material.CORAL))
					&& ((this.world.getBlockState(pos)).getMaterial() != Material.WATER));
		}
		if (isAtBottom && this.world.getBlockState(this.getPosition().up()).getMaterial() == Material.WATER) {
			this.setPositionAndUpdate(this.getPosition().up().getX(), this.getPosition().up().getY(), this.getPosition().up().getZ());
		}

		return super.attackEntityFrom(source, (amount));

	}

	//@Override
	//public net.minecraft.util.SoundEvent getAmbientSound() {
	//    return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
	//            .getObject(new ResourceLocation("lepidodendron:eurypterus_idle"));
	//}

	@Override
	public SoundEvent getAmbientSound() {
		return (SoundEvent) SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
	}


	//@Override
	//public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
	//    return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
	//            .getObject(new ResourceLocation("lepidodendron:eurypterus_hurt"));
	//}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return (SoundEvent) SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.hurt"));
	}

	//@Override
	//public net.minecraft.util.SoundEvent getDeathSound() {
	//    return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
	//            .getObject(new ResourceLocation("lepidodendron:eurypterus_death"));
	//}
	@Override
	public SoundEvent getDeathSound() {
		return (SoundEvent) SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.death"));
	}

	@Override
	protected float getSoundVolume() {
		return 1.0F;
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < (double) this.world.getSeaLevel() && this.isInWater();
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
		return 1 + this.world.rand.nextInt(1);
	}

	@Override
	public boolean isOnLadder() {
		return false;
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.renderYawOffset = this.rotationYaw;
	}

	public void onEntityUpdate()
	{
		super.onEntityUpdate();
		Entity entity = null;
		if (this.getAgeScale() >= 0.99)
		{
			if (!(world.isRemote)) {
				BlockPos pos = this.getPosition();
				int i = rand.nextInt(8);
				if (i == 0) {
					entity = ItemMonsterPlacer.spawnCreature(this.getEntityWorld(), EntityList.getKey(EntityPrehistoricFloraPalaeodictyoptera_Delitzschala.class), (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D);
				}
				if (i == 1) {
					entity = ItemMonsterPlacer.spawnCreature(this.getEntityWorld(), EntityList.getKey(EntityPrehistoricFloraPalaeodictyoptera_Dunbaria.class), (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D);
				}
				if (i == 2) {
					entity = ItemMonsterPlacer.spawnCreature(this.getEntityWorld(), EntityList.getKey(EntityPrehistoricFloraPalaeodictyoptera_Homaloneura.class), (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D);
				}
				if (i == 3) {
					entity = ItemMonsterPlacer.spawnCreature(this.getEntityWorld(), EntityList.getKey(EntityPrehistoricFloraPalaeodictyoptera_Homoioptera.class), (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D);
				}
				if (i == 4) {
					entity = ItemMonsterPlacer.spawnCreature(this.getEntityWorld(), EntityList.getKey(EntityPrehistoricFloraPalaeodictyoptera_Lithomantis.class), (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D);
				}
				if (i == 5) {
					entity = ItemMonsterPlacer.spawnCreature(this.getEntityWorld(), EntityList.getKey(EntityPrehistoricFloraPalaeodictyoptera_Lycocercus.class), (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D);
				}
				if (i == 6) {
					entity = ItemMonsterPlacer.spawnCreature(this.getEntityWorld(), EntityList.getKey(EntityPrehistoricFloraPalaeodictyoptera_Sinodunbaria.class), (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D);
				}
				if (i == 7) {
					entity = ItemMonsterPlacer.spawnCreature(this.getEntityWorld(), EntityList.getKey(EntityPrehistoricFloraPalaeodictyoptera_Stenodictya.class), (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D);
				}

				if (entity != null) {
					this.setDead();
					if (world instanceof WorldServer) {
						((WorldServer) world).playSound(null, pos.up(), SoundEvents.BLOCK_SLIME_BREAK, SoundCategory.BLOCKS, 0.5F, 2.6F + (rand.nextFloat() - rand.nextFloat()) * 0.8F);
						for (int k = 0; k < 8; ++k) {
							((WorldServer) world).spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, (double) pos.getX() + Math.random(), (double) pos.getY() + Math.random(), (double) pos.getZ() + Math.random() + Math.random(), (int) 1, 0.5, 0.5, 0.5, 0.1, new int[0]);
						}
					}
				}
			}
		}
	}

	public boolean isDirectPathBetweenPoints(Vec3d vec1, Vec3d vec2) {
		RayTraceResult movingobjectposition = this.world.rayTraceBlocks(vec1, new Vec3d(vec2.x, vec2.y, vec2.z), false, true, false);
		return movingobjectposition == null || movingobjectposition.typeOfHit != RayTraceResult.Type.BLOCK;
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return null;
	}

	@Override
	public void travel(float strafe, float vertical, float forward) {
		float f4;
		if (this.isServerWorld()) {
			if (this.isInWater()) {
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
				ItemStack itemstack1 = new ItemStack(ItemBucketPalaeodictyopteraNymph.block, (int) (1));
				itemstack1.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(player, itemstack1);
				this.setDead();
				return true;
			}
		}

		return super.processInteract(player, hand);
	}
}
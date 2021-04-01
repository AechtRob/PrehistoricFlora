package net.lepidodendron.entity.render;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraLimnoscelis;
import net.lepidodendron.entity.model.ModelLimnoscelis;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderLimnoscelis extends RenderLiving<EntityPrehistoricFloraLimnoscelis> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/limnoscelis.png");

    public RenderLimnoscelis(RenderManager mgr) {
        super(mgr, new ModelLimnoscelis(), 1.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraLimnoscelis entity) {
        return RenderLimnoscelis.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraLimnoscelis entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

}
package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraOrthoceras;
import net.lepidodendron.entity.model.entity.ModelOrthoceras;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderOrthoceras extends RenderLiving<EntityPrehistoricFloraOrthoceras> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/orthoceras.png");

    public RenderOrthoceras(RenderManager mgr) {
        super(mgr, new ModelOrthoceras(), 0.6f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraOrthoceras entity) {
        return RenderOrthoceras.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraOrthoceras entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

}
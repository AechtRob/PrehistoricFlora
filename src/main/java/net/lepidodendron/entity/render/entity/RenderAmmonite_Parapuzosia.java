package net.lepidodendron.entity.render.entity;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.EntityPrehistoricFloraAmmonite_Parapuzosia;
import net.lepidodendron.entity.model.entity.ModelAmmonite200pluscm;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderAmmonite_Parapuzosia extends RenderLiving<EntityPrehistoricFloraAmmonite_Parapuzosia> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/ammonite_parapuzosia.png");

    public RenderAmmonite_Parapuzosia(RenderManager mgr) {
        super(mgr, new ModelAmmonite200pluscm(), 1.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPrehistoricFloraAmmonite_Parapuzosia entity) {
        return RenderAmmonite_Parapuzosia.TEXTURE;
    }

    @Override
    protected void applyRotations(EntityPrehistoricFloraAmmonite_Parapuzosia entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }

}
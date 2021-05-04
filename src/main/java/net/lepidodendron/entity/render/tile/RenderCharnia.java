package net.lepidodendron.entity.render.tile;

import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.block.BlockCharnia;
import net.lepidodendron.entity.model.tile.ModelCharnia;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderCharnia extends TileEntitySpecialRenderer<BlockCharnia.TileEntityCustom> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(LepidodendronMod.MODID + ":textures/entities/charnia.png");
    private final ModelCharnia modelCharnia;

    public RenderCharnia() {
        this.modelCharnia = new ModelCharnia();
    }

    @Override
    public void render(BlockCharnia.TileEntityCustom entity, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        //GlStateManager.pushMatrix();
        this.bindTexture(TEXTURE);
        ModelCharnia modelCharnia = this.modelCharnia;
        GlStateManager.pushMatrix();
        GlStateManager.translate(x + 0.5, y + 2.5, z + 0.5);
        GlStateManager.rotate(180, 0F, 0F, 1F);
        modelCharnia.renderAll();
        GlStateManager.popMatrix();
    }
}
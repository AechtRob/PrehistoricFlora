package net.lepidodendron.entity.model;

import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAmmonite200cm extends AdvancedModelBase {
    public AdvancedModelRenderer Shell1;
    public AdvancedModelRenderer Shell2;
    public AdvancedModelRenderer Mantle;
    public AdvancedModelRenderer Shellbase;
    public AdvancedModelRenderer Shell3;
    public AdvancedModelRenderer Shell4;
    public AdvancedModelRenderer Shell5;
    public AdvancedModelRenderer Shell6;
    public AdvancedModelRenderer Shell7;
    public AdvancedModelRenderer Shell8;
    public AdvancedModelRenderer Shell9;
    public AdvancedModelRenderer Siphon;
    public AdvancedModelRenderer Tentacle1a;
    public AdvancedModelRenderer Tentacle2a;
    public AdvancedModelRenderer Tentacle3a;
    public AdvancedModelRenderer Tentacle4a;
    public AdvancedModelRenderer Tentacle5a;
    public AdvancedModelRenderer Tentacle6a;
    public AdvancedModelRenderer Tentacle7a;
    public AdvancedModelRenderer Tentacle8a;
    public AdvancedModelRenderer Tentacle9a;
    public AdvancedModelRenderer Tentacle10a;
    public AdvancedModelRenderer Tentacle1b;
    public AdvancedModelRenderer Tentacle2b;
    public AdvancedModelRenderer Tentacle3b;
    public AdvancedModelRenderer Tentacle4b;
    public AdvancedModelRenderer Tentacle5b;
    public AdvancedModelRenderer Tentacle6b;
    public AdvancedModelRenderer Tentacle7b;
    public AdvancedModelRenderer Tentacle8b;
    public AdvancedModelRenderer Tentacle9b;
    public AdvancedModelRenderer Tentacle10b;

    public ModelAmmonite200cm() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Tentacle5a = new AdvancedModelRenderer(this, 0, 7);
        this.Tentacle5a.setRotationPoint(0.800000011920929F, 1.399999976158142F, 3.5F);
        this.Tentacle5a.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tentacle5a, -0.46705011182842415F, 0.04241150198859518F, 0.12740903872453743F);
        this.Tentacle6a = new AdvancedModelRenderer(this, 0, 7);
        this.Tentacle6a.setRotationPoint(-1.399999976158142F, 3.5F, 3.5F);
        this.Tentacle6a.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tentacle6a, 0.5731661290180989F, -0.4881685797985891F, -2.4198989013636942F);
        this.Mantle = new AdvancedModelRenderer(this, 0, 14);
        this.Mantle.setRotationPoint(0.0F, -2.9000000953674316F, 5.800000190734863F);
        this.Mantle.addBox(-2.5F, 0.0F, 0.0F, 5, 5, 4, 0.0F);
        this.setRotateAngle(Mantle, -0.2972295835988592F, 0.0F, 0.0F);
        this.Shellbase = new AdvancedModelRenderer(this, 20, 17);
        this.Shellbase.setRotationPoint(-0.009999999776482582F, 2.9600000381469727F, 0.0F);
        this.Shellbase.addBox(-3.0F, -2.0F, 0.0F, 6, 2, 6, 0.0F);
        this.setRotateAngle(Shellbase, -0.12740903872453743F, 0.0F, 0.0F);
        this.Tentacle3b = new AdvancedModelRenderer(this, 1, 0);
        this.Tentacle3b.setRotationPoint(0.0F, 0.0F, 4.5F);
        this.Tentacle3b.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tentacle3b, -0.21223203437934937F, -0.1911135497644277F, 0.0F);
        this.Shell6 = new AdvancedModelRenderer(this, 27, 26);
        this.Shell6.setRotationPoint(0.0F, 1.100000023841858F, -4.349999904632568F);
        this.Shell6.addBox(-2.0F, -2.5F, -6.0F, 4, 5, 6, 0.0F);
        this.setRotateAngle(Shell6, -0.7005751510978795F, 0.0F, 0.0F);
        this.Tentacle2b = new AdvancedModelRenderer(this, 1, 0);
        this.Tentacle2b.setRotationPoint(0.0F, 0.0F, 4.5F);
        this.Tentacle2b.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tentacle2b, 0.169820528229565F, 0.04241150198859518F, 0.0F);
        this.Shell3 = new AdvancedModelRenderer(this, 0, 24);
        this.Shell3.setRotationPoint(-0.009999999776482582F, 0.8999999761581421F, -4.900000095367432F);
        this.Shell3.addBox(-3.0F, -3.0F, -7.0F, 6, 6, 7, 0.0F);
        this.setRotateAngle(Shell3, -0.7853981633974483F, 0.0F, 0.0F);
        this.Tentacle1a = new AdvancedModelRenderer(this, 0, 7);
        this.Tentacle1a.setRotationPoint(1.399999976158142F, 3.5F, 3.5F);
        this.Tentacle1a.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tentacle1a, 0.5731661290180989F, 0.4881685797985891F, 2.4198989013636942F);
        this.Tentacle6b = new AdvancedModelRenderer(this, 1, 0);
        this.Tentacle6b.setRotationPoint(0.0F, 0.0F, 4.5F);
        this.Tentacle6b.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tentacle6b, -0.36093409463874954F, 0.08482300397719036F, 0.0F);
        this.Shell2 = new AdvancedModelRenderer(this, 0, 38);
        this.Shell2.setRotationPoint(0.009999999776482582F, 0.3499999940395355F, 1.399999976158142F);
        this.Shell2.addBox(-3.0F, -3.0F, -7.0F, 6, 6, 7, 0.0F);
        this.setRotateAngle(Shell2, -0.4881685797985891F, 0.0F, 0.0F);
        this.Shell8 = new AdvancedModelRenderer(this, 48, 33);
        this.Shell8.setRotationPoint(0.0F, 0.30000001192092896F, -3.799999952316284F);
        this.Shell8.addBox(-1.5F, -2.5F, -5.0F, 3, 5, 5, 0.0F);
        this.setRotateAngle(Shell8, -0.4881685797985891F, 0.0F, 0.0F);
        this.Shell7 = new AdvancedModelRenderer(this, 46, 47);
        this.Shell7.setRotationPoint(-0.009999999776482582F, 1.0F, -4.0F);
        this.Shell7.addBox(-2.0F, -2.5F, -5.0F, 4, 5, 5, 0.0F);
        this.setRotateAngle(Shell7, -0.9552186916270132F, 0.0F, 0.0F);
        this.Tentacle2a = new AdvancedModelRenderer(this, 0, 7);
        this.Tentacle2a.setRotationPoint(1.5499999523162842F, 2.9000000953674316F, 3.5F);
        this.Tentacle2a.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tentacle2a, -0.31834805156902407F, -0.5307546228683145F, -1.1674507260063627F);
        this.Siphon = new AdvancedModelRenderer(this, 9, 2);
        this.Siphon.setRotationPoint(0.0F, 2.5F, 0.0F);
        this.Siphon.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 5, 0.0F);
        this.setRotateAngle(Siphon, -0.2972295835988592F, 0.0F, 0.0F);
        this.Tentacle9a = new AdvancedModelRenderer(this, 0, 7);
        this.Tentacle9a.setRotationPoint(-1.4500000476837158F, 1.7999999523162842F, 3.5F);
        this.Tentacle9a.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tentacle9a, -0.2972295835988592F, -0.38205256260891435F, -0.8915142138766367F);
        this.Shell4 = new AdvancedModelRenderer(this, 25, 51);
        this.Shell4.setRotationPoint(0.0F, 1.1100000143051147F, -4.659999847412109F);
        this.Shell4.addBox(-2.5F, -3.0F, -7.0F, 5, 6, 7, 0.0F);
        this.setRotateAngle(Shell4, -0.8915142138766367F, 0.0F, 0.0F);
        this.Tentacle4b = new AdvancedModelRenderer(this, 1, 0);
        this.Tentacle4b.setRotationPoint(0.0F, 0.0F, 4.5F);
        this.Tentacle4b.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tentacle4b, -0.08482300397719036F, -0.06370451936226872F, 0.0F);
        this.Shell5 = new AdvancedModelRenderer(this, 27, 38);
        this.Shell5.setRotationPoint(0.009999999776482582F, 1.0199999809265137F, -4.75F);
        this.Shell5.addBox(-2.5F, -3.0F, -6.0F, 5, 6, 6, 0.0F);
        this.setRotateAngle(Shell5, -0.8491027077268521F, 0.0F, 0.0F);
        this.Tentacle10a = new AdvancedModelRenderer(this, 0, 7);
        this.Tentacle10a.setRotationPoint(-0.800000011920929F, 1.399999976158142F, 3.5F);
        this.Tentacle10a.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tentacle10a, -0.46705011182842415F, -0.04241150198859518F, -0.12740903872453743F);
        this.Tentacle8b = new AdvancedModelRenderer(this, 1, 0);
        this.Tentacle8b.setRotationPoint(0.0F, 0.0F, 4.5F);
        this.Tentacle8b.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tentacle8b, -0.21223203437934937F, 0.1911135497644277F, 0.0F);
        this.Shell1 = new AdvancedModelRenderer(this, 0, 52);
        this.Shell1.setRotationPoint(0.0F, 20.5F, 0.0F);
        this.Shell1.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(Shell1, 0.6155776271784F, 0.0F, 0.0F);
        this.Tentacle5b = new AdvancedModelRenderer(this, 1, 0);
        this.Tentacle5b.setRotationPoint(0.0F, 0.0F, 4.5F);
        this.Tentacle5b.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tentacle5b, -0.04241150198859518F, -0.10611601718967469F, 0.0F);
        this.Tentacle1b = new AdvancedModelRenderer(this, 1, 0);
        this.Tentacle1b.setRotationPoint(0.0F, 0.0F, 4.5F);
        this.Tentacle1b.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tentacle1b, -0.36093409463874954F, -0.08482300397719036F, 0.0F);
        this.Tentacle9b = new AdvancedModelRenderer(this, 1, 0);
        this.Tentacle9b.setRotationPoint(0.0F, 0.0F, 4.5F);
        this.Tentacle9b.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tentacle9b, -0.08482300397719036F, 0.06370451936226872F, 0.0F);
        this.Tentacle4a = new AdvancedModelRenderer(this, 0, 7);
        this.Tentacle4a.setRotationPoint(1.4500000476837158F, 1.7999999523162842F, 3.5F);
        this.Tentacle4a.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tentacle4a, -0.2972295835988592F, 0.38205256260891435F, 0.8915142138766367F);
        this.Shell9 = new AdvancedModelRenderer(this, 50, 23);
        this.Shell9.setRotationPoint(0.009999999776482582F, -1.899999976158142F, -3.5999999046325684F);
        this.Shell9.addBox(-1.5F, -2.5F, -4.0F, 3, 5, 4, 0.0F);
        this.setRotateAngle(Shell9, -2.122669484212403F, 0.0F, 0.0F);
        this.Tentacle7a = new AdvancedModelRenderer(this, 0, 7);
        this.Tentacle7a.setRotationPoint(-1.5499999523162842F, 3.0F, 3.5F);
        this.Tentacle7a.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tentacle7a, -0.31834805156902407F, 0.5307546228683145F, 1.1674507260063627F);
        this.Tentacle3a = new AdvancedModelRenderer(this, 0, 7);
        this.Tentacle3a.setRotationPoint(1.7999999523162842F, 2.200000047683716F, 3.5F);
        this.Tentacle3a.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tentacle3a, -0.021293017373673524F, 0.6155776351678833F, 1.314407417066352F);
        this.Tentacle8a = new AdvancedModelRenderer(this, 0, 7);
        this.Tentacle8a.setRotationPoint(-1.7999999523162842F, 2.200000047683716F, 3.5F);
        this.Tentacle8a.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tentacle8a, -0.021293017373673524F, -0.6155776351678833F, -1.31615285284479F);
        this.Tentacle7b = new AdvancedModelRenderer(this, 1, 0);
        this.Tentacle7b.setRotationPoint(0.0F, 0.0F, 4.5F);
        this.Tentacle7b.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tentacle7b, 0.169820528229565F, -0.04241150198859518F, 0.0F);
        this.Tentacle10b = new AdvancedModelRenderer(this, 1, 0);
        this.Tentacle10b.setRotationPoint(0.0F, 0.0F, 4.5F);
        this.Tentacle10b.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tentacle10b, -0.04241150198859518F, 0.10611601718967469F, 0.0F);
        this.Mantle.addChild(this.Tentacle5a);
        this.Mantle.addChild(this.Tentacle6a);
        this.Shell1.addChild(this.Mantle);
        this.Shell1.addChild(this.Shellbase);
        this.Tentacle3a.addChild(this.Tentacle3b);
        this.Shell5.addChild(this.Shell6);
        this.Tentacle2a.addChild(this.Tentacle2b);
        this.Shell2.addChild(this.Shell3);
        this.Mantle.addChild(this.Tentacle1a);
        this.Tentacle6a.addChild(this.Tentacle6b);
        this.Shell1.addChild(this.Shell2);
        this.Shell7.addChild(this.Shell8);
        this.Shell6.addChild(this.Shell7);
        this.Mantle.addChild(this.Tentacle2a);
        this.Mantle.addChild(this.Siphon);
        this.Mantle.addChild(this.Tentacle9a);
        this.Shell3.addChild(this.Shell4);
        this.Tentacle4a.addChild(this.Tentacle4b);
        this.Shell4.addChild(this.Shell5);
        this.Mantle.addChild(this.Tentacle10a);
        this.Tentacle8a.addChild(this.Tentacle8b);
        this.Tentacle5a.addChild(this.Tentacle5b);
        this.Tentacle1a.addChild(this.Tentacle1b);
        this.Tentacle9a.addChild(this.Tentacle9b);
        this.Mantle.addChild(this.Tentacle4a);
        this.Shell8.addChild(this.Shell9);
        this.Mantle.addChild(this.Tentacle7a);
        this.Mantle.addChild(this.Tentacle3a);
        this.Mantle.addChild(this.Tentacle8a);
        this.Tentacle7a.addChild(this.Tentacle7b);
        this.Tentacle10a.addChild(this.Tentacle10b);

        this.Tentacle1a.rotateAngleX = 0.9F;
        this.Tentacle2a.rotateAngleX = -0.6F;
        this.Tentacle3a.rotateAngleX = 0.2F;
        this.Tentacle4a.rotateAngleX = 0F;
        this.Tentacle5a.rotateAngleX = -0.1F;
        this.Tentacle6a.rotateAngleX = 0.9F;
        this.Tentacle7a.rotateAngleX = -0.6F;
        this.Tentacle8a.rotateAngleX = 0.2F;
        this.Tentacle9a.rotateAngleX = 0F;
        this.Tentacle10a.rotateAngleX = -0.1F;

        //2

        updateDefaultPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Shell1.render(f5 * 1.75F);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, e);

        this.resetToDefaultPose();
        this.Shell1.offsetY = -0.2F;

        AdvancedModelRenderer[] tentacle1 = {this.Tentacle1a, this.Tentacle1b};
        AdvancedModelRenderer[] tentacle2 = {this.Tentacle2a, this.Tentacle2b};
        AdvancedModelRenderer[] tentacle3 = {this.Tentacle3a, this.Tentacle3b};
        AdvancedModelRenderer[] tentacle4 = {this.Tentacle4a, this.Tentacle4b};
        AdvancedModelRenderer[] tentacle5 = {this.Tentacle5a, this.Tentacle5b};
        AdvancedModelRenderer[] tentacle6 = {this.Tentacle6a, this.Tentacle6b};
        AdvancedModelRenderer[] tentacle7 = {this.Tentacle7a, this.Tentacle7b};
        AdvancedModelRenderer[] tentacle8 = {this.Tentacle8a, this.Tentacle8b};
        AdvancedModelRenderer[] tentacle9 = {this.Tentacle9a, this.Tentacle9b};
        AdvancedModelRenderer[] tentacle10 = {this.Tentacle10a, this.Tentacle10b};

        float speed = 0.09F;
        if (!e.isInWater()) {
            speed = 0.5F;
        }

        //Left:
        this.chainWave(tentacle3, speed, 0.3F, -2, f2, 1F);
        //Left lower middle:
        this.chainWave(tentacle2, speed, -0.3F, -2, f2, 1F);
        this.chainFlap(tentacle2, speed, -0.3F, -2, f2, 1F);
        //Left lower bottom:
        this.chainWave(tentacle1, speed, 0.3F, -2, f2, 1F);
        //Left upper middle:
        this.chainWave(tentacle4, speed, 0.3F, -2, f2, 1F);
        //Left upper top:
        this.chainWave(tentacle5, speed, 0.3F, -2, f2, 1F);

        //Right:
        this.chainWave(tentacle8, speed, 0.3F, -2, f2, 1F);
        //Right lower middle:
        this.chainWave(tentacle7, speed, -0.3F, -2, f2, 1F);
        this.chainFlap(tentacle7, speed, 0.3F, -2, f2, 1F);
        //Right lower bottom:
        this.chainWave(tentacle6, speed, 0.3F, -2, f2, 1F);
        //Right upper middle:
        this.chainWave(tentacle9, speed, 0.3F, -2, f2, 1F);
        //Right upper top:
        this.chainWave(tentacle10, speed, 0.3F, -2, f2, 1F);

        if (e.isInWater()) {
            this.bob(Shell1, 0.1F, 0.75F, false, f2, 2);
            //this.body.offsetX = this.moveBox(speed, 1.5F, true, 2, 1.5F);
        }
        else {
            this.Shell1.rotateAngleZ = (float) Math.toRadians(90);
            this.Shell1.offsetY = -1.0F;
        }

    }

}

package defeatedcrow.hac.food.client;

import defeatedcrow.hac.core.client.base.DCFoodModelBase;
import defeatedcrow.hac.food.client.model.ModelTumbler;
import defeatedcrow.hac.food.entity.EntityTeaCupSilver;
import defeatedcrow.hac.main.MainInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TumblerRenderer extends DCEntityRenderBase<EntityTeaCupSilver> {

	private static final ResourceLocation RAW_TEX = new ResourceLocation("dcs_climate",
			"textures/entity/food/tumbler_glass.png");
	private static final ModelTumbler MODEL = new ModelTumbler(false);

	public TumblerRenderer(RenderManager renderManager) {
		super(renderManager);
	}

	@Override
	public void doRender(EntityTeaCupSilver entity, double x, double y, double z, float yaw, float partialTicks) {
		Fluid f = FluidRegistry.getFluid(entity.getFluidName());
		if (f != null) {
			renderFluid(f, x, y, z, entity.rotationYaw, partialTicks, 0.98F, false);
		}
		if (entity.getMilk() != 0) {
			renderFluid(MainInit.cream, x, y, z, entity.rotationYaw, partialTicks, 0.5F, true);
		}
		super.doRender(entity, x, y + 0.125D, z, yaw, partialTicks);
	}

	@Override
	protected float getScale() {
		return 0.5F;
	}

	@Override
	protected ResourceLocation getFoodTexture() {
		return RAW_TEX;
	}

	@Override
	protected DCFoodModelBase getEntityModel() {
		return MODEL;
	}

	private void renderFluid(Fluid fluid, double x, double y, double z, float r, float partialTicks, float alpha,
			boolean isMilk) {
		GlStateManager.disableLighting();
		TextureMap texturemap = Minecraft.getMinecraft().getTextureMapBlocks();
		TextureAtlasSprite textureatlassprite = texturemap.getAtlasSprite(fluid.getStill().toString());
		GlStateManager.pushMatrix();
		GlStateManager.enableBlend();
		GlStateManager
				.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		GlStateManager.translate((float) x, (float) y, (float) z);
		float f2 = 0.375F;
		float f = 0.075F;
		float f3 = 0.075F;
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder vertexbuffer = tessellator.getBuffer();
		if (isMilk) {
			GlStateManager.scale(1.01F, 1.01F, 1.01F);
		}
		GlStateManager.rotate(-r, 0.0F, 1.0F, 0.0F);
		GlStateManager.color(1.0F, 1.0F, 1.0F, alpha);

		int i = 0;
		vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);

		this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
		float uM = textureatlassprite.getMinU();
		float vM = textureatlassprite.getMinV();
		float uX = textureatlassprite.getMaxU();
		float vX = textureatlassprite.getMaxV();

		vertexbuffer.pos(f, f2, -f).tex(uX, vM).endVertex();
		vertexbuffer.pos(-f, f2, -f).tex(uM, vM).endVertex();
		vertexbuffer.pos(-f, f2, f).tex(uM, vX).endVertex();
		vertexbuffer.pos(f, f2, f).tex(uX, vX).endVertex();

		vertexbuffer.pos(f, f3, -f).tex(uM, vX).endVertex();
		vertexbuffer.pos(f, f2, -f).tex(uM, vM).endVertex();
		vertexbuffer.pos(f, f2, f).tex(uX, vM).endVertex();
		vertexbuffer.pos(f, f3, f).tex(uX, vX).endVertex();

		vertexbuffer.pos(-f, f3, f).tex(uM, vX).endVertex();
		vertexbuffer.pos(-f, f2, f).tex(uM, vM).endVertex();
		vertexbuffer.pos(-f, f2, -f).tex(uX, vM).endVertex();
		vertexbuffer.pos(-f, f3, -f).tex(uX, vX).endVertex();

		vertexbuffer.pos(f, f3, f).tex(uM, vX).endVertex();
		vertexbuffer.pos(f, f2, f).tex(uM, vM).endVertex();
		vertexbuffer.pos(-f, f2, f).tex(uX, vM).endVertex();
		vertexbuffer.pos(-f, f3, f).tex(uX, vX).endVertex();

		vertexbuffer.pos(-f, f3, -f).tex(uM, vX).endVertex();
		vertexbuffer.pos(-f, f2, -f).tex(uM, vM).endVertex();
		vertexbuffer.pos(f, f2, -f).tex(uX, vM).endVertex();
		vertexbuffer.pos(f, f3, -f).tex(uX, vX).endVertex();

		vertexbuffer.pos(-f, f3, -f).tex(uX, vM).endVertex();
		vertexbuffer.pos(f, f3, -f).tex(uM, vM).endVertex();
		vertexbuffer.pos(f, f3, f).tex(uM, vX).endVertex();
		vertexbuffer.pos(-f, f3, f).tex(uX, vX).endVertex();

		GlStateManager.rotate(0.0F, 0.0F, 0.0F, 0.0F);
		tessellator.draw();
		GlStateManager.disableBlend();
		GlStateManager.popMatrix();
		GlStateManager.enableLighting();
	}
}

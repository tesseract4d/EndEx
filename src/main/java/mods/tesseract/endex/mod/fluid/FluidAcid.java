package mods.tesseract.endex.mod.fluid;

import mods.tesseract.endex.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class FluidAcid extends Fluid {
    public static ResourceLocation acid_still = new ResourceLocation(Reference.MODID, "blocks/acid");
    public static ResourceLocation acid_flowing = new ResourceLocation(Reference.MODID, "blocks/acid_flow");
    public final int color;

    public FluidAcid(String s, int c) {
        this(s, c, acid_still, acid_flowing);
    }

    public FluidAcid(String s, int c, ResourceLocation t, ResourceLocation f) {
        super(s, t, f);
        if (((c >> 24) & 0xFF) == 0)
            c |= 0xFF << 24;
        this.color = c;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public String getLocalizedName(FluidStack stack) {
        String s = this.getUnlocalizedName();
        return s == null ? "" : I18n.translateToLocal(s + ".name");
    }
}

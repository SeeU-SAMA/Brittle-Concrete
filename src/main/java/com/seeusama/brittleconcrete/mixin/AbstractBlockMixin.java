package com.seeusama.brittleconcrete.mixin;

import net.minecraft.block.AbstractBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.Settings.class)
public abstract class AbstractBlockMixin {

    @Inject(method = "hardness", at = @At("HEAD"), cancellable = true)
    private void onHardness(float hardness, CallbackInfoReturnable<AbstractBlock.Settings> cir) {
        ((AbstractBlockSettingsAccessor) (Object) this).setHardness(1.5f);
        cir.setReturnValue((AbstractBlock.Settings) (Object) this);
    }
}
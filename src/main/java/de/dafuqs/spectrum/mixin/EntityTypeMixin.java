package de.dafuqs.spectrum.mixin;

import de.dafuqs.spectrum.entity.SpectrumEntityTypes;
import net.minecraft.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityType.class)
public abstract class EntityTypeMixin {
	
	@Inject(at = @At("RETURN"), method = "alwaysUpdateVelocity()Z", cancellable = true)
	public void alwaysUpdateVelocity(CallbackInfoReturnable<Boolean> cir) {
		if (cir.getReturnValue() && ((Object) this == SpectrumEntityTypes.PHANTOM_FRAME || (Object) this == SpectrumEntityTypes.GLOW_PHANTOM_FRAME)) {
			cir.setReturnValue(false);
		}
	}
	
}

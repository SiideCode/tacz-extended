package com.sidecode.taczextended.mixin.resource.modifier;

import com.tacz.guns.api.modifier.IAttachmentModifier;
import com.tacz.guns.resource.modifier.AttachmentPropertyManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.sidecode.taczextended.resource.modifier.custom.MagSizeModifier;

import java.util.Map;

@Mixin(AttachmentPropertyManager.class)
public class AttachmentPropertyManagerMixin {
    @Shadow(remap = false)
    @Final
    private static Map<String, IAttachmentModifier<?, ?>> MODIFIERS;

    @Inject(method="registerModifier()V", at=@At(value="TAIL"), remap = false)
    private static void registerExtendedModifiers(CallbackInfo ci)
    {
        MODIFIERS.put(MagSizeModifier.ID, new MagSizeModifier());
    }
}

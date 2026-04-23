package com.sidecode.taczextended.mixin.util;

import com.tacz.guns.resource.pojo.data.attachment.Modifier;
import com.tacz.guns.resource.pojo.data.gun.GunData;
import com.tacz.guns.util.AttachmentDataUtils;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(AttachmentDataUtils.class)
public abstract class AttachmentDataUtilsMixin {
    @Shadow
    private static List<Modifier> getModifiers(ItemStack gunItem, GunData gunData, String id) {
        return List.of();
    }

    @Inject(method="getAmmoCountWithAttachment", at=@At(value="RETURN"), remap = false)
    private static void magSizeWrapper(ItemStack gunItem, GunData gunData, CallbackInfoReturnable<Integer> cir)
    {
        //TODO: fix this. should check for if there's an extended mag, and then add to the extended mag if there is, if there isn't one - add to the existing mag
    }
}

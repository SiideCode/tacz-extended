package com.sidecode.taczextended.mixin.util;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import com.sidecode.taczextended.resource.modifier.custom.MagSizeModifier;
import com.tacz.guns.resource.modifier.AttachmentPropertyManager;
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

    @Shadow
    public static int getMagExtendLevel(ItemStack gunItem, GunData gunData) {
        return 0;
    }

    @Inject(method="getAmmoCountWithAttachment", at=@At(value="INVOKE", target="com/tacz/guns/resource/pojo/data/gun/GunData.getExtendedMagAmmoAmount ()[I"), remap = false)
    private static void gunItemPasser(ItemStack gunItem, GunData gunData, CallbackInfoReturnable<Integer> cir, @Share("gunItem") LocalRef<ItemStack> item) {
        item.set(gunItem);
    }

    @WrapOperation(method="getAmmoCountWithAttachment", at=@At(value="INVOKE", target="com/tacz/guns/resource/pojo/data/gun/GunData.getExtendedMagAmmoAmount()[I"), remap = false)
    private static int[] magSizeWrapper(GunData gunData, Operation<int[]> original, @Share("gunItem") LocalRef<ItemStack> item)
    {
        int[] ammoCount = original.call(gunData);
        if (ammoCount != null)
        {
            ItemStack gunItem = item.get();
            int magLevel = getMagExtendLevel(gunItem, gunData);
            if (magLevel != 0) {
                List<Modifier> magSizeMods = getModifiers(gunItem, gunData, MagSizeModifier.ID);
                ammoCount[magLevel - 1] = Math.toIntExact(Math.round(AttachmentPropertyManager.eval(magSizeMods, ammoCount[magLevel - 1])));
            }
        }
        return ammoCount;
    }
}

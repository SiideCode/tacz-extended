package com.sidecode.taczextended.mixin.api;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.sidecode.taczextended.api.ExtendedGunProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import com.tacz.guns.api.GunProperties;

import java.util.Set;

@Mixin(GunProperties.class)
public class GunPropertiesMixin {
    @WrapOperation(method="lambda$static$0", at = @At(value="INVOKE", target="java/util/Set.of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Set;"), remap = false)
    private static Set<Object> addPropertiesToCache(Object e1, Object e2, Object e3, Object e4, Object e5, Object e6, Object e7, Operation<Set<Object>> original) {
        Set<Object> set = original.call(e1, e2, e3, e4, e5, e6, e7);
        set.add(ExtendedGunProperties.MAG_SIZE);
        return set;
    }
}
package com.sidecode.taczextended.mixin.api.item;


import com.tacz.guns.api.item.IGun;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.List;

@Mixin(IGun.class)
public interface IGunMixin {
    @Unique
    List<ResourceLocation> getAmmoIds();
    @Unique
    void setAmmoIds(List<ResourceLocation> ammoId);
}

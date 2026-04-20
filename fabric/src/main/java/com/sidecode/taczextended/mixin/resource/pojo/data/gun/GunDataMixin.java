package com.sidecode.taczextended.mixin.resource.pojo.data.gun;

import com.tacz.guns.resource.pojo.data.gun.GunData;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.List;

@Mixin(GunData.class)
public class GunDataMixin {
    @Unique
    private List<ResourceLocation> ammoIds;

    @Unique
    public List<ResourceLocation> getAmmoIds() {
        return this.ammoIds;
    }

    @Unique
    public void setAmmoIds(List<ResourceLocation> ammoIds) {
        this.ammoIds = ammoIds;
    }
}

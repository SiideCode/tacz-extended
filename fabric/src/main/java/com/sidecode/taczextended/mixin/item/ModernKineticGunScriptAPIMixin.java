package com.sidecode.taczextended.mixin.item;

import com.sidecode.taczextended.Constants;
import com.tacz.guns.api.item.gun.AbstractGunItem;
import com.tacz.guns.api.item.gun.FireMode;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import com.tacz.guns.item.ModernKineticGunScriptAPI;

import org.luaj.vm2.LuaValue;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ModernKineticGunScriptAPI.class)
@SuppressWarnings("unused")
public abstract class ModernKineticGunScriptAPIMixin {
    @Shadow(remap = false)
    private AbstractGunItem abstractGunItem;
    @Shadow(remap = false)
    private ItemStack itemStack;

    @Unique
    public void setFireMode(long firemode) {
        abstractGunItem.setFireMode(itemStack, getFireModeFromLong(firemode));
    }

    @Unique
    private FireMode getFireModeFromLong(long firemode) {
        return FireMode.values()[(int) firemode];
    }
}

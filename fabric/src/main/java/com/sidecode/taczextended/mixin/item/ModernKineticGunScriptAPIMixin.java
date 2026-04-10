package com.sidecode.taczextended.mixin.item;

import com.tacz.guns.api.item.gun.AbstractGunItem;
import com.tacz.guns.api.item.gun.FireMode;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import com.tacz.guns.item.ModernKineticGunScriptAPI;

import org.luaj.vm2.LuaValue;
import org.spongepowered.asm.mixin.Shadow;


//TODO: at first just make all the gun stats accessible to be get/set
//TODO: add input passing
//TODO: make sure you can change ammo types via scripts, then make it editable via configs
@Mixin(ModernKineticGunScriptAPI.class)
@SuppressWarnings("unused")
public abstract class ModernKineticGunScriptAPIMixin {
    @Shadow
    private AbstractGunItem abstractGunItem;
    @Shadow
    private ItemStack itemStack;

    public void setFireMode(int firemode)
    {
        /*TODO: somehow automate turning lua side firemode (number) into java side firemode (enum).
        Maybe writing the  some sort of a function reference into the lua table will work.*/
        abstractGunItem.setFireMode(itemStack, FireMode.values()[firemode]);
    }
}

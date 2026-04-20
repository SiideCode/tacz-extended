package com.sidecode.taczextended.mixin.api.item.builder;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.tacz.guns.api.item.IGun;
import com.tacz.guns.api.item.builder.GunItemBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GunItemBuilder.class)
public class GunItemBuilderMixin {
    @Unique
    private ResourceLocation ammoId;
    @Unique
    private final GunItemBuilder self = (GunItemBuilder) (Object) this;

    @Unique
    public GunItemBuilder setAmmoId(ResourceLocation ammoId) {
        this.ammoId = ammoId;
        return self;
    }

    @WrapOperation(method="forceBuild", at=@At(value= "INVOKE", target="com/tacz/guns/api/item/IGun.setBulletInBarrel(Lnet/minecraft/world/item/ItemStack;Z)V"))
    public void forceBuildAddProperties(IGun instance, ItemStack itemStack, boolean b, Operation<Void> original)
    {
        original.call(instance, itemStack, b);
        //instance.setAmmoId
    }

    @WrapOperation(method="build", at=@At(value= "INVOKE", target="com/tacz/guns/api/item/IGun.setBulletInBarrel(Lnet/minecraft/world/item/ItemStack;Z)V"))
    public void buildAddProperties(IGun instance, ItemStack itemStack, boolean b, Operation<Void> original)
    {
        original.call(instance, itemStack, b);
        //instance.setAmmoId
    }
}

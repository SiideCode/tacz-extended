package com.sidecode.taczextended.resource.modifier.custom;

import com.google.gson.annotations.SerializedName;
import com.sidecode.taczextended.api.ExtendedGunProperties;
import com.tacz.guns.api.item.IGun;
import com.tacz.guns.api.item.gun.FireMode;
import com.tacz.guns.api.modifier.CacheValue;
import com.tacz.guns.api.modifier.JsonProperty;
import com.tacz.guns.api.modifier.IAttachmentModifier;
import com.tacz.guns.resource.CommonAssetsManager;
import com.tacz.guns.resource.modifier.AttachmentPropertyManager;
import com.tacz.guns.resource.pojo.data.attachment.Modifier;
import com.tacz.guns.resource.pojo.data.gun.GunData;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class MagSizeModifier implements IAttachmentModifier<Modifier, Long> {
    public static final String ID = ExtendedGunProperties.MAG_SIZE.name();

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public JsonProperty<Modifier> readJson(String json) {
        Data data = CommonAssetsManager.GSON.fromJson(json, Data.class);
        return new MagazineJsonProperty(data.get_mag_size());
    }

    @Override
    public CacheValue<Long> initCache(ItemStack gunItem, GunData gunData) {
        Long ammoAmount = (long) gunData.getAmmoAmount();
        return new CacheValue<>(ammoAmount);
    }

    @Override
    public void eval(List<Modifier> modifiedValues, CacheValue<Long> cache) {
        double eval = AttachmentPropertyManager.eval(modifiedValues, cache.getValue());
        cache.setValue(Math.round(eval));
    }

    //TODO: add getPropertyDiagramsData and getDiagramsDataSize

    public static class MagazineJsonProperty extends JsonProperty<Modifier> {
        public MagazineJsonProperty(Modifier value) {
            super(value);
        }

        @Override
        public void initComponents() {
            Modifier value = this.getValue();
            if (value != null) {
                long eval = (long) AttachmentPropertyManager.eval(value, 2);
                long magSizeAddend = Math.round(eval);
                if (magSizeAddend > 0) {
                    components.add(Component.translatable("tooltip.taczextended.attachment.mag_size.increase").withStyle(ChatFormatting.GREEN));
                } else if (magSizeAddend < 0) {
                    components.add(Component.translatable("tooltip.taczextended.attachment.mag_size.decrease").withStyle(ChatFormatting.RED));
                }
            }
        }
    }

    public static class Data {
        @SerializedName("mag_size")
        @Nullable
        private Modifier mag_size = null;

        public Modifier get_mag_size()
        {
            return mag_size;
        }
    }
}

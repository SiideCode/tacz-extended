package com.sidecode.taczextended.api;

import com.tacz.guns.api.GunProperty;
import com.tacz.guns.api.ValueModifiableAtRuntime;

public class ExtendedGunProperties {
    @ValueModifiableAtRuntime(Long.class)
    public static final GunProperty<Long> MAG_SIZE = GunProperty.of("mag_size", Long.class);
}

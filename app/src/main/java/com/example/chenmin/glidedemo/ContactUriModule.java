package com.example.chenmin.glidedemo;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Ensures that Glide's generated API is created for the Contact Uri sample.
 */
@GlideModule
public class ContactUriModule extends AppGlideModule {
    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        super.applyOptions(context, builder);
        MemorySizeCalculator.Builder calculator = new MemorySizeCalculator.Builder(context).setMaxSizeMultiplier(0.2f);
        builder.setMemorySizeCalculator(calculator);
    }
    // Intentionally empty.
}

package com.tencent.shadow.dynamic.impl;

import android.content.Context;

import com.example.plugin_manager.SamplePluginManager;
import com.tencent.shadow.dynamic.host.ManagerFactory;
import com.tencent.shadow.dynamic.host.PluginManagerImpl;

/**
 * 此类包名及类名固定
 */
public final class ManagerFactoryImpl implements ManagerFactory {
    @Override
    public PluginManagerImpl buildManager(Context context) {
        return new SamplePluginManager(context);
    }
}

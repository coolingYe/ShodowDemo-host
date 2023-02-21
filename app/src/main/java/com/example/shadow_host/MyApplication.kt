package com.example.shadow_host

import android.app.Application
import com.example.shadow_lib.InitApplication

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        InitApplication.onApplicationCreate(this)
    }
}
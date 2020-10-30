package com.immortalalexsan.cleanarchitecture.core.app

import com.immortalalexsan.cleanarchitecture.core.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.paperdb.Paper

class ClearArchitectureApp : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        Paper.init(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}

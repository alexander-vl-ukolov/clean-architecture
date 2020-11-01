package com.immortalalexsan.cleanarchitecture.core.di.components

import android.app.Application
import com.immortalalexsan.cleanarchitecture.core.app.ClearArchitectureApp
import com.immortalalexsan.cleanarchitecture.core.di.modules.AppModule
import com.immortalalexsan.cleanarchitecture.core.di.modules.CacheModule
import com.immortalalexsan.cleanarchitecture.core.di.modules.DataDomainMapperModule
import com.immortalalexsan.cleanarchitecture.core.di.modules.DatabaseModule
import com.immortalalexsan.cleanarchitecture.core.di.modules.RepositoryModule
import com.immortalalexsan.cleanarchitecture.core.di.modules.ServiceApiModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        CacheModule::class,
        DatabaseModule::class,
        ServiceApiModule::class,
        RepositoryModule::class,
        DataDomainMapperModule::class
    ]
)
interface AppComponent : AndroidInjector<ClearArchitectureApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}

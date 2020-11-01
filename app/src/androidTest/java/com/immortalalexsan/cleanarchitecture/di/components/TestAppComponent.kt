package com.immortalalexsan.cleanarchitecture.di.components

import android.app.Application
import com.immortalalexsan.cleanarchitecture.ApiServiceTest
import com.immortalalexsan.cleanarchitecture.core.di.components.AppComponent
import com.immortalalexsan.cleanarchitecture.core.di.modules.AppModule
import com.immortalalexsan.cleanarchitecture.core.di.modules.CacheModule
import com.immortalalexsan.cleanarchitecture.core.di.modules.DataDomainMapperModule
import com.immortalalexsan.cleanarchitecture.di.modules.TestDatabaseModule
import com.immortalalexsan.cleanarchitecture.di.modules.TestRepositoryModule
import com.immortalalexsan.cleanarchitecture.di.modules.TestServiceApiModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        CacheModule::class,
        TestDatabaseModule::class,
        TestServiceApiModule::class,
        TestRepositoryModule::class,
        DataDomainMapperModule::class
    ]
)
interface TestAppComponent : AppComponent {

    fun inject(instance: ApiServiceTest)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): TestAppComponent
    }
}

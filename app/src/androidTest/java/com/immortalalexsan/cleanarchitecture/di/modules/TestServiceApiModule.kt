package com.immortalalexsan.cleanarchitecture.di.modules

import com.google.gson.Gson
import com.immortalalexsan.cleanarchitecture.core.di.modules.ServiceApiModule
import com.immortalalexsan.cleanarchitecture.data.network.api.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class TestServiceApiModule : ServiceApiModule() {

    @Singleton
    @Provides
    fun mockWebServer(): MockWebServer = MockWebServer().apply { start() }

    @Singleton
    @Provides
    @Named("BaseUrl")
    fun baseUrl(mockServer: MockWebServer): String = mockServer.url("/").toString()

    @Provides
    @Singleton
    @Named("TestRetrofit")
    fun testRetrofit(client: OkHttpClient, gson: Gson, @Named("BaseUrl") url: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(url)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()

    @Provides
    @Singleton
    @Named("TestApiService")
    fun testApiService(@Named("TestRetrofit") retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}

package com.immortalalexsan.cleanarchitecture.core.di.modules

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.immortalalexsan.cleanarchitecture.BuildConfig
import com.immortalalexsan.cleanarchitecture.R
import com.immortalalexsan.cleanarchitecture.data.network.api.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedInputStream
import java.security.KeyStore
import java.security.cert.Certificate
import java.security.cert.CertificateFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager

@Module
open class ServiceApiModule {

    @Provides
    @Singleton
    fun trustManager(appContext: Context): X509TrustManager {
        val caFactory = CertificateFactory.getInstance("X.509")

        var ca: Certificate?
        BufferedInputStream(appContext.resources.openRawResource(R.raw.ca)).use {
            ca = caFactory.generateCertificate(it)
        }

        val keyStore = KeyStore.getInstance(KeyStore.getDefaultType()).apply {
            load(null, null)
            setCertificateEntry("ca", ca)
        }

        val algorithm = TrustManagerFactory.getDefaultAlgorithm()
        val trustManagerFactory = TrustManagerFactory.getInstance(algorithm).apply {
            init(keyStore)
        }

        return trustManagerFactory.trustManagers[0] as X509TrustManager
    }

    @Provides
    @Singleton
    fun sslSocketFactory(trustManager: X509TrustManager): SSLSocketFactory =
        SSLContext.getInstance("TLS")
            .apply { init(null, arrayOf(trustManager), null) }
            .socketFactory

    @Provides
    @Singleton
    fun certificatePinner(): CertificatePinner {
        val regex = "https?://|/.*".toRegex()
        val hostname = BuildConfig.BASE_URL.replace(regex, "")
        return CertificatePinner.Builder()
            .add(hostname, BuildConfig.PIN_SHA256)
            .build()
    }

    @Provides
    @Singleton
    fun httpLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun client(
        sslSocketFactory: SSLSocketFactory,
        trustManager: X509TrustManager,
        certificatePinner: CertificatePinner,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .sslSocketFactory(sslSocketFactory, trustManager)
            .certificatePinner(certificatePinner)
            .addInterceptor(loggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun gson(): Gson = GsonBuilder()
        .setLenient()
        .excludeFieldsWithoutExposeAnnotation()
        .create()

    @Provides
    @Singleton
    fun retrofit(client: OkHttpClient, gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build()

    @Provides
    @Singleton
    fun apiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}

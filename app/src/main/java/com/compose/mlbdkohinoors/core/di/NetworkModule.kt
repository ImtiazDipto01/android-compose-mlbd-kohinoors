package com.compose.mlbdkohinoors.core.di

import com.compose.mlbdkohinoors.core.extensions.CONNECT_TIMEOUT_S
import com.compose.mlbdkohinoors.core.extensions.READ_TIMEOUT_S
import com.compose.mlbdkohinoors.core.extensions.WRITE_TIMEOUT_S
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        return interceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val httpClient = OkHttpClient.Builder().apply {
            connectTimeout(CONNECT_TIMEOUT_S, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT_S, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT_S, TimeUnit.SECONDS)
            addInterceptor(httpLoggingInterceptor)
            /*addInterceptor(Interceptor {
                val newRequest: Request = it.request().newBuilder()
                    .addHeader(HEADER_AUTHORIZATION, "$HEADER_AUTHORIZATION_TYPE $AUTH_TOKEN")
                    .build()
                it.proceed(newRequest)
            })*/
        }
        return httpClient.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.npoint.io/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }
}
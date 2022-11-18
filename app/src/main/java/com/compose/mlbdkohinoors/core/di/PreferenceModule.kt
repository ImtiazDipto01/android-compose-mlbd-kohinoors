package com.compose.mlbdkohinoors.core.di

import android.content.Context
import android.content.SharedPreferences
import com.compose.mlbdkohinoors.core.extensions.APP_PREF
import com.compose.mlbdkohinoors.data.local.preference.AppPreference
import com.compose.mlbdkohinoors.data.local.preference.PreferenceHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferenceModule {

    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(
            APP_PREF, Context.MODE_PRIVATE
        )

    @Singleton
    @Provides
    fun providePreferenceHelper(appPreferenceHelper: AppPreference): PreferenceHelper =
        appPreferenceHelper

}
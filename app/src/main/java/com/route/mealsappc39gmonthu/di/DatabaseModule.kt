package com.route.mealsappc39gmonthu.di

import com.route.mealsappc39gmonthu.model.database.MealsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(): MealsDatabase {
        return MealsDatabase.getInstance()
    }

}
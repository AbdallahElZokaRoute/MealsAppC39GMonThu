package com.route.mealsappc39gmonthu.di

import com.route.mealsappc39gmonthu.contracts.MealsOfflineDataSource
import com.route.mealsappc39gmonthu.contracts.MealsOnlineDataSource
import com.route.mealsappc39gmonthu.contracts.MealsRepository
import com.route.mealsappc39gmonthu.contracts.NetworkHandler
import com.route.mealsappc39gmonthu.dataSource.offline.MealsOfflineDataSourceImpl
import com.route.mealsappc39gmonthu.dataSource.online.MealsOnlineDataSourceImpl
import com.route.mealsappc39gmonthu.repository.MealsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {
    @Singleton
    @Provides
    fun provideMealsRepository(
        impl: MealsRepositoryImpl
    ): MealsRepository {
        return impl
    }

    @Singleton
    @Provides
    fun provideMealsOnlineDataSource(
        impl: MealsOnlineDataSourceImpl
    ): MealsOnlineDataSource {
        return impl
    }

    @Singleton
    @Provides
    fun provideMealsOfflineDataSource(
        impl: MealsOfflineDataSourceImpl
    ): MealsOfflineDataSource {
        return impl
    }

    @Provides
    fun provideNetworkHandler(): NetworkHandler {
        return object : NetworkHandler {
            override fun isOnline(): Boolean {
                return true
            }
        }
    }
}

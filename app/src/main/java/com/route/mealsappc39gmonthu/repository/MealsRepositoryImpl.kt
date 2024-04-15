package com.route.mealsappc39gmonthu.repository

import com.route.mealsappc39gmonthu.contracts.MealsOfflineDataSource
import com.route.mealsappc39gmonthu.contracts.MealsOnlineDataSource
import com.route.mealsappc39gmonthu.contracts.MealsRepository
import com.route.mealsappc39gmonthu.contracts.NetworkHandler
import com.route.mealsappc39gmonthu.model.CategoryItem
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val onlineDataSource: MealsOnlineDataSource,
    private val offlineDataSource: MealsOfflineDataSource,
    private val networkHandler: NetworkHandler
) : MealsRepository {
    override suspend fun getMeals(): List<CategoryItem> {
        if (networkHandler.isOnline()) {
            val meals = onlineDataSource.fetchMeals()
            offlineDataSource.clearMeals()
            offlineDataSource.saveMeals(meals)
            return meals
        }
        return offlineDataSource.getMeals()
    }
}
package com.route.mealsappc39gmonthu.dataSource.offline

import com.route.mealsappc39gmonthu.contracts.MealsOfflineDataSource
import com.route.mealsappc39gmonthu.model.CategoryItem
import com.route.mealsappc39gmonthu.model.database.MealsDatabase
import javax.inject.Inject

class MealsOfflineDataSourceImpl @Inject constructor(
    private val database: MealsDatabase
) : MealsOfflineDataSource {
    override suspend fun saveMeals(meals: List<CategoryItem>) {
        try {
            database.getMealsDAO().saveMeals(meals)
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getMeals(): List<CategoryItem> {
        return try {
            database.getMealsDAO().getMeals()
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun clearMeals() {
        try {
            database.getMealsDAO().clearMeals()
        } catch (e: Exception) {
            throw e
        }
    }
}
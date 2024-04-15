package com.route.mealsappc39gmonthu.contracts

import com.route.mealsappc39gmonthu.model.CategoryItem

interface MealsRepository {
    suspend fun getMeals(): List<CategoryItem>
}

interface MealsOnlineDataSource {
    suspend fun fetchMeals(): List<CategoryItem>
}

interface MealsOfflineDataSource {
    suspend fun saveMeals(meals: List<CategoryItem>)
    suspend fun getMeals(): List<CategoryItem>
    suspend fun clearMeals()
}

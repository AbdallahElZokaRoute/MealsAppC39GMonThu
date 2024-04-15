package com.route.mealsappc39gmonthu.dataSource.online

import com.route.mealsappc39gmonthu.contracts.MealsOnlineDataSource
import com.route.mealsappc39gmonthu.model.CategoryItem
import com.route.mealsappc39gmonthu.model.api.MealsService
import javax.inject.Inject

class MealsOnlineDataSourceImpl @Inject constructor(
    private val mealsService: MealsService,
) : MealsOnlineDataSource {
    override suspend fun fetchMeals(): List<CategoryItem> {
        return try {
            mealsService.fetchMeals().categories ?: listOf()
        } catch (e: Exception) {
            throw e
        }
    }

}

package com.route.mealsappc39gmonthu.model.api

import com.route.mealsappc39gmonthu.model.MealsCategoriesResponse
import retrofit2.http.GET

interface MealsService {
    @GET("categories.php")
    suspend fun fetchMeals(): MealsCategoriesResponse
}

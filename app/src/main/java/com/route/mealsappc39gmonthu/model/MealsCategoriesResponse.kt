package com.route.mealsappc39gmonthu.model

import com.google.gson.annotations.SerializedName

data class MealsCategoriesResponse(

    @field:SerializedName("categories")
    val categories: List<CategoryItem>? = null
)
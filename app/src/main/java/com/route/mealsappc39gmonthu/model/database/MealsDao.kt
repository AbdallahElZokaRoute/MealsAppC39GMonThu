package com.route.mealsappc39gmonthu.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.route.mealsappc39gmonthu.model.CategoryItem

// Meals
// Online DataSource
// MVI
// 14 Item ->

@Dao
interface MealsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMeals(meals: List<CategoryItem>)

    @Query("DELETE FROM CategoryItem")
    suspend fun clearMeals()

    @Query("SELECT * FROM CategoryItem")
    suspend fun getMeals(): List<CategoryItem>
}

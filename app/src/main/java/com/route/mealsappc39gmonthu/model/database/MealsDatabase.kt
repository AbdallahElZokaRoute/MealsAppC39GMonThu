package com.route.mealsappc39gmonthu.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.route.mealsappc39gmonthu.model.CategoryItem

@Database([CategoryItem::class], version = 1)
abstract class MealsDatabase : RoomDatabase() {
    abstract fun getMealsDAO(): MealsDao

    companion object {
        private var INSTANCE: MealsDatabase? = null
        private val DATABASE_NAME = "Meals Database"
        fun init(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, MealsDatabase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build()

            }
        }

        fun getInstance(): MealsDatabase {
            return INSTANCE!!
        }
    }
}

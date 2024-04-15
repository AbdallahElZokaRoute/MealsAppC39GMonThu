package com.route.mealsappc39gmonthu

import android.app.Application
import com.route.mealsappc39gmonthu.model.database.MealsDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MealzApp : Application() {

    override fun onCreate() {
        super.onCreate()
        MealsDatabase.init(this)
    }
}
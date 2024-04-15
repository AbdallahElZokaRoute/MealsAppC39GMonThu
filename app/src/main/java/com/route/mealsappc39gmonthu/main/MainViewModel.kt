package com.route.mealsappc39gmonthu.main

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.mealsappc39gmonthu.contracts.MealsRepository
import com.route.mealsappc39gmonthu.model.CategoryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MealsRepository
) : ViewModel() {
    val categoriesList = mutableStateListOf<CategoryItem>()
    fun fetchCategoriesList() {
        viewModelScope.launch(Dispatchers.IO) {
            val meals = repository.getMeals()
            categoriesList.addAll(meals)
        }
    }
}

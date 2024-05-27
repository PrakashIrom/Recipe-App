package com.example.myrecipeapp.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrecipeapp.api.recipeService
import com.example.myrecipeapp.model.UIState
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _categorieState = mutableStateOf(UIState())
    val categorieState: State<UIState> = _categorieState

    init {
        fetchCategories()
    }

    private fun fetchCategories(){
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()

                _categorieState.value = _categorieState.value.copy(
                    list=response.categories,
                    loading = false,
                    error = null
                )
            }
            catch(e: Exception){
                _categorieState.value = _categorieState.value.copy(
                    loading = false,
                    error = "Error fetching categories ${e.message}"
                )
            }
        }
    }
}
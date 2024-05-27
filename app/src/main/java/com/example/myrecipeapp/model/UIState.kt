package com.example.myrecipeapp.model

data class UIState(
    val loading: Boolean = true,
    val list: List<Category> = emptyList(),
    val error: String? = null
)

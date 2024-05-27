package com.example.myrecipeapp.model

data class Category(val idCategory: String,
                    val strCategoryThumb: String,
                    val strCategoryDescription: String
)

data class CategoriesResponse(val categories: List<Category>)


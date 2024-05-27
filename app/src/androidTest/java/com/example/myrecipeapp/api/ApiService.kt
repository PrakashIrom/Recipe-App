package com.example.myrecipeapp.api

import com.example.myrecipeapp.model.CategoriesResponse
import retrofit2.http.GET

interface ApiService{
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse
}
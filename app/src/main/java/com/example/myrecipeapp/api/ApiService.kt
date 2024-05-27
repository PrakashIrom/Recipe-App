package com.example.myrecipeapp.api

import com.example.myrecipeapp.model.CategoriesResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

import retrofit2.http.GET

val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"


private val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .build()

val recipeService = retrofit.create(ApiService::class.java)

interface ApiService{
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse
}


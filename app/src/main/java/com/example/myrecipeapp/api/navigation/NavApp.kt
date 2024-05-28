package com.example.myrecipeapp.api.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myrecipeapp.detailscreen.CategoryDetailsScreen
import com.example.myrecipeapp.home.HomeScreen
import com.example.myrecipeapp.home.MainViewModel
import com.example.myrecipeapp.model.Category

@Composable
fun Navigation(navController: NavHostController, recipeViewModel: MainViewModel = viewModel()){
    val viewState by recipeViewModel.categorieState

    NavHost(navController = navController, startDestination = NavClass.RecipeScreen.route ){

        composable(NavClass.RecipeScreen.route){
            HomeScreen(state = viewState, navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("cat",it)
                navController.navigate(NavClass.DetailScreen.route)
            } )
        }

        composable(NavClass.DetailScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.
            get<Category>("cat") ?: Category("","","","")
            CategoryDetailsScreen(category = category)
        }

    }
}
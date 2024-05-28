package com.example.myrecipeapp.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myrecipeapp.model.Category

@Composable
fun HomeScreen(modifier: Modifier = Modifier,state: MainViewModel.UIState  , navigateToDetail: (Category) -> Unit){

    Box(modifier.fillMaxSize()){
        when{
            state.loading ->{
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            state.error != null ->{
                Text("Error")
            }

            else -> {
                Success(state.list,navigateToDetail)
            }
        }
    }

}

@Composable
fun Success(list: List<Category>, navigateToDetail: (Category) -> Unit){
    LazyVerticalGrid(GridCells.Fixed(2),modifier=Modifier.fillMaxSize()){
        items(list){
            item-> Item(item, navigateToDetail)
        }
    }
}

@Composable
fun Item(category: Category, navigateToDetail: (Category) -> Unit){
    Column(modifier= Modifier
        .padding(8.dp)
        .fillMaxSize()
        .clickable { navigateToDetail(category) },
        horizontalAlignment = Alignment.CenterHorizontally){
        AsyncImage(model = category.strCategoryThumb, contentDescription = "Meal Image")
        Text(text=category.strCategory,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top=4.dp)
            )
    }
}
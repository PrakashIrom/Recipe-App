package com.example.myrecipeapp.detailscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myrecipeapp.model.Category

@Composable
fun CategoryDetailsScreen(category: Category){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text=category.strCategory, textAlign = TextAlign.Center)
        AsyncImage(model = category.strCategoryThumb,
            contentDescription = "Recipe Image",
            modifier = Modifier
                .wrapContentSize()
                .aspectRatio(1f) // ratio of height and width should be equal
            )
        Text(text = category.strCategoryDescription, textAlign = TextAlign.Justify,
            modifier = Modifier.verticalScroll(rememberScrollState()) // remember will take care of which text to display when we scroll
            )
    }
}
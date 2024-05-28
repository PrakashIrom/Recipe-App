package com.example.myrecipeapp.api.navigation

sealed class NavClass(val route:String) {
    object RecipeScreen: NavClass("recipescreen")
    object DetailScreen: NavClass("detailscreen")
}

//In Kotlin, classes are final by default, meaning they cannot be subclassed unless explicitly marked with the open keyword.
// Therefore, when you try to create object RecipeScreen and object DetailScreen as subclasses of NavClass,
// the compiler throws an error because NavClass is not open for inheritance.

//A sealed class in Kotlin is implicitly open for inheritance within the same file where it is declared.
// This allows you to define a restricted class hierarchy, where all subclasses of the sealed class must be defined
// in the same file
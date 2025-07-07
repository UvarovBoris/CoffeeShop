package com.example.coffeeshop.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(onItemClick: (String) -> Unit) {
    Column {
        Text("Home Screen")
        Button(onClick = { onItemClick("123") }) {
            Text("Go to Detail of item 123")
        }
    }
}

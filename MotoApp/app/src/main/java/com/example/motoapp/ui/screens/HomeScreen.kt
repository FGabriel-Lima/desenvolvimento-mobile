package com.example.motoapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.motoapp.models.Moto
import com.example.motoapp.models.motoList
import com.example.motoapp.ui.components.MotoListItem

@Composable
fun HomeScreen(onMotoSelected: (Moto) -> Unit){
    var searchQuery by remember { mutableStateOf("") }
    val filteredMotos = remember(searchQuery) {
        motoList.filter {
            it.name.contains(searchQuery, ignoreCase = true)
        }
    }
    Column {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Pesquisar") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(horizontal = 8.dp)
        ){
            items(filteredMotos) { moto ->
                MotoListItem(moto = moto, onMotoSelected)
            }
        }
    }
}
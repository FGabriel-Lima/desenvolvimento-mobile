package com.example.motoapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.motoapp.models.Moto

@ExperimentalMaterial3Api
@Composable
fun MotoScreen(moto: Moto){
    Scaffold(
        topBar = {
            TopAppBar(title = {Text(moto.name)})
        }
    ){ paddingValues ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = moto.imageRes),
                contentDescription = "${moto.name} Image",
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = moto.marca,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = moto.descripition,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
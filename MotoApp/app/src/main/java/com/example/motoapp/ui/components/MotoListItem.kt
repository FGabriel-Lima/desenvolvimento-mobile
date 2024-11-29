package com.example.motoapp.ui.components

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

@Composable
fun MotoListItem( moto : Moto, onMotoSelect: (Moto) -> Unit){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = moto.imageRes),
                    contentDescription = "${moto.name} Image",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = moto.name,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = moto.marca,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = moto.descripition,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
package com.example.animalapp

import android.content.Intent
import android.graphics.drawable.Icon
import android.media.MediaPlayer
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.animalapp.ui.theme.AnimalAppTheme
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.VideoView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalAppTheme {
                AnimalApp()
            }
        }
    }
}

class VideoPlayerActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            val videoRes = intent.getIntExtra("videoRes", R.raw.vidgalo)
            AndroidView(
                factory = { context ->
                    VideoView(context).apply {

                        setVideoURI(Uri.parse("android.resource://$packageName/$videoRes"))
                        start()
                    }
                },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun AnimalAppMenu(onOptionSelected: (String) -> Unit){
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = {expanded = true}){
        Icon(Icons.Default.MoreVert, contentDescription = "Menu")
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = {expanded = false}
    ) {
        DropdownMenuItem(
            text = { Text("Galo") },
            onClick = {
                expanded = false
                onOptionSelected("Galo")
            }
        )
        DropdownMenuItem(
            text = { Text("Leão") },
            onClick = {
                expanded = false
                onOptionSelected("Leão")
            }
        )
    }
}

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(onAnimalSelected: (String) -> Unit){
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text("AnimalApp")},
                actions = {
                    AnimalAppMenu (onOptionSelected =
                    onAnimalSelected)
                }
            )
        }
    ){ paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ){
            Text("Selecione um animal no menu.")
        }
    }
}

@Composable
fun AnimalScreen(animal: String){
    val context = LocalContext.current
    val imageRes = if (animal == "Galo") R.drawable.imggalo else R.drawable.imgleao
    val soundRes = if (animal == "Galo") R.raw.audgalo else R.raw.audleao
    val videoRes = if (animal == "Galo") R.raw.vidgalo else R.raw.vidleao

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "$animal Imagem",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            try{
                val mediaPlayer = MediaPlayer.create(context, soundRes)
                if (mediaPlayer != null){
                    mediaPlayer.start()
                    mediaPlayer.setOnCompletionListener { mediaPlayer.release() }
                }else{
                    println("Erro: MediaPlayer retornou null para p recurso $soundRes")
                }
            }catch (e : Exception){
                println("Erro ao iniciar o MediaPlayer: ${e.message}")
            }
        }) {
            Text("Reproduzir Som")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val intent = Intent(context, VideoPlayerActivity::class.java)
            intent.putExtra("videoRes", videoRes)
            context.startActivity(intent)
        }) {
            Text("Reproduzir Vídeo")
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun AnimalApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home"){
            HomeScreen(onAnimalSelected = { animal ->
                navController.navigate("animal/$animal")
            })
        }
        composable(
            "animal/{animal}",
            arguments = listOf(navArgument("animal") { type =
            NavType.StringType })
        ){ backStackEntry ->
            val animal =
                backStackEntry.arguments?.getString("animal") ?: "Galo"
            AnimalScreen(animal)
        }
    }
}




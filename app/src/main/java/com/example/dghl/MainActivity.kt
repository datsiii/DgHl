package com.example.dghl

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@AndroidEntryPoint //для каждого класса, в котором есть инъекции нужна аннотация
class MainActivity : ComponentActivity() {
    //переменная не может быть private, если создаём инстанцию через Hilt
    @Inject //"дай мне wifiManager уже инициализированный"
    lateinit var wifiManager: WiFiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
        //инициализация не нужна
        //wifiManager.connect()
        //wifiManager.sendMessage()
        Log.d("MyLog", "MainActivity Instance id: $wifiManager")
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val screen1ViewModel: Screen1ViewModel = hiltViewModel()
    val screen2ViewModel: Screen2ViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = "screen1") {
        composable("screen1") { Screen1(screen1ViewModel, navController) }
        composable("screen2") { Screen2(screen2ViewModel, navController) }
    }
}

@HiltViewModel
class Screen1ViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var wifiManager: WiFiManager
}

@Composable
fun Screen1(screen1ViewModel: Screen1ViewModel = hiltViewModel(), navController: NavController) {
    Log.d("MyLog", "Screen1 Instance id: ${screen1ViewModel.wifiManager}")
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Экран 1")
        Button(onClick = { navController.navigate("screen2") }) {
            Text("Перейти на экран 2")
        }
    }
}

@HiltViewModel
class Screen2ViewModel @Inject constructor() : ViewModel() {
    // Логика для управления состоянием
    @Inject
    lateinit var wifiManager: WiFiManager
}


@Composable
fun Screen2(screen2ViewModel: Screen2ViewModel = hiltViewModel(), navController: NavController) {
    Log.d("MyLog", "Screen2 Instance id: ${screen2ViewModel.wifiManager}")
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Экран 2")
        Button(onClick = { navController.popBackStack() }) {
            Text("Вернуться на экран 1")
        }
    }
}
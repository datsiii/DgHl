package com.example.dghl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dghl.ui.theme.DgHlTheme

class MainActivity : ComponentActivity() {
    private lateinit var wifiManager: WiFiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        }
        val settings = WiFiSettings()
        wifiManager = WiFiManager(settings)

        wifiManager.connect()
        wifiManager.sendMessage()
    }
}

package com.example.dghl

import android.util.Log
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton

@ActivityRetainedScoped
class WiFiManager @Inject constructor(private val settings: WiFiSettings) {
    fun connect() {
        settings.openConnection()
    }

    fun sendMessage() {
        settings.writeBytes()
    }
}

//@Inject constructor нужен для того,
//чтобы Hilt смог найти класс и создать его инстанцию (экземпляр)

//Если помечено только @Inject constructor, то библиотека Hilt знает как создать экземпляр класса,
//но каждый раз будет создавать новый экземпляр
class WiFiSettings @Inject constructor() {
    fun openConnection() {
        Log.d("MyLog", "Connected")
    }

    fun writeBytes() {
        Log.d("MyLog", "Hello!")
    }
}
package com.example.dghl

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//класс Application создаётся всегда как анонимный (без имени),
//в следствие этого необходимо сделать его явным, присвоить аннотацию
// и указать имя в AndroidManifest.xml

//"Класс Application или ваш подкласс класса Application
//создается раньше любого другого класса
//при создании процесса для вашего приложения/пакета"

@HiltAndroidApp
class App : Application() {
}
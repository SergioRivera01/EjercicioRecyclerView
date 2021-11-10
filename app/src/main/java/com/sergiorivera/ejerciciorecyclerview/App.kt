package com.sergiorivera.ejerciciorecyclerview

import android.app.Application
class App : Application() {
    val repositories: MutableList<repository> = mutableListOf()
}
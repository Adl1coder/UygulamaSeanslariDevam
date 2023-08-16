package com.adilegungor.notdefterim

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {
}

annotation class HiltAndroidApp

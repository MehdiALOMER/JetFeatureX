package com.example.jetfeaturex

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Hilt'in proje genelinde çalışması için başlangıç sınıfı
@HiltAndroidApp
class HiltApplication : Application()
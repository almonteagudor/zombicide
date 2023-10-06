package com.montisgal.zombicide

import android.app.Application
import com.montisgal.zombicide.data.ZombicideContainer
import com.montisgal.zombicide.data.ZombicideDataContainer

class ZombicideApplication : Application() {
    lateinit var container: ZombicideContainer

    override fun onCreate() {
        super.onCreate()
        container = ZombicideDataContainer(this)
    }
}
package com.montisgal.zombicide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.montisgal.zombicide.ui.ZombicideApp
import com.montisgal.zombicide.ui.theme.ZombicideTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZombicideTheme {
                ZombicideApp()
            }
        }
    }
}
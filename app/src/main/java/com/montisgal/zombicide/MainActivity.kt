package com.montisgal.zombicide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.montisgal.zombicide.ui.NavManager
import com.montisgal.zombicide.ui.theme.ZombicideTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZombicideTheme {
                NavManager(modifier = Modifier.fillMaxSize())
            }
        }
    }
}
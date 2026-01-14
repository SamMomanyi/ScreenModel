package org.example.project.Presentation.Screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.LocalNavigatorSaver
import cafe.adriel.voyager.navigator.currentOrThrow
import org.example.project.Presentation.Screen.detail.DetailsScreen

class HomeScreen: Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable{
                    navigator.push(DetailsScreen())
                },
            contentAlignment = Alignment.Center
        ){
            Text(text = "Home Screen")
        }
    }


}
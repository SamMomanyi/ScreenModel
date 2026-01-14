package org.example.project.Presentation.Screen.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import cafe.adriel.voyager.core.screen.Screen
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.Icons
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class DetailsScreen: Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Scaffold(
            topBar = {
               TopAppBar(
                   title = {Text(text = "Details")},
                   navigationIcon = {
                       IconButton(
                           onClick = {
                               navigator.pop()
                           }
                       ){
                           Icon(
                               imageVector = Icons.AutoMirrored.Default.ArrowBack,
                               contentDescription = "Back Arrow icon"
                           )
                       }
                   }
               )
            }
        ){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                .clickable {navigator.pop()},
                contentAlignment = Alignment.Center
            ){
                Text(text = "Details Screen")
            }
        }
    }
}
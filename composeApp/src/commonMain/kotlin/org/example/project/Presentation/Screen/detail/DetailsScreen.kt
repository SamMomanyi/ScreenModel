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
import cafe.adriel.voyager.core.model.rememberNavigatorScreenModel
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class DetailsScreen: Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        //to initialize a viewModel we call the screenModel composable function and initialize the viewModel
        //here the viewmodel instance is tied to the screen(the instance is destroyed on exiting) , when we exit it gets killed
//        val viewModel = rememberScreenModel{ DetailsViewModel() }
        //to share it(tie it to the navigator)we use:
        val viewModel = navigator.rememberNavigatorScreenModel { DetailsViewModel() }
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
                Text(text = "Details Screen (${viewModel.number.value})" )
            }
        }
    }
}
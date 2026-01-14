package org.example.project.Presentation.Screen.detail

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DetailsViewModel  : ScreenModel {

    private var _number = mutableStateOf(0)
    val number: State<Int> = _number

    //value is initliazed after ten seconds of creation
    init{
        println(
            "DetailsViewModel: Initializing..."
        )
        screenModelScope.launch{
            delay(2000)
            _number.value = 10
        }
    }

    override fun onDispose(){
        super.onDispose()
        println("DetailsViewModel: Disposing....")
    }

}
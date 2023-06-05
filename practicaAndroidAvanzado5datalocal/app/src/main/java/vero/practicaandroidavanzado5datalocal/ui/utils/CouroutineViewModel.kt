package vero.practicaandroidavanzado5datalocal.ui.utils

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CouroutineViewModel: ViewModel() {

    fun tareaCostosa() {
        Thread.sleep(100000)
    }

    fun miCorrutinaEnMain() {
        GlobalScope.launch(Dispatchers.Main) {

        }
    }

    fun miCorrutinaEnIO() {
        val job = GlobalScope.launch(Dispatchers.IO) {

        }
    }


}
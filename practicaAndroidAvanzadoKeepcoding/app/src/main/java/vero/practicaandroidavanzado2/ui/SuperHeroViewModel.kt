package vero.practicaandroidavanzado2.ui

import vero.practicaandroidavanzado2.ui.model.Superhero
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import vero.practicaandroidavanzado2.data.Repository


import javax.inject.Inject


@HiltViewModel
class SuperheroViewModel @Inject constructor(private val repository: Repository) : ViewModel() {



    private val _heroes = MutableLiveData<List<Superhero>>()

    val heroes: LiveData<List<Superhero>>
        get() = _heroes

    fun getHeroes() {
      viewModelScope.launch {
          val result = withContext(Dispatchers.IO){
              repository.getHeroes()//como el ejemplo de Thread.sleep(1000)
          }
          _heroes.value = result
      }

    }
}




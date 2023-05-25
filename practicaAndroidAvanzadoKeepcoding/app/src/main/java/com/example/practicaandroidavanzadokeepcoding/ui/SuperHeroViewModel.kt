package com.example.practicaandroidavanzadokeepcoding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicaandroidavanzadokeepcoding.data.Repository
import com.example.practicaandroidavanzadokeepcoding.data.remote.GetHeroesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SuperHeroViewModel: ViewModel(){

    private val repository = Repository()

    private val _heroes = MutableLiveData<List<GetHeroesResponse>>()

    val heroes: LiveData<List<GetHeroesResponse>>
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
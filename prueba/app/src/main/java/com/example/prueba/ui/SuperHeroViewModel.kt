package com.example.practicaandroidavanzadokeepcoding.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicaandroidavanzadokeepcoding.data.Repository
import com.example.practicaandroidavanzadokeepcoding.data.remote.response.GetHeroesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SuperHeroViewModel: ViewModel() {

    private val repository = Repository()

    private val _heroes = MutableLiveData<List<GetHeroesResponse>>()
    val heroes: MutableLiveData<List<GetHeroesResponse>> get() = _heroes

    fun getHeroes() {
        viewModelScope.launch {
            var result = withContext(Dispatchers.IO) {
               repository.getHeroes() //thread.sleep(1000)
            }
        _heroes.value = result

        }
    }
}


package vero.practicaandroidavanzado5datalocal.ui.superherodetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import vero.practicaandroidavanzado5datalocal.domain.Repository
import vero.practicaandroidavanzado5datalocal.domain.SuperHeroDetail
import javax.inject.Inject

@HiltViewModel
class SuperHeroDetailViewModel @Inject constructor(
    private val repository: Repository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _state = MutableLiveData<DetailState>()
    val state: LiveData<DetailState>
        get() = _state

    fun getHeroDetail(name: String, id: String) {
        viewModelScope.launch {
            val superHeroDetail = async(dispatcher) {
                repository.getHeroDetail(name)
            }
            val superHeroLocations = async(dispatcher) {
                repository.getHeroLocations(id)
            }

            _state.value = DetailState.Success(
                superHeroDetail.await() ?: SuperHeroDetail(
                    "",
                    "",
                    "",
                    "",
                    false
                ), superHeroLocations.await()
            )
        }
    }

    fun toggleFavorite() {
        viewModelScope.launch {
            (_state.value as? DetailState.Success)?.let { state ->
                val prevHero = state.hero
                val hero = withContext(dispatcher) {
                    val hero =
                        prevHero.copy(favourite = !prevHero.favourite).also { superHeroDetail ->
                            if (prevHero.favourite) {
                                repository.insertFav(superHeroDetail)
                            } else {
                                repository.deleteFav(superHeroDetail)
                            }
                        }
                    hero
                }
                _state.value = DetailState.Success(hero, state.heroLocations)
            }
        }
    }
}

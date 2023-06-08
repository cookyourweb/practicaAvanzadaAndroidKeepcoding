package vero.practicaandroidavanzado5datalocal.ui.superherolist
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import vero.practicaandroidavanzado5datalocal.domain.Repository
import vero.practicaandroidavanzado5datalocal.domain.SuperHero
import javax.inject.Inject

@HiltViewModel
class SuperHeroListViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    private val _heros = MutableLiveData<List<SuperHero>>()
    val heros: LiveData<List<SuperHero>>

        get() = _heros

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _state = MutableLiveData<SuperHeroListState>()
    val state: LiveData<SuperHeroListState>
        get() = _state

    companion object {
        private val TAG = "ListViewModel: "
    }


    fun getSuperheros() {
        viewModelScope.launch {
            val superheros = withContext(Dispatchers.IO) {
                repository.getHerosWithCache()
            }
            Log.d(TAG, superheros.toString())
            _heros.value = superheros
        }
    }

    fun getHerosWithException() {
        viewModelScope.launch {
            val superheroListState = withContext(Dispatchers.IO) {
                repository.getHerosWithException()
            }
            Log.d(TAG, superheroListState.toString())

            _state.value = superheroListState
        }
    }
}

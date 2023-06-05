package vero.practicaandroidavanzado5datalocal.ui.superherolist

import vero.practicaandroidavanzado5datalocal.domain.SuperHero


sealed class SuperHeroListState {
    data class Success(val heros: List<SuperHero>) : SuperHeroListState()
    data class Failure(val error: String?) : SuperHeroListState()
    data class NetworkFailure(val code: Int) : SuperHeroListState()
}

package vero.practicaandroidavanzadoreentrega.ui.superherolist

import vero.practicaandroidavanzadoreentrega.domain.SuperHero

sealed class SuperHeroListState {
    data class Success(val heros: List<SuperHero>) : SuperHeroListState()
    data class Failure(val error: String?) : SuperHeroListState()
    data class NetworkFailure(val code: Int) : SuperHeroListState()
}

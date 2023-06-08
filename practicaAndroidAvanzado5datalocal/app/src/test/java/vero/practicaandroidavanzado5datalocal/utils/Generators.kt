package vero.practicaandroidavanzado5datalocal.utils

import vero.practicaandroidavanzado5datalocal.data.local.model.SuperHeroLocal
import vero.practicaandroidavanzado5datalocal.data.remote.response.SuperHeroRemote

import vero.practicaandroidavanzado5datalocal.domain.SuperHero



fun generateHerosRemote(): List<SuperHeroRemote> {
    return (0 until 10).map {
        SuperHeroRemote(
            "ID: $it",
            "Name $it",
            "Photo $it",
            "Description $it"
        )
    }
}

fun generateHerosLocal(): List<SuperHeroLocal> {
    return (0 until 10).map {
        SuperHeroLocal(
            "ID: $it",
            "Name $it",
            "Photo $it",
            "Description $it",
            false
        )
    }
}


fun generateHeros(): List<SuperHero> {
    return (0 until 10).map {
        SuperHero(
            "ID: $it",
            "Name $it",
            "Photo $it"
        )
    }
}


package vero.practicaandroidavanzado2.data.mappers

import vero.practicaandroidavanzado2.data.local.model.LocalSuperhero
import vero.practicaandroidavanzado2.data.remote.response.GetHeroesResponse
import javax.inject.Inject

class RemoteToLocalMapper @Inject constructor(){

    fun mapGetHeroResponse(getheroesResponses: List<GetHeroesResponse>): List<LocalSuperhero> {
        return getheroesResponses.map { mapGetHeroResponse(it) }
    }

    fun mapGetHeroResponse(getHeroesResponse: GetHeroesResponse): LocalSuperhero {
        return LocalSuperhero(getHeroesResponse.id, getHeroesResponse.name, false)
    }
}

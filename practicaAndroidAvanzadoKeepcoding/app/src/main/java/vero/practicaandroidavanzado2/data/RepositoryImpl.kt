package vero.practicaandroidavanzado2.data

import vero.practicaandroidavanzado2.data.local.LocalDataSource
import vero.practicaandroidavanzado2.data.mappers.LocalToPresentationMapper
import vero.practicaandroidavanzado2.data.mappers.RemoteToLocalMapper
import vero.practicaandroidavanzado2.ui.model.Superhero

import vero.practicaandroidavanzado2.data.remote.RemoteDataSource


class RepositoryImpl (
    //estas son las depencias directas
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val localToPresentationMapper: LocalToPresentationMapper,
    private val remoteToLocalMapper: RemoteToLocalMapper,
): Repository {

//se crea la implementacion de la clase y la interfaz asociada

    override suspend fun getHeroes(): List<Superhero> {
        if (localDataSource.getHeroes().isEmpty()) {
            val remoteSuperheroes = remoteDataSource.getHeroes()
            localDataSource.insertHeroes(remoteToLocalMapper.mapGetHeroResponse(remoteSuperheroes))
        }

     //   return localToPresentationMapper.mapLocalSuperheroes(localDataSource.getheroes())

    return localToPresentationMapper.mapLocalSuperheroes((localDataSource.getHeroes()))
    }
}

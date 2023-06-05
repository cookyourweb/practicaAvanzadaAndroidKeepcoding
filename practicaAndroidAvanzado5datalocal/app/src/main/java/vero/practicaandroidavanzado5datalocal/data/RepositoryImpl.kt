package vero.practicaandroidavanzado5datalocal.data

import com.google.android.gms.maps.model.LatLng



import okhttp3.internal.ignoreIoExceptions
import retrofit2.HttpException
import vero.practicaandroidavanzado5datalocal.data.local.LocalDataSource
import vero.practicaandroidavanzado5datalocal.data.mappers.LocalToPresentationMapper
import vero.practicaandroidavanzado5datalocal.data.mappers.PresentationToLocalMapper
import vero.practicaandroidavanzado5datalocal.data.mappers.RemoteToLocalMapper
import vero.practicaandroidavanzado5datalocal.data.mappers.RemoteToPresentationMapper
import vero.practicaandroidavanzado5datalocal.data.remote.RemoteDataSource
import vero.practicaandroidavanzado5datalocal.domain.Bootcamp
import vero.practicaandroidavanzado5datalocal.domain.Repository
import vero.practicaandroidavanzado5datalocal.domain.SuperHero
import vero.practicaandroidavanzado5datalocal.domain.SuperHeroDetail
import vero.practicaandroidavanzado5datalocal.ui.superherolist.SuperHeroListState
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val remoteToPresentationMapper: RemoteToPresentationMapper,
    private val remoteToLocalMapper: RemoteToLocalMapper,
    private val localToPresentationMapper: LocalToPresentationMapper,
    private val presentationToLocalMapper: PresentationToLocalMapper,
) : Repository {

    override suspend fun getBootcamps(): List<Bootcamp> {
        return remoteDataSource.getBootcamps()
    }

    override suspend fun getHeros(): List<SuperHero> {
        return remoteToPresentationMapper.map(remoteDataSource.getHeros())
    }

    override suspend fun getHerosWithCache(): List<SuperHero> {
        // 1º Pido los datos a local
        val localSuperHeros = localDataSource.getHeros()
        // 2º Compruebo si hay datos
        if (localSuperHeros.isEmpty()) {
            // 3º Si no hay datos
            //3a Pido datos a remoto
            val remoteSuperHeros = remoteDataSource.getHeros()
            //3b Guardo datos en local
            localDataSource.insertHeros(remoteToLocalMapper.map(remoteSuperHeros))
        }
        // 4º Devuelvo datos local
        return localToPresentationMapper.map(localDataSource.getHeros())
    }

    override suspend fun getHerosWithException(): SuperHeroListState {
        val result = remoteDataSource.getHerosWithException()
        return when {
            result.isSuccess -> SuperHeroListState.Success(remoteToPresentationMapper.map(result.getOrThrow()))
            else -> {
                when (val exception = result.exceptionOrNull()) {
                    is HttpException -> SuperHeroListState.NetworkFailure(
                        exception.code()
                    )
                    else -> {
                        SuperHeroListState.Failure(
                            result.exceptionOrNull()?.message
                        )
                    }
                }
            }
        }
    }

    override suspend fun getHeroDetail(name: String): SuperHeroDetail? {
        val result = remoteDataSource.getHeroDetail(name).also {
            if (it.isSuccess){
                it.getOrNull()?.let { superHeroDetailRemote ->
                    if (superHeroDetailRemote.favorite) {
                        localDataSource.insertHero(remoteToLocalMapper.map(superHeroDetailRemote))
                    } else {
                        localDataSource.deleteHero(remoteToLocalMapper.map(superHeroDetailRemote))
                    }
                }
            }
        }
        return result.getOrNull()?.let { remoteToPresentationMapper.map(it) }
    }

    override suspend fun login(email: String, password: String): Boolean {
        val result = remoteDataSource.login(email, password)
        val success = result.isSuccess
        if (success) {
            result.getOrNull()?.let { localDataSource.setToken(it) }
        }
        return success
    }

    override suspend fun insertFav(superHeroDetail: SuperHeroDetail) {
        localDataSource.insertHero(presentationToLocalMapper.map(superHeroDetail)).also {
            remoteDataSource.getHeroDetail(superHeroDetail.name).getOrNull()?.favorite?.let {
                if (!it) {
                    remoteDataSource.toggleFavourite(superHeroDetail.id)
                }
            }
        }
    }

    override suspend fun deleteFav(superHeroDetail: SuperHeroDetail) {
        localDataSource.deleteHero(presentationToLocalMapper.map(superHeroDetail)).also {
            remoteDataSource.getHeroDetail(superHeroDetail.name).getOrNull()?.favorite?.let {
                if (it) {
                    remoteDataSource.toggleFavourite(superHeroDetail.id)
                }
            }
        }
    }

    override suspend fun getHeroLocations(id: String): List<LatLng> {
        return remoteDataSource.getSuperheroLocations(id)
    }
}

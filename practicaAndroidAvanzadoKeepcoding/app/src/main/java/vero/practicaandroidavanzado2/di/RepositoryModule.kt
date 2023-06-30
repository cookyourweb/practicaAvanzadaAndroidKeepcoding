package vero.practicaandroidavanzado2.di

import vero.practicaandroidavanzado2.data.Repository
import vero.practicaandroidavanzado2.data.RepositoryImpl
import vero.practicaandroidavanzado2.data.local.LocalDataSourceImpl
import vero.practicaandroidavanzado2.data.mappers.LocalToPresentationMapper
import vero.practicaandroidavanzado2.data.mappers.RemoteToLocalMapper
import vero.practicaandroidavanzado2.data.remote.RemoteDataSource

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent



@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    companion object {
        @Provides
        fun providesRepositoryImpl(
            localDataSource: LocalDataSourceImpl,
            remoteDataSource: RemoteDataSource,
            localToPresentationMapper: LocalToPresentationMapper,
            remoteToLocalMapper: RemoteToLocalMapper
        ): RepositoryImpl {
            return RepositoryImpl(localDataSource, remoteDataSource, localToPresentationMapper, remoteToLocalMapper)
        }
    }

    //enlazamos la implelmentacion de arriba con una interfaz y devolvemos la abstraccio
    @Binds
    abstract fun bindsRepository(repositoryImpl: RepositoryImpl): Repository
}

